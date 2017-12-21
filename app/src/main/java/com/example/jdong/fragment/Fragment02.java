package com.example.jdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jdong.R;
import com.example.jdong.adapter.ElvAdapter;
import com.example.jdong.adapter.LvAdapter;
import com.example.jdong.adapter.RightAdapter;
import com.example.jdong.bean.FLRightBean;
import com.example.jdong.bean.FenLeiBean;
import com.example.jdong.net.ImageLoaderHelper;
import com.example.jdong.presenter.FLRightPresenter;
import com.example.jdong.presenter.FenLeiPresenter;
import com.example.jdong.view.IFenLeiRightView;
import com.example.jdong.view.IFenLeiView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class Fragment02 extends Fragment implements IFenLeiView,IFenLeiRightView{
    private ListView listView;
    ExpandableListView expandableListView;
    ElvAdapter elvAdapter;
    LvAdapter lvAdapter;
    RightAdapter rightAdapter;
    FenLeiPresenter fenLeiPresenter;
    FLRightPresenter flRightPresenter;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<FLRightBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表数据


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02,container,false);
        listView = view.findViewById(R.id.lv);
        expandableListView = view.findViewById(R.id.elv);
        //banner条
        Banner banner = view.findViewById(R.id.banner);
        banner.setImageLoader(new ImageLoaderHelper());
        List<String> images = new ArrayList<>();
        images.add("http://img5.duitang.com/uploads/item/201505/19/20150519192024_3xB4X.thumb.700_0.jpeg");
        images.add("http://ww2.sinaimg.cn/large/7be022cfgw1enl58amvp1j215o0ng4ju.jpg");
        images.add("http://www.sgstad.com/UploadFile/jdlc.jpg");
        images.add("http://pic2.ooopic.com/11/59/56/04b1OOOPICb9.jpg");
        images.add("http://www.ad-cn.net/Uploads/20170913/59b920d8409fa.jpg");
        images.add("http://tpic.home.news.cn/xhCloudNewsPic/xhpic1501/M09/32/EF/wKhTlFhSbwqEZ6ikAAAAAMiBzZY198.jpg");
        images.add("http://picture.ik123.com/uploads/allimg/170823/12-1FR3144259.jpg");
        images.add("http://att.bbs.duowan.com/forum/201306/19/150547amlh9el0tc3qzl93.jpg");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        //左侧
        fenLeiPresenter=new FenLeiPresenter(this);
        fenLeiPresenter.getFenLeiBean();
        //右侧
       flRightPresenter=new FLRightPresenter(this);

        return view;
    }

    @Override
    public void show(List<FenLeiBean.DataBean> fenLeiBean) {
        lvAdapter=new LvAdapter(fenLeiBean,getContext());
        listView.setAdapter(lvAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FenLeiBean.DataBean dataBean = (FenLeiBean.DataBean) adapterView.getItemAtPosition(i);
                int cid = dataBean.getCid();
                flRightPresenter.getFLBean(cid+"");
            }
        });

    }



    @Override
    public void show(FLRightBean flRightBean) {
        groupList.clear();
        childList.clear();
        List<FLRightBean.DataBean> list = flRightBean.getData();
        for (int i=0;i<list.size();i++){
            FLRightBean.DataBean dataBean = list.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }
        elvAdapter = new ElvAdapter(getContext(),groupList,childList);
        expandableListView.setAdapter(elvAdapter);
        for (int i=0;i<list.size();i++){
            expandableListView.expandGroup(i);
        }
    }
}
