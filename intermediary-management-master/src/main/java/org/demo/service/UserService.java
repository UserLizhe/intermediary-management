package org.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.demo.entity.User;

public interface UserService extends IService<User> {
    //根据用户名查询你用户
    User findByUserName(String username);

    //注册
    void register(User user);
}
