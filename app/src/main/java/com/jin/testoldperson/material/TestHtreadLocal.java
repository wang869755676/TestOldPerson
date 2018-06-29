package com.jin.testoldperson.material;

/**
 * Created by my on 2018/6/27.
 */

public class TestHtreadLocal {
    private ThreadLocal<My> threadLocal=new ThreadLocal<>();
    public String name;
    public My my;

    public My getMy() {
        return threadLocal.get();
    }

    public void setMy(My my) {
        threadLocal.set(my);
    }

    public TestHtreadLocal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
