package com.example.jdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jdong.Activity.SearchActivity;
import com.example.jdong.R;
import com.example.jdong.adapter.HomeMsAdapter;
import com.example.jdong.adapter.RVAdapter;
import com.example.jdong.bean.FenLeiBean;
import com.example.jdong.bean.HomeBean;
import com.example.jdong.net.ImageLoaderHelper;
import com.example.jdong.presenter.FenLeiPresenter;
import com.example.jdong.presenter.Presenter;
import com.example.jdong.view.IFenLeiView;
import com.example.jdong.view.IView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class Fragment01 extends Fragment implements IView,IFenLeiView{
    private GridView gridView;
    private Banner banner;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    //fragment集合
    private List<Fragment> fragments=new ArrayList<Fragment>();
    private VpFragment01 vpFragment01;
    private VpFragment02 vpFragment02;
    //主页banner
    Presenter presenter;
    //分类
    FenLeiPresenter fenLeiPresenter;
    private List<String> images=new ArrayList<String>();
    //扫一扫
    private ImageView sao;
    //搜索框
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01,container,false);
        //轮播
        banner=view.findViewById(R.id.banner);
        //秒杀
        gridView= view.findViewById(R.id.hsgv);
        //分类推荐
        viewPager=view.findViewById(R.id.vp);
        recyclerView=view.findViewById(R.id.rv);
        //主页面banner
        presenter=new Presenter(this);
        presenter.getHomeBean();
        //主页面分类
        fenLeiPresenter=new FenLeiPresenter(this);
        fenLeiPresenter.getFenLeiBean();
        //推荐分类
        vpFragment01=new VpFragment01();
        vpFragment02=new VpFragment02();
        fragments.add(vpFragment01);
        fragments.add(vpFragment02);

        //扫一扫
        sao=view.findViewById(R.id.iv_sao);
        sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator=new IntentIntegrator(getActivity());
                intentIntegrator.initiateScan();
            }
        });
        //搜索
        editText=view.findViewById(R.id.et_sousuo);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

    //扫一扫 二维码
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            String result = scanResult.getContents();
            Toast.makeText(getContext(),result, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void show(HomeBean homeBean) {
        //轮播
        List<HomeBean.DataBean> list=homeBean.getData();
        for (int i=0;i<list.size();i++){
            String image=list.get(i).getIcon();
            images.add(image);
        }
        banner.setImageLoader(new ImageLoaderHelper());
        banner.setImages(images);
        banner.start();
        //秒杀
        List<HomeBean.MiaoshaBean.ListBeanX> xList=homeBean.getMiaosha().getList();
        HomeMsAdapter homeMsAdapter=new HomeMsAdapter(getContext(),xList);
        gridView.setAdapter(homeMsAdapter);
        //推荐
        List<HomeBean.TuijianBean.ListBean> listBean=homeBean.getTuijian().getList();
        RVAdapter adapter=new RVAdapter(getContext(),listBean);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);

    }

    //分类
    @Override
    public void show(List<FenLeiBean.DataBean> fenLeiBean) {
        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }
}
