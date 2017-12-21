package com.example.jdong.model.imodel;


import com.example.jdong.bean.XiangQingBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by Apple on 2017/12/15.
 */

public interface IXiangQingModel {
    public void doxiangqing(String pid, OnNetListener<XiangQingBean> onNetListener);
}
