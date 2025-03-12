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

    // 添加角色对象字段（用于JWT生成）
    @TableField(exist = false) // 非数据库字段
    private Role role;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
