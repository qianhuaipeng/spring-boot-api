package com.alan.api.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * author: alan.peng
 * description: 资源权限控制
 * date: create in 10:10 2018/11/7
 * modified By：
 */
@Data
public class Permission {

    /**
     * 权限ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限对应资源
     */
    private String resource;

    /**
     * 权限的代码/通配符，对应代码中@hasAutoruty(xx)
     */
    private String code;

    /**
     * 对应资源操作
     */
    private String handle;
}
