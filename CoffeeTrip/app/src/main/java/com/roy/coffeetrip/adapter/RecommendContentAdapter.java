package com.roy.coffeetrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.RecommendContentBean;

import java.util.List;

/**
 * Created by ${Roy} on 16/5/19.
 */
public class RecommendContentAdapter extends BaseAdapter {

    private Context context;
    private RecommendContentBean recommendContentBean;

    public RecommendContentAdapter(Context context) {
        this.context = context;
    }

    public void setRecommendContentBean(RecommendContentBean recommendContentBean) {
        this.recommendContentBean = recommendContentBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return recommendContentBean != null ? recommendContentBean.getTrip_days().size() :0;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_content_lv_tv,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.descriptionTv.setText(recommendContentBean.getTrip_days().get(0).getNodes().
                get(0).getNotes().get(0).getDescription());
        return convertView;
    }

    class ViewHolder{
        TextView descriptionTv;
        public ViewHolder(View itemView){
            descriptionTv = (TextView) itemView.findViewById(R.id.item_content_lv_tv);
        }
    }
}
