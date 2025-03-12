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
    public boolean login(User user) {
        User user1 = loginMapper.login(user);
        boolean isT;
        if (user1!=null){
            isT=false;
        }else {
            isT=true;
        }
        return isT;
    }
}
