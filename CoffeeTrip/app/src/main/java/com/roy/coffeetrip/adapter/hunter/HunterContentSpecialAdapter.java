package com.roy.coffeetrip.adapter.hunter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.hunter.HunterContentSpecialBean;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/24.
 */
public class HunterContentSpecialAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<HunterContentSpecialBean> datas;

    public HunterContentSpecialAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HunterContentSpecialBean> datas) {
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
            convertView = inflater.inflate(R.layout.item_hunter_content_special,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(datas.get(position).getImage_url()).into(holder.picImg);
        holder.titleTv.setText(datas.get(position).getTitle());
        holder.nameTv.setText(datas.get(position).getName());

        return convertView;
    }

    class ViewHolder{
        ImageView picImg;
        TextView nameTv,titleTv;
        public ViewHolder(View itemView){
            picImg = (ImageView) itemView.findViewById(R.id.hunter_content_special_pic);
            nameTv = (TextView) itemView.findViewById(R.id.hunter_content_special_name);
            titleTv = (TextView) itemView.findViewById(R.id.hunter_content_special_title);
        }
    }
}
