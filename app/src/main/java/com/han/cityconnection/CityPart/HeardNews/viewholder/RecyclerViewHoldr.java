package com.han.cityconnection.CityPart.HeardNews.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.han.cityconnection.R;
import com.han.cityconnection.base.ViewHolder;

/**
 * Created by Administrator on 2017/5/10.
 */

public class RecyclerViewHoldr  extends RecyclerView.ViewHolder {
    public ImageView headIamgeView;
    public TextView headTitle;
    public TextView headHead;
    public TextView headVisable;
    public LinearLayout headLinear;
    public RecyclerViewHoldr(View itemView) {
        super(itemView);
        headIamgeView= (ImageView) itemView.findViewById(R.id.head_image);
        headTitle= (TextView) itemView.findViewById(R.id.head_title);
        headHead= (TextView) itemView.findViewById(R.id.head_head);
        headVisable= (TextView) itemView.findViewById(R.id.head_variable1);
        headLinear= (LinearLayout) itemView.findViewById(R.id.head_newInfo);

    }


}
