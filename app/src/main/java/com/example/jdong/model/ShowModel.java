package com.example.jdong.model;

import com.example.jdong.bean.ShowBean;
import com.example.jdong.model.imodel.IShowModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public class ShowModel implements IShowModel {
    @Override
    public void doGet(String pscid, final OnNetListener<ShowBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<ShowBean> beanCall=servApi.getShowBean(pscid);
        beanCall.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
