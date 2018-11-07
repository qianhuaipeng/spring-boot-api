package com.alan.api.service.impl;

import com.alan.api.core.service.AbstractService;
import com.alan.api.mapper.PermissionMapper;
import com.alan.api.model.Permission;
import com.alan.api.model.Resource;
import com.alan.api.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 11:21 2018/11/7
 * modified By：
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService{

    @javax.annotation.Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Resource> findResourceWithHandle() {
        return this.permissionMapper.findResourceWithHandle();
    }

    @Override
    public List<Resource> findRoleWithResourceByRoleId(Long roleId) {
        return this.permissionMapper.findRoleWithResourceByRoleId(roleId);
    }
}
