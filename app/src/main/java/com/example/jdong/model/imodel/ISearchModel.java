package com.example.jdong.model.imodel;

import com.example.jdong.bean.SearchBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public interface ISearchModel {
    public void doget(String name,OnNetListener<SearchBean> onNetListener);
}
