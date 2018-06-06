package com.jin.testoldperson.dragger;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by my on 2018/6/4.
 */


public class A {
    @Inject
    B b;  // 成员变量要求是包级可见，也就是说@Inject不可以标记为private类型。
    @Inject
    C c;

    public void init() {
        DaggerDraggerComponent.builder().draggerModule(new DraggerModule()).build().inject(this);
        Log.e("===", b.toString());
       // WifiConfiguration
        //EthernetManager
        //Ethernet
    }

}
