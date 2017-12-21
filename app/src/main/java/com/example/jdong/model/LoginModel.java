package com.example.jdong.model;

import com.example.jdong.bean.LoginBean;
import com.example.jdong.model.imodel.ILoginModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class LoginModel implements ILoginModel {
    @Override
    public void doGet(String mobile, String password, final OnNetListener<LoginBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<LoginBean> beanCall=servApi.getLoginBean(mobile,password);
        beanCall.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
