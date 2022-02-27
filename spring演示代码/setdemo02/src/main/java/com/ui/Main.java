package com.ui;

import com.Dao.Impl.eatipml;
import com.Dao.Impl.finishimpl;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
       // ApplicationContext act = new FileSystemXmlApplicationContext("applicationContext.xml"); //从容器中获取对象实例用文件
       eatipml e= (eatipml) act.getBean("beanId");
        e.eatFood();
       finishimpl f= (finishimpl) act.getBean("finishimpl");
        f.divie();
        DruidDataSource ds;
        DruidDataSource dataSource = (DruidDataSource) act.getBean("dataSource");
        System.out.println(dataSource);


        ArrayList<String> al=new ArrayList<>();


    }
}
