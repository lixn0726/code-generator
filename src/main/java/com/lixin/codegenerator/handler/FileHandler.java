package com.lixin.codegenerator.handler;

import com.lixin.codegenerator.config.entity.DatabaseConfig;
import com.lixin.codegenerator.config.entity.IConfig;
import com.lixin.codegenerator.config.entity.UniversalConfig;
import com.lixin.codegenerator.pojo.TableInfo;

import java.io.File;
import java.util.List;
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

    @Override
    public void initConfig(List<IConfig> configs) {
        databaseConfig = (DatabaseConfig) configs.get(0);
        universalConfig = (UniversalConfig) configs.get(1);
        codes = universalConfig.getParams();
        // todo 在initConfig的时候先把文件夹生成？会不会导致先做了无用功，如果后续file生成失败的话，这个文件夹要再去删除吗？
        for (String code : codes) {
            String dirPath = universalConfig.getOutputDir() + "/" + code;
            mkdirs(new File(dirPath));
        }
    }

    // 创建文件夹
    @SuppressWarnings("ignored")
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

    private void generateSingleFile(String[] codes, TableInfo info) {
        for (String code : codes) {
            generateSingleTypeFile(code, info);
        }
    }

    /**
     * code: 一个文件种类如controller/mapper/...
     */
    private void generateSingleTypeFile(String code, TableInfo info) {
        String targetDir = universalConfig.getOutputDir();


    }

    private String upperFirst(String code) {
        return null;
    }
}
