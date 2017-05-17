package com.han.cityconnection.CityPart.HeardNews.fragment;

import android.app.ActionBar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.han.cityconnection.App;
import com.han.cityconnection.CityPart.HeardNews.adapter.ViewPagerBanner;
import com.han.cityconnection.R;
import com.han.cityconnection.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

public class TouTiaoFragment extends BaseFragment {
    private ViewPager viewPager;
    private ViewPagerBanner viewPagerBanner;
    private List<ImageView> list;


    private int[] imageID;

    @Override
    protected int getLayoutId() {
        return R.layout.toutiaofragment;
    }

    @Override
    protected void initView(View view) {

        imageID = new int[]{R.drawable.my_main_advice1,R.drawable.my_main_advice2,R.drawable.my_main_advice3,R.drawable.my_main_advice4};
        list = new ArrayList<>();
        for (int i = 0;i<imageID.length;i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(imageID[i]);
            list.add(imageView);
        }
        viewPager = (ViewPager) view.findViewById(R.id.main_ViewPager);
        viewPagerBanner = new ViewPagerBanner(list);
        viewPager.setAdapter(viewPagerBanner);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }
}
