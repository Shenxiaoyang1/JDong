package com.example.jdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.adapter.CarAdapter;
import com.example.jdong.bean.CarBean;
import com.example.jdong.bean.DeleteBean;
import com.example.jdong.event.MessageEvent;
import com.example.jdong.event.PriceAndCountEvent;
import com.example.jdong.presenter.CarPresenter;
import com.example.jdong.presenter.DeletePresenter;
import com.example.jdong.view.ICarView;
import com.example.jdong.view.IDeleteView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class Fragment04 extends Fragment implements ICarView,IDeleteView{
    private CarPresenter carPresenter;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    private TextView mTvPrice;
    private TextView mTvNum;
    private CarAdapter carAdapter;
    private DeletePresenter deletePresenter;
    private String uid,pid,token;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04,container,false);
//接收uid和token
        Intent intent = getActivity().getIntent();
        uid = intent.getStringExtra("uid");
        token = intent.getStringExtra("token");
        pid = intent.getStringExtra("pid");
        carPresenter = new CarPresenter(this);
        carPresenter.docp(uid,token);
        deletePresenter = new DeletePresenter(this);

        //购物车
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        mTvPrice = (TextView) view.findViewById(R.id.tv_price);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);

        EventBus.getDefault().register(this);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showcar(List<CarBean.DataBean> grouplist, List<List<CarBean.DataBean.ListBean>> childlist) {
//        carAdapter = new CarAdapter(getContext(),grouplist,childlist);
//        mElv.setAdapter(carAdapter);
//        mElv.setGroupIndicator(null);
//        for (int i=0;i<grouplist.size();i++){
//            mElv.expandGroup(i);
//        }
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event){
        mCheckbox2.setChecked(event.isChecked());
    }
    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event){
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }

    @Override
    public void showdelete(DeleteBean deleteBean) {
        deletePresenter.dodp(uid,pid,token);
    }
}
