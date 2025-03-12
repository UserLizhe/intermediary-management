package com.example.intermediarymanagementboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.intermediarymanagementboot.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper extends BaseMapper<User> {
//    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User login(User user);
}
