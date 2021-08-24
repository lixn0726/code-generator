package com.lixin.codegenerator.pojo;

import com.lixin.codegenerator.enums.DatabaseColumnType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lixn
 * @ClassName TableField
 * @Description TODO 数据库表字段实体
 * @create 2021/8/20 9:12 上午
 **/
@Setter
@Getter
@NoArgsConstructor
public class TableField {
    private boolean keyFlag;
    private boolean keyIdentityFlag;
    private String name;
    private String type;
    private String propertyName;
    private DatabaseColumnType propertyType;
    private String comment;

    @Override
    public String toString() {
        return "TableField{" +
                "keyFlag=" + keyFlag +
                ", keyIdentityFlag=" + keyIdentityFlag +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyType=" + propertyType +
                ", comment='" + comment + '\'' +
                '}';
    }
}
