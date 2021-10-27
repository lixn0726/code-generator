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
public class TableInfo {
    private String name;
    private String comment = "";
    private List<TableField> fields;

    public TableInfo() {};

    // ------ inner builder

    public static final class Builder {
        private String name;
        private String comment = "";
        private List<TableField> fields;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder withFields(List<TableField> fields) {
            this.fields = fields;
            return this;
        }

        public TableInfo build() {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setName(name);
            tableInfo.setComment(comment);
            tableInfo.setFields(fields);
            return tableInfo;
        }
    }

    // ------ getter and setter

    @Override
    public String toString() {
        return "TableInfo{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", fields=" + fields +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<TableField> getFields() {
        return fields;
    }

    public void setFields(List<TableField> fields) {
        this.fields = fields;
    }

}
