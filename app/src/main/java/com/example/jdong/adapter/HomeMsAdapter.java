package com.example.jdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.bean.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/14.
 */

public class HomeMsAdapter extends BaseAdapter {

    public Context context;
    public List<HomeBean.MiaoshaBean.ListBeanX> list;

    public HomeMsAdapter(Context context, List<HomeBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item01,null);
            holder.iv=convertView.findViewById(R.id.iv);
            holder.textView=convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getPrice()+"");
        holder.iv.setImageURI(list.get(position).getImages());
        return convertView;
    }

    class ViewHolder{
        TextView textView;
        SimpleDraweeView iv;
    }
}
