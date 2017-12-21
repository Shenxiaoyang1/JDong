package com.example.jdong.presenter;

import com.example.jdong.bean.RegBean;
import com.example.jdong.model.RegModel;
import com.example.jdong.model.imodel.ILoginModel;
import com.example.jdong.model.imodel.IRegModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.IRegView;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class RegPresenter {
    IRegModel iRegModel;
    IRegView iRegView;

    public RegPresenter(IRegView iRegView) {
        this.iRegView = iRegView;
        iRegModel=new RegModel();
    }
    public void getRegBean(String mobile,String pass){
        iRegModel.doGet(mobile, pass, new OnNetListener<RegBean>() {
            @Override
            public void OnSuccess(RegBean regBean) {
                String data = regBean.getCode();
                String msg = regBean.getMsg();
                iRegView.show(data,msg);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
