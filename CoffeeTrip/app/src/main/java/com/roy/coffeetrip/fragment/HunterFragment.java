package com.roy.coffeetrip.fragment;


import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.hunter.HunterListViewAdapter;
import com.roy.coffeetrip.base.BaseFragment;
import com.roy.coffeetrip.bean.hunter.HunterBean;
import com.roy.coffeetrip.utill.VolleySingleton;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ${Roy} on 16/5/10.
 */
public class HunterFragment extends BaseFragment {


    private ListView listView;
    private HunterListViewAdapter listViewAdapter;
    private List<HunterBean> datas;
    private TextView title;


    @Override
    public int setLayout() {
        return R.layout.fragment_hunter;
    }

    @Override
    public void initView() {
        listView = (ListView) getView().findViewById(R.id.hunter_lv);
        listViewAdapter = new HunterListViewAdapter(mContext);
        title = (TextView) getView().findViewById(R.id.hunter_title_tv);
        title.setText("I'm hunter!");
    }

    @Override
    public void initData() {
        datas = new ArrayList<>();

         VolleySingleton.addRequest("http://chanyouji.com/api/destinations.json?page=1", HunterBean.class,
                new Response.Listener<HunterBean>() {
                    @Override
                    public void onResponse(HunterBean response) {

                        listViewAdapter.setData(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("HunterFragment", "error---------->" + error);
                    }
                });

        listView.setAdapter(listViewAdapter);

    }
}

