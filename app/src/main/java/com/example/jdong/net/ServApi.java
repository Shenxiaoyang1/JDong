package com.example.jdong.net;

import com.example.jdong.bean.CarBean;
import com.example.jdong.bean.DeleteBean;
import com.example.jdong.bean.FLRightBean;
import com.example.jdong.bean.FenLeiBean;
import com.example.jdong.bean.HomeBean;
import com.example.jdong.bean.JoinBean;
import com.example.jdong.bean.LoginBean;
import com.example.jdong.bean.RegBean;
import com.example.jdong.bean.SearchBean;
import com.example.jdong.bean.ShowBean;
import com.example.jdong.bean.XiangQingBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public interface ServApi {
    //轮播
    @GET(Api.INDEX_BANNER)
    Call<HomeBean> getHomeBean();
    //分类
    @GET(Api.INDEX_FL)
    Call<FenLeiBean> getFenLeiBean();
    @GET(Api.FL_RIGHT)
    Call<FLRightBean> getFLBean();
    @GET(Api.SHOW)
    Call<ShowBean> getShowBean(@Query("pscid")String pscid);
    //搜索
    @GET(Api.SEARCH)
    Call<SearchBean> getSearchBean(@Query("keywords") String name);
    //详情
    @GET(Api.XIANGQING)
    Call<XiangQingBean> xiangqingbean(@Query("pid") String pid);
    //购物车
    @GET(Api.CAR)
    Call<CarBean> getCartBean();
    //加入购物车
    @GET(Api.JOIN)
    Call<JoinBean> joinbean(@Query("uid") String uid, @Query("pid")String pid, @Query("token") String token);

    //查询购物车
    @GET(Api.CAR)
    Call<CarBean> carbean(@Query("uid") String uid,@Query("token")String token);

    //删除购物车
    @GET(Api.DELETE)
    Call<DeleteBean> deletebean(@Query("uid") String uid, @Query("pid") String pid, @Query("token") String token);

    //注册
    @GET(Api.REG)
    Call<RegBean> getRegBean(@Query("mobile")String mobile, @Query("password")String password);
    //登录
    @GET(Api.LOGIN)
    Call<LoginBean> getLoginBean(@Query("mobile")String mobile, @Query("password")String password);
}
