package com.example.jdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    private List<ShowBean.DataBean> list;
    private Context context;

    public ShowAdapter(List<ShowBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    //1.首先自定义一个接口
    public interface OnItemClickListener {
        public void onItemClieck(String str);
    }
    //2.设置一个变量
    public ShowAdapter.OnItemClickListener onItemClickListener;
    //3.定义一个方法
    public void setOnItemClickListener(ShowAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_search,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder holder1=holder;
        ShowBean.DataBean bean=list.get(position);
        holder1.sdv.setImageURI(bean.getImages());
        holder1.title.setText(bean.getTitle());
        holder1.price.setText(bean.getPrice()+"");
        final int pid = bean.getPid();
        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClieck(pid+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("56666","66666"+list.size());
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdv;
        TextView price,title;
        LinearLayout ll;
        public ViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.fresco);
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);
            ll = itemView.findViewById(R.id.ll_search);
        }
    }
}
