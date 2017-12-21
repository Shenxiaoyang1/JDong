package com.example.jdong.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.jdong.R;
import com.example.jdong.adapter.ShowAdapter;
import com.example.jdong.bean.ShowBean;
import com.example.jdong.presenter.ShowPresenter;
import com.example.jdong.view.IShowView;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements IShowView{
    private ShowPresenter showPresenter;
    private ShowAdapter showAdapter;
    private RecyclerView rv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        rv = (RecyclerView) findViewById(R.id.rv);
        iv = (ImageView) findViewById(R.id.back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        showPresenter = new ShowPresenter(this);
        showPresenter.getShowBean(pscid);
    }

    @Override
    public void show(ShowBean showBean) {
        List<ShowBean.DataBean> list = showBean.getData();
        showAdapter = new ShowAdapter(list,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(showAdapter);
        showAdapter.setOnItemClickListener(new ShowAdapter.OnItemClickListener() {
            @Override
            public void onItemClieck(String str) {
                Intent intent = new Intent(ShowActivity.this, DetailsActivity.class);
                intent.putExtra("pid",str);
                startActivity(intent);
            }
        });
    }
}
