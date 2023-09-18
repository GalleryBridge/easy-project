package com.project.backend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "account")
public class Account implements Serializable {

    /**
     * 用户ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer account_id;

    /**
     * 用户名
     */
    private String account_name;

    /**
     * 密码
     */
    private String account_password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date create_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
