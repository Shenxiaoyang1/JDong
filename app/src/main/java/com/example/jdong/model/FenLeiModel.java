package com.example.jdong.model;

import com.example.jdong.bean.FenLeiBean;
import com.example.jdong.model.imodel.IFenLeiModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/15.
 */

public class FenLeiModel implements IFenLeiModel{
    @Override
    public void doGet(final OnNetListener<FenLeiBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<FenLeiBean> beanCall=servApi.getFenLeiBean();
        beanCall.enqueue(new Callback<FenLeiBean>() {
            @Override
            public void onResponse(Call<FenLeiBean> call, Response<FenLeiBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FenLeiBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
