package com.lixin.codegenerator.config.entity;

/**
 * Description: 全局通用配置类
 * date: 2021/10/27 12:00 下午
 *
 * @author lixn
 */
public class UniversalConfig {
    private String author;
    private String outputDir;
    private String[] params;
    private String projectName;
    private String packagePath;

    // ------ getter and setter

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
