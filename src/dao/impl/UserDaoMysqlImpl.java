package dao.impl;

import dao.IUserDao;

public class UserDaoMysqlImpl implements IUserDao {
    @Override
    public void getUser() {
        System.out.println("查询MySQL");
    }
}
