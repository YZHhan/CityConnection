package com.han.cityconnection.CityPart.HeardNews.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.han.cityconnection.R;
import com.han.cityconnection.base.ViewHolder;

/**
 * Created by Administrator on 2017/5/15.
 */

public class TouTiaoViewHolder extends ViewHolder {
    public ImageView headIamgeView;
    public TextView headTitle;
    public TextView headHead;
    public TextView headVisable;
    public LinearLayout headLinear;
    private TouTiaoViewHolder(Context context, View convertView) {
        super(context, convertView);
        headIamgeView= (ImageView) convertView.findViewById(R.id.head_image);
        headTitle= (TextView) convertView.findViewById(R.id.head_title);
        headHead= (TextView) convertView.findViewById(R.id.head_head);
        headVisable= (TextView) convertView.findViewById(R.id.head_variable1);
        headLinear= (LinearLayout) convertView.findViewById(R.id.head_newInfo);
    }
}
