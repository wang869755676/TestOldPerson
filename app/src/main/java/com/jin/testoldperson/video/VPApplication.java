package com.jin.testoldperson.video;

import android.app.Application;

import com.jin.testoldperson.CrashHandler;

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
        CrashHandler crashHandler=CrashHandler.getInstance();
        crashHandler.init(this);
    }
}