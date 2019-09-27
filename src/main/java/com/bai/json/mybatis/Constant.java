package com.bai.json.mybatis;

/**
 * 项目名常量
 */
public class Constant {


    public static final String BASE_PACKAGE = "com.bai.json";	//项目基础包名称，根据自己公司的项目修改

    public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".entity";	//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";	//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";	//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";	//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";	//Controller所在包

    //public static final String MAPPER_INTERFACE_REFERENCE = "classpath:/mappers/**/*.xml";
}
