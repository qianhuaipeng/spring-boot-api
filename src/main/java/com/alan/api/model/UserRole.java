package com.alan.api.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * author: alan.peng
 * description: 用户角色表
 * date: create in 10:01 2018/11/3
 * modified By：
 */
@Table(name = "user_role")
public class UserRole {


    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    @Getter
    private Long userId;

    @Column(name = "role_id")
    @Getter
    private Long roleId;

    public UserRole setRoleId(final Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public UserRole setUserId(final Long userId) {
        this.userId = userId;
        return this;
    }
}
