package com.alan.api.mapper;

import com.alan.api.core.mapper.MyMapper;
import com.alan.api.model.Permission;
import com.alan.api.model.Resource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author: alan.peng
 * description: 资源控制
 * date: create in 10:09 2018/11/7
 * modified By：
 */
public interface PermissionMapper extends MyMapper<Permission>{

    /**
     * 找到所有权限可控资源
     * @return
     */
    List<Resource> findResourceWithHandle();


    /**
     * 通过ID找到所有权限可控资源
     * @param roleId
     * @return
     */
    List<Resource> findRoleWithResourceByRoleId(@Param("roleId") Long roleId);


    /**
     * 获取所有权限代码
     * @return
     */
    @Select("SELECT p.code FROM `permission` p")
    List<String> findAllCode();

}
