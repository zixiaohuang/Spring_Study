package cn.hw.service.impl;

import cn.hw.dao.IUserDao;
import cn.hw.entity.User;
import cn.hw.service.IUserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
//public class UserServiceImpl {
    @Autowired
    IUserDao userDao;

    @Override
    @Logger(name = "用户的查询方法")
    public User select(Integer id) throws Exception {
        System.out.println("查询User");
        return userDao.select(id);
    }

    @Override
    public void add(User user) throws Exception {
        System.out.println("增加User");
        userDao.add(user);
    }

    @Override
    public void update(User user) throws Exception {
        System.out.println("更新User");
        userDao.update(user);
    }

    @Override
    public void delete(Integer id) throws Exception {
        System.out.println("删除User");
        userDao.delete(id);
    }
}
