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

public class VpFragment02 extends Fragment implements IFenLeiView{

    private GridView gridView;
    private GvAdapter adapter;
    private FenLeiPresenter fenLeiPresenter;
    private List<FenLeiBean.DataBean> list2=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f_vp02,container,false);
        gridView=view.findViewById(R.id.gridview2);

        fenLeiPresenter=new FenLeiPresenter(this);
        fenLeiPresenter.getFenLeiBean();;
        return view;
    }

    @Override
    public void show(List<FenLeiBean.DataBean> fenLeiBean) {
        for (int i=10;i<fenLeiBean.size();i++){
            FenLeiBean.DataBean bean=fenLeiBean.get(i);
            list2.add(bean);
        }
        adapter=new GvAdapter(list2,getContext());
        gridView.setAdapter(adapter);
    }
}
