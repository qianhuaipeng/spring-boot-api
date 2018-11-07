package com.alan.api.core;

/**
 * author: alan.peng
 * description:
 * date: create in 11:53 2018/11/3
 * modified By：
 */
public final class ProjectConstant {

    /**
     * 项目基础包名称
     */
    public static final String BASE_PACKAGE = "com.alan.api";

    /**
     * Model 所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";

    /**
     * Mapper 所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";

    /**
     * Service 所在包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

    /**
     * Service实现类所在包
     */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    /**
     * Controller 所在包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

    /**
     * Mapper 插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFRENCE = BASE_PACKAGE + ".core.mapper.MyMapper";


}
