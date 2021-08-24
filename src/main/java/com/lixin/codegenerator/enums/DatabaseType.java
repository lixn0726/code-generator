package com.lixin.codegenerator.enums;

/**
 * @author lixn
 * @ClassName DbType
 * @Description TODO 数据库类型枚举 待添加
 * @create 2021/8/20 9:15 上午
 **/
public enum DatabaseType {
    MYSQL("mysql"),
    ORACLE("oracle");

    private final String value;

    private DatabaseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
