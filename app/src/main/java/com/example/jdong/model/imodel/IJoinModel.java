package com.example.jdong.model.imodel;


import com.example.jdong.bean.JoinBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by Apple on 2017/12/18.
 */

public interface IJoinModel {
    public void dojoin(String uid, String pid, String token, OnNetListener<JoinBean> onNetListener);
}
