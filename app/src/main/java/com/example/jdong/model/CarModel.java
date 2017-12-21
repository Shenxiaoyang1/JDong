package com.example.jdong.model;

import android.os.Handler;

import com.example.jdong.bean.CarBean;
import com.example.jdong.model.imodel.ICarModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 刘雅文 on 2017/12/19.
 */

public class CarModel implements ICarModel{

    @Override
    public void docar(String uid, String token, final OnNetListener<CarBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        retrofit2.Call<CarBean> beanCall=servApi.getCartBean();
        beanCall.enqueue(new retrofit2.Callback<CarBean>() {
            @Override
            public void onResponse(retrofit2.Call<CarBean> call, retrofit2.Response<CarBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<CarBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
