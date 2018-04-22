package com.example.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuxun
 * @since 2018-04-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    //@Transactional(propagation = Propagation.NEVER)
    public User getById(int i) {
        return userMapper.getById(i);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int insert2(User user) {
        return userMapper.insertAllColumn(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert3(User user) {
        return userMapper.insertAllColumn(user);
    }
}
