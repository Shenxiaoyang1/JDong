package com.example.jdong.model.imodel;

import com.example.jdong.bean.FenLeiBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/15.
 */

public interface IFenLeiModel {
    public void doGet(OnNetListener<FenLeiBean> onNetListener);
}
