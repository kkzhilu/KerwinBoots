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
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//生成的Mapper所在包

    /***
     * service包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//生成的Service所在包

    /***
     * serviceImpl包
     */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//生成的ServiceImpl所在包

    /***
     * web-controller包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";//生成的Controller所在包

    /***
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";
}
