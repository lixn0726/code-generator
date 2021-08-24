package com.lixin.codegenerator.config.convert;

import com.lixin.codegenerator.config.ITypeConvert;
import com.lixin.codegenerator.enums.DatabaseColumnType;

/**
 * @author lixn
 * @ClassName MySQLTypeConvert
 * @Description TODO
 * @create 2021/8/20 9:55 上午
 **/
public class MySQLTypeConvertor implements ITypeConvert {
    public MySQLTypeConvertor() {
    }

    public DatabaseColumnType processTypeConvert(String fieldType) {
        String type = fieldType.toLowerCase();
        if (!type.contains("char") && !type.contains("text")) {
            if (type.contains("bigint")) {
                return DatabaseColumnType.LONG;
            } else if (type.contains("int")) {
                return DatabaseColumnType.INTEGER;
            } else if (!type.contains("date") && !type.contains("time") && !type.contains("year")) {
                if (type.contains("text")) {
                    return DatabaseColumnType.STRING;
                } else if (type.contains("bit")) {
                    return DatabaseColumnType.BOOLEAN;
                } else if (type.contains("decimal")) {
                    return DatabaseColumnType.BIG_DECIMAL;
                } else if (type.contains("clob")) {
                    return DatabaseColumnType.CLOB;
                } else if (type.contains("blob")) {
                    return DatabaseColumnType.BLOB;
                } else if (type.contains("binary")) {
                    return DatabaseColumnType.BYTE_ARRAY;
                } else if (type.contains("float")) {
                    return DatabaseColumnType.FLOAT;
                } else if (type.contains("double")) {
                    return DatabaseColumnType.DOUBLE;
                } else {
                    return !type.contains("json") && !type.contains("enum") ? DatabaseColumnType.STRING : DatabaseColumnType.STRING;
                }
            } else {
                return DatabaseColumnType.DATE;
            }
        } else {
            return DatabaseColumnType.STRING;
        }
    }
}
