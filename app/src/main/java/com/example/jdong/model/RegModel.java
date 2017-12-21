package com.example.jdong.model;

import com.example.jdong.bean.RegBean;
import com.example.jdong.model.imodel.IRegModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class RegModel implements IRegModel {
    @Override
    public void doGet(String mobile, String password, final OnNetListener<RegBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<RegBean> beanCall=servApi.getRegBean(mobile,password);
        beanCall.enqueue(new Callback<RegBean>() {
            @Override
            public void onResponse(Call<RegBean> call, Response<RegBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RegBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
