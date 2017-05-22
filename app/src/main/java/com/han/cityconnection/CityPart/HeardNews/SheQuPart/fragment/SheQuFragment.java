package com.han.cityconnection.CityPart.HeardNews.SheQuPart.fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.han.cityconnection.CityPart.HeardNews.SheQuPart.adapter.HomeFrageAdapter;
import com.han.cityconnection.CityPart.HeardNews.SheQuPart.bean.TabBean;
import com.han.cityconnection.CityPart.HeardNews.SheQuPart.contract.SheQuContract;
import com.han.cityconnection.CityPart.HeardNews.SheQuPart.entity.ShequParsenterImpl;
import com.han.cityconnection.R;
import com.han.cityconnection.base.BaseFragment;
import com.han.cityconnection.config.Urls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/5/10.
 */

public class SheQuFragment extends BaseFragment implements SheQuContract.SheQuview{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> title;
    private HomeFrageAdapter dapter;
    private List<TabBean.ServerInfoBean>list;
    private List<BaseFragment> fragments;
    private ShequParsenterImpl shequParsenter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shequ;
    }

    @Override
    protected void sendQuest() {

    }

    @Override
    protected void initView(View view) {
       // inflateview = LayoutInflater.from(getContext()).inflate(R.layout.shequfragment, null);
        list=new ArrayList<>();
        title=new ArrayList<>();
        fragments=new ArrayList<>();
        tabLayout= (TabLayout) view.findViewById(R.id.mytablayout);
        viewPager= (ViewPager) view.findViewById(R.id.shequviewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        shequParsenter=new ShequParsenterImpl(this);
    }
    @Override
    protected void initData() {
        dapter=new HomeFrageAdapter(getActivity().getSupportFragmentManager(),fragments,title);
        viewPager.setAdapter(dapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        Map<String,String> map=new HashMap<>();
        map.put("param","{\"customerID\":8001,\"requestTime\":\"2017-05-12 09:55:02\",\"Method\":\"PHSocket_GetUseNavigationInfo\",\"customerKey\":\"20E52BF6B076853BA584DA182D374CD2\",\"appName\":\"CcooCity\",\"version\":\"4.6\",\"Param\":{\"siteID\":2422,\"type\":6},\"Statis\":{\"SiteId\":2494,\"UserId\":28833994,\"PhoneNo\":\"Redmi 3\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"861648039279173\",\"PhoneNum\":\"\"}}\n");
    shequParsenter.loadNetData(Urls.APPURL,map);
    }

    @Override
    public void senddata(TabBean tabBean) {
        list.addAll(tabBean.getServerInfo());
       for(TabBean.ServerInfoBean bean :tabBean.getServerInfo()){
           tabLayout.addTab(tabLayout.newTab().setText(bean.getName()).setTag(bean.getId()));
           title.add(bean.getName());
       }
        dapter.notifyDataSetChanged();

    }

    @Override
    public void showErrorImage() {

    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void turnVideoPlay() {

    }

    @Override
    public void turnDetailInfor() {

    }

    @Override
    public void LoadMore() {

    }

    @Override
    public void LoadRefresh() {

    }

    @Override
    public void showActionBarStyle() {

    }
}
