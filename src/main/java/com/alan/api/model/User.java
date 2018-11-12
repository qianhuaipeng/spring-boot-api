package com.alan.api.model;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

/**
 * author: alan.peng
 * description: 用户信息类
 * date: create in 17:39 2018/11/2
 * modified By：
 */
@Data
public class User {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3, message = "用户名长度过不能小于3")
    private String username;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能小于6")
    private String password;

    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不能为空")
    @Email
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String resume;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Timestamp registerTime;

    /**
     * 上一次登录时间
     */
    @Column(name = "login_time")
    private Timestamp loginTime;

    /* ---------------- 以下字段来自于联表查询  ----------------*/
    /**
     * 用户的角色ID
     */
    @Transient
    private Long roleId;

    /**
     * 用户的角色名
     */
    @Transient
    private String roleName;

    /**
     * 用户角色对应的权限code
     */
    @Transient
    private List<String> permissionCodeList;


}