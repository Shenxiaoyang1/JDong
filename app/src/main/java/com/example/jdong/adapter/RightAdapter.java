package com.example.jdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.bean.FLRightBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<FLRightBean.DataBean.ListBean> list;

    public RightAdapter(Context context, List<FLRightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    //1、接口回调第一步，先定义一个接口
    public interface OnItemClickListener {
        public void onItemClick(FLRightBean.DataBean.ListBean listBean);
    }
    //2、定义一个属性
    private OnItemClickListener onItemClickListener;

    //3、定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item02_right,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final FLRightBean.DataBean.ListBean listBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.tv.setText(listBean.getName());
        holder1.sdv.setImageURI(listBean.getIcon());
        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(listBean);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         SimpleDraweeView sdv;
         TextView tv;
         LinearLayout ll;
        public ViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.iv_right);
            tv = itemView.findViewById(R.id.tv02_right);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
