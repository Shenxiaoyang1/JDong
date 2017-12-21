package com.example.jdong.utils;

import com.example.jdong.net.Api;
import com.example.jdong.net.ServApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ServApi servApi;
    static {
        okHttpClient=OkHttp3Utils.getClient();
    }
    public static ServApi getServApi(){
        if (servApi==null){
            synchronized (ServApi.class){
                if(servApi==null){
                    servApi=createApi(ServApi.class, Api.HOST);
                }
            }
        }
        return servApi;
    }
    public static <T> T createApi(Class<T> tClass,String url){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }

}
