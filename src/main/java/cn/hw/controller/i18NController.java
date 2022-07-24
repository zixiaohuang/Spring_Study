package cn.hw.controller;

import cn.hw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 根据浏览器设置语言切换
 *  1.新建jsp对应的国际化属性资源文件：
 *  login.properties
 *  login_en_US.properties
 *  login_zh_CN.properties
 *  2.配置spring mvc，将国际化资源文件注入到spring mvc中
 *  3。页面来调用属性资源文件
 *
 *  使用超链接的方式切换语言
 * 1。更改默认本地化语言解析器LocaleResolver（通过请求头来设置的）改成SessionLocaleResolver（通过超链接形式，且要保持，放到session里面）
 *   方式1：创建一个请求方法接受local参数（en_US\zh_CN）接受到设置session中去
 *   方式2：使用spring mvc提供的拦截器,接收local参数(en_US\zh_CN) 设置session中去
 *
 *
 */

@Controller
public class i18NController {

    @RequestMapping("/i18n")
    public String i18n(Locale locale) {
        return "login";
    }


    @RequestMapping("/i18n/{language}_{country}")
    public String changeLocale(@PathVariable("language") String language,
                               @PathVariable("country") String country,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               @Autowired SessionLocaleResolver localeResolver) {
        Locale local = new Locale(language, country);
        localeResolver.setLocale(request, response, local);
        return "login";
    }


}
