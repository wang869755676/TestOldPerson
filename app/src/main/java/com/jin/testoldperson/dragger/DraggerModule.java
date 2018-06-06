package com.jin.testoldperson.dragger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by my on 2018/6/4.
 */

@Module
public class DraggerModule {

    @Provides
    public B getB(){
        return new B();
    }

}
