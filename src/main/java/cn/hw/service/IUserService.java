package cn.hw.service;

import cn.hw.entity.User;

public interface IUserService {
    User select(Integer id) throws Exception;
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(Integer id) throws Exception;
}
