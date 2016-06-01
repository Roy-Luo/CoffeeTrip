package com.roy.coffeetrip.adapter.customize;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.customize.CustomizeBean;
import com.roy.coffeetrip.utill.Image;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/26.
 */
public class CustomizeHeaderImgAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<CustomizeBean.ItemsEntity.PicListEntity> datas;

    public void setDatas(List<CustomizeBean.ItemsEntity.PicListEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public CustomizeHeaderImgAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.item_customize_header_img,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(datas.get(position).getUrl()).resize(200,200)
                .into(holder.imageView);

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        public ViewHolder(View itemView){
            imageView = (ImageView) itemView.findViewById(R.id.item_customize_header_img);
        }
    }
}
