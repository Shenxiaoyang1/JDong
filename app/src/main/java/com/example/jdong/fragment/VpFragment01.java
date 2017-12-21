package com.example.jdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.jdong.R;
import com.example.jdong.adapter.GvAdapter;
import com.example.jdong.bean.FenLeiBean;
import com.example.jdong.presenter.FenLeiPresenter;
import com.example.jdong.view.IFenLeiView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/15.
 */

public class VpFragment01 extends Fragment implements IFenLeiView{

    private GridView gridView;
    private GvAdapter adapter;
    private FenLeiPresenter fenLeiPresenter;
    private List<FenLeiBean.DataBean> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f_vp01,container,false);
        gridView=view.findViewById(R.id.gridview1);

        fenLeiPresenter=new FenLeiPresenter(this);
        fenLeiPresenter.getFenLeiBean();;
        return view;
    }

    @Override
    public void show(List<FenLeiBean.DataBean> fenLeiBean) {
        for (int i=0;i<10;i++){
            FenLeiBean.DataBean bean=fenLeiBean.get(i);
            list.add(bean);
        }
        adapter=new GvAdapter(list,getContext());
        gridView.setAdapter(adapter);
    }
}
