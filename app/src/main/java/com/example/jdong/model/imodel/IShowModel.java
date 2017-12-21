package com.example.jdong.model.imodel;

import com.example.jdong.bean.ShowBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public interface IShowModel {
    public void doGet(String pscid, OnNetListener<ShowBean> onNetListener);
}
