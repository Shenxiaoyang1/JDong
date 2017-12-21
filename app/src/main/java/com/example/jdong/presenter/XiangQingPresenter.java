package com.example.jdong.presenter;


import com.example.jdong.bean.XiangQingBean;
import com.example.jdong.model.XiangQingModel;
import com.example.jdong.model.imodel.IXiangQingModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.XiangQingView;

/**
 * Created by Apple on 2017/12/15.
 */

public class XiangQingPresenter {
    IXiangQingModel iXiangQingModel;
    XiangQingView xiangQingView;

    public XiangQingPresenter(XiangQingView xiangQingView) {
        this.xiangQingView = xiangQingView;
        iXiangQingModel = new XiangQingModel();
    }
    public void doxq(String pid){
        iXiangQingModel.doxiangqing(pid, new OnNetListener<XiangQingBean>() {
            @Override
            public void OnSuccess(XiangQingBean xiangQingBean) {
                xiangQingView.showxiangqing(xiangQingBean);
            }

            @Override
            public void OnError(Exception e) {

            }


        });
    }
}
