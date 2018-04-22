package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {

    @GetMapping("thread")
    public String thread(){
        String name = thread2();
        System.out.println(name);
        return  Thread.currentThread().getName()+":"+name;
    }

    @GetMapping("thread2")
    public String thread2(){
        return  Thread.currentThread().getName();
    }

    public static void main(String[] args){
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
