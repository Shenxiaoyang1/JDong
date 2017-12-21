package com.example.jdong.model;

import com.example.jdong.bean.DeleteBean;
import com.example.jdong.model.imodel.IDeleteModel;
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

public class DeleteModel implements IDeleteModel {
    @Override
    public void dodelete(String uid, String pid, String token, final OnNetListener<DeleteBean> onNetListener) {
        ServApi servApi = RetrofitHelper.getServApi();
        Call<DeleteBean> bean=servApi.deletebean(uid, pid, token);
        bean.enqueue(new Callback<DeleteBean>() {
            @Override
            public void onResponse(Call<DeleteBean> call, Response<DeleteBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DeleteBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
