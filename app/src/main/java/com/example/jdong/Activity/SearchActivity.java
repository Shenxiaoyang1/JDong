package com.example.jdong.Activity;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdong.R;
import com.example.jdong.net.FlowGroupView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mBack;
    private EditText et_name;
    /**
     * 搜索
     */
    private TextView mSousuo;
    private ListView listView;
    /**
     * 清空历史记录
     */
    private Button bt_clear;
    private LinearLayout mLsjl;
    private FlowGroupView flowGroupView;
    private ArrayList<String> strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        add();
        back();
        sousuo();
    }



    private void sousuo() {
        mSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= et_name.getText().toString().trim();
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(SearchActivity.this,"输入为空！",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent=new Intent(SearchActivity.this,FindActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
        });
    }

    private void back() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mBack.setOnClickListener(this);
    }

    private void add() {
        strings = new ArrayList<>();
        strings.add("电脑");
        strings.add("相机");
        strings.add("手机");
        strings.add("玩具");
        strings.add("零食");
        strings.add("蛋糕");
        strings.add("服装");
        strings.add("进口饮料/零食/蛋糕");
        strings.add("高档服侍/鞋类/包类");
        strings.add("婴儿用具/衣服/童鞋");
        //为布局添加内容
        for (int i = 0; i < strings.size(); i++) {
            addTextView(strings.get(i));
        }
    }
    /**
     * 动态添加布局
     * @param s
     */
    private void addTextView(String s) {
        TextView child = new TextView(this);
        ViewGroup.MarginLayoutParams params=new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        child.setLayoutParams(params);
        child.setBackgroundResource(R.drawable.flag);
        child.setText(s);
        child.setTextColor(Color.parseColor("#ffffff"));
        //监听
        flowGroupView.addView(child);
    }

    private void init() {
        bt_clear = (Button) findViewById(R.id.bt_clear);
        mBack = (ImageView) findViewById(R.id.back);
        et_name = (EditText) findViewById(R.id.ed_name);
        mSousuo = (TextView) findViewById(R.id.sousuo);
        listView = (ListView) findViewById(R.id.lv);
        mLsjl = (LinearLayout) findViewById(R.id.lsjl);
        flowGroupView = (FlowGroupView) findViewById(R.id.flowGroupView);

        bt_clear.setOnClickListener(this);
        mBack.setOnClickListener(this);
          }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_clear:
                    break;
                case R.id.back:
                    finish();
                    break;
            }
        }

}

