package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.impl.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        // 加载spring 上下文 加载ioc
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");

        IUserService service = ioc.getBean(IUserService.class);;
        service.getUser();
    }
}
