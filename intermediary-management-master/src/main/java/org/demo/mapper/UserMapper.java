package org.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.demo.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //根据用户名查询用户
    @Select("select * from users where username=#{username}")
    User findByUserName(String username);
    //添加
    @Insert("insert into users (username,password,role_id,email,phone,nickname,user_pic,create_time,update_time)"+
    "values(#{username},#{password},#{roleId},#{email},#{phone},#{nickname},#{userPic},now(),now())")
    void add(User user);
}
