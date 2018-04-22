package com.example.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuxun
 * @since 2018-04-04
 */
public interface IUserService extends IService<User> {


    User getById(int i);

    int insert2(User user);

    int insert3(User user);
}
