package com.roy.coffeetrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.HunterBean;
import com.roy.coffeetrip.utill.MyGridView;

import java.util.List;

/**
 * Created by ${Roy} on 16/5/16.
 */
public class HunterListViewAdapter extends BaseAdapter{
    private Context context;
    //    private List<HunterBean> datas;
    private HunterBean data;
    private HunterGridAdapter gridAdapter;

    public HunterListViewAdapter(Context context) {
        this.context = context;

    }


    public void setData(HunterBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.getArray().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hunter_grid,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        gridAdapter = new HunterGridAdapter(context);
        holder.hunterGv.setAdapter(gridAdapter);
        data.getArray().get(position).getCategory();
        List<HunterBean.ArrayEntity.DestinationsEntity> destinations = data.getArray().get(position).getDestinations();
        gridAdapter.setDestinations(destinations);

        switch (Integer.valueOf(data.getArray().get(position).getCategory())) {
            case 1:
                holder.internationalTv.setText("国际·亚洲");
                break;
            case 2:
                holder.internationalTv.setText("国际·欧洲");
                break;
            case 3:
                holder.internationalTv.setText("美洲、大洋洲、非洲与南极洲");
                break;
            case 99:
                holder.internationalTv.setText("国内·港澳台");
                break;
            case 999:
                holder.internationalTv.setText("国内·大陆");
                break;
        }

        return convertView;
    }

    class ViewHolder {

        MyGridView hunterGv;
        TextView internationalTv;

        public ViewHolder(View itemView) {

            hunterGv = (MyGridView) itemView.findViewById(R.id.hunter_gv);
            internationalTv = (TextView) itemView.findViewById(R.id.hunter_lv_tv);
        }
    }
}
