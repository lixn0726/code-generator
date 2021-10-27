package com.lixin.codegenerator.config.entity;

/**
 * Description: 全局通用配置类
 * date: 2021/10/27 12:00 下午
 *
 * @author lixn
 */
public class UniversalConfig {
    private String author;
    private String outputDir; // 文件输出路径
    private String[] params; // 要生成的代码种类
    private String projectName; // 项目名
    private String packageName; // 包名

    // ------ inner builder

    static final class Builder {
        private String author;
        private String outputDir;
        private String[] params;
        private String projectName;
        private String packagePath;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withOutputDir(String outputDir) {
            this.outputDir = outputDir;
            return this;
        }

        public Builder withParams(String[] params) {
            this.params = params;
            return this;
        }

        public Builder withProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder withPackagePath(String packagePath) {
            this.packagePath = packagePath;
            return this;
        }

        public UniversalConfig build() {
            UniversalConfig universalConfig = new UniversalConfig();
            universalConfig.setAuthor(author);
            universalConfig.setOutputDir(outputDir);
            universalConfig.setParams(params);
            universalConfig.setProjectName(projectName);
            universalConfig.setPackageName(packagePath);
            return universalConfig;
        }
    }

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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
