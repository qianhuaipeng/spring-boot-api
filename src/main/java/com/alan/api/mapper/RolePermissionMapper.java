package com.alan.api.mapper;

import com.alan.api.core.mapper.MyMapper;
import com.alan.api.model.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:44 2018/11/11
 * modified By：
 */
public interface RolePermissionMapper extends MyMapper<RolePermission> {

    /**
     *  保存角色以及对应的权限ID
     * @param roleId                角色ID
     * @param permissionIdList      权限ID列表
     */
    void saveRolePermission(@Param("roleId") Long roleId, @Param("permissionList") List<Integer> permissionIdList);
}
