package com.lixin.codegenerator.handler;

import com.lixin.codegenerator.common.Constant;
import com.lixin.codegenerator.config.entity.UniversalConfig;

import java.util.Map;

/**
 * Description:
 * date: 2021/10/27 2:07 下午
 *
 * @author lixn
 */
public class UniversalConfigHandler extends IHandler<Map<String, Object>>{
    private static final UniversalConfig config;

    static {
        config = new UniversalConfig();
    }

    @Override
    public void initConfig(Map<String, Object> args) {
        String outputDir = (String) args.get(Constant.OUTPUT_DIR);
        String packageName = (String) args.get(Constant.PACKAGE);
        config.setAuthor(args.get(Constant.AUTHOR) == null ? System.getProperty("user.name") : (String) args.get(Constant.AUTHOR));
        // 输出的文件位置需要重新考虑，因为如果是多模块的开发，如果用户要配置多个路径的话会显得很麻烦很不方便，需要思考
        // ->       output-dir和 package-name的组合关系
        // 单机开发其实不需要，微服务的时候会需要到
        config.setOutputDir(outputDir == null ? getDefaultOutputPath(packageName) : outputDir);
        config.setProjectName((String) args.get(Constant.PROJECT_NAME));
        config.setPackageName((String) args.get(Constant.PACKAGE));
        String codes = (String) args.get(Constant.CODES);
        String[] types = codes.trim().split(",");
        config.setParams(types);
    }

    private String getDefaultOutputPath(String packageName) {
        packageName = packageName.replace(".", "/");
        return Constant.OUTPUT_PATH + packageName;
    }
}
