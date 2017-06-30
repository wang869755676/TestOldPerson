package com.jin.testoldperson.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class MyInstalledReceiver extends BroadcastReceiver {
    @Override  
    public void onReceive(Context context, Intent intent) {
  
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {     // install  
            String packageName = intent.getDataString();  
  
            Log.i("homer", "安装了 :" + packageName);

            final IWXAPI api = WXAPIFactory.createWXAPI(context, null);
            // 将该app注册到微信
            api.registerApp(Constants.APP_ID);
        }  
  
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {   // uninstall  
            String packageName = intent.getDataString();  
  
            Log.i("homer", "卸载了 :" + packageName);  
        }  
    }  
}