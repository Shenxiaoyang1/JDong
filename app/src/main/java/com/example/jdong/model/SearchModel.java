package com.example.jdong.model;

import com.example.jdong.bean.SearchBean;
import com.example.jdong.model.imodel.ISearchModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.net.ServApi;
import com.example.jdong.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class SearchModel implements ISearchModel{


    @Override
    public void doget(String name, final OnNetListener<SearchBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<SearchBean> beanCall=servApi.getSearchBean(name);
        beanCall.enqueue(new Callback<SearchBean>() {
            @Override
            public void onResponse(Call<SearchBean> call, Response<SearchBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SearchBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
