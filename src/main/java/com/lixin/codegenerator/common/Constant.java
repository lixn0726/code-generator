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

    // ------ args

    String JDBC = "com.mysql.cj.jdbc.Driver";
    String DATASOURCE_CONFIGURATION = "Datasource";
    String GLOBAL_CONFIGURATION = "Global";
    String SETTLED_PATH = "/src/main/java/";

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
