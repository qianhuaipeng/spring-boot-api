package com.alan.api.model;

import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:23 2018/11/7
 * modified By：
 */
@Data
public class Resource {

    @Transient
    private String resource;

    private List<Handle> handleList;
}
