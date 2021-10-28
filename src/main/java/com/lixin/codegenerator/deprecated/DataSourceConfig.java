package com.lixin.codegenerator.deprecated;

import com.lixin.codegenerator.converter.ITypeConvert;
import com.lixin.codegenerator.converter.MySQLTypeConvertor;
import com.lixin.codegenerator.converter.OracleTypeConvertor;
import com.lixin.codegenerator.config.IConfig;
import com.lixin.codegenerator.enums.DatabaseType;
import com.lixin.codegenerator.dbmessage.TableField;
import com.lixin.codegenerator.dbmessage.TableInfo;
import com.lixin.codegenerator.util.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author lixn
 * @ClassName DataSourceConfig
 * @Description TODO 数据库配置以及API
 * @create 2021/8/20 9:23 上午
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class DataSourceConfig implements IConfig {
    private DatabaseType dbType;
    private ITypeConvert typeConvert;
    private String url;
    private String driverName;
    private String username;
    private String password;
    private Connection conn = null;

    // 获取数据库类型 mysql oracle... etc
    public DatabaseType getDbType() {
        if (null == this.dbType) {
            if (this.driverName.contains("mysql")) {
                this.dbType = DatabaseType.MYSQL;
            } else {
                this.dbType = DatabaseType.ORACLE;
            }
        }
        return this.dbType;
    }

    /**
     * 获取数据库下所有表名
     * @return
     */
    public List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConn();
        ResultSet rs = null;
        try {
            // 元数据操作
            DatabaseMetaData db = conn.getMetaData();
            // 获取所有表名
            rs = db.getTables(getDBName(url), null, null, new String[]{"TABLE"});
            while (rs.next()) {
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

    public ITypeConvert getTypeConvert() {
        if (null == this.typeConvert) {
            if (this.getDbType() == DatabaseType.ORACLE) {
                this.typeConvert = new OracleTypeConvertor();
            } else {
                this.typeConvert = new MySQLTypeConvertor();
            }
        }
        return this.typeConvert;
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConn() {
        if (null != conn) {
            return conn;
        }
        try {
            Class.forName(this.driverName);
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", this.password );
            properties.setProperty("remarks", "true");
            properties.setProperty("useInformationSchema", "true");//mysql设置可以获取tables remarks信息 -> remarks信息：注释信息
            conn = DriverManager.getConnection(this.url, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     */
    public void closeConnection() {
        try {
            if (null != conn) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取生成表的信息
     */
//    public List<TableInfo> getTablesInfo(String[] tables) {
//        List<TableInfo> tableList = new ArrayList();
//        for(int i = 0; i < tables.length; ++i){
//            TableInfo tableInfo = new TableInfo();
//            tableInfo.setName(tables[i]);
//            List<TableField> fieldList = this.getTableFields(tableInfo.getName());
//            tableInfo.setFields(fieldList);
//            tableList.add(tableInfo);
//        }
//        return tableList;
//    }
    public List<TableInfo> getTablesInfo(List<String> tables) {
        List<TableInfo> tableList = new ArrayList<>();
        for (String table : tables) {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setName(table);
            List<TableField> fieldList = this.getTableFields(table);
            tableInfo.setFields(fieldList);
            tableList.add(tableInfo);
        }
        return tableList;
    }

    /**
     * 获取数据库表下的所有字段信息
     * @param tableName 表名
     * @return List<TableField>
     */
    public List<TableField> getTableFields(String tableName) {
        List<TableField> tbColumns = new ArrayList<>();
        Connection conn = getConn();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.createStatement();
            ResultSet rsKey = conn.getMetaData().getPrimaryKeys(null, null, tableName.toUpperCase());
            String keyName = null;
            while (rsKey.next()) {
                keyName = rsKey.getString("COLUMN_NAME").toLowerCase();
                keyName = CommonUtils.getNoUnderlineStr(keyName);
            }
            rs = conn.getMetaData().getColumns(null, null, tableName.toUpperCase(), "%");
            while (rs.next()) {
                TableField tableField = new TableField();
                String fieldNm = rs.getString("COLUMN_NAME").toLowerCase();
                tableField.setName(fieldNm);//表字段名
                tableField.setPropertyName(CommonUtils.getNoUnderlineStr(fieldNm));//字段名
                tableField.setComment(rs.getString("REMARKS"));//字段注释
                tableField.setType(rs.getString("TYPE_NAME"));//字段类型
                tableField.setPropertyType(this.getTypeConvert().processTypeConvert(tableField.getType()));

                if(keyName!=null && keyName.equals(tableField.getName())){
                    tableField.setKeyIdentityFlag(true);
                }else{
                    tableField.setKeyIdentityFlag(false);
                }

                tbColumns.add(tableField);
            }
            if(stm!=null){
                stm.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbColumns;
    }

    private String getDBName(String url) {
        return url.contains("?") ? resolve(url.substring(0, url.indexOf("?"))) : resolve(url);
    }

    private String resolve(String url) {
        String converted = new StringBuilder(url).reverse().toString();
        return new StringBuilder(converted.substring(0, converted.indexOf("/"))).reverse().toString();
    }
}
