package com.jin.testoldperson.video;

import android.app.Application;

import com.jin.testoldperson.CrashHandler;
import com.jin.testoldperson.app.CheckApkExist;
import com.jin.testoldperson.app.Constants;
import com.jin.testoldperson.app.WxUtils;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * @author : Wells
 * @time : 16/9/5
 * @notes :
 */
public class VPApplication extends Application {
    public static VPApplication instance;
    public JCVideoPlayerStandard VideoPlaying;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        WxUtils.getInstance().register(CheckApkExist.getOtherContext(this,"com.ldfs.wxkd"),Constants.WEIKAN_APP_ID);
       /* CrashHandler crashHandler=CrashHandler.getInstance();
        crashHandler.init(this);*/
    }
}