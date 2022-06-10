package cn.hw.service;

// 设置成泛型
public interface BaseService<T> {
    T getBean();

    // 公共增删查改
}
