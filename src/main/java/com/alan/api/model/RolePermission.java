package com.alan.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * author: alan.peng
 * description:
 * date: create in 10:28 2018/11/7
 * modified By：
 */
@Data
@Table(name = "role_permission")
public class RolePermission {

    /**
     * 角色ID
     */
    @Id
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 权限ID
     */
    @Column(name = "permission_id")
    private Long permissionId;
}
