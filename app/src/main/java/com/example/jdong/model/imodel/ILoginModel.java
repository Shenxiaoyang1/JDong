package com.example.jdong.model.imodel;

import com.example.jdong.bean.LoginBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public interface ILoginModel {
    public void doGet(String mobile, String password, OnNetListener<LoginBean> onNetListener);
}
