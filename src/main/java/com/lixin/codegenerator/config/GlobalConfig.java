package com.lixin.codegenerator.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author lixn
 * @ClassName GlobalConfig
 * @Description TODO
 * @create 2021/8/20 9:11 上午
 **/
public class GlobalConfig {
    private String encoding = "UTF-8";
    private String templatePath = "";// 模版路径
    private String outputDir = "";// 新文件输出路径
    private String entityPackage = "entity";// 实体包名
    private String mapperPackage = "mapper";// dao层包名
    private String mapperXmlPath = "";// dao层xml路径
    private String serviceImplPackage = "service.Impl";// serviceImpl层包名
    private String servicePackage = "service";// service层包名
    private String controllerPackage = "controller";// 控制层包名
    private List<String> tableNames;// 表名
    private String[] prefix;// 表前缀
    private String author = "";// 作者
    private String projectName = "";// 项目名

    // ------ inner builder

    public static final class Builder {
        private String encoding = "UTF-8";
        private String templatePath = "";// 模版路径
        private String outputDir = "";// 新文件输出路径
        private String entityPackage = "entity";// 实体包名
        private String mapperPackage = "mapper";// dao层包名
        private String mapperXmlPath = "";// dao层xml路径
        private String serviceImplPackage = "service.Impl";// serviceImpl层包名
        private String servicePackage = "service";// service层包名
        private String controllerPackage = "controller";// 控制层包名
        private List<String> tableNames;// 表名
        private String[] prefix;// 表前缀
        private String author = "";// 作者
        private String projectName = "";// 项目名

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withEncoding(String encoding) {
            this.encoding = encoding;
            return this;
        }

        public Builder withTemplatePath(String templatePath) {
            this.templatePath = templatePath;
            return this;
        }

        public Builder withOutputDir(String outputDir) {
            this.outputDir = outputDir;
            return this;
        }

        public Builder withEntityPackage(String entityPackage) {
            this.entityPackage = entityPackage;
            return this;
        }

        public Builder withMapperPackage(String mapperPackage) {
            this.mapperPackage = mapperPackage;
            return this;
        }

        public Builder withMapperXmlPath(String mapperXmlPath) {
            this.mapperXmlPath = mapperXmlPath;
            return this;
        }

        public Builder withServiceImplPackage(String serviceImplPackage) {
            this.serviceImplPackage = serviceImplPackage;
            return this;
        }

        public Builder withServicePackage(String servicePackage) {
            this.servicePackage = servicePackage;
            return this;
        }

        public Builder withControllerPackage(String controllerPackage) {
            this.controllerPackage = controllerPackage;
            return this;
        }

        public Builder withTableNames(List<String> tableNames) {
            this.tableNames = tableNames;
            return this;
        }

        public Builder withPrefix(String[] prefix) {
            this.prefix = prefix;
            return this;
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public GlobalConfig build() {
            GlobalConfig globalConfig = new GlobalConfig();
            globalConfig.setEncoding(encoding);
            globalConfig.setTemplatePath(templatePath);
            globalConfig.setOutputDir(outputDir);
            globalConfig.setEntityPackage(entityPackage);
            globalConfig.setMapperPackage(mapperPackage);
            globalConfig.setMapperXmlPath(mapperXmlPath);
            globalConfig.setServiceImplPackage(serviceImplPackage);
            globalConfig.setServicePackage(servicePackage);
            globalConfig.setControllerPackage(controllerPackage);
            globalConfig.setTableNames(tableNames);
            globalConfig.setPrefix(prefix);
            globalConfig.setAuthor(author);
            globalConfig.setProjectName(projectName);
            return globalConfig;
        }
    }

    // ------ getter and setter

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getMapperXmlPath() {
        return mapperXmlPath;
    }

    public void setMapperXmlPath(String mapperXmlPath) {
        this.mapperXmlPath = mapperXmlPath;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public List<String> getTableNames() {
        return tableNames;
    }

    public void setTableNames(List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public String[] getPrefix() {
        return prefix;
    }

    public void setPrefix(String[] prefix) {
        this.prefix = prefix;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}
