package org.demo.entity;
// Role.java

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.joda.time.DateTime;


@Data
@TableName("roles")
public class Role {

    @TableField("id") // 主键字段
    private String id;

    @TableField("role_name") // 角色名称
    private String roleName;

    @TableField("role_remake") // 角色备注
    private String roleRemake;

    @TableField("create_time") // 创建时间
    private DateTime createTime;

    @TableField("update_time") // 更新时间
    private DateTime updateTime;

}
