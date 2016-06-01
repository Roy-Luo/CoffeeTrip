package com.roy.coffeetrip.adapter.hunter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.hunter.HunterContentDesitinationBean;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/24.
 */
public class HuntetContentDesitinationAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<HunterContentDesitinationBean> datas;

    public HuntetContentDesitinationAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HunterContentDesitinationBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
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
            convertView = inflater.inflate(R.layout.item_hunter_content_destination,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(datas.get(position).getImage_url()).into(holder.picImg);
        holder.numTv.setText(datas.get(position).getAttraction_trips_count()+" 篇游记");
        holder.titleTv.setText(datas.get(position).getName());
        holder.contentTv.setText(datas.get(position).getDescription_summary());
        double num = Double.parseDouble(datas.get(position).getUser_score());
        if (4 <= num && num < 4.5 ){
            holder.fourImag.setVisibility(View.VISIBLE);
        } else if (4.5 <= num && num < 5){
            holder.fiveImg.setVisibility(View.VISIBLE);
        }


        return convertView;
    }
    class ViewHolder{
        TextView numTv,titleTv,contentTv;
        ImageView picImg,fourImag,fiveImg;
        public ViewHolder(View itemView){
            numTv = (TextView) itemView.findViewById(R.id.hunter_content_destination_num);
            titleTv = (TextView) itemView.findViewById(R.id.hunter_content_destination_title);
            contentTv = (TextView) itemView.findViewById(R.id.hunter_content_destination_content);
            picImg = (ImageView) itemView.findViewById(R.id.hunter_content_destination_pic);
            fourImag = (ImageView) itemView.findViewById(R.id.hunter_content_destination_four_star);
            fiveImg = (ImageView) itemView.findViewById(R.id.hunter_content_destination_five_star);
        }
    }
}
