package com.example.jdong.presenter;

import com.example.jdong.bean.LoginBean;
import com.example.jdong.model.LoginModel;
import com.example.jdong.model.imodel.ILoginModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.ILoginView;

import retrofit2.http.PUT;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class LoginPresenter {
    ILoginModel iLoginModel;
    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginModel=new LoginModel();
    }
    public void getLoginBean(String mobile,String password){
        iLoginModel.doGet(mobile, password, new OnNetListener<LoginBean>() {
            @Override
            public void OnSuccess(LoginBean loginBean) {
                String code = loginBean.getCode();
                String msg = loginBean.getMsg();
                iLoginView.show(code,msg);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
