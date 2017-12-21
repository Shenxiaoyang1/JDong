package com.example.jdong.presenter;

import com.example.jdong.bean.FLRightBean;
import com.example.jdong.model.FenLeiRightModel;
import com.example.jdong.model.imodel.IFenLeiRightModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.IFenLeiRightView;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public class FLRightPresenter {
    IFenLeiRightModel iFenLeiRightModel;
    IFenLeiRightView iFenLeiRightView;

    public FLRightPresenter(IFenLeiRightView iFenLeiRightView) {
        this.iFenLeiRightView = iFenLeiRightView;
        iFenLeiRightModel=new FenLeiRightModel();
    }

    public void getFLBean(String cid){
        iFenLeiRightModel.doGet( cid,new OnNetListener<FLRightBean>() {
            @Override
            public void OnSuccess(FLRightBean flRightBean) {

                iFenLeiRightView.show(flRightBean);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    };




}
