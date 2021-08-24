package com.lixin.codegenerator;

import com.lixin.codegenerator.config.DataSourceConfig;
import com.lixin.codegenerator.config.GlobalConfig;
import com.lixin.codegenerator.enums.DatabaseType;
import com.lixin.codegenerator.execute.CodeGenerate;
import com.lixin.codegenerator.pojo.TableInfo;

import java.util.List;

/**
 * @author lixn
 * @ClassName Demo
 * @Description TODO
 * @create 2021/8/20 10:18 上午
 **/
public class Demo {
    public static void main(String[] args) {
        DataSourceConfig config = new DataSourceConfig();
        config.setUrl("jdbc:mysql://localhost:3306/lixn-mall?userUnicode=true");
        config.setDriverName("com.mysql.cj.jdbc.Driver");
        config.setPassword("lx990726");
        config.setUsername("root");
        config.setDbType(DatabaseType.MYSQL);
//        System.out.println(config.getTableNames());
        List<String> tableNames = config.getTableNames();
        List<TableInfo> tableInfoList = config.getTablesInfo(tableNames);
//        for (TableInfo tableInfo : tableInfoList) {
//            System.out.println(tableInfo.toString());
//        }

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("lixin");
        globalConfig.setOutputDir("/Users/aihuishou/tmp");
        globalConfig.setEntityPackage("com.lixin.codegenerator.test.entity");
        globalConfig.setTableNames(tableNames);
        globalConfig.setTemplatePath("/template");
        CodeGenerate codeGenerate = new CodeGenerate(globalConfig, config);
        codeGenerate.generateToFile();
    }
}
