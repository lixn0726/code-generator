package com.lixin.codegenerator.pojo;

import com.lixin.codegenerator.enums.DatabaseColumnType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lixn
 * @create 2021/8/20 9:12 上午
 **/
public class TableField {
    private boolean keyFlag;
    private boolean keyIdentityFlag;
    private String name;
    private String type;
    private String propertyName;
    private DatabaseColumnType propertyType;
    private String comment;

    public TableField() {}

    // ------ builder

    public static final class Builder {
        private boolean keyFlag;
        private boolean keyIdentityFlag;
        private String name;
        private String type;
        private String propertyName;
        private DatabaseColumnType propertyType;
        private String comment;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withKeyFlag(boolean keyFlag) {
            this.keyFlag = keyFlag;
            return this;
        }

        public Builder withKeyIdentityFlag(boolean keyIdentityFlag) {
            this.keyIdentityFlag = keyIdentityFlag;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withPropertyName(String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public Builder withPropertyType(DatabaseColumnType propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public TableField build() {
            TableField tableField = new TableField();
            tableField.setKeyFlag(keyFlag);
            tableField.setKeyIdentityFlag(keyIdentityFlag);
            tableField.setName(name);
            tableField.setType(type);
            tableField.setPropertyName(propertyName);
            tableField.setPropertyType(propertyType);
            tableField.setComment(comment);
            return tableField;
        }
    }

    // ------ getter and setter

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

    public boolean isKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(boolean keyFlag) {
        this.keyFlag = keyFlag;
    }

    public boolean isKeyIdentityFlag() {
        return keyIdentityFlag;
    }

    public void setKeyIdentityFlag(boolean keyIdentityFlag) {
        this.keyIdentityFlag = keyIdentityFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public DatabaseColumnType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(DatabaseColumnType propertyType) {
        this.propertyType = propertyType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
