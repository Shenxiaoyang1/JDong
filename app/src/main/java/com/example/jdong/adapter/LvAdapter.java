package com.example.jdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.bean.FenLeiBean;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/16.
 */

public class LvAdapter extends BaseAdapter {
    private List<FenLeiBean.DataBean> list;
    private Context context;

    public LvAdapter(List<FenLeiBean.DataBean> list, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item02,null);
            holder.tv02=convertView.findViewById(R.id.tv02);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv02.setText(list.get(position).getName());

        return convertView;
    }
    class ViewHolder{
        TextView tv02;

    }
}
