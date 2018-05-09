package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-05-05-13:02
 */
@SpringBootApplication
@ImportResource(value = {"classpath:bean.xml"})
public class HelloSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBoot.class,args);
    }

}
