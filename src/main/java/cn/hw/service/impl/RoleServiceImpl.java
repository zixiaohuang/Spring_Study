package cn.hw.service.impl;

import cn.hw.beans.Role;
import cn.hw.dao.UserDao;
import cn.hw.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements BaseService<Role> {
    @Autowired
    UserDao userDao;
    public Role getBean() {
        System.out.println("RoleServiceImpl");
        userDao.getUser();
        return null;
    }
}