package com.example.beetl.controller;

import com.example.beetl.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-05-02-15:10
 */
@Controller
public class TestController {


    @GetMapping("/test")
    public String test(Model m) {

        System.out.println("test");
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            userList.add(new User(i,"liuxun"+i));
        }


        m.addAttribute("name","liuxun");
        m.addAttribute("userList",userList);
        return "test.html";
    }
}
