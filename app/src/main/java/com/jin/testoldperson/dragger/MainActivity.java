package com.jin.testoldperson.dragger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.jin.testoldperson.R;
import com.jin.testoldperson.permission.PermissionHandle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this)).build()
                .inject(MainActivity.this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionHandle.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    /*
        switch (requestCode) {
            case 1:
                if (PermissionUtils.verifyPermissions(grantResults)) {
                    Log.e("====", "permissionGrand================");
                } else {
                    if (!PermissionUtils.shouldShowRequestPermissionRationale(this, PermissionHandle.PERMISSION_CAMERA)) {
                        Log.e("====", " permissionNeverAsk===========");
                    } else {
                        Log.e("====", " permissionDeny==============");
                    }
                }
                break;
        }*/
    }
}
