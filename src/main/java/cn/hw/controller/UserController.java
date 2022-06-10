package cn.hw.controller;

import cn.hw.beans.Role;
import cn.hw.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    /*
    * 使用AutoWired来实现自动注入
    * bytype byname
    * 默认优先根据类型去匹配
    * 如果匹配到多个类型则会按照名字匹配
    * 如果名字又没有匹配则会报错
    *       1。可以去修改属性的名字对应bean的名字 为对应类的首字母小写userServiceImpl
    *       2。可以去修改bean的名字对应属性的名字 类上的value标明 @Service(value = "userService")
    *       3。可以加一个@Qualifier("userServiceImpl")设置属性的别名(覆盖)
    *       4. 可以通过@Primary 设置其中一个Bean为主要自动注入Bean
    *       5. 使用泛型作为自动注入限定符
     * */

    /*
    * @Autowired和@Resource区别
    * @Resource依赖jdk，@Autowired依赖spring
    * @Resource优先根据名字匹配
    * @Autowired 优先根据类型匹配
    * */

    @Autowired
//    @Qualifier("userService")
    BaseService<Role> userService;

    public void getUser() {
        userService.getBean();
    }
}
