package com.roy.coffeetrip.adapter.customize;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.activity.customize.CustomizeWebAty;
import com.roy.coffeetrip.bean.customize.CustomizeBean;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/26.
 */
public class CustomizeHeaderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<CustomizeBean.BannerEntity> datas;

    public CustomizeHeaderAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<CustomizeBean.BannerEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? Integer.MAX_VALUE : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = inflater.inflate(R.layout.item_customize_header_img,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_customize_header_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CustomizeWebAty.class);
                intent.putExtra("title",datas.get(position%datas.size()).getTitle());
                Log.d("CustomizeHeaderAdapter", datas.get(position % datas.size()).getTitle());
                intent.putExtra("web",datas.get(position%datas.size()).getExtend());
                context.startActivity(intent);
            }
        });

        Picasso.with(context).load(datas.get(position%datas.size()).getPicUrl()).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
