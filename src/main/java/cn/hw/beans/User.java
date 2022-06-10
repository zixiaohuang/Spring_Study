package cn.hw.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    /*
    * 使用 @Value设置依赖注入的属性
    * 1。除了可以写硬编码值
    * 2。还可以写${}\ #{SPEL语言} 通过SPEL可以获取一个外部Bean的属性
    * */
//    @Value("${mysql.name}")
    @Value("#{role.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
        System.out.println("User已加载");
    }
}
