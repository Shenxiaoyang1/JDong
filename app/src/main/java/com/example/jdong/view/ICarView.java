package com.example.jdong.view;

import com.example.jdong.bean.CarBean;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/19.
 */

public interface ICarView {
    public void showcar(List<CarBean.DataBean> grouplist, List<List<CarBean.DataBean.ListBean>> childlist);

}
