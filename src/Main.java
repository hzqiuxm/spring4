import com.qiuxm.controller.UserController;
import com.qiuxm.services.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2016/7/14.
 */
public class Main {
    public static void main(String[] args) {

//        //1 创建spring的IOC对象 ApplicationContext就是IOC容器
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //2 从IOC容器中获取Bean的实例
//        HelloWorld hl = (HelloWorld) ctx.getBean("helloworld");
//        //3 调用方法
//        hl.hello();


        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println("userController = "+userController);

        //接口是没有bean的
//        IUserService iUserService = (IUserService) ctx.getBean("iUserService");
//        System.out.println("iUserService = "+iUserService);

        UserServiceImpl userService = (UserServiceImpl) ctx.getBean("userService");
        System.out.println("userService = "+userService);

        userService.doSomething();

    }
}
