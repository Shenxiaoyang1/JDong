package com.example.jdong.presenter;

import com.example.jdong.bean.ShowBean;
import com.example.jdong.model.ShowModel;
import com.example.jdong.model.imodel.IShowModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.IShowView;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public class ShowPresenter {
    IShowModel iShowModel;
    IShowView iShowView;

    public ShowPresenter(IShowView iShowView) {
        this.iShowView = iShowView;
        iShowModel=new ShowModel();
    }
    public void getShowBean(String pscid){
        iShowModel.doGet(pscid, new OnNetListener<ShowBean>() {
            @Override
            public void OnSuccess(ShowBean showBean) {
                iShowView.show(showBean);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
