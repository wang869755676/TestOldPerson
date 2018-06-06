package com.jin.testoldperson.dragger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by my on 2018/6/4.
 */

@Module
public class DraggerModule1 {

    @Provides
    public C getC(){
        return new C();
    }

}
