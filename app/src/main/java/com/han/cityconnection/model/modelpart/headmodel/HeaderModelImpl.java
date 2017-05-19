package com.han.cityconnection.model.modelpart.headmodel;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/10.
 */

public class HeaderModelImpl implements IHeaderModel {
    private VolleyHttp volleyHttp;

    public HeaderModelImpl() {
        super();
        volleyHttp=VolleyHttp.getInstance();
    }

    @Override
    public <T> void getHeaderData(String url, Map<String, String> map, NetWorkCallBack<T> callBack) {
                volleyHttp.post(url,map,callBack);
    }
}
