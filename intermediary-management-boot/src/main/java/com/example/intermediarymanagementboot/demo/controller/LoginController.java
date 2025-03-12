package com.example.intermediarymanagementboot.demo.controller;

import com.example.intermediarymanagementboot.demo.common.Result;
import com.example.intermediarymanagementboot.demo.entity.User;
import com.example.intermediarymanagementboot.demo.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loginUser")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/auth")
    public Result<Map<String, Object>> login(@RequestBody User user) {
        User dbUser = loginService.login(user);
        if (dbUser == null) return Result.fail("用户名或密码错误");

        String token = Jwts.builder()
                .setSubject(dbUser.getUsername())
                .claim("role", dbUser.getRole().getRoleName()) // 确保角色字段存在且正确
                .signWith(SignatureAlgorithm.HS256, "yourSecretKey") // 密钥需与验证逻辑一致
                .compact();

        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("role", dbUser.getRole().getRoleName()); // 返回角色给前端
        return Result.success(data);
    }


}
