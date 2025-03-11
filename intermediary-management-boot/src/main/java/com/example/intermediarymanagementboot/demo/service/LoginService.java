package com.example.intermediarymanagementboot.demo.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.intermediarymanagementboot.demo.entity.User;

public interface LoginService extends IService<User> {

    boolean login(User user);

}
