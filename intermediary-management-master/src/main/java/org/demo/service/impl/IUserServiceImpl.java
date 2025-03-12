package org.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.demo.entity.User;
import org.demo.mapper.UserMapper;
import org.demo.service.UserService;
import org.demo.utils.Md5Util;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(User user) {
        //加密 密码
        String password = Md5Util.getMD5String(user.getPassword());
        user.setPassword(password);
        user.setRoleId("ROLE_admin");
        user.setEmail("1");
        user.setPhone("1");
        user.setNickname("1");
        user.setUserPic("1");
        userMapper.add(user);

    }
}
