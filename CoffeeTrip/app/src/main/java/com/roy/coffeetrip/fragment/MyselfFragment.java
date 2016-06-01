package com.roy.coffeetrip.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.login.MyselfAdapter;
import com.roy.coffeetrip.base.BaseFragment;
import com.roy.coffeetrip.greendaolite.Collection;
import com.roy.coffeetrip.greendaolite.CollectionDao;
import com.roy.coffeetrip.greendaolite.GreenDaoSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Roy} on 16/5/10.
 */
public class MyselfFragment extends BaseFragment {

    private ListView listView;
    private MyselfAdapter adapter;
    private List<String> titles;
    private CollectionDao collectionDao;
    private Collection collection;


    @Override
    public int setLayout() {
        return R.layout.fragment_myself;
    }

    @Override
    public void initView() {

        listView = (ListView) getView().findViewById(R.id.myself_lv);
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_myself_header,null);
        listView.addHeaderView(view);


    }

    @Override
    public void initData() {



        adapter = new MyselfAdapter(mContext);
        listView.setAdapter(adapter);
//
//        datas = collectionDao.queryBuilder().list();
//        for (Collection data : datas) {
//
//            String url = data.getUrl();
//            String title = data.getTitle();
//            int ids = data.getContentId();
//
//            collection = new Collection(null,title,null,null,url,ids);
//        }

        titles = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            titles.add("");
        }
        adapter.setDatas(titles);


    }


}
