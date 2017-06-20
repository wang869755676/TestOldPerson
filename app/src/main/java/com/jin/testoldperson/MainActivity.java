package com.jin.testoldperson;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.jin.testoldperson.permission.PermissionHandle;
import com.jin.testoldperson.permission.PermissionUtils;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (PermissionUtils.verifyPermissions(grantResults)) {
                    Log.e("====", "permissionGrand");
                } else {
                    if (!PermissionUtils.shouldShowRequestPermissionRationale(this, PermissionHandle.PERMISSION_CAMERA)) {
                        Log.e("====", " permissionNeverAsk");
                    } else {
                        Log.e("====", " permissionDeny");
                    }
                }
                break;
        }
    }
}
