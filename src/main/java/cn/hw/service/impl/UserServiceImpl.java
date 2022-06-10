package cn.hw.service.impl;

import cn.hw.beans.User;
import cn.hw.dao.UserDao;
import cn.hw.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service(value = "userService") //userServiceImpl
@Service
@Primary
public class UserServiceImpl implements BaseService<User> {
    @Autowired
    UserDao userDao;
    public User getBean() {
        System.out.println("UserServiceImpl");
        userDao.getUser();
        return null;
    }
}
