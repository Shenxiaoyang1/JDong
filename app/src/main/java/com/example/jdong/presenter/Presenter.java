package com.example.jdong.presenter;

import com.example.jdong.bean.HomeBean;
import com.example.jdong.model.imodel.IModel;
import com.example.jdong.model.Model;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.IView;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class Presenter {
    public IModel iModel;
    public IView iView;

    public Presenter(IView iView) {
        this.iView = iView;
        iModel=new Model();
    }
    public void getHomeBean(){
        iModel.doGet(new OnNetListener<HomeBean>() {
            @Override
            public void OnSuccess(HomeBean homeBean) {
                iView.show(homeBean);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
