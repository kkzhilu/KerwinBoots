package com.boot.config;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/2 11:19
 * description:  CodeGeneratorConfig
 * version:      V1.0
 * ******************************
 */
public class CodeGeneratorConfig {

    /**
     * 基础包名
     */
    public static final String BASE_PACKAGE = "com.boot";

    /***
     * model包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";

    /***
     * dao包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";

    /***
     * service包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

    /***
     * serviceImpl包
     */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    /***
     * web-controller包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";

    /***
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";
}
