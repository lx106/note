package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @Autowired
    private User user;


    @RequestMapping("/")
    @ResponseBody
    public String home() {
        UserService userService = new UserService();
        System.out.println(user);
        System.out.println(user);
        System.out.println(user);
        System.out.println(user);
        return "Hello World!";
    }

    @GetMapping("/hello1")
    public String hello() {
        return "hello";
    }


}
