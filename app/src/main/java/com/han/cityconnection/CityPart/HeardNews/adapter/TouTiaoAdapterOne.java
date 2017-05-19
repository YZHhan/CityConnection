package com.han.cityconnection.CityPart.HeardNews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.han.cityconnection.App;
import com.han.cityconnection.CityPart.HeardNews.Entity.BeiJingMsgList;
import com.han.cityconnection.CityPart.HeardNews.fragment.NewsInfoActivity;
import com.han.cityconnection.R;
import com.han.cityconnection.base.CommonAdapter;
import com.han.cityconnection.base.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */

public class TouTiaoAdapterOne extends CommonAdapter<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean> {
    private Context context;
    private List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean> datas;
    private LinearLayout linearLayout;

    public TouTiaoAdapterOne(Context context, int layoutId, List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean> datas) {
        super(context, layoutId, datas);
        this.context = context;
        this.datas = datas;
    }

    @Override
    public void convert(ViewHolder holder, BeiJingMsgList.ServerInfoBean.HeadTInfoListBean headTInfoListBean) {

        List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean.DataBean> data = headTInfoListBean.getData();
        View convertView = holder.getConvertView();
        linearLayout= (LinearLayout) convertView.findViewById(R.id.head_newInfo);
        final int theirID = headTInfoListBean.getTheirID();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentBuilder.getInstance().start(NewsInfoFragment.class).build();
                Intent intent=new Intent(App.activity, NewsInfoActivity.class);
                intent.putExtra("newsId",theirID);
                context.startActivity(intent);
            }
        });
        for (final BeiJingMsgList.ServerInfoBean.HeadTInfoListBean.DataBean dataBean : data) {
            holder.setText(R.id.head_title,dataBean.getTitle());
            holder.setText(R.id.head_head,dataBean.getVariable8());
            holder.setText(R.id.head_variable1,dataBean.getVariable1()+"");
            holder.setNetWorkImg(R.id.head_image,dataBean.getImage());


        }

    }


}
