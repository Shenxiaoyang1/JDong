package com.example.jdong.model;

import com.example.jdong.bean.FLRightBean;
import com.example.jdong.model.imodel.IFenLeiRightModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public class FenLeiRightModel implements IFenLeiRightModel{

    @Override
    public void doGet(String cid, final OnNetListener<FLRightBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<FLRightBean> beanCall=servApi.getFLBean();
        beanCall.enqueue(new Callback<FLRightBean>() {
            @Override
            public void onResponse(Call<FLRightBean> call, Response<FLRightBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FLRightBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
