package com.example.jdong.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.jdong.bean.CarBean;
import com.example.jdong.model.CarModel;
import com.example.jdong.model.imodel.ICarModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.ICarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘雅文 on 2017/12/19.
 */

public class CarPresenter {
    ICarModel iCarModel;
    ICarView icarView;

    public CarPresenter(ICarView icarView) {
        this.icarView = icarView;
        iCarModel = new CarModel();
    }
    public void docp(String uid,String token){
        iCarModel.docar(uid, token, new OnNetListener<CarBean>() {
            @Override
            public void OnSuccess(CarBean carBean) {
                List<CarBean.DataBean> dataBeans = carBean.getData();
                List<List<CarBean.DataBean.ListBean>> childlist = new ArrayList<List<CarBean.DataBean.ListBean>>();
//                for (int i=0;i<dataBeans.size();i++){
//                    List<CarBean.DataBean.ListBean> datas = dataBeans.get(i).getList();
//                    childlist.add(datas);
//                }
                icarView.showcar(dataBeans,childlist);
            }

            @Override
            public void OnError(Exception e) {

            }

        });
    }

}
