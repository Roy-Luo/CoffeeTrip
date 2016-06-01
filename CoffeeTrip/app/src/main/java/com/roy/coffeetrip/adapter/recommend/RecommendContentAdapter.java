package com.roy.coffeetrip.adapter.recommend;

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

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.bean.recommend.RecommendContentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Roy} on 16/5/19.
 */
public class RecommendContentAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private RecommendContentBean data;
    private RecommendListviewAdapter adapter;

    public RecommendContentAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setRecommendContentBean(RecommendContentBean recommendContentBean) {
        this.data = recommendContentBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ?
                data.getTrip_days().size() : 0;
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_content_group, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            // 不知道为啥! 一定要清空
            holder.groupLayout.removeAllViews();
        }
        Log.d("MainAdapter", "data.getId():" + data.getId());

        holder.dateTv.setText("DAY" + data.getTrip_days().get(position).getDay());
        holder.numTv.setText(data.getTrip_days().get(position).getTrip_date());


        /**
         * 用groupLayout加载title布局
         * 因为data.getTrip_days().get(position).getNodes()的size()数值与
         * data.getTrip_days().get(position)不同,
         * 所以用一个集合来获取其中的数值
         */
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < data.getTrip_days().get(position).getNodes().size(); i++) {
            nums.add(i);
        }

        for (int i = 0; i < nums.size(); i++) {
            View view = inflater.inflate(R.layout.item_content_title, null);
            ImageView icon = (ImageView) view.findViewById(R.id.title_icon_img);
            TextView addressTv = (TextView) view.findViewById(R.id.item_title_address_tv);
            ImageView addressImg = (ImageView) view.findViewById(R.id.title_icon_img);
            ListView listView = (ListView) view.findViewById(R.id.content_lv);

            /**
             * 设置listView的布局,因为另个listView嵌套会有冲突
             * 所以自定义了一个listView,并且复写其中的onMeasure()方法
             * 固定里层的listView高!来避免冲突
             */
            adapter = new RecommendListviewAdapter(context);
            listView.setAdapter(adapter);
            /**
             * 因为里层listView的数据比较详细,所以在此先把里层所需要的data做成一个集合
             * 然后在传给adapter
             */
            data.getTrip_days().get(position).getNodes().get(i).getNotes();
            List<RecommendContentBean.TripDaysBean.NodesBean.NotesBean> datas = data.getTrip_days().get(position).getNodes().get(i).getNotes();
            adapter.setData(datas);

            /**
             * 因为getEntry_name()有时为空,所以在此加一个判断,
             * 若为空则不显示,
             * 反之显示
             */

            if (data.getTrip_days().get(position).getNodes().get(i).getEntry_name()!=null) {
                icon.setVisibility(View.VISIBLE);
            }else {
                icon.setVisibility(View.INVISIBLE);
            }
            /**
             * 此判断添加同理icon
             */
            if (data.getTrip_days().get(position).getNodes().get(i).getEntry_name() != null) {
                addressTv.setText(data.getTrip_days().get(position).getNodes().get(i).getEntry_name() + "");
            }else {
                addressTv.setText("");
            }
            /**
             * 利用grouplayout来包裹 item_title以添加到item_date的布局里面
             */
            holder.groupLayout.addView(view);
        }

        return convertView;
    }

    class ViewHolder {
        TextView dateTv, numTv;
        LinearLayout groupLayout;

        public ViewHolder(View itemView) {
            dateTv = (TextView) itemView.findViewById(R.id.item_date_tv);
            numTv = (TextView) itemView.findViewById(R.id.item_date_numTv);
            groupLayout = (LinearLayout) itemView.findViewById(R.id.groud_layout);

        }
    }
}
