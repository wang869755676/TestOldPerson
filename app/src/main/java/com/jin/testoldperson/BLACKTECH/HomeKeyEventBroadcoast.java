package com.jin.testoldperson.BLACKTECH;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by my on 2018/5/8.
 */

public class HomeKeyEventBroadcoast extends BroadcastReceiver {

    static final String SYSTEM_REASON = "reason";
    static final String SYSTEM_HOME_KEY = "homekey";
    static final String SYSTEM_RECENT_APPS = "recentapps";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
            String reason = intent.getStringExtra(SYSTEM_REASON);
            if (reason != null) {
                if (reason.equals(SYSTEM_HOME_KEY)) {
                    Log.d("TAG", "收到HomeKey点击");
                } else if (reason.equals(SYSTEM_RECENT_APPS)) {
                    Log.d("TAG", "收到长按Home键或任务键点击");
                }
            }
        }
    }
}
