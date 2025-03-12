package org.demo.controller;

import org.demo.common.Result;
import org.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loginUser")
public class LoginController {
//    @Autowired
//    private LoginService loginService;

    @PostMapping("/auth")
    public Result<Map<String, Object>> login(@RequestBody User user) {
//        User dbUser = loginService.login(user);
//        if (dbUser == null) return Result.error("用户名或密码错误");



        Map<String, Object> data = new HashMap<>();
        data.put("token", "token");
        data.put("role", "role"); // 返回角色给前端
        return Result.success(data);
    }


}
