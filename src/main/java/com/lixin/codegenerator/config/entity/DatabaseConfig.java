package com.lixin.codegenerator.config.entity;

import com.lixin.codegenerator.enums.DatabaseType;

/**
 * Description: DB相关配置类
 * date: 2021/10/27 12:01 下午
 *
 * @author lixn
 */
public class DatabaseConfig implements IConfig{
    private DatabaseType type;
    private String url;
    private String driverName;
    private String username;
    private String password;
    private String[] prefix;

    // ------ inner builder

    class Builder {
        private DatabaseType type;
        private String url;
        private String driverName;
        private String username;
        private String password;
        private String[] prefix;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withType(DatabaseType type) {
            this.type = type;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withPrefix(String[] prefix) {
            this.prefix = prefix;
            return this;
        }

        public DatabaseConfig build() {
            DatabaseConfig databaseConfig = new DatabaseConfig();
            databaseConfig.setType(type);
            databaseConfig.setUrl(url);
            databaseConfig.setDriverName(driverName);
            databaseConfig.setUsername(username);
            databaseConfig.setPassword(password);
            databaseConfig.setPrefix(prefix);
            return databaseConfig;
        }
    }

    // ------ getter and setter

    public DatabaseType getType() {
        return type;
    }

    public void setType(DatabaseType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getPrefix() {
        return prefix;
    }

    public void setPrefix(String[] prefix) {
        this.prefix = prefix;
    }


}
