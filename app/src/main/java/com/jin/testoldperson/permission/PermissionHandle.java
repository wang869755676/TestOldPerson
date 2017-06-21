package com.jin.testoldperson.permission;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2017/6/20.
 */

public class PermissionHandle {
    public static final int CODE_RECORD_AUDIO = 0;
    public static final int CODE_GET_ACCOUNTS = 1;
    public static final int CODE_READ_PHONE_STATE = 2;
    public static final int CODE_CALL_PHONE = 3;
    public static final int CODE_CAMERA = 4;
    public static final int CODE_ACCESS_FINE_LOCATION = 5;
    public static final int CODE_ACCESS_COARSE_LOCATION = 6;
    public static final int CODE_READ_EXTERNAL_STORAGE = 7;
    public static final int CODE_WRITE_EXTERNAL_STORAGE = 8;
    public static final int CODE_MULTI_PERMISSION = 100;

    public static final String PERMISSION_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO; // 录音
    public static final String PERMISSION_GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public static final String PERMISSION_READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE; // 读取电话电话状态
    public static final String PERMISSION_CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    public static final String PERMISSION_ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String PERMISSION_ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String PERMISSION_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String PERMISSION_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;


    static void requestPermission(Activity activity,int requestCode,PermissionListener listener,String... permission){
        if(PermissionUtils.hasSelfPermissions(activity,permission)){
            listener.permissionGrand(requestCode);
        }else {
            if(PermissionUtils.shouldShowRequestPermissionRationale(activity,permission)){
                listener.permissionTip(requestCode);
            }else{
                ActivityCompat.requestPermissions(activity, permission,requestCode);

            }
        }
    }
    public static void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        //requestResult(activity, requestCode, permissions, grantResults);
    }
    private static void requestResult(Activity activity, int requestCode, String[] permissions, int[] grantResults,PermissionListener listener) {

        if (PermissionUtils.verifyPermissions(grantResults)) {
          listener.permissionGrand(requestCode);
        } else {
            if (!PermissionUtils.shouldShowRequestPermissionRationale(activity, PermissionHandle.PERMISSION_CAMERA)) {
              listener.permissionNeverAsk(requestCode);
            } else {
                listener.permissionDeny(requestCode);
            }
        }
    }
}
