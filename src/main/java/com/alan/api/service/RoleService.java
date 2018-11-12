package com.alan.api.service;

import com.alan.api.core.service.Service;
import com.alan.api.dto.RoleWithPermission;
import com.alan.api.model.Role;
import com.alan.api.model.RoleWithResource;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:36 2018/11/11
 * modified By：
 */
public interface RoleService extends Service<Role>{

    /**
     * 新建角色
     * @param role 带权限列表的角色
     */
    void save(RoleWithPermission role);

    /**
     * 更新角色
     * @param role 带权限列表的角色
     */
    void update(RoleWithPermission role);

    /**
     * 获取所有角色以及对应的角色
     * @return
     */
    List<RoleWithResource> findRoleWithPermission();
}
