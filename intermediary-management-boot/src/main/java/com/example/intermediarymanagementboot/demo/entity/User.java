package com.example.intermediarymanagementboot.demo.entity;
// User.java
import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer roleId;
}


