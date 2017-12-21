package com.example.jdong.net;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public interface OnNetListener <T>{
    public void OnSuccess(T t);
    public void OnError(Exception e);

}
