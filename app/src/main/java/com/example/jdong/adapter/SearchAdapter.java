package com.example.jdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.bean.SearchBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>{
    private List<SearchBean.DataBean> list;
    private Context context;

    public SearchAdapter(List<SearchBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item_search,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyViewHolder holder1=holder;
        SearchBean.DataBean bean=list.get(position);
        holder.sdv.setImageURI(bean.getImages());
        holder.title.setText(bean.getTitle());
        holder.price.setText(bean.getPrice()+"");
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdv;
        TextView price,title;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.fresco);
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);
        }
    }
}
