package com.han.cityconnection.CityPart.HeardNews.fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.han.cityconnection.App;
import com.han.cityconnection.CityPart.HeardNews.Entity.BeiJingMsgList;
import com.han.cityconnection.CityPart.HeardNews.adapter.TouTiaoAdapter;
import com.han.cityconnection.CityPart.HeardNews.adapter.TouTiaoAdapterOne;
import com.han.cityconnection.persenteer.header.HeaderParsenterImpl;
import com.han.cityconnection.CityPart.HeardNews.adapter.ViewPagerBanner;
import com.han.cityconnection.CityPart.HeardNews.contract.HeaderNewContract;
import com.han.cityconnection.R;
import com.han.cityconnection.base.BaseFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/9.
 */

public class TouTiaoFragment extends BaseFragment implements HeaderNewContract.HeaderView {
    private SlidingMenu mMenu;
    private ListView listView;
    private TouTiaoAdapter touTiaoAdapter;
    private List<Object> data;
    //网路请求的
    private HeaderParsenterImpl headerParsenter;

    //PullToRecyclerView
//    private PullToRefreshRecyclerView recyclerView;
//    private RecyclerViewAdapter recyclerViewAdapter;
//    private List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean> datas;

    //设置 ListViw
    private ListView headListView;
    private TouTiaoAdapterOne touTiaoAdapterOne;


    private List<ImageView> listImg;
    private int[] imageID;
    private ViewPager viewPager;
    private ViewPagerBanner viewPagerBanner;
    private View view1;

    @Override
    protected int getLayoutId() {
        return R.layout.toutiaofragment;
    }


    @Override
    protected void initView(View view) {

        imageID = new int[]{R.drawable.my_main_advice1, R.drawable.my_main_advice2, R.drawable.my_main_advice3, R.drawable.my_main_advice4};
        listImg = new ArrayList<>();
        for (int i = 0; i < imageID.length; i++) {
            ImageView imageView = new ImageView(App.activity);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imageID[i]);
            listImg.add(imageView);
        }
        view1 = LayoutInflater.from(App.activity).inflate(R.layout.toutiaolistviewheader, null);
        viewPager = (ViewPager) view1.findViewById(R.id.main_ViewPager);
        viewPagerBanner = new ViewPagerBanner(listImg);
        viewPager.setAdapter(viewPagerBanner);
        headerParsenter = new HeaderParsenterImpl(this);
        headListView = (ListView) view.findViewById(R.id.header_listView);
        headListView.addHeaderView(view1);
//
//        datas = new ArrayList<>();
//        recyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.header_recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(App.activity);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    protected void initData() {

    }

    /**
     * 发送请求
     */
    @Override
    protected void sendQuest() {
        showProgress();
        Map<String, String> param = new HashMap<>();
        String params = listCreateParams();
        param.put("param", params);
        Log.d("abca", "param:" + params);

        headerParsenter.loadNetData(Urls.APPURL, param);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

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

    @Override
    public void setData(BeiJingMsgList beiJingMsgList) {
        if (beiJingMsgList != null) {
            diaProgress();
            Toast.makeText(App.activity, "请求成功", Toast.LENGTH_SHORT).show();
            BeiJingMsgList.ServerInfoBean serverInfoBean = beiJingMsgList.getServerInfo();
            List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean> headTInfoList = serverInfoBean.getHeadTInfoList();
            touTiaoAdapterOne = new TouTiaoAdapterOne(App.activity, R.layout.toutiao_listview, headTInfoList);
            headListView.setAdapter(touTiaoAdapterOne);

// datas.addAll(headTInfoList);
//            recyclerViewAdapter = new RecyclerViewAdapter(App.activity, datas);
//            recyclerView.setAdapter(recyclerViewAdapter);
        }


    }

    //头条今日前的请求
    private String listCreateParams() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2482);
            jo.put("page", 1);
            jo.put("pageSize", 10);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.PHSocket_GetHeadlinesInfoO, jo);
//        listParam2 = Constants.PHSocket_GetHeadlinesInfoO + jo.toString();
        return params;
    }
}
