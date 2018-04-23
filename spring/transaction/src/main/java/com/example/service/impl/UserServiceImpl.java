package com.example.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    //@Transactional
    @Transactional
    public User getById(int i) {
        return userMapper.getById(i);
    }

    @Override
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert2(User user) {
        return userMapper.insertAllColumn(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert20(User user) {
        int count = userMapper.insertAllColumn(user);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 1/0;
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert21(User user) {
        userMapper.insertAllColumn(user);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 1/0;
        return 1;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED)
    //@Transactional
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    public int insert22(User user) {
        return userMapper.insertAllColumn(user);
    }

    @Override
    @Transactional
    public User getById20(int i) {
        return userMapper.getById(i);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED)
    //2@Transactional
    public int selectCount21(){
        return userMapper.selectCount(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
    //@Transactional
    public int selectCount22(){
        return userMapper.selectCount(null);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert3(User user) {
        return userMapper.insertAllColumn(user);
    }
}
