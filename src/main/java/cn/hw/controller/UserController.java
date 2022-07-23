package cn.hw.controller;

import cn.hw.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * 实现数据验证的步骤
 * 1。加入hiernate-validator依赖
 * 2。将新加入的jar包 加入到WEB-INF/lib中
 * 3。在需要验证的javaBean的属性中加入对应的验证注解
 * 4.在需要验证的处理方法的对应javaBean参数上面加上@Valid
 * 5。在需要验证的处理方法参数中加入BindingResult, 代表自己处理错误，这样就会显示错误页面也没了
 *
 * 基于原生form表单实现方式：
 * 1。在将错误信息循环通过map存入到request域中
 * 2。在jsp通过${errors.id}获取对应的错误信息
 */
@Controller
public class UserController {
    @PostMapping("/user")
    public String add(@Valid User user, BindingResult result, Model model) {
        // 将错误信息取出来，输出到jsp页面
        if(result.hasErrors()) {
            // 存放错误信息：key=错误信息的属性名 value=错误信息 这样就有利于在jsp中分别取出${errors.id}
            Map<String, String> errors = new HashMap<>();

            // 获取所有的错误信息 包含错误的属性，错误信息
            List<FieldError> fieldErrors = result.getFieldErrors();
            // 循环转移到map中
            for(FieldError fieldError: fieldErrors) {
                // fieldError.getField() 是属性名
                // filedError.getDefaultMessage() 验证失败的错误信息
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            // 如果验证失败将请求重新转发到添加页面
            return "user/add";
        }
        System.out.println(user);
        return "show";
    }
}
