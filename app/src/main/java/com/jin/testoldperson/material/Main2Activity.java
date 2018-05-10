package com.jin.testoldperson.material;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.jin.testoldperson.BLACKTECH.HomeKeyEventBroadcoast;
import com.jin.testoldperson.R;

import java.util.Arrays;
import java.util.Collections;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        StringBuilder sb = new StringBuilder();
        String str = "Argument goes here";
        if (str.length() > 0) {
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
        }
        str.toCharArray();
        HomeKeyEventBroadcoast receiver = new HomeKeyEventBroadcoast();
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));


    }
}
