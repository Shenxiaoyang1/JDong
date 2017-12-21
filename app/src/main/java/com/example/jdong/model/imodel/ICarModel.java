package com.example.jdong.model.imodel;

import com.example.jdong.bean.CarBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/20.
 */

public interface ICarModel {
    public void docar(String uid, String token, OnNetListener<CarBean> onNetListener);

}
