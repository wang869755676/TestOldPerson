package com.jin.testoldperson.dialog;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class ForceExitReceiver extends BroadcastReceiver {
  
    @Override  
    public void onReceive(final Context context, Intent intent) {
        final Activity activity = ActivityController.getCurrentActivity();
        Log.d("activity", activity + "");
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle("Warning")  
                .setMessage("您已经被强制退出登录，请重新登录")  
                .setCancelable(false)  
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override  
                    public void onClick(DialogInterface dialog, int which) {  
                        ActivityController.finishAll();  

                    }  
                });  
        dialog.create().show();  
    }  
}  