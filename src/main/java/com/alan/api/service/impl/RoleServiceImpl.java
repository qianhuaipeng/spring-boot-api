package com.alan.api.service.impl;

import com.alan.api.core.service.AbstractService;
import com.alan.api.dto.RoleWithPermission;
import com.alan.api.mapper.PermissionMapper;
import com.alan.api.mapper.RoleMapper;
import com.alan.api.mapper.RolePermissionMapper;
import com.alan.api.model.Role;
import com.alan.api.model.RolePermission;
import com.alan.api.model.RoleWithResource;
import com.alan.api.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:39 2018/11/11
 * modified By：
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public void save(RoleWithPermission role) {
        this.roleMapper.insert(role);
        this.rolePermissionMapper.saveRolePermission(role.getId(), role.getPermissionIdList());
    }

    @Override
    public void update(RoleWithPermission role) {
        Condition condition = new Condition(RolePermission.class);
        condition.createCriteria().andCondition("role_id = ", role.getId());
        this.rolePermissionMapper.deleteByCondition(condition);
        this.rolePermissionMapper.saveRolePermission(role.getId(), role.getPermissionIdList());
    }

    @Override
    public List<RoleWithResource> findRoleWithPermission() {
        List<RoleWithResource> roles = roleMapper.findRoles();
        roles.forEach(role -> {
            List<com.alan.api.model.Resource> resources = permissionMapper.findRoleWithResourceByRoleId(role.getId());
            role.setResourceList(resources);
        });
        return roles;
    }
}
