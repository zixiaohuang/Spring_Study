package cn.hw.dao.impl;

import cn.hw.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void getUser() {
        System.out.println("查询数据库");
    }
}
