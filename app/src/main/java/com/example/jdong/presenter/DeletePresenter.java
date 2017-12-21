package com.example.jdong.presenter;


import com.example.jdong.bean.DeleteBean;
import com.example.jdong.model.DeleteModel;
import com.example.jdong.model.imodel.IDeleteModel;
import com.example.jdong.net.OnNetListener;
import com.example.jdong.view.IDeleteView;

/**
 * Created by Apple on 2017/12/18.
 */

public class DeletePresenter {
    IDeleteModel iDeleteModel;
    IDeleteView ideleteView;

    public DeletePresenter(IDeleteView ideleteView) {
        this.ideleteView = ideleteView;
        iDeleteModel = new DeleteModel();
    }
    public void dodp(String uid,String pid,String token){
        iDeleteModel.dodelete(uid, pid, token, new OnNetListener<DeleteBean>() {
            @Override
            public void OnSuccess(DeleteBean deleteBean) {
                ideleteView.showdelete(deleteBean);
            }

            @Override
            public void OnError(Exception e) {

            }


        });
    }
}
