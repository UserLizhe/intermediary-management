package com.example.intermediarymanagementboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.intermediarymanagementboot.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface LoginMapper extends BaseMapper<User> {
    boolean login(@Param("param") User user);
}
