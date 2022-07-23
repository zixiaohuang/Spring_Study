package cn.hw.controller;

import cn.hw.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/converter")
public class ConverterController {
    @RequestMapping("/test")
    public String test(User user) {
        System.out.println(user);
        return "show";
    }

}
