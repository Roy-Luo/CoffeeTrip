package com.roy.coffeetrip.adapter.hunter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.activity.hunter.HunterContentDesitinationAty;
import com.roy.coffeetrip.activity.hunter.HunterContentSpecialAty;
import com.roy.coffeetrip.activity.hunter.HunterContentTravelAty;
import com.roy.coffeetrip.bean.hunter.HunterContentBean;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/23.
 */
public class HunterContentAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<HunterContentBean> data;

    public HunterContentAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<HunterContentBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_hunter_content, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(data.get(position).getImage_url()).into(holder.picImg);
        holder.tvChina.setText(data.get(position).getName_zh_cn() + "概览");
        holder.tvEnglish.setText(data.get(position).getName_en());

        holder.show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        holder.show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int id = data.get(position).getId();
                Intent intent = new Intent(context, HunterContentTravelAty.class);
                intent.putExtra("id",id);
                intent.putExtra("name",data.get(position).getName_zh_cn());
                context.startActivity(intent);
                Log.d("coushazi", "id:" + id);

            }
        });
        holder.show3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = data.get(position).getId();
                String name = data.get(position).getName_zh_cn();
                Intent intent = new Intent(context, HunterContentDesitinationAty.class);
                intent.putExtra("name",name);
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });
        holder.show4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = data.get(position).getId();
                String name = data.get(position).getName_zh_cn();
                Intent intent = new Intent(context, HunterContentSpecialAty.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                context.startActivity(intent);

            }
        });


        return convertView;
    }

    class ViewHolder {
        ImageView picImg;
        TextView tvChina, tvEnglish;
        LinearLayout show1, show2, show3, show4;

        public ViewHolder(View itemView) {
            picImg = (ImageView) itemView.findViewById(R.id.raiders_img);
            tvChina = (TextView) itemView.findViewById(R.id.raiders_chn);
            tvEnglish = (TextView) itemView.findViewById(R.id.radiders_eng);
            show1 = (LinearLayout) itemView.findViewById(R.id.selector_1);
            show2 = (LinearLayout) itemView.findViewById(R.id.selector_2);
            show3 = (LinearLayout) itemView.findViewById(R.id.selector_3);
            show4 = (LinearLayout) itemView.findViewById(R.id.selector_4);
        }
    }
}
