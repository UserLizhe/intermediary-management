package com.example.intermediarymanagementboot.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.intermediarymanagementboot.demo.entity.User;
import com.example.intermediarymanagementboot.demo.mapper.LoginMapper;
import com.example.intermediarymanagementboot.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILoginService extends ServiceImpl<LoginMapper, User> implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User login(User user) {
        User user1 = loginMapper.login(user);
        return user1;
    }

}
