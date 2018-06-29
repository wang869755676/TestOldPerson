package com.jin.testoldperson.material;

/**
 * Created by my on 2018/6/28.
 */

class Aby  implements Cloneable{
    public  int i;
    public Aby(int i) {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
