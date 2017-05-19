package com.han.cityconnection.CityPart.HeardNews.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

public class ViewPagerBanner extends PagerAdapter {
    private List<ImageView> list;
    public ViewPagerBanner(List<ImageView> list) {
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list.size() == 0) {
            return 1;
        }
            return Integer.MAX_VALUE;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = list.get(position % list.size());
        if (imageView.getParent() != null) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        } else {
            container.addView(imageView);
        }
        return imageView;
    }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
//       super.destroyItem(container, position, object);
   }

}
