package com.jin.testoldperson.app;

import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by jin on 2017/7/1.
 */

public class WxUtils {
    private static volatile WxUtils wxUtils;
    private WxUtils() {}
    public static WxUtils getInstance() {
        if (wxUtils == null) {
            synchronized (WxUtils.class) {
                if (wxUtils == null) {
                    wxUtils = new WxUtils();
                }
            }
        }
        return wxUtils;
    }

    public IWXAPI iwxapi;
    public void register(Context context,String appID)
    {
        iwxapi=WXAPIFactory.createWXAPI(context,appID);
       // iwxapi.registerApp(appID);
    }
}
