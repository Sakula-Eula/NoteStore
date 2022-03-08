package com.service.Impl;

import com.service.accountService;
// 构造方法来注入对象
public class accountServiceImpl implements accountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private Integer id;
    private String name;
    private Integer money;

    public accountServiceImpl() {
    }
    public accountServiceImpl(Integer id, String name, Integer money) {
        this.id = id;
        this.name = name;
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
