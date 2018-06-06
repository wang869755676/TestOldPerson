package com.jin.testoldperson.dragger;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

//定义Module
@Module
public class ActivityModule {
    private Context mContext;
    private Context mAppContext ;

    public ActivityModule(Context context) {
        mContext = context;
        mAppContext=mContext.getApplicationContext();
    }

    @Named("Activity")
    @Provides
    public Context provideContext() {
        return mContext;
    }

    @Named("Application")
    @Provides
    public Context provideApplicationContext() {
        return mAppContext;
    }
}


