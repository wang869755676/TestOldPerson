package com.jin.testoldperson.night;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.jin.testoldperson.R;

public class NightActivity extends AppCompatActivity {

    private  int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);
       mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
    }

    public void changeTheme(View view) {
        if(mode == Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate
                    .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if(mode == Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate
                    .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            // blah blah
        }
        recreate();
    }
}
