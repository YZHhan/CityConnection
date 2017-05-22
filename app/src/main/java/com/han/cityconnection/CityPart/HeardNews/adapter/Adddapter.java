package com.han.cityconnection.CityPart.HeardNews.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.han.cityconnection.App;
import com.han.cityconnection.CityPart.HeardNews.Entity.MainAddbean;
import com.han.cityconnection.R;
import com.han.cityconnection.base.CommonAdapter;
import com.han.cityconnection.config.Urls;

import java.util.List;

/**
 * Created by think on 2017/5/20.
 */

public class Adddapter extends CommonAdapter<MainAddbean.ServerInfoBean.ConfigDataBean> {
    private List<MainAddbean.ServerInfoBean.ConfigDataBean> list;
    private Context context;
    public Adddapter(Context context, List<MainAddbean.ServerInfoBean.ConfigDataBean> datas) {
        super(context, R.layout.additem, datas);
        this.list=datas;
        this.context=context;
    }

    @Override
    public void convert(com.han.cityconnection.base.ViewHolder holder, MainAddbean.ServerInfoBean.ConfigDataBean configDataBean) {
        holder.setText(R.id.addname,configDataBean.getTitle());
        View view = LayoutInflater.from(context).inflate(R.layout.additem,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.addimg);
            Glide.with(context).load(configDataBean.getIcon()).into(imageView);


    }


}
