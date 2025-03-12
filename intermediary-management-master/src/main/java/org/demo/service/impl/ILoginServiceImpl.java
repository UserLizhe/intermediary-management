package org.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.demo.entity.User;
import org.demo.mapper.LoginMapper;
import org.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {
    @Autowired
    private LoginMapper loginMapper;


    @Override
    public User login(User user) {
        return null;
    }
}
