package com.han.cityconnection.CityPart.HeardNews.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.han.cityconnection.App;
import com.han.cityconnection.CityPart.HeardNews.Entity.BeiJingMsgList;
import com.han.cityconnection.R;
import com.han.cityconnection.base.BaseActivity;
import com.han.cityconnection.base.CommonAdapter;
import com.han.cityconnection.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */

public class TouTiaoAdapter extends BaseAdapter {
    public static final int ITEMCOUNT = 3;
    public static final int ITEMYPE1 = 0;
    public static final int ITEMYPE2 = 1;
    public static final int ITEMYPE3 = 2;
    public static final int ITEMYPE4 = 3;
    private List<ImageView> listImg;
    private int[] imageID;
    private ViewPagerBanner viewPagerBanner;
    private ViewPager viewPager;


    private Context context;
    private List<Object> datas;
    private LayoutInflater inflater;
    private RecyclerViewAdapter recyclerViewAdapter;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;

    public TouTiaoAdapter(Context context, List<Object> datas) {
        super();
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
        listImg = new ArrayList<>();

    }

    //listView 的item有几种类型
    @Override
    public int getViewTypeCount() {
        return ITEMCOUNT;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        Object o = datas.get(position);
        switch (viewType) {
            case ITEMYPE1:
                convertView = (View) o;
                break;
            case ITEMYPE2:
                convertView = (View) o;

                break;
            case ITEMYPE3:
//                convertView = inflater.inflate(R.layout.toutiaopulltolistview, null);
//                pullToRefreshRecyclerView = (PullToRefreshRecyclerView) convertView.findViewById(R.id.header_recyclerView);
                LinearLayoutManager layoutManager = new LinearLayoutManager(App.activity);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                pullToRefreshRecyclerView.setLayoutManager(layoutManager);
                List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean> headTInfoListBeen = (List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean>) o;
                recyclerViewAdapter = new RecyclerViewAdapter(context, headTInfoListBeen);
                pullToRefreshRecyclerView.setAdapter(recyclerViewAdapter);
                break;
        }

        return convertView;
    }

    //下标索引对应的 item类型
    @Override
    public int getItemViewType(int position) {
        Object o = datas.get(position);
        if (o instanceof View) {
            Log.d("ssss", "111");
            return ITEMYPE1;
        } else if (o instanceof View) {
            Log.d("ssss", "222");
            return ITEMYPE2;
        } else if (o instanceof  BeiJingMsgList.ServerInfoBean.HeadTInfoListBean ) {
            Log.d("ssss", "333");
            return ITEMYPE3;
        }
        return -1;
    }


}
