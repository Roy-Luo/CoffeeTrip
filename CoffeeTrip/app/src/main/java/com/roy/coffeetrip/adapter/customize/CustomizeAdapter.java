package com.roy.coffeetrip.adapter.customize;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.customize.CustomizeBean;
import com.roy.coffeetrip.utill.MyGridView;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/26.
 */
public class CustomizeAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private Context context;
    private List<CustomizeBean.ItemsEntity> datas;
    private CustomizeHeaderImgAdapter adapter;

    public CustomizeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<CustomizeBean.ItemsEntity> datas) {
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
            convertView = inflater.inflate(R.layout.item_customize,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 设置俩个性别的布局为gone!
        holder.boyLl.setVisibility(View.GONE);
        holder.girlLl.setVisibility(View.GONE);

        // 设置对象
        DraweeController controller = Fresco.newDraweeControllerBuilder().
                setUri(datas.get(position).getHeadUrl()).build();
        holder.iconImg.setController(controller);
        holder.nameTv.setText(datas.get(position).getNickname());

        // 设置 boy or girl
        String boy = "男"; String girl = "女";
        Log.d("CustomizeAdapter", "getAge()----->:" + datas.get(position).getAge());
        if (datas.get(position).getGender().equals(boy)){
            holder.boyLl.setVisibility(View.VISIBLE);
            holder.girlLl.setVisibility(View.GONE);
            holder.ageBoyTv.setText(String.valueOf(datas.get(position).getAge()));
        }else if (datas.get(position).getGender().equals(girl)){
            holder.girlLl.setVisibility(View.VISIBLE);
            holder.boyLl.setVisibility(View.GONE);
            holder.ageGirlTv.setText(String.valueOf(datas.get(position).getAge()));
        }

        // 设置正常对象
        holder.distanceTv.setText(String.valueOf(datas.get(position).getDistance()));
        holder.destinationTv.setText(datas.get(position).getDestination());
        holder.requireTv.setText(datas.get(position).getRequire());
        holder.moneyTv.setText(datas.get(position).getMoneyType());
        holder.likeTv.setText(String.valueOf(datas.get(position).getYueyouLikeCount()));
        holder.replyTv.setText(String.valueOf(datas.get(position).getYueyouReplyCount()));

        // 实例化gridView的adapter
        adapter = new CustomizeHeaderImgAdapter(context);
        List<CustomizeBean.ItemsEntity.PicListEntity> data = datas.get(position).getPicList();
        adapter.setDatas(data);
        holder.gridView.setAdapter(adapter);

        return convertView;
    }

    class ViewHolder{
        TextView nameTv,ageBoyTv,ageGirlTv,distanceTv,remarkTv,destinationTv,requireTv,moneyTv
                 ,likeTv,replyTv;
        SimpleDraweeView iconImg;
        LinearLayout boyLl,girlLl;
        MyGridView gridView;
        public ViewHolder(View itemView){
            nameTv = (TextView) itemView.findViewById(R.id.item_customize_name_tv); // 网名
            ageBoyTv = (TextView) itemView.findViewById(R.id.item_customize_age_boy_tv); // 男孩的年龄
            ageGirlTv = (TextView) itemView.findViewById(R.id.item_customize_age_girl_tv); // 女孩时的年龄
            distanceTv = (TextView) itemView.findViewById(R.id.item_customize_distance_tv); // 路程多远
            remarkTv = (TextView) itemView.findViewById(R.id.item_customize_remark_tv); // 详情
            destinationTv = (TextView) itemView.findViewById(R.id.item_customize_destination_tv); // 目的地
            requireTv = (TextView) itemView.findViewById(R.id.item_customize_demand_tv); // 标签
            moneyTv = (TextView) itemView.findViewById(R.id.item_customize_money_tv); // 费用
            likeTv = (TextView) itemView.findViewById(R.id.item_customize_like_tv); // 喜欢
            replyTv = (TextView) itemView.findViewById(R.id.item_customize_reply_tv); // 评论
            // icon
            iconImg = (SimpleDraweeView) itemView.findViewById(R.id.item_customize_head_img); // 头像
            // boy or girl
            boyLl = (LinearLayout) itemView.findViewById(R.id.item_customize_boy_icon); // 判断为男孩时显示
            girlLl = (LinearLayout) itemView.findViewById(R.id.item_customize_girl_icon); // 判断为女孩时显示
            // image GridView
            gridView = (MyGridView) itemView.findViewById(R.id.item_customize_pic_img); // 晒图片
        }
    }
}
