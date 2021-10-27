package com.lixin.codegenerator.common;

/**
 * Description: 通用常量类
 * date: 2021/10/27 9:44 上午
 *
 * @author lixn
 */
public interface Constant {
    String YAML_PATH = "/generator.yml";
    String CURRENT_DIR = System.getProperty("user.dir");
    String JAVA_FILE_PATH = "/src/main/java/";

    // ------ args

    String JDBC = "com.mysql.cj.jdbc.Driver";
    String DATASOURCE_CONFIGURATION = "Datasource";
    String GLOBAL_CONFIGURATION = "Global";
    String OUTPUT_PATH = CURRENT_DIR + JAVA_FILE_PATH; // 固定文件输出路径
    String TEMPLATE_PATH = "/template"; // 模版文件存放路径
    String TEMPLATE_SUFFIX = "Template.ftl"; // 模版文件统一后缀

    // ------ elements

    String DRIVER = "driver-class-name";
    String URL = "url";
    String USERNAME = "username";
    String PWD = "password";
    String PREFIX = "prefix";

    String AUTHOR = "author";
    String OUTPUT_DIR = "output-dir";
    String PACKAGE = "package";
    String CODES = "type";
    String PROJECT_NAME = "project-name";
}
