package com.han.cityconnection;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;

import com.han.cityconnection.CityPart.HeardNews.Entity.MainAddbean;
import com.han.cityconnection.CityPart.HeardNews.SheQuPart.fragment.SheQuFragment;
import com.han.cityconnection.CityPart.HeardNews.adapter.Adddapter;
import com.han.cityconnection.CityPart.HeardNews.contract.HeaderNewContract;
import com.han.cityconnection.CityPart.HeardNews.fragment.imageloader.ImgFileListActivity;
import com.han.cityconnection.base.BaseActivity;
import com.han.cityconnection.config.FragmentBuilder;
import com.han.cityconnection.config.Parameter;
import com.han.cityconnection.config.Urls;
import com.han.cityconnection.persenteer.header.HeaderParsenterImpl;
import com.han.cityconnection.view.fragment.FanChanFragment;
import com.han.cityconnection.view.fragment.FoundFragment;
import com.han.cityconnection.CityPart.HeardNews.fragment.TouTiaoFragment;
import com.han.cityconnection.view.fragment.ZhaoPinFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener,HeaderNewContract.gridview{
    private RadioButton toutioButton;
    private RadioButton shequButton;
    private RadioButton zhaopinButton;
    private RadioButton fangchanButton;
    private RadioButton foundButton;
    private ImageView addImg,bottomimg;
    private GridView mGridView;
    private Adddapter dapter;
    private List<MainAddbean.ServerInfoBean.ConfigDataBean> list;
    private HeaderParsenterImpl headerParsenter;
    /**
     * 当前下降的是哪个item
     */
    private int downNum;

    /**
     * 是否多次点击关闭按钮
     */
    private boolean isMultiple = false;
    private View conview;
    private PopupWindow popupWindow;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //添加动态授权
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                ) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

        }



        FragmentBuilder.getInstance().start(TouTiaoFragment.class).build();
        conview = LayoutInflater.from(this).inflate(R.layout.toutiaoadd,null);
        toutioButton = (RadioButton) findViewById(R.id.main_toutiaoBtn);
        shequButton = (RadioButton) findViewById(R.id.main_shequBtn);
        zhaopinButton = (RadioButton) findViewById(R.id.main_zhaopinBtn);
        fangchanButton = (RadioButton) findViewById(R.id.main_fangchanBtn);
        foundButton = (RadioButton) findViewById(R.id.main_foundBtn);
        headerParsenter=new HeaderParsenterImpl(this);
        addImg = (ImageView) findViewById(R.id.title_addLink);
        list=new ArrayList<>();
        bottomimg= (ImageView) conview.findViewById(R.id.bottomimage);
        mGridView= (GridView) conview.findViewById(R.id.mygridview);
        mGridView.setLayoutAnimation(getAnimationController());
        dapter=new Adddapter(this,list);
        mGridView.setAdapter(dapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "0000", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,ImgFileListActivity.class));
                        Toast.makeText(MainActivity.this, "1111", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "2222", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    protected void initListener() {
        bottomimg.setOnClickListener(this);
        toutioButton.setOnClickListener(this);
        shequButton.setOnClickListener(this);
        zhaopinButton.setOnClickListener(this);
        fangchanButton.setOnClickListener(this);
        foundButton.setOnClickListener(this);
        addImg.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
//        FragmentBuilder.getInstance().start(TouTiaoFragment.class).build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_toutiaoBtn:
                FragmentBuilder.getInstance().start(TouTiaoFragment.class).build();
                break;
            case R.id.main_shequBtn:
                FragmentBuilder.getInstance().start(SheQuFragment.class).build();
                break;
            case R.id.main_zhaopinBtn:
                FragmentBuilder.getInstance().start(ZhaoPinFragment.class).build();
                break;
            case R.id.main_fangchanBtn:
                FragmentBuilder.getInstance().start(FanChanFragment.class).build();
                break;
            case R.id.main_foundBtn:
                FragmentBuilder.getInstance().start(FoundFragment.class).build();
                break;
            case R.id.title_addLink:
                String s = creatParamsPeizhi();
                Map<String,String> map=new HashMap<>();
                map.put("param",s);
                headerParsenter.loadgriddata(Urls.APPURL,map);
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.revolve);
                addImg.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        showpopu();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                Toast.makeText(this, "你点到我了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bottomimage:
                if (!isMultiple) {
                    isMultiple = true;
                    if(popupWindow!=null) {
                        downNum = list.size() - 1;
                        removeGridViewItem(mGridView.getChildAt(downNum), downNum);
                    }
                }

                break;
        }
    }

    private void showpopu() {

        popupWindow = new PopupWindow(conview,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
                popupWindow.setTouchable(true);
                popupWindow.showAtLocation(conview, Gravity.BOTTOM,0,0);

    }

    private String ReplyParams(String username) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("phone", username);
            jo.put("siteID", "2482");
            jo.put("ip", "115.171.30.103");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //————需要进行  一些改造
        final String params = Parameter.createnewsParam(
                Urls.METHOD_SetRegSendCode, jo);
        return params;
    }


    private String ReplyParams1(String username, String userpwd) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("phone", username);// 手机号
            jo.put("authKey", userpwd);// 短信验证码
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.PHSocket_GetPhoneRegCodeCheck, jo);
        return params;
    }


    /**
     * @return
     */
    private String ReplyParams() {
        JSONObject jo = new JSONObject();
        JSONObject jo1 = new JSONObject();
        try {
            jo.put("RoleIMG", "data/site");
            jo.put("SiteID", "2482");
            jo.put("RoleName", "尹自含");
            jo.put("lifeaddr", "北京吉利大学");
            jo.put("sex", "男");
            jo.put("birthday", "1993_01_20");
//            if (getIntent().getStringExtra("client_flag") != null && !getIntent().getStringExtra("client_flag").equals("")) {//客户端过来
//                jo.put("Tel", "");
//                jo.put("UserPWD", "");
//                if (getIntent().getStringExtra("client_flag").equals("qq")) {
//                    jo.put("OType", 2);
//                    jo.put("QQOpenID", getIntent().getStringExtra("client_id"));//qqid
//                } else if (getIntent().getStringExtra("client_flag").equals("weixin")) {
//                    jo.put("OType", 4);
//                    jo.put("openID", getIntent().getStringExtra("client_id"));//微信id
//                    jo.put("weixin", "weixin@ccoo.cn");
//                } else {
//                    jo.put("OType", 3);
//                    jo.put("WeiboID", getIntent().getStringExtra("client_id"));//微博id
//                }
//            } else {
            jo.put("OType", 5);
            jo.put("Tel", "15650714120");
            jo.put("UserPWD", "qwert12345");
//            }
            jo1.put("InUser", jo);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.METHOD_SetRegUserInfo, jo1);
        return params;
    }

    @Override
    public void getgrid(MainAddbean mainAddbean) {
        List<MainAddbean.ServerInfoBean.ConfigDataBean> configData = mainAddbean.getServerInfo().getConfigData();
        list.addAll(configData);
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

    /**
     * 加号点击监听事件
     * @return
     */
    private String creatParamsPeizhi() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteid",2422);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.METHOD_PHSocket_GetPubConfigInfo, jo);

        return params;
    }
    /**
     * Layout动画
     *
     * @return
     */
    protected LayoutAnimationController getAnimationController() {
        int duration = 400;
        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(duration);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);

        animation.setDuration(duration);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        return controller;
    }
    /**
     * 移除gridView固定位置的一个item
     *
     * @param rootView
     *            gridView固定位置的View
     * @param position
     *            gridView固定位置的position
     */
    private void removeGridViewItem(final View rootView, final int position) {

        AnimationSet set = new AnimationSet(true);

        Animation   animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        animation.setDuration(400);
        set.addAnimation(animation);

        animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(400);
        set.addAnimation(animation);



        set.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                //隐藏已经退出的item
                rootView.setVisibility(View.INVISIBLE);
                downNum--;
                if (downNum == -1) {
                    isMultiple = false;
                    popupWindow.dismiss();
                    return;
                }
                removeGridViewItem(mGridView.getChildAt(downNum), downNum);
            }
        });

        rootView.startAnimation(set);

    }

}
