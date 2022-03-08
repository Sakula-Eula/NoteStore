import Dao.accountDao;
import Dao.impl.accountImpl;
import com.home;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Impl.accountServiceImpl;
import service.accountService;

public class useApp {
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取资源
        /*home ho = (home) ctx.getBean("home");
        home ho1 = (home) ctx.getBean("home");
        home ho2 = (home) ctx.getBean("home");
        ho.save();
        ho.save();*/
        /*accountDao ad= (accountDao) ctx.getBean("accountDao");//直接使用就可,不用直接new
        ad.select();

        accountDao ad=new accountImpl();
        ad.select();
        */
        accountService as1= (accountService) ctx.getBean("accountService");
        System.out.println(as1);
//        as1.select(); 不可以直接使用select方法，因为还没有在业务层注入对象

       /* accountServiceImpl as=new accountServiceImpl();
        as.select();*/



    }
}
