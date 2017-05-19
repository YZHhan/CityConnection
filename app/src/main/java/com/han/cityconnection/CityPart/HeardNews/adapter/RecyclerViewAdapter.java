package com.han.cityconnection.CityPart.HeardNews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.han.cityconnection.App;
import com.han.cityconnection.CityPart.HeardNews.Entity.BeiJingMsgList;
import com.han.cityconnection.CityPart.HeardNews.viewholder.RecyclerViewHoldr;
import com.han.cityconnection.R;
import com.han.cityconnection.base.CommonAdapter;
import com.han.cityconnection.base.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean>  datas;
    private Context context;
    private LayoutInflater inflater;
    public RecyclerViewAdapter(Context context,List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean>  datas) {
        super();
        this.context=context;
        this.datas=datas;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view=inflater.inflate(R.layout.toutiao_listview,null);
       RecyclerViewHoldr viewHoldr=new RecyclerViewHoldr(view);
        return viewHoldr;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BeiJingMsgList.ServerInfoBean.HeadTInfoListBean headTInfoListBean = datas.get(position);
        List<BeiJingMsgList.ServerInfoBean.HeadTInfoListBean.DataBean> data = headTInfoListBean.getData();
        RecyclerViewHoldr recyclerViewHoldr= (RecyclerViewHoldr) holder;
            for(BeiJingMsgList.ServerInfoBean.HeadTInfoListBean.DataBean dataBean: data){
                recyclerViewHoldr.headTitle.setText(dataBean.getTitle());
                recyclerViewHoldr.headHead.setText(dataBean.getVariable8());
                recyclerViewHoldr.headVisable.setText(dataBean.getVariable1()+"");
                Glide.with(App.activity).load(dataBean.getImage()).into(recyclerViewHoldr.headIamgeView);
            }

        //点击进入城市详情
        recyclerViewHoldr.headLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        }



    @Override
    public int getItemCount() {
        return datas.size();
    }
}
