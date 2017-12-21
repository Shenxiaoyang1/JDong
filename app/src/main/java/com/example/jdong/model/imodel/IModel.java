package com.example.jdong.model.imodel;

import com.example.jdong.bean.HomeBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public interface IModel {
    public void doGet(OnNetListener<HomeBean> onNetListener);
}
