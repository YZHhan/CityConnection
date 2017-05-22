package com.han.cityconnection.CityPart.HeardNews.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.han.cityconnection.R;
import com.han.cityconnection.base.BaseFragment;

/**
 * Created by Administrator on 2017/5/16.
 */

public class NewsInfoFragment extends BaseFragment {

    private ImageView addImg;

    @Override
    protected int getLayoutId() {
        return R.layout.newsinfo_item;
    }

    @Override
    protected void sendQuest() {

    }

    @Override
    protected void initView(View view) {
    //注册EventBus
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.title_fragment, null);
        addImg = (ImageView) view1.findViewById(R.id.title_addLink);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        addImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"你点到我了",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
