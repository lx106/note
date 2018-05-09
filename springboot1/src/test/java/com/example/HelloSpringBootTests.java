package com.example;
import com.example.bean.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-05-05-13:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSpringBootTests {

    @Autowired
    private User user;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void contextLoads(){
        System.out.println(user);
        boolean flag = ioc.containsBean("userService");
        System.out.println(flag);
    }
}
