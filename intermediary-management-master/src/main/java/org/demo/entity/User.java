package org.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.joda.time.DateTime;

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
    @TableField("nickname")
    private String nickname; // 用户昵称（数据库注释已标明）
    @TableField("user_pic")
    private String userPic; // 用户头像路径
    @TableField("create_time")
    private DateTime createTime; // 推荐使用Java8时间类型
    @TableField("update_time")
    private DateTime updateTime;


}
