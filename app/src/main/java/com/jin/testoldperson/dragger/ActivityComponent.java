package com.jin.testoldperson.dragger;

import android.app.Activity;

import dagger.Component;

//定义Component
@Component(modules={ActivityModule.class})
interface ActivityComponent{   
    void inject(Activity container);
}