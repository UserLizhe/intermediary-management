package org.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import org.demo.entity.User;

@Mapper
public interface LoginMapper extends BaseMapper<User> {
//    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User login(User user);
}
