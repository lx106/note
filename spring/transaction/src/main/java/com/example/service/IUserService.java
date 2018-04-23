package com.example.service;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.example.entity.User;
import org.springframework.transaction.annotation.Propagation;
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

    int insert20(User user);

    int insert21(User user);

    int insert22(User user);

    User getById20(int i);

    int insert3(User user);

    int selectCount21();

    int selectCount22();
}
