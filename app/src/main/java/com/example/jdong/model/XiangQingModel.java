package com.example.jdong.model;

import com.example.jdong.bean.XiangQingBean;
import com.example.jdong.model.imodel.IXiangQingModel;
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
 * Created by Apple on 2017/12/15.
 */

public class XiangQingModel implements IXiangQingModel {
    @Override
    public void doxiangqing(String pid, final OnNetListener<XiangQingBean> onNetListener) {
        ServApi serviceApi = RetrofitHelper.getServApi();
        Call<XiangQingBean> beanCall=serviceApi.xiangqingbean(pid);
        beanCall.enqueue(new Callback<XiangQingBean>() {
            @Override
            public void onResponse(Call<XiangQingBean> call, Response<XiangQingBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<XiangQingBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
