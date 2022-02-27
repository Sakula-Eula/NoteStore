package service.Impl;

import Dao.accountDao;
import Dao.impl.accountImpl;
import service.accountService;

public class accountServiceImpl implements accountService {

    //    下面的accountdao后不new一个对象的话就无法使用
  private accountDao accountdao;
//  不是默认无参函数，就会直接报错，不然使用另外两种实例化bean方法
   /* public accountServiceImpl(accountDao accountdao) {
        this.accountdao = accountdao;
    }*/
    public void select() {
        accountdao.select();
    }
    public accountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  init(){
        System.out.println("对象初始化了。。。");
    }
    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }
}
