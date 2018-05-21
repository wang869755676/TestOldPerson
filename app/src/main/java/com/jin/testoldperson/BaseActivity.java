package com.jin.testoldperson;

import android.app.Activity;
import android.os.Bundle;

import com.jin.testoldperson.dialog.ActivityController;

public class BaseActivity extends Activity {
    @Override  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        ActivityController.addActivity(this);
        ActivityController.setCurrentActivity(this);  
    }  
  
    @Override  
    protected void onDestroy() {  
        super.onDestroy();  
        ActivityController.removeActivity(this);  
    }  
}  