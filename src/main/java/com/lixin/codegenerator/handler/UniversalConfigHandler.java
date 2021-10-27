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
public class UniversalConfigHandler extends IHandler{
    private static final UniversalConfig config;

    static {
        config = new UniversalConfig();
    }

    @Override
    public void initConfig(Map<String, Object> args) {
        config.setAuthor(args.get(Constant.AUTHOR) == null ? System.getProperty("user.name") : (String) args.get(Constant.AUTHOR));
        config.setOutputDir((String) args.get(Constant.OUTPUT_DIR));
        config.setProjectName((String) args.get(Constant.PROJECT_NAME));
        config.setPackagePath((String) args.get(Constant.PACKAGE));
        String codes = (String) args.get(Constant.CODES);
        String[] types = codes.trim().split(",");
        config.setParams(types);
    }
}
