package com.jin.testoldperson.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

public class CheckApkExist {
    private static String facebookPkgName = "com.facebook.katana";

    public static boolean checkApkExist(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName))
            return false;
        try {
            PackageInfo info = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);

            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
   public static void getAllPagcke( Context context )
    {
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for ( int i = 0; i < pinfo.size(); i++ )
        {
            Log.e("===",pinfo.get(i).packageName+"----------");
        }

    }


}