package com.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuxun
 * @since 2018-04-04
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    //@Select("select * from user where id = #{id}")
    User getById(int id);
}
