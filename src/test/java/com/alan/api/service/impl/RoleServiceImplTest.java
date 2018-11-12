package com.alan.api.service.impl;

import com.alan.api.dto.RoleWithPermission;
import com.alan.api.model.RoleWithResource;
import com.alan.api.service.RoleService;
import com.alan.springbootapi.ApplicationTest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 9:30 2018/11/12
 * modified By：
 */
public class RoleServiceImplTest extends ApplicationTest {

    @Resource
    private RoleService roleService;

    @Test
    public void save() {
        RoleWithPermission role = new RoleWithPermission();
        role.setName("ROLE_ABA");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        role.setPermissionIdList(list);
        roleService.save(role);
    }

    @Test
    public void update() {
        RoleWithPermission role = new RoleWithPermission();
        role.setId(Long.valueOf(6));

        role.setName("ROLE_ABA");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        role.setPermissionIdList(list);
        roleService.update(role);
    }

    @Test
    public void findRoleWithPermission() {
        List<RoleWithResource> list = roleService.findRoleWithPermission();
        System.out.println(JSON.toJSONString(list));
    }
}
