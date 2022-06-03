package dao.impl;

import dao.IUserDao;

public class UserDaoImpl implements IUserDao {

    @Override
    public void getUser() {
        System.out.println("查询数据库");
    }
}
