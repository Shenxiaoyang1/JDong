package com.example.jdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.jdong.Activity.ShowActivity;
import com.example.jdong.R;
import com.example.jdong.bean.FLRightBean;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/18.
 */

public class ElvAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<String> grouplist;
    private List<List<FLRightBean.DataBean.ListBean>> childlist;

    public ElvAdapter(Context context, List<String> grouplist, List<List<FLRightBean.DataBean.ListBean>> childlist) {
        this.context = context;
        this.grouplist = grouplist;
        this.childlist = childlist;
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grouplist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childlist.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder holder;
        if (convertView==null){
            holder = new GroupHolder();
            convertView = View.inflate(context,R.layout.item02_lv,null);
            holder.textView = convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else {
            holder = (GroupHolder) convertView.getTag();
        }
        holder.textView.setText(grouplist.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder holder;
        if (convertView==null){
            holder = new ChildHolder();
            convertView = View.inflate(context,R.layout.item02_rv,null);
            holder.recyclerView = convertView.findViewById(R.id.recyclerView);
            convertView.setTag(holder);
        }else {
            holder = (ChildHolder) convertView.getTag();
        }
        final List<FLRightBean.DataBean.ListBean> listBeans = childlist.get(childPosition);
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        RightAdapter adapter = new RightAdapter(context,listBeans);
        holder.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RightAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FLRightBean.DataBean.ListBean listBean) {
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("cid",listBean.getPscid());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    class GroupHolder{
        TextView textView;
    }
    class ChildHolder{
        RecyclerView recyclerView;
    }
}
