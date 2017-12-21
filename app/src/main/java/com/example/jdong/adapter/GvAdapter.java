package com.example.jdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.bean.FenLeiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/15.
 */

public class GvAdapter extends BaseAdapter {
    private List<FenLeiBean.DataBean> list;
    private Context context;

    public GvAdapter(List<FenLeiBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
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
            convertView=View.inflate(context, R.layout.item01,null);
            holder.sdv=convertView.findViewById(R.id.iv);
            holder.tv=convertView.findViewById(R.id.tv);
            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getName());
        holder.sdv.setImageURI(list.get(position).getIcon());

        return convertView;
    }
    class ViewHolder{
        TextView tv;
        SimpleDraweeView sdv;
    }
}
