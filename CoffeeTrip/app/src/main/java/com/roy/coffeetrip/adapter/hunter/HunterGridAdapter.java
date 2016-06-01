package com.roy.coffeetrip.adapter.hunter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.hunter.HunterBean;

import java.util.List;

/**
 * Created by ${Roy} on 16/5/16.
 */
public class HunterGridAdapter extends BaseAdapter {

    private Context context;

    List<HunterBean.ArrayEntity.DestinationsEntity> destinations;

    public HunterGridAdapter(Context context) {
        this.context = context;
    }

    public void setDestinations(List<HunterBean.ArrayEntity.DestinationsEntity> destinations) {
        this.destinations = destinations;
        notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        return destinations != null ? destinations.size() : 0;
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
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hunter_grid_img,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.chineseTv.setText(destinations.get(position).getName_zh_cn());
        holder.englishTv.setText(destinations.get(position).getName_en());
        holder.destinationTv.setText("旅行地");
        holder.num.setText(String.valueOf(destinations.get(position).getPoi_count()));
        DraweeController background = Fresco.newDraweeControllerBuilder().setUri(destinations.get(position).getImage_url())
                .build();
        holder.backGroundSdv.setController(background);



        return convertView;
    }

    class ViewHolder{
        TextView chineseTv,englishTv,destinationTv,num;
        SimpleDraweeView backGroundSdv;

        public ViewHolder(View itemView){
            chineseTv = (TextView) itemView.findViewById(R.id.hunter_gv_chinese_tv);
            englishTv = (TextView) itemView.findViewById(R.id.hunter_gv_english_tv);
            destinationTv = (TextView) itemView.findViewById(R.id.hunter_gv_destination);
            num = (TextView) itemView.findViewById(R.id.hunter_gv_num_tv);
            backGroundSdv = (SimpleDraweeView) itemView.findViewById(R.id.hunter_gv_sdv);
        }
    }
}
