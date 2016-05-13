package com.roy.coffeetrip.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.RecommendItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Roy} on 16/5/12.
 */
public class RecommendAdapter extends BaseAdapter {
    private Context context;
    ArrayList<RecommendItemBean> datas;

    public RecommendAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(ArrayList<RecommendItemBean> datas) {
        this.datas = datas;
        Log.d("444","---->"+datas.size());
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
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
          ViewHolder viewHolder = null;
        if (convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recommend_item,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        RecommendItemBean data = datas.get(position);
        viewHolder.titleTv.setText(data.getName());
        viewHolder.dateTV.setText(data.getStart_date()+"/ "+data.getDays()+"天 /"
        +data.getPhotos_count()+"图");
        DraweeController controllerBackground = Fresco.newDraweeControllerBuilder().setUri(data
        .getFront_cover_photo_url()).build();
        DraweeController controllerIcon = Fresco.newDraweeControllerBuilder().setUri(data.getUser().getImage()).build();
        viewHolder.backgroundSdv.setController(controllerBackground);
        viewHolder.iconSdv.setController(controllerIcon);

        return convertView;
    }
    class ViewHolder{
        SimpleDraweeView backgroundSdv,iconSdv;
        TextView titleTv,dateTV;
        public ViewHolder (View itemView){
            backgroundSdv = (SimpleDraweeView) itemView.findViewById(R.id.recommend_background_sdv);
            iconSdv = (SimpleDraweeView) itemView.findViewById(R.id.recommend_icon_sdv);
            titleTv = (TextView) itemView.findViewById(R.id.recommend_title_tv);
            dateTV = (TextView) itemView.findViewById(R.id.recommend_date_tv);
        }

    }
}
