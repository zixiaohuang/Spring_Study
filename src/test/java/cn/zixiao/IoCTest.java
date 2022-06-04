package cn.zixiao;

import hw.zixiao.beans.Person;
import hw.zixiao.beans.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCTest {

    ApplicationContext ioc;;
    @Before
    public void before() {
        // 加载spring容器
        // ApplicationContext spring的顶层核心接口
        // ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
        // FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化spring容器
        // AnnotationConfigApplicationContext 根据javaconfig来配置实例化spring容器
        // 在容器实例化的时候， 就会加载所有的bean
         ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
    }

    @Test
    public void test01(){

        System.out.println("Spring容器已加载");
        // 获取bean
        // 1。通过类来获取，getBean(User.class)
//        User bean = ioc.getBean(User.class); // new User()
        // 2。通过bean的名字或者id来获取
        // 3.通过名字-类型
        User bean = (User)ioc.getBean("user");

        System.out.println(bean);
    }

    /*
        通过别名来获取
    */
    @Test
    public void test02() {

        User bean = ioc.getBean("haha", User.class);
        System.out.println(bean);
    }

    @Test
    public void test03() {

        User bean = ioc.getBean("user2", User.class);
        System.out.println(bean);
    }

    @Test
    public void test04() {

        User bean = ioc.getBean("user3", User.class);
        System.out.println(bean);
    }

    @Test
    public void test05() {

        Person bean = ioc.getBean("person", Person.class);
        System.out.println(bean);
    }
}
