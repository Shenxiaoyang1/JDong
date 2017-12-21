package com.example.jdong.utils;

import okhttp3.OkHttpClient;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class OkHttp3Utils {
    public static OkHttpClient client;
    public static OkHttpClient getClient(){
        if (client==null){
            synchronized (OkHttpClient.class){
                if (client==null){
                    client=new OkHttpClient();
                }
            }
        }
        return client;
    }
}
