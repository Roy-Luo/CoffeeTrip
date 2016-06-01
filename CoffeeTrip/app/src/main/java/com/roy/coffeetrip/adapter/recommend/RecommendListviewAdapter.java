package com.roy.coffeetrip.adapter.recommend;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.recommend.RecommendContentBean;

import java.util.List;

import it.sephiroth.android.library.picasso.MemoryPolicy;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/21.
 */
public class RecommendListviewAdapter extends BaseAdapter {
    private Context context;
    private List<RecommendContentBean.TripDaysBean.NodesBean.NotesBean> data;
    private LayoutInflater inflater;

    public RecommendListviewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<RecommendContentBean.TripDaysBean.NodesBean.NotesBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
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
            convertView = inflater.inflate(R.layout.item_content_content,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        /**
         * 因为有的getDescription()是空的 所以需要加一个判断
         */
        if (data.get(position).getDescription()!= null) {
            holder.contentTV.setText(data.get(position).getDescription().toString());
        }
        /**
         * 因为有的getPhoto()是空的 所以需要加一个判断
         * 再者,因为图片太大,所以需要用resize(wid , hei)来设置图片的大小,以避免OOM
         * config()
         * 对于不透明的图片可以使用RGB_565来优化内存。Android中有四种，分别是：ALPHA_8：每个像素占用1byte内存
         * ARGB_4444:每个像素占用2byte内存,ARGB_8888:每个像素占用4byte内存
         * RGB_565:每个像素占用2byte内存
         *
         */
        if (data.get(position).getPhoto() != null) {
            Picasso.with(context).load(data.get(position).getPhoto().getUrl()).
                    resize(400,400).config(Bitmap.Config.RGB_565).centerCrop().
                    memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE).
                    into(holder.picImg);
        }else {
            Log.d("222222", "我真的受伤了");
        }



        return convertView;
    }



    class ViewHolder{
        ImageView picImg,likeImg,commentImg;
        TextView contentTV,addressTv;
        public ViewHolder(View itemView){
            picImg = (ImageView) itemView.findViewById(R.id.content_img);
            contentTV = (TextView) itemView.findViewById(R.id.content_tv);
            addressTv = (TextView) itemView.findViewById(R.id.content_address);
            likeImg = (ImageView) itemView.findViewById(R.id.content_like_imgbtn);
            commentImg = (ImageView) itemView.findViewById(R.id.content_comment);
        }
    }
}
