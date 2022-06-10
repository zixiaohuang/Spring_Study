package cn.hw.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@DependsOn("user") // depends-on 因为依赖，所以会改变加载顺序
//@Lazy // lazy-init 懒加载
//@Scope("prototype") // singleton单例 prototype 多例
public class Role {
    @Value("管理员")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role() {
        System.out.println("Role已加载");
    }

    // 生命周期回调 初始化
    @PostConstruct
    public void init() {
        System.out.println("初始化");
    }

    // 生命周期回调 销毁
    @PreDestroy
    public void destroy() {
        System.out.println("销毁");
    }
}
