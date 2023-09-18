package com.project.backend.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户试图
 */
@Data
public class AccountVo implements Serializable {

    /**
     * 用户名
     */
    private String account_name;

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

    private static final long serialVersionUID = 1L;
}
