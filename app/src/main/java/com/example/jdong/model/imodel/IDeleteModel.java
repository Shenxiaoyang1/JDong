package com.example.jdong.model.imodel;


import com.example.jdong.bean.DeleteBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by Apple on 2017/12/18.
 */

public interface IDeleteModel {
    public void dodelete(String uid, String pid, String token, OnNetListener<DeleteBean> onNetListener);
}
