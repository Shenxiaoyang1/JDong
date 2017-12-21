package com.example.jdong.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdong.R;
import com.example.jdong.adapter.RVAdapter;
import com.example.jdong.bean.JoinBean;
import com.example.jdong.bean.XiangQingBean;
import com.example.jdong.net.ImageLoaderHelper;
import com.example.jdong.presenter.JoinPresenter;
import com.example.jdong.presenter.XiangQingPresenter;
import com.example.jdong.view.JoinView;
import com.example.jdong.view.XiangQingView;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements XiangQingView,JoinView {
    private XiangQingPresenter xiangQingPresenter;
    private JoinPresenter joinPresenter;
    private RVAdapter rvAdapter;
    //详情商品名和价钱
    private TextView tv1,tv2;
    private Banner banner;
    private List<String> list;
    private ImageView ivv;
    private Button bt_join;
    private String pid,uid,token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //点击返回
        ivv = (ImageView) findViewById(R.id.iv_edit);
        ivv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //加入购物车
        bt_join = (Button) findViewById(R.id.bt_join);
        //接收pid
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        token = intent.getStringExtra("token");
        uid = intent.getStringExtra("uid");
        xiangQingPresenter = new XiangQingPresenter(this);
        xiangQingPresenter.doxq(pid);
        joinPresenter = new JoinPresenter(this);
        joinPresenter.dojp(uid,pid,token);
    }

    @Override
    public void showjoin(JoinBean joinBean) {
        final String msg = joinBean.getMsg();
        bt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showxiangqing(XiangQingBean xiangQingBean) {
        tv1 = (TextView) findViewById(R.id.tv_goods_name);
        tv2 = (TextView) findViewById(R.id.tv_goods_price);
        //详情banner
        banner = (Banner) findViewById(R.id.banner_lun);
        banner.setImageLoader(new ImageLoaderHelper());
        String images = xiangQingBean.getData().getImages();
        String[] image = images.split("\\|");
        list = new ArrayList<>();
        for (int i=0;i<3;i++){
            list.add(image[i]);
        }
        banner.setImages(list);
        banner.setBannerAnimation(Transformer.CubeIn);
        banner.start();
        //详情p层
        tv1.setText(xiangQingBean.getData().getTitle());
        tv2.setText(xiangQingBean.getData().getPrice()+"");
    }
}
