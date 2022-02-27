package com.service.Impl;

import com.service.accountService;
//setDI 一定要有set函数

public class accountServiceImpl2 implements accountService {
    private Integer id;
    private String name;
    private Integer money;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "accountServiceImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    @Override
    public void select() {
        /**/
        System.out.println(id+" is "+name+" he "+"have "+money);
    }
}
