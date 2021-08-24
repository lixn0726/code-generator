package com.lixin.codegenerator.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author lixn
 * @ClassName GlobalConfig
 * @Description TODO
 * @create 2021/8/20 9:11 上午
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalConfig {
    private String encoding = "UTF-8";
    private String templatePath = "";// 模版路径
    private String outputDir = "";// 新文件输出路径
    private String entityPackage = "entity";// 实体包名
    private String mapperPackage = "mapper";// dao层包名
    private String mapperXmlPath = "";// dao层xml路径
    private String serviceImplPackage = "service.Impl";// serviceImpl层包名
    private String servicePackage = "service";// service层包名
    private String controllerPackage = "controller";// 控制层包名
    private List<String> tableNames;// 表名
    private String[] prefix;// 表前缀
    private String author = "";// 作者
    private String projectName = "";// 项目名
}
