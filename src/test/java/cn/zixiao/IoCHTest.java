package cn.zixiao;

import hw.zixiao.beans.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCHTest {
    ClassPathXmlApplicationContext ioc;;
    @Before
    public void before() {
        // 加载spring容器
        // ApplicationContext spring的顶层核心接口
        // ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
        // FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化spring容器
        // AnnotationConfigApplicationContext 根据javaconfig来配置实例化spring容器
        // 在容器实例化的时候， 就会加载所有的bean
        ioc = new ClassPathXmlApplicationContext("spring-ioc-high.xml");
    }

    @Test
    public void test1() {
        System.out.println("Spring已加载");
    }

    @Test
    public void test2() {
        // 测试单例/多例范围
        System.out.println("Spring已加载");
        Person person1 = ioc.getBean("person", Person.class);
        Person person2 = ioc.getBean("person", Person.class);
        System.out.println(person1);

    }

    @Test
    public void test3() {
        // 静态工厂方法实例化
        Person person1 = ioc.getBean("person2", Person.class);
        System.out.println(person1);

    }

    @Test
    public void test4() {
        Person person1 = ioc.getBean("person3", Person.class);
        System.out.println(person1);

    }

    @Test
    public void test5() {
        // 自动注入
        Person person1 = ioc.getBean("person4", Person.class);
        System.out.println(person1);

    }

    @Test
    public void test6() {
        // 生命周期回调
        // 1. 通过接口方式
        // 初始化回调 实现InitializingBean 重写afterPropertiesSet
        // 销毁回调 实现DisposableBean 重写destory
        // 2。通过配置方式
        // 接口先，后配置
        Person person1 = ioc.getBean("person", Person.class);
        System.out.println(person1);
        ioc.close(); // ioc关闭的时候才会销毁，防止单例重复创建销毁的动作
    }
}
