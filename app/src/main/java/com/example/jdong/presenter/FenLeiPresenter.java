package com.example.jdong.presenter;

import com.example.jdong.bean.FenLeiBean;
import com.example.jdong.model.FenLeiModel;
import com.example.jdong.model.imodel.IFenLeiModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.IFenLeiView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/15.
 */

public class FenLeiPresenter {
    public IFenLeiModel iFenLeiModel;
    public IFenLeiView iFenLeiView;

    public FenLeiPresenter(IFenLeiView iFenLeiView) {
        this.iFenLeiView = iFenLeiView;
        iFenLeiModel=new FenLeiModel();
    }
    public void getFenLeiBean(){
        iFenLeiModel.doGet(new OnNetListener<FenLeiBean>() {
            @Override
            public void OnSuccess(FenLeiBean fenLeiBean) {
                List<FenLeiBean.DataBean> list=fenLeiBean.getData();
                iFenLeiView.show(list);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
