package com.han.cityconnection.CityPart.HeardNews.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;

import com.han.cityconnection.CityPart.HeardNews.Entity.CityNewsInfoBean;
import com.han.cityconnection.CityPart.HeardNews.Entity.MainAddbean;
import com.han.cityconnection.CityPart.HeardNews.contract.HeaderNewContract;
import com.han.cityconnection.R;
import com.han.cityconnection.base.BaseActivity;
import com.han.cityconnection.config.Parameter;
import com.han.cityconnection.config.Urls;
import com.han.cityconnection.persenteer.header.HeaderParsenterImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/16.
 */

public class NewsInfoActivity extends BaseActivity implements HeaderNewContract.HeaderNewsView {
    private HeaderParsenterImpl headerParsenter;
    private int newsId;
    private TextView titleText;
    private TextView cityNameText;
    private TextView browseText;
    private TextView showTimeText;
    private WebView webView;
    private Set<WebView> wvList = new HashSet<>();
    //加载  ListView
    private ListView newsListView;

    @Override
    protected int getLayoutId() {
        return R.layout.newsinfo_item;
    }

    @Override
    protected void init() {
        newsListView= (ListView) findViewById(R.id.newsInfo_listView);

        Intent intent = getIntent();
        newsId = intent.getIntExtra("newsId",0);
        headerParsenter = new HeaderParsenterImpl(this);
        titleText = (TextView) findViewById(R.id.newsInfo_title);
        cityNameText = (TextView) findViewById(R.id.newsInfo_cityName);
        browseText = (TextView) findViewById(R.id.newsInfo_browse);
        showTimeText = (TextView) findViewById(R.id.newsInfo_showTime);
        webView= (WebView) findViewById(R.id.webview);
        wvList.add(webView);
//        LayoutInflater inflater=LayoutInflater.from(this);
//        View view=inflater.inflate(R.layout.newsinfo_item,null);
//        View footView=inflater.inflate(R.layout.newsinfo_footitem,null);







    }

    @Override
    protected void initListener() {


    }

    @Override
    protected void loadData() {
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("siteID",2482);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String s = Parameter.createnewsParam(Urls.PHSocket_APP_CityMasterIndex, jsonObject);
        Log.d("qqq", s);
        Map<String, String> params = new HashMap<>();
        String param = RequestData1();
        params.put("param", param);
        headerParsenter.loadNewsData(Urls.APPURL,params);
    }


    //得到城市详情 的数据
    private String RequestData1() {// 上方信息请求
        // TODO 数据请求
        JSONObject jo = new JSONObject();
        try {

            jo.put("siteID", 2482);
//            if (utils.isLogin()) {
//                try {
//                    jo.put("userID", Integer.parseInt(utils.getUserID()));
//
//                    dbJson.put("userID", Integer.parseInt(utils.getUserID()));
//                } catch (Exception e) {
//                    // TODO: handle exception
//                }
//            }
            jo.put("newsID",  newsId );

//            jo.put("sourceType", CcooApp.headhomeFlag);
            jo.put("sourceType", 1);

//            dbJson.put("sourceType", CcooApp.headhomeFlag);
//
//            dbJson.put("siteID", utils.getCityId());
//            dbJson.put("newsID", Integer.parseInt(newsId));
//            dbJson.put("method", Urls.PHSocket_GetCityNewsBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = Parameter.createParam(
                Urls.PHSocket_GetCityNewsBody, jo);
        Log.d("newnew", params);
        return params;
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

    //返回的数据
    @Override
    public void setData(CityNewsInfoBean cityNewsInfoBean) {
        showProgress();
        if (cityNewsInfoBean.getMessageList().getCode() == 1000) {
            diaProgress();
            CityNewsInfoBean.ServerInfoBean serverInfo = cityNewsInfoBean.getServerInfo();
            List<CityNewsInfoBean.ServerInfoBean.NewsInfoBean> newsInfo = serverInfo.getNewsInfo();
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webView.getSettings().setBlockNetworkImage(true);


            for (CityNewsInfoBean.ServerInfoBean.NewsInfoBean newsInfoBean : newsInfo) {
                titleText.setText(newsInfoBean.getTitle());
                cityNameText.setText(newsInfoBean.getWapSiteName());
                browseText.setText(newsInfoBean.getBrowse()+"");
                showTimeText.setText(newsInfoBean.getShowTime());
                webView.loadDataWithBaseURL("file:///android_asset/", newsInfoBean.getBody().replaceAll("file:///", ""),
                        "text/html", "utf-8", null);

            }
//            webView.setWebViewClient(new MyWebViewClient(context,
//                    webview));


        }

    }

    @Override
    protected void onPause() {
        if (wvList != null && wvList.size() > 0) {
            for (WebView v : wvList) {
                if (v != null)
                    v.onPause();
            }
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wvList != null && wvList.size() > 0) {
            for (WebView v : wvList) {
                if (v != null)
                    v.onResume();
            }
        }
    }
}
