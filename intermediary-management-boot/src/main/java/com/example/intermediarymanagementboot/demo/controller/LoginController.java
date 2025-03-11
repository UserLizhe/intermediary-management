package com.example.intermediarymanagementboot.demo.controller;

import com.example.intermediarymanagementboot.demo.entity.User;
import com.example.intermediarymanagementboot.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping(value = "/list")
    public Map<String, Object> login(@RequestBody User user) {

        boolean success = loginService.login(user);

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        return response;
    }
}
