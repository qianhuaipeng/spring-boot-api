package com.alan.api.service.impl;

import com.alan.api.model.Resource;
import com.alan.api.service.PermissionService;
import com.alan.springbootapi.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 11:28 2018/11/7
 * modified By：
 */
public class PermissionServiceImplTest extends ApplicationTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void findResourceWithHandle(){
        List<Resource> list = permissionService.findResourceWithHandle();
        System.out.println(list);
    }

    @Test
    public void findRoleWithResourceByRoleId() {
        List<Resource> list = permissionService.findRoleWithResourceByRoleId(Long.parseLong("3"));
        System.out.println(list);
    }
}
