package com.lixin.codegenerator;

import com.lixin.codegenerator.execute.GeneratorManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author lixn
 * @ClassName Demo
 * @Description TODO
 * @create 2021/8/20 10:18 上午
 **/
public class Demo {
    public static void main(String[] args) throws Exception{

        GeneratorManager manager = GeneratorManager.getInstance();
        manager.init();
        manager.loadDBMessages();
        manager.show();

//        String tableName = "t_user_info";
//        System.out.println(tableName.length());
//        String prefix = "t_";
//        System.out.println(tableName.replace(prefix, ""));
//        System.out.println(tableName.replace(prefix, "").length());
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "root");
//        properties.setProperty("remarks", "true");
//        properties.setProperty("useInformationSchema", "true");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://106.52.106.211:3306/mall", "root", "root");
//
//
//        ResultSet resultSet = connection.getMetaData().getPrimaryKeys(null, null, "t_user");
//        String keyName = null;
//        while (resultSet.next()) {
//            keyName = resultSet.getString("COLUMN_NAME");
//        }
//        System.out.println(keyName);
//        String name = resultSet.getString("table_name");
//        System.out.println(name);

//        GeneratorFacade facadeInstance = GeneratorFacade.getInstance();
//        List<Map<String, Object>> conf =  facadeInstance.load();
//        DatabaseHandler databaseHandler = new DatabaseHandler();
//        databaseHandler.initConfig(conf.get(0));

//
//        DataSourceConfig config = new DataSourceConfig();
//        config.setUrl("jdbc:mysql://106.52.106.211:3306/lixin?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
//        config.setDriverName("com.mysql.cj.jdbc.Driver");
//        config.setPassword("root");
//        config.setUsername("root");
//        config.setDbType(DatabaseType.MYSQL);
//        System.out.println(config.getTableNames());

//        List<String> tableNames = config.getTableNames();
//        List<TableInfo> tableInfoList = config.getTablesInfo(tableNames);
//        for (TableInfo tableInfo : tableInfoList) {
//            System.out.println(tableInfo.toString());
//        }
//
//        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setAuthor("lixin");
////        globalConfig.setOutputDir("/Users/aihuishou/tmp");
//        globalConfig.setOutputDir("/Users/mac/github-project/code-generator");
//        globalConfig.setEntityPackage("com.lixin.codegenerator.test.entity");
//        globalConfig.setTableNames(tableNames);
//        globalConfig.setTemplatePath("/template");
//        CodeGenerate codeGenerate = new CodeGenerate(globalConfig, config);
//        codeGenerate.generateToFile();

        // -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* //

//        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) YamlReader.convertYaml2Map("/application.yml");
//        System.out.println(map.toString());
//        System.out.println(YamlReader.convertYaml2Map().toString());
//        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) YamlReader.convertYaml2Map();
//        System.out.println("Datasource config is " + map.get("Datasource").toString());
//        System.out.println(map.get("Datasource") instanceof Map);
//        Map<String, Object> res = (Map<String, Object>) map.get("Datasource");
////        System.out.println(res.toString());
//        System.out.println(res.get("driver-class-name"));
//        System.out.println(conf.split(",").length);
//        System.out.println("GlobalConfig is " + map.get("GlobalConfig").toString());
//        System.out.println(System.getProperty("user.dir")); // 当前项目工程所在的路径
//        LinkedHashMap<String, Object> map = YamlReader.convertYaml2Map();
//        Map<String, Object> dbConf = (Map<String, Object>) map.get(Constant.DATASOURCE_CONFIGURATION);
//        int count = 1;
//        for (Map.Entry<String, Object> element : dbConf.entrySet()) {
//            System.out.println("NO." + count++ + " : key = " + element.getKey() + " , value = " + element.getValue());
//        }
    }
}
