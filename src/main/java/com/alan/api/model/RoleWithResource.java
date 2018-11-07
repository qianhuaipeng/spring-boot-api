package com.alan.api.model;

import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:30 2018/11/7
 * modified By：
 */
@Data
public class RoleWithResource extends Role {

    /**
     * 角色对应的权限
     */
    @Transient
    private List<Resource> resourceList;
}
