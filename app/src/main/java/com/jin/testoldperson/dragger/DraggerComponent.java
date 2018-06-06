package com.jin.testoldperson.dragger;

import dagger.Component;

/**
 * Created by my on 2018/6/4.
 */

@Component(modules ={DraggerModule.class,DraggerModule1.class })
public interface DraggerComponent {  // 必须定义为接口，Dagger2框架将自动生成Component的实现类，对应的类名是Dagger×××××，这里对应的实现类是DaggerDraggerComponent

    void inject(A a); // 注入到 A的方法里
}
