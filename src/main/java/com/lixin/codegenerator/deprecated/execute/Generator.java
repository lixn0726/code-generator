package com.lixin.codegenerator.deprecated.execute;

import com.lixin.codegenerator.deprecated.DataSourceConfig;
import com.lixin.codegenerator.deprecated.GlobalConfig;
import com.lixin.codegenerator.dbmessage.TableInfo;

import java.util.List;

/**
 * Description:
 * date: 2021/10/27 11:01 上午
 *
 * @author lixn
 */
@Deprecated
public class Generator {
    private DataSourceConfig dataSourceConfig;
    private GlobalConfig globalConfig;
    private List<TableInfo> infoList;

    private static volatile Generator singleton;

    // ------ singleton

    private Generator() {}

    public static Generator getInstance() {
        if (singleton == null) {
            synchronized (GeneratorFacade.class) {
                if (singleton == null) {
                    singleton = new Generator();
                }
            }
        }
        return singleton;
    }


}
