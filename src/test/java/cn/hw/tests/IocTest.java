package cn.hw.tests;

import cn.hw.beans.Role;
import cn.hw.beans.User;
import cn.hw.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

    ClassPathXmlApplicationContext ioc;
    @Before
    public void before() {
        ioc = new ClassPathXmlApplicationContext("spring_ioc.xml");
    }

    @Test
    public void test() {
        UserController userController = ioc.getBean("userController", UserController.class);
        System.out.println(userController);
    }

    @Test
    public void test2() {
        User bean = ioc.getBean(User.class);
        System.out.println(bean.getName());
    }

    @Test
    public void test3() {
        UserController bean = ioc.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    public void test4() {

        Role bean = ioc.getBean(Role.class);
        ioc.close();
    }
}
