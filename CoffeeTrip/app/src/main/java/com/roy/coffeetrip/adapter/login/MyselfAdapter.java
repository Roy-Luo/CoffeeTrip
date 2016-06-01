package com.roy.coffeetrip.adapter.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.greendaolite.Collection;
import com.roy.coffeetrip.greendaolite.CollectionDao;
import com.roy.coffeetrip.greendaolite.GreenDaoSingleton;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/30.
 */
public class MyselfAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> datas;

    public MyselfAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ?datas.size() : 0;
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
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_myself_collection,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        CollectionDao collectionDao = GreenDaoSingleton.getInstance().getCollectionDao();

        List<Collection> collections = collectionDao.queryBuilder().list();
        for (Collection collection : collections) {

            holder.titleTv.setText(collection.getTitle());
            Picasso.with(context).load(collection.getUrl()).into(holder.picImg);

        }


        return convertView;
    }

    class ViewHolder{

        TextView titleTv;
        ImageView picImg;
        public ViewHolder(View itemView){
            titleTv = (TextView) itemView.findViewById(R.id.myself_collection_tv);
            picImg = (ImageView) itemView.findViewById(R.id.myself_collection_img);
        }
    }
}
