package com.alan.api.dto;

import com.alan.api.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:24 2018/11/11
 * modified By：
 */
public class RoleWithPermission extends Role {

    @Getter
    @Setter
    private List<Integer> permissionIdList;
}
