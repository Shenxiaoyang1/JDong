package com.example.jdong.model;

import com.example.jdong.bean.HomeBean;
import com.example.jdong.model.imodel.IModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class Model implements IModel {
    @Override
    public void doGet(final OnNetListener<HomeBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<HomeBean> beanCall=servApi.getHomeBean();
        beanCall.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                onNetListener.OnSuccess(response.body());
               // Log.e("111111111",response.body().toString());
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
