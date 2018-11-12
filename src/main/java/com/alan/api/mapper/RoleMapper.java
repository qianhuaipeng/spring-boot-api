package com.alan.api.mapper;

import com.alan.api.core.mapper.MyMapper;
import com.alan.api.model.Role;
import com.alan.api.model.RoleWithResource;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:34 2018/11/11
 * modified By：
 */
public interface RoleMapper extends MyMapper<Role>{

    /**
     * 获取所有角色以及对应的权限
     *
     * @return
     */
    List<RoleWithResource> findRoleWithPermission();


    /**
     * 获取所有角色以及对应的权限
     * @return
     */
    List<RoleWithResource> findRoles();
}
