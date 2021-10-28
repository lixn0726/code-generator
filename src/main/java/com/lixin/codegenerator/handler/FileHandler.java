package com.lixin.codegenerator.handler;

import com.lixin.codegenerator.common.Constant;
import com.lixin.codegenerator.config.DatabaseConfig;
import com.lixin.codegenerator.config.IConfig;
import com.lixin.codegenerator.config.UniversalConfig;
import com.lixin.codegenerator.dbmessage.TableInfo;
import com.lixin.codegenerator.util.CommonUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Description: 新建文件writer
 * date: 2021/10/27 3:31 下午
 *
 * @author lixn
 */
public class FileHandler extends IHandler<List<IConfig>>{
    private static DatabaseConfig databaseConfig;
    private static UniversalConfig universalConfig;
    private static String[] codes;
    private static Map<String, Object> templateData = new HashMap<>(); // 不论生成什么类型的文件都通用的一个配置Map

    @Override
    public IConfig init(List<IConfig> configs) {
        databaseConfig = (DatabaseConfig) configs.get(0);
        universalConfig = (UniversalConfig) configs.get(1);
        codes = universalConfig.getParams();
        prepareTemplateData();
        // todo 在init的时候先把文件夹生成？会不会导致先做了无用功，如果后续file生成失败的话，这个文件夹要再去删除吗？
//        for (String code : codes) {
//            String dirPath = universalConfig.getOutputDir() + "/" + code;
//            mkdirs(new File(dirPath));
//        }
        return null;
    }

    // 创建文件夹
    private void mkdirs(File file) {
        if (file.exists() && file.isDirectory()) {
            return;
        }
        if (file.exists()) {
            file.delete();
            file.mkdirs();
            return;
        } else {
            file.mkdirs();
        }
    }

    /**
     * 根据模版生成代码
     *
     * @param infos 相关的表信息
     */
    public void generateFile(List<TableInfo> infos) {
        for (TableInfo info : infos) {
            generateSingleFile(codes, info);
        }
    }

    /**
     * 按表信息来生成代码
     */
    private void generateSingleFile(String[] codes, TableInfo info) {
        for (String code : codes) {
            generateSingleTypeFile(code, info);
        }
    }

    /**
     * 按表信息以及指定的一种类型来生成代码
     */
    private void generateSingleTypeFile(String code, TableInfo info) {
        String targetFilePath = getTargetFilePath(code, info.getName()); // 新文件存在的路径
        String templateFilePath = code + Constant.TEMPLATE_SUFFIX;
        execute(templateFilePath, targetFilePath);
    }


    /**
     * 生成文件
     */
    private void execute(String templateName, String targetFilePath) {
        try {
            Template template = getConfiguration().getTemplate(templateName);
            Writer writer = new OutputStreamWriter(
                    new FileOutputStream(targetFilePath), StandardCharsets.UTF_8
            );
            template.process(templateData, writer);
            writer.close();
        } catch (IOException | TemplateException e) {
            System.out.println("[Processing error] ... Generating New File Error ... Error Causing By " + e.getMessage());
        }
    }

    /**
     * 生成新文件的绝对路径
     */
    private String getTargetFilePath(String code, String tableName) {
        String packagePath = universalConfig.getOutputDir() // /User/mac/github-project/code-generator/src/main/java/com/lixin/codegenerator/test
                + "/" + code + "/";  // ... /test/model/
        return packagePath + CommonUtils.getNoUnderlineStr(tableName) + CommonUtils.upperFirst(code) + ".java";
    }

    /**
     * 将准备好的数据放入map中，结合.ftl文件进行生成
     */
    // todo need to finish
    private void prepareTemplateData() {
        for (String codeType : codes) {
            templateData.put(codeType + "Package", universalConfig.getPackageName() + "." + codeType);
        }
        // todo
    }

    private Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(super.getClass(), Constant.TEMPLATE_PATH);
        configuration.setLocale(Locale.CHINA);
        configuration.setDefaultEncoding(Constant.UTF8);
        return configuration;
    }
}
