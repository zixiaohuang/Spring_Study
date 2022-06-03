package service.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import service.IUserService;

public class UserServiceImpl implements IUserService {

    public IUserDao getDao() {
        return dao;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    IUserDao dao;
    @Override
    public void getUser() {
        dao.getUser();
    }
}
