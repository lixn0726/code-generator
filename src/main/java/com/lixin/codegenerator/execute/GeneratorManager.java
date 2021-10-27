package com.lixin.codegenerator.execute;

import com.lixin.codegenerator.common.Constant;
import com.lixin.codegenerator.handler.DatabaseConfigHandler;
import com.lixin.codegenerator.handler.FileHandler;
import com.lixin.codegenerator.handler.UniversalConfigHandler;
import com.lixin.codegenerator.pojo.TableInfo;
import com.lixin.codegenerator.util.YamlReader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * date: 2021/10/27 3:19 下午
 *
 * @author lixn
 */
public class GeneratorManager {
    private static final UniversalConfigHandler universalConfigHandler;
    private static final DatabaseConfigHandler databaseConfigHandler;
    private static final FileHandler fileHandler;
    private static List<TableInfo> infos = new ArrayList<>();

    static {
        databaseConfigHandler = new DatabaseConfigHandler();
        universalConfigHandler = new UniversalConfigHandler();
        fileHandler = new FileHandler();
    }

    // ------ singleton

    private static volatile GeneratorManager singleton;

    private GeneratorManager() {}

    public static GeneratorManager getInstance(){
        if (singleton == null) {
            synchronized (GeneratorFacade.class) {
                if (singleton == null) {
                    singleton = new GeneratorManager();
                }
            }
        }
        return singleton;
    }

    /**
     * 配置初始化
     */
    @SuppressWarnings("unchecked")
    public void init() {
        LinkedHashMap<String, Object> params = YamlReader.convertYaml2Map();
        Map<String, Object> dataConf = (Map<String, Object>) params.get(Constant.DATASOURCE_CONFIGURATION);
        Map<String, Object> uniConf = (Map<String, Object>) params.get(Constant.GLOBAL_CONFIGURATION);
        databaseConfigHandler.initConfig(dataConf);
        universalConfigHandler.initConfig(uniConf);
    }

    public void loadDBMessages() {
        infos = databaseConfigHandler.getDataBaseInfos();
    }

    @Deprecated
    public void show() {
        System.out.println(infos.toString());
    }

    public void generate() {
        fileHandler.generateFile(infos);
    }
}
