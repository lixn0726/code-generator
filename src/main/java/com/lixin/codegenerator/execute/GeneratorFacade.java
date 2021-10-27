package com.lixin.codegenerator.execute;

import com.lixin.codegenerator.common.Constant;
import com.lixin.codegenerator.config.DataSourceConfig;
import com.lixin.codegenerator.config.GlobalConfig;
import com.lixin.codegenerator.pojo.TableInfo;
import com.lixin.codegenerator.util.YamlReader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 门面模式 Facade
 * date: 2021/10/27 10:55 上午
 *
 * @author lixn
 */
@Deprecated
public class GeneratorFacade implements IWork{
    private DataSourceConfig dataSourceConfig;
    private GlobalConfig globalConfig;
    private List<TableInfo> infoList;
    private Generator generator;

    static {

    }
    // ------ singleton
    private static volatile GeneratorFacade singleton;

    private GeneratorFacade() {}

    public static GeneratorFacade getInstance() {
        if (singleton == null) {
            synchronized (GeneratorFacade.class) {
                if (singleton == null) {
                    singleton = new GeneratorFacade();
                }
            }
        }
        return singleton;
    }

    @Override
    public void execute() {

    }

    /**
     * 初始化，解析yaml配置并将所有的参数准备好
     *
     * @return List<Map<String,Object>>
     * @author lixn
     * @date 2021/10/27 11:20 上午
     */
    public List<Map<String, Object>> load() {
        LinkedHashMap<String, Object> configurations = YamlReader.convertYaml2Map();
        List<Map<String, Object>> conf = new ArrayList<>(2);
        Map<String, Object> datasourceConf = (Map<String, Object>) configurations.get(Constant.DATASOURCE_CONFIGURATION);
        Map<String, Object> globalConf = (Map<String, Object>) configurations.get(Constant.GLOBAL_CONFIGURATION);
        conf.add(datasourceConf);
        conf.add(globalConf);
        return conf;
    }

    public void fill(Map<String, Object> conf) {

    }

}
