package cn.hw.dao.impl;

import cn.hw.dao.IUserDao;
import cn.hw.entity.User;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements IUserDao {

    @Override
    public User select(Integer id) throws Exception {
        if(id == null) {
            throw new Exception("id不能为null");
        }
        // 访问数据库，查询User
        return new User();
    }

    @Override
    public void add(User user) throws Exception {
        if(user == null) {
            throw new Exception("user不能为null");
        }
    }

    @Override
    public void update(User user) throws Exception {
        if(user == null) {
            throw new Exception("user不能为null");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == null) {
            throw new Exception("id不能为null");
        }
    }
}
