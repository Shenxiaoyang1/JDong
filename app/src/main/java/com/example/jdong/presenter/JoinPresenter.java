package com.example.jdong.presenter;

import com.example.jdong.bean.JoinBean;
import com.example.jdong.model.JoinModel;
import com.example.jdong.model.imodel.IJoinModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.JoinView;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Apple on 2017/12/18.
 */

public class JoinPresenter {
    IJoinModel iJoinModel;
    JoinView joinView;

    public JoinPresenter(JoinView joinView) {
        this.joinView = joinView;
        iJoinModel = new JoinModel();
    }
    public void dojp(final String uid, final String pid, final String token){
        iJoinModel.dojoin(uid, pid, token, new OnNetListener<JoinBean>() {
            @Override
            public void OnSuccess(JoinBean joinBean) {
                joinView.showjoin(joinBean);
            }

            @Override
            public void OnError(Exception e) {

            }


        });
    }
}
