package com.alan.api.model;

import lombok.Data;

import javax.persistence.Transient;

/**
 * author: alan.peng
 * description:
 * date: create in 10:25 2018/11/7
 * modified By：
 */
@Data
public class Handle {

    /**
     * 对应权限ID
     */
    @Transient
    private Long id;

    /**
     * 操作名称
     */
    @Transient
    private String handle;

}
