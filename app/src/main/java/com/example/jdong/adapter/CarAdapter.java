package com.example.jdong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jdong.R;
import com.example.jdong.bean.CarBean;
import com.example.jdong.event.MessageEvent;
import com.example.jdong.event.PriceAndCountEvent;
import com.facebook.drawee.view.SimpleDraweeView;


import org.greenrobot.eventbus.EventBus;

import java.util.List;



/**
 * Created by Apple on 2017/12/18.
 */

public class CarAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<CarBean.DataBean> grouplist;
    private List<List<CarBean.DataBean.ListBean>> childlist;
    private final LayoutInflater inflater;

    public CarAdapter(Context context, List<CarBean.DataBean> grouplist, List<List<CarBean.DataBean.ListBean>> childlist) {
        this.context = context;
        this.grouplist = grouplist;
        this.childlist = childlist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childlist.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return grouplist.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childlist.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        View v;
        final GroupViewHolder holder;
        if (view==null){
            holder = new GroupViewHolder();
            v = inflater.inflate(R.layout.item_car_group,null);
            holder.cbGroup = v.findViewById(R.id.cb_parent);
            holder.tv_number = v.findViewById(R.id.tv_number);
            v.setTag(holder);
        }else {
            v = view;
            holder = (GroupViewHolder) v.getTag();
        }
        final CarBean.DataBean dataBean = grouplist.get(i);
        holder.cbGroup.setChecked(dataBean.isChecked());
        holder.tv_number.setText(dataBean.getSellerName());
        //一级
        holder.cbGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBean.setChecked(holder.cbGroup.isChecked());
                changeChildCbState(i,holder.cbGroup.isChecked());
                EventBus.getDefault().post(compute());
                changeAllCbState(isAllGroupCbSelected());
                notifyDataSetChanged();
            }
        });
        return v;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        View v;
        final ChildViewHolder holder;
        if (view==null){
            holder = new ChildViewHolder();
            v = inflater.inflate(R.layout.item_car_child,null);
            holder.cbChild = v.findViewById(R.id.cb_child);
            holder.tv_content = v.findViewById(R.id.tv_content);
            holder.tv_price = v.findViewById(R.id.tv_pri);
            holder.tv_del = v.findViewById(R.id.tv_del);
            holder.tv_tel = v.findViewById(R.id.tv_tel);
            holder.sdv = v.findViewById(R.id.sdv);
            holder.tv_num = v.findViewById(R.id.tv_num);
            v.setTag(holder);
        }else {
            v = view;
            holder = (ChildViewHolder) v.getTag();
        }
        final CarBean.DataBean.ListBean datasBean = childlist.get(i).get(i1);
        holder.cbChild.setChecked(datasBean.isChecked());
        holder.sdv.setImageURI(datasBean.getImages());
        holder.tv_tel.setText(datasBean.getPrice()+"");
        holder.tv_content.setText(datasBean.getTitle()+"");
        holder.tv_num.setText(datasBean.getNum()+"");
        //二级
        holder.cbChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datasBean.setChecked(holder.cbChild.isChecked());
                PriceAndCountEvent priceAndCountEvent = compute();
                EventBus.getDefault().post(priceAndCountEvent);
                if (holder.cbChild.isChecked()){
                    if (isAllChildCbSelected(i)){
                        changGroupCbState(i,true);
                        changeAllCbState(isAllGroupCbSelected());
                    }
                }else {
                    changGroupCbState(i,false);
                    changeAllCbState(isAllGroupCbSelected());
                }
                notifyDataSetChanged();
            }
        });
        holder.tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<CarBean.DataBean.ListBean> datasBeen = childlist.get(i);
                CarBean.DataBean.ListBean remove = datasBeen.remove(i1);
                if (datasBeen.size() == 0) {
                    childlist.remove(i);
                    grouplist.remove(i);
                }
                EventBus.getDefault().post(compute());
                notifyDataSetChanged();
            }
        });
        return v;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    class GroupViewHolder{
        CheckBox cbGroup;
        TextView tv_number;
    }
    class ChildViewHolder {
        CheckBox cbChild;
        TextView tv_tel;
        TextView tv_content;
        TextView tv_price;
        TextView tv_del;
        //ImageView iv_del;
        //ImageView iv_add;
        TextView tv_num;
        SimpleDraweeView sdv;
    }
    /**
     * 改变全选的状态
     *
     * @param flag
     */
    private void changeAllCbState(boolean flag) {
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setChecked(flag);
        EventBus.getDefault().post(messageEvent);
    }


    /**
     * 改变一级列表checkbox状态
     *
     * @param groupPosition
     */
    private void changGroupCbState(int groupPosition, boolean flag) {
        CarBean.DataBean dataBean = grouplist.get(groupPosition);
        dataBean.setChecked(flag);
    }


    /**
     * 改变二级列表checkbox状态
     *
     * @param groupPosition
     * @param flag
     */
    private void changeChildCbState(int groupPosition, boolean flag) {
        List<CarBean.DataBean.ListBean> datasBeen = childlist.get(groupPosition);
        for (int i = 0; i < datasBeen.size(); i++) {
            CarBean.DataBean.ListBean datasBean = datasBeen.get(i);
            datasBean.setChecked(flag);
        }
    }


    /**
     * 判断一级列表是否全部选中
     *
     * @return
     */
    private boolean isAllGroupCbSelected() {
        for (int i = 0; i < grouplist.size(); i++) {
            CarBean.DataBean dataBean = grouplist.get(i);
            if (!dataBean.isChecked()) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断二级列表是否全部选中
     *
     * @param groupPosition
     * @return
     */
    private boolean isAllChildCbSelected(int groupPosition) {
        List<CarBean.DataBean.ListBean> datasBeen = childlist.get(groupPosition);
        for (int i = 0; i < datasBeen.size(); i++) {
            CarBean.DataBean.ListBean datasBean = datasBeen.get(i);
            if (!datasBean.isChecked()) {
                return false;
            }
        }
        return true;
    }


    /**
     * 计算列表中，选中的钱和数量
     */
    private PriceAndCountEvent compute() {
        int count = 0;
        int price = 0;
        for (int i = 0; i < childlist.size(); i++) {
            List<CarBean.DataBean.ListBean> datasBeen = childlist.get(i);
            for (int j = 0; j < datasBeen.size(); j++) {
                CarBean.DataBean.ListBean datasBean = datasBeen.get(j);
                if (datasBean.isChecked()) {
                    price += datasBean.getNum() * datasBean.getPrice();
                    count += datasBean.getNum();
                }
            }
        }
        PriceAndCountEvent priceAndCountEvent = new PriceAndCountEvent();
        priceAndCountEvent.setCount(count);
        priceAndCountEvent.setPrice(price);
        return priceAndCountEvent;
    }

    /**
     * 设置全选、反选
     *
     * @param flag
     */
    public void changeAllListCbState(boolean flag) {
        for (int i = 0; i < grouplist.size(); i++) {
            changGroupCbState(i, flag);
            changeChildCbState(i, flag);
        }
        EventBus.getDefault().post(compute());
        notifyDataSetChanged();
    }
}
