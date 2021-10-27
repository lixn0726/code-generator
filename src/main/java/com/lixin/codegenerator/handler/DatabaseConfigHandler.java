package com.lixin.codegenerator.handler;

import com.lixin.codegenerator.common.Constant;
import com.lixin.codegenerator.config.ITypeConvert;
import com.lixin.codegenerator.config.convert.MySQLTypeConvertor;
import com.lixin.codegenerator.config.convert.OracleTypeConvertor;
import com.lixin.codegenerator.config.entity.DatabaseConfig;
import com.lixin.codegenerator.enums.DatabaseType;
import com.lixin.codegenerator.pojo.TableField;
import com.lixin.codegenerator.pojo.TableInfo;
import com.lixin.codegenerator.util.CommonUtils;

import java.sql.*;
import java.util.*;

/**
 * Description:
 * date: 2021/10/27 2:07 下午
 *
 * @author lixn
 */
public class DatabaseConfigHandler extends IHandler<Map<String, Object>>{
    private static final DatabaseConfig config;
    private static Connection connection;
    private static ITypeConvert converter;

    static {
        config = new DatabaseConfig();
        connection = null;
        converter = null;
    }

    /**
     * 配置信息初始化
     */
    @Override
    public void initConfig(Map<String, Object> args) {
        config.setDriverName((args.get(Constant.DRIVER)) == null ? Constant.JDBC : (String) args.get(Constant.DRIVER));
        config.setUrl((String) args.get(Constant.URL));
        config.setUsername((String) args.get(Constant.USERNAME));
        config.setPassword((String) args.get(Constant.PWD));
        String type = (String) args.get(Constant.URL);
        if (type.contains("mysql")) {
            converter = new MySQLTypeConvertor();
            config.setType(DatabaseType.MYSQL);
        } else {
            converter = new OracleTypeConvertor();
            config.setType(DatabaseType.ORACLE);
        }
        String prefix = (String) args.get(Constant.PREFIX);
        String[] prefixes = prefix.trim().split(",");
        config.setPrefix(prefixes);
    }

    /**
     * 连接数据库获取信息，暴露给外部使用
     */
    public List<TableInfo> getDataBaseInfos() {
        // 1、连接数据库
        connection = getConnection();
        // 2、获取所有表名
        List<String> tableName = getTableNames();
        return generateTableInfos(tableName);
    }

    /**
     * 连接至数据库
     */
    private static Connection getConnection() {
        if (null != connection) {
            return connection;
        }
        try {
            Class.forName(config.getDriverName());
            Properties properties = new Properties();
            properties.setProperty("user", config.getUsername());
            properties.setProperty("password", config.getPassword());
            properties.setProperty("remarks", "true");
            properties.setProperty("useInformationSchema", "true");
            connection = DriverManager.getConnection(config.getUrl(), properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 获取数据库下所有表名
     */
    private static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection connection = getConnection();
        ResultSet rs;
        try {
            // 1、元数据操作
            DatabaseMetaData metaData = connection.getMetaData();
            // 2、获取所有表名
            rs = metaData.getTables(getDataBaseName(config.getUrl()), null, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString(3);
                tableNames.add(rs.getString(3));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return tableNames;
    }

    /**
     * 按照表名，获取数据库内表的详细信息如字段名、字段类型、字段注释等等...
     */
    private static List<TableField> getTableFields(String tableName) {
        List<TableField> columns = new ArrayList<>();
        Connection connection = getConnection();
        Statement stm = null;
        ResultSet rs;
        try {
            stm = connection.createStatement();
            ResultSet rsKey = connection.getMetaData().getPrimaryKeys(null, null, tableName);
            String keyName = null;
            while (rsKey.next()) {
                keyName = rsKey.getString("COLUMN_NAME").toUpperCase(Locale.ROOT);
                keyName = CommonUtils.getNoUnderlineStr(keyName).toLowerCase(Locale.ROOT);
            }
            rs = connection.getMetaData().getColumns(null, null, tableName.toUpperCase(Locale.ROOT), "%");
            while (rs.next()) {
                TableField tableField = TableField.Builder.builder()
                        .withName(rs.getString("COLUMN_NAME").toLowerCase(Locale.ROOT))
                        .withPropertyName(CommonUtils.getNoUnderlineStr(rs.getString("COLUMN_NAME").toLowerCase(Locale.ROOT)))
                        .withComment(rs.getString("REMARKS"))
                        .withType(rs.getString("TYPE_NAME"))
                        .withPropertyType(converter.processTypeConvert(rs.getString("TYPE_NAME")))
                        .build();
                tableField.setKeyIdentityFlag(keyName != null && keyName.equals(tableField.getName()));
                columns.add(tableField);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columns;
    }

    /**
     * 依据表名，生成数据库表信息类
     */
    private static List<TableInfo> generateTableInfos(List<String> tableNames) {
        List<TableInfo> infos = new ArrayList<>();
        List<String> prefixes = Arrays.asList(config.getPrefix());
        for (String tableName : tableNames) {
            TableInfo info = TableInfo.Builder.builder()
                    .withName(handlePrefix(prefixes, tableName))
                    .withFields(getTableFields(tableName))
                    .build();
            infos.add(info);
        }
        return infos;
    }

    private static String handlePrefix(List<String> prefixes, String name) {
        for (String prefix : prefixes) {
            if (name.contains(prefix)) {
                return name.replace(prefix, "");
            }
        }
        return name;
    }

    /**
     * 根据url的情况获取对应的数据库名，以免获取到该端口下的所有表名
     *      如 url: jdbc://localhost:3306/test
     *         url: jdbc://localhost:3306/test?xxxx
     *      应当分情况进行解析，处理成第一种url统一进行处理
     */
    private static String getDataBaseName(String url) {
        return url.contains("?") ? resolve(url.substring(0, url.indexOf("?"))) : resolve(url);
    }

    /**
     * 统一对url进行解析，获取数据库名
     */
    private static String resolve(String url) {
        String converted = new StringBuilder(url).reverse().toString();
        return new StringBuilder(converted.substring(0, converted.indexOf("/"))).reverse().toString();
    }

    /**
     * 关闭数据库连接
     */
    private static void closeConnection() {
        try {
            if (null != connection) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
