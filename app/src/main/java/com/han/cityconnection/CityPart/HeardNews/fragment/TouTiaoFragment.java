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
//        ImageView imageView1 = new ImageView(App.activity);
//        imageView1.setImageResource(R.drawable.my_main_advice1);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1000);
//        imageView1.setLayoutParams(layoutParams);
//        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
//        list.add(imageView1);
//        ImageView imageView2 = new ImageView(App.activity);
//        imageView2.setLayoutParams(layoutParams);
//        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
//        imageView2.setImageResource(R.drawable.my_main_advice2);
//        list.add(imageView2);
//        ImageView imageView3 = new ImageView(App.activity);
//        imageView3.setLayoutParams(layoutParams);
//        imageView3.setImageResource(R.drawable.my_main_advice3);
//        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
//        list.add(imageView3);
//        ImageView imageView4 = new ImageView(App.activity);
//        imageView4.setLayoutParams(layoutParams);
//        imageView4.setImageResource(R.drawable.my_main_advice4);
//        imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
//        list.add(imageView4);
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
