package com.example.jdong.Activity;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jdong.R;
import com.example.jdong.fragment.Fragment01;
import com.example.jdong.fragment.Fragment02;
import com.example.jdong.fragment.Fragment03;
import com.example.jdong.fragment.Fragment04;
import com.example.jdong.fragment.Fragment05;
import com.hjm.bottomtabbar.BottomTabBar;

/*
首页
 */
public class MainActivity extends AppCompatActivity {
    private BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.BLACK)
                .addTabItem("首页",R.drawable.ac0,Fragment01.class)
                .addTabItem("发现",R.drawable.abw, Fragment02.class)
                .addTabItem("分类",R.drawable.aby, Fragment03.class)
                .addTabItem("购物车",R.drawable.abu, Fragment04.class)
                .addTabItem("我的",R.drawable.ac2, Fragment05.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }


}
