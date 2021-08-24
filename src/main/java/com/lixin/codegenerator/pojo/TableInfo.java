package com.lixin.codegenerator.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author lixn
 * @ClassName TableInfo
 * @Description TODO 数据库表实体
 * @create 2021/8/20 9:12 上午
 **/
@Getter
@Setter
@NoArgsConstructor
public class TableInfo {
    private String name;
    private String comment = "";
    private List<TableField> fields;

    @Override
    public String toString() {
        return "TableInfo{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", fields=" + fields +
                '}';
    }
}
