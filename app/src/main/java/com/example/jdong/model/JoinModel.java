package com.example.jdong.model;

import com.example.jdong.bean.JoinBean;
import com.example.jdong.model.imodel.IJoinModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Apple on 2017/12/18.
 */

public class JoinModel implements IJoinModel {
    @Override
    public void dojoin(String uid, String pid, String token, final OnNetListener<JoinBean> onNetListener) {
        ServApi serviceApi = RetrofitHelper.getServApi();
        Call<JoinBean> beanCall=serviceApi.joinbean(uid, pid, token);
        beanCall.enqueue(new Callback<JoinBean>() {
            @Override
            public void onResponse(Call<JoinBean> call, Response<JoinBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<JoinBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
