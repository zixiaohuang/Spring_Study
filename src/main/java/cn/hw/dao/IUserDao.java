package cn.hw.dao;

import cn.hw.entity.User;

public interface IUserDao {
    User select(Integer id) throws Exception;
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(Integer id) throws Exception;
}
