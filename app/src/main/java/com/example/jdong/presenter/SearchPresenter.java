package com.example.jdong.presenter;

import com.example.jdong.bean.SearchBean;
import com.example.jdong.model.SearchModel;
import com.example.jdong.model.imodel.ISearchModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.ISearchView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class SearchPresenter {
    ISearchModel iSearchModel;
    ISearchView iSearchView;

    public SearchPresenter(ISearchView iSearchView) {
        this.iSearchView = iSearchView;
        iSearchModel=new SearchModel();
    }

    public void getSrearchBean(String name){
        iSearchModel.doget(name,new OnNetListener<SearchBean>() {
            @Override
            public void OnSuccess(SearchBean searchBean) {
                List<SearchBean.DataBean> list=searchBean.getData();
                iSearchView.show(list);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
