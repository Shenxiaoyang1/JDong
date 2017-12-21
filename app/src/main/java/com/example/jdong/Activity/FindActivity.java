package com.example.jdong.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jdong.R;
import com.example.jdong.adapter.SearchAdapter;
import com.example.jdong.bean.SearchBean;
import com.example.jdong.presenter.SearchPresenter;
import com.example.jdong.view.ISearchView;

import java.util.ArrayList;
import java.util.List;

public class FindActivity extends AppCompatActivity implements ISearchView{
    public SearchPresenter searchPresenter;
    private ImageView mBack;
    private EditText mImg;
    private ImageView mQiehuan;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        init();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(FindActivity.this,name, Toast.LENGTH_SHORT).show();
        searchPresenter = new SearchPresenter(this);
        searchPresenter.getSrearchBean(name);
        mImg.setText(name);
        back();
    }

    private void back() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindActivity.this,SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        mBack = (ImageView) findViewById(R.id.back);
        mImg = (EditText) findViewById(R.id.img);
        mQiehuan = (ImageView) findViewById(R.id.qiehuan);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
    }

    @Override
    public void show(List<SearchBean.DataBean> searchBean) {
        GridLayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        SearchAdapter adapter=new SearchAdapter(searchBean,this);
        recyclerView.setAdapter(adapter);
    }
}
