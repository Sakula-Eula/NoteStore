package com.ui;

import com.service.Impl.accountServiceImpl;
import com.service.Impl.accountServiceImpl2;
import com.service.Impl.accountServiceImpl3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// 测试注入方法
public class TestSet {
    public static void main(String[] args) {
        ApplicationContext act=new ClassPathXmlApplicationContext("set.xml");

        accountServiceImpl asi= (accountServiceImpl) act.getBean("accountService");//构造函数构造


        asi.select();

        accountServiceImpl2 asi2= (accountServiceImpl2) act.getBean("accountService2");//setDi
        asi2.select();

        accountServiceImpl3 asi3= (accountServiceImpl3) act.getBean("accountService3");//
        asi3.select();



    }
}
