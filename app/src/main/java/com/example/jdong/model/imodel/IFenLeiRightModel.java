package com.example.jdong.model.imodel;

import com.example.jdong.bean.FLRightBean;
import com.example.jdong.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public interface IFenLeiRightModel {
    public void doGet(String cid,OnNetListener<FLRightBean> onNetListener);
}
