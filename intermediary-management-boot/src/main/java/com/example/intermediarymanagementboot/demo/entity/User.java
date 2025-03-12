package com.example.intermediarymanagementboot.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users") // 指定数据库表名
public class User {
    private String id;
    @TableField("username") // 指定数据库列名
    private String username;
    @TableField("password")
    private String password;
    @TableField("role_id") // 假设数据库列名为 role_id
    private String roleId;
    @TableField("email")
    private String email;
    @TableField("phone")
    private String phone;
}
