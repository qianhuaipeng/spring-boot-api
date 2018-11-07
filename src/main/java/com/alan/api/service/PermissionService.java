package com.alan.api.service;

import com.alan.api.core.service.Service;
import com.alan.api.model.Permission;
import com.alan.api.model.Resource;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 11:20 2018/11/7
 * modified By：
 */
public interface PermissionService extends Service<Permission>{

    /**
     * 找到所有权限可控资源
     * @return
     */
    List<Resource> findResourceWithHandle();

    /**
     * 通过角色ID查找所有可控资源
     * @param roleId 角色ID
     * @return
     */
    List<Resource> findRoleWithResourceByRoleId(Long roleId);
}
