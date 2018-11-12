package com.alan.api.controller;

import com.alan.api.core.Response.Result;
import com.alan.api.core.Response.ResultGenerator;
import com.alan.api.dto.RoleWithPermission;
import com.alan.api.model.RoleWithResource;
import com.alan.api.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: alan.peng
 * description: 角色管理控制器
 * date: create in 10:13 2018/11/11
 * modified By：
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PreAuthorize("hasAuthority('role:add')")
    @PostMapping
    public Result add(@RequestBody RoleWithPermission role){
        this.roleService.save(role);
        return ResultGenerator.genOkResult();
    }

    @PreAuthorize("hasAuthority('role:delete')")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        this.roleService.deleteById(id);
        return ResultGenerator.genOkResult();
    }

    @PreAuthorize("hasAuthority('role:update')")
    public Result update(@RequestBody RoleWithPermission role){
        return ResultGenerator.genOkResult();
    }

    @PreAuthorize("hasAuthority('role:list')")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size){
        PageHelper.startPage(page, size);
        List<RoleWithResource> list = this.roleService.findRoleWithPermission();
        PageInfo<RoleWithResource> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }
}
