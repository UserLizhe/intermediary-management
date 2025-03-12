package org.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.demo.entity.User;

public interface LoginService extends IService<User> {

    User login(User user);

}
