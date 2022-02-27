package com.Dao.Impl;

import com.Dao.Impl.eatipml;
import com.Dao.finish;

public class finishimpl implements finish {
    private String name;
    private int num;
    private eatipml a;

    public void setA(eatipml a) {
        this.a = a;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void divie() {
        System.out.println("游啊游。。。。。"+name+num);
        System.out.println(a);
    }
public <e>void send(){
    System.out.println("e");

}


}
