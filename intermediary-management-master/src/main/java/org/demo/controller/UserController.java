package org.demo.controller;

import org.demo.common.Result;
import org.demo.entity.User;
import org.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(User user){
        User u= userService.findByUserName(user.getUsername());
        if (u==null){
            userService.register(user);
            return  Result.success();
        }else {
            return Result.error("用户名已被占用");
        }
    }
}
