package cn.hw.tests;

import cn.hw.entity.User;
import cn.hw.service.IUserService;
import cn.hw.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext(("classpath:/spring.xml"));
        IUserService bean = ioc.getBean(IUserService.class);
//        bean.select(null); // 前置--> 方法--> 后置 --> 异常
        bean.select(1); // 前置--> 方法--> 后置 --> 返回
        //        UserServiceImpl bean = ioc.getBean(UserServiceImpl.class); // 若实现了接口，要么是通过接口类来获取（因为被代理类），要么通过名字获取，否则会报错
        System.out.println(bean.getClass());
        // 在没有使用aop下：class cn.hw.service.impl.UserServiceImpl
        // 当使用了aop的情况下：
        // 1.jdk代理所产生了一个动态代理类, 当被代理的类实现了接口会默认使用jdk接口
        // class com.sun.proxy.$Proxy19
        // 2.cglib代理所产生的一个动态代理类，当被代理的类没有实现接口就会使用cglib代理
        // class cn.hw.service.impl.UserServiceImpl$$EnhancerBySpringCGLIB$$da6eb431
    }
}
