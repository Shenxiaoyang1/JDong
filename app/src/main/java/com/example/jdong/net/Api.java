package com.example.jdong.net;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class Api {
    //共用接口
    public static final String HOST = "https://www.zhaoapi.cn/";
    //首页的banner条
    public static final String INDEX_BANNER = "ad/getAd";
    //首页的分类
    public static final String INDEX_FL = "product/getCatagory";
    public static final String FL_RIGHT = "product/getProductCatagory";
    //搜索框
    public static final String SEARCH = "product/searchProducts?source=android";
    //子类详情
    public static final String SHOW = "product/getProducts?source=android";
    //加入购物车
    public static final String JOIN = "product/addCart?source=android";
    //查询购物车
    public static final String CAR = "product/getCarts?source=android";
    //删除购物车
    public static final String DELETE = "product/deleteCart?source=android";
    //注册
    public static final String REG="user/reg?";
    //登录
    public static final String LOGIN = "user/login?";
    //详情
    public static final String XIANGQING = "product/getProductDetail?source=android";


}
