package com.roy.coffeetrip.adapter.hunter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.hunter.HunterContentTravelBean;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/23.
 */
public class HunterContentTravelAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<HunterContentTravelBean> datas;

    public HunterContentTravelAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HunterContentTravelBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (datas==null){
            return 0;
        }
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_hunter_content_travel,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(datas.get(position).getImage_url()).into(holder.picImg);
        holder.titleTv.setText(datas.get(position).getName());
        holder.dayTv.setText(datas.get(position).getPlan_days_count()+"天");
        holder.numTv.setText(datas.get(position).getPlan_nodes_count()+"个旅行地");
        holder.introduceTv.setText(datas.get(position).getDescription());

        return convertView;
    }

    class ViewHolder{
        ImageView picImg;
        TextView titleTv,dayTv,numTv,introduceTv;
        public ViewHolder(View itemView){
            picImg = (ImageView) itemView.findViewById(R.id.hunter_content_travel_pic);
            titleTv = (TextView) itemView.findViewById(R.id.hunter_content_travel_title_tv1);
            dayTv = (TextView) itemView.findViewById(R.id.hunter_content_travel_day_tv);
            numTv = (TextView) itemView.findViewById(R.id.hunter_content_travel_num_tv);
            introduceTv = (TextView) itemView.findViewById(R.id.hunter_content_travel_introduce_tv);
        }
    }
}
