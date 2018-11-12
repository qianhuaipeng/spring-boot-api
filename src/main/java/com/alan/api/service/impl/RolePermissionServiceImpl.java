package com.alan.api.service.impl;

import com.alan.api.core.service.AbstractService;
import com.alan.api.mapper.RolePermissionMapper;
import com.alan.api.model.RolePermission;
import com.alan.api.service.RolePermissionService;

import javax.annotation.Resource;

/**
 * author: alan.peng
 * description:
 * date: create in 10:52 2018/11/11
 * modified By：
 */
public class RolePermissionServiceImpl extends AbstractService<RolePermission> implements RolePermissionService {

    @Resource
    private RolePermissionMapper rolePermissionMapper;
}
