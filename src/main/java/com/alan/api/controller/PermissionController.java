package com.alan.api.controller;

import com.alan.api.core.response.Result;
import com.alan.api.core.response.ResultGenerator;
import com.alan.api.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 18:06 2018/11/12
 * modified By：
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @PreAuthorize("hasAuthority('role:list')")
    @GetMapping
    public Result listResourcePermission(@RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page,size);
        List<com.alan.api.model.Resource> list = this.permissionService.findResourceWithHandle();
        PageInfo<com.alan.api.model.Resource> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }
}
