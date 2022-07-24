package cn.hw.controller;

import cn.hw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;


/**
 *
 * 实现数据验证的步骤
 * 1。加入hiernate-validator依赖
 * 2。将新加入的jar包 加入到WEB-INF/lib中
 * 3。在需要验证的javaBean的属性中加入对应的验证注解, 可以设置message属性定制更友好错误提示信息
 * 4.在需要验证的处理方法的对应javaBean参数上面加上@Valid
 * 5。在需要验证的处理方法参数中加入BindingResult, 代表自己处理错误，这样就会显示错误页面也没了
 *
 * * 基于原生html form表单实现方式：
 *      1。在将错误信息循环通过map存入到request域中
 *      2。在jsp通过${errors.id}获取对应的错误信息
 *
 *  * 基于spring form标签库的实现方式:
 *      1. 添加一个显示jsp的处理方法，一定要传入一个空的User到Model中
 *      2。在jsp中导入spring-form标签
 *      3.在form标签上一定要加上ModelAttribute
 *      4.加上对应的form标签，必须都要以form：开头
 */

/**
 * 1。解决java的硬编码的国际化
 *      1。在属性资源文件中加入需要国际化的硬编码内容
 *      2。将MessageSource 自动注入进来
 *      3。根据MessageSource getMessage 获取国际化内容
 *         String code, 资源文件中的key
 *         @Nullable Object[] args,  文本中的参数 可以用占位符的方式在资源文件文本中设置参数占位符 {0}方式
 *         Locale locale 当前本地化语言
 *
 */
@Controller
public class UserController {
    @Autowired
    MessageSource messageSource;

    @PostMapping("/user")
    public String add(@Valid User user, BindingResult result, Model model, Locale locale) {
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
            System.out.println("errors happened");
            model.addAttribute("errMsg", messageSource.getMessage("add_error", null, locale));
//            model.addAttribute("errors", messageSource.getMessage());
            // 如果验证失败将请求重新转发到添加页面
            return "user/add";
        }
        System.out.println(user);
        return "show";
    }

    @ModelAttribute // 每次方法调用前都会调用
    public void initData(Model model) {
        // 初始化该页面的数据
//        List<String> list = Arrays.asList("唱歌", "跳舞");
//        model.addAttribute("list", list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "唱歌");
        map.put("2", "跳舞");
        model.addAttribute("list", map);
    }

    @PostMapping("/form/user")
    public String springformAdd(@Valid User user, BindingResult result, Model model, Locale locale) {
        if(result.hasErrors()) {
            model.addAttribute("errMsg", messageSource.getMessage("add_error", null, locale));
            return "user/add";
        }
        System.out.println(user);
        return "show";
    }

    @GetMapping("/user/add")
    public String addView(User user, Model model) { // 自动new 一个User

        return "user/add";
    }

    @RequestMapping("/usr/add/{language}_{country}")
    public String changeLocale(User user,
                               @PathVariable("language") String language,
                               @PathVariable("country") String country,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               @Autowired SessionLocaleResolver localeResolver) {
        System.out.println("language: " + language + ", country: " + country);
        Locale local = new Locale(language, country);
        localeResolver.setLocale(request, response, local);
        return "user/add";
    }
}
