package com.han.cityconnection.CityPart.HeardNews.SheQuPart.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.han.cityconnection.base.BaseFragment;

import java.util.List;

/**
 * Created by think on 2017/3/13.
 */

public class HomeFrageAdapter extends FragmentPagerAdapter {
    private List<String> titles;
   private List<BaseFragment> list;

    public HomeFrageAdapter(FragmentManager fm, List<BaseFragment> list, List<String> titles) {
        super(fm);
        this.titles = titles;
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
