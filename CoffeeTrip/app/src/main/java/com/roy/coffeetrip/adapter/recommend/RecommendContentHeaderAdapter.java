package com.roy.coffeetrip.adapter.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.recommend.RecommendContentBean;

import java.util.List;

/**
 * Created by ${Roy} on 16/5/19.
 */
public class RecommendContentHeaderAdapter extends BaseAdapter {
    private Context context;
    private List<RecommendContentBean> datas;

    public RecommendContentHeaderAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<RecommendContentBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() :0;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_content_pic,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(convertView);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }



        return convertView;
    }

    class ViewHolder{
        ImageView backGroundImg;
        SimpleDraweeView iconSdv;
        TextView titleTv,dateTv;
        public ViewHolder(View itemView){
            backGroundImg = (ImageView) itemView.findViewById(R.id.content_pic_img);
            iconSdv = (SimpleDraweeView) itemView.findViewById(R.id.content_icon_sdv);
            titleTv = (TextView) itemView.findViewById(R.id.content_title_tv);
            dateTv = (TextView) itemView.findViewById(R.id.content_date_tv);
        }
    }
}
