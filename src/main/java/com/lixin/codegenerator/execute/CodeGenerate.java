package com.lixin.codegenerator.execute;

import com.lixin.codegenerator.config.DataSourceConfig;
import com.lixin.codegenerator.config.GlobalConfig;
import com.lixin.codegenerator.pojo.TableField;
import com.lixin.codegenerator.pojo.TableInfo;
import com.lixin.codegenerator.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import sun.misc.GC;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixn
 * @ClassName CodeGenerate
 * @Description TODO
 * @create 2021/8/20 10:03 上午
 **/
public class CodeGenerate implements ICallBack{
    private List<TableInfo> tableInfoList;
    private TableInfo tableInfo;
    private GlobalConfig globalConfig;
    private DataSourceConfig dataSourceConfig;

    public CodeGenerate() {

    }

    public CodeGenerate(GlobalConfig globalConfig, DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
        this.globalConfig = globalConfig;
    }

    /**
     * 获取需要执行的数据
     * @return
     */
    public Map<String, Object> execute() {
        Map<String, Object> data = new HashMap<>();
        data.put("entityPackage", globalConfig.getEntityPackage());//实体的包名
        data.put("controllerPackage", globalConfig.getControllerPackage());
        data.put("servicePackage", globalConfig.getServicePackage());
        data.put("serviceImplPackage", globalConfig.getServiceImplPackage());
        data.put("mapperPackage",globalConfig.getMapperPackage());
//        移除表前缀，表名之间的下划线，得到实体类型
//        String entity = CommonUtils.getNoUnderlineStr(CommonUtils.removePrefix(tableInfo.getName().toLowerCase(),globalConfig.getPrefix()));
        String entity = CommonUtils.getNoUnderlineStr(tableInfo.getName().toLowerCase());
        data.put("entity", StringUtils.capitalize(entity));//实体名称
        data.put("author", globalConfig.getAuthor());//创建作者
        data.put("projectName", globalConfig.getProjectName());//项目名称
        data.put("date",  CommonUtils.getFormatTime("yyyy-MM-dd HH:mm:ss", new Date() ));//创建时间
        data.put("table", tableInfo);//表信息
        boolean isKeyFlag = false;
        for (TableField field:tableInfo.getFields()) {
            if(field.isKeyIdentityFlag()){//获取主键字段信息
                data.put("tbKey", field.getName());
                data.put("tbKeyType", field.getPropertyType());
                isKeyFlag = true;
                break;
            }
        }
        if(!isKeyFlag){
            throw new RuntimeException(String.format("[%s]表缺少主键，不能没有主键",tableInfo.getName()));
        }
        return data;
    }

    /**
     * 生成代码文件
     * @return
     */
    public boolean generateToFile() {
        initConfig();
        for(TableInfo tableInfo : tableInfoList){
            this.tableInfo = tableInfo;//当前需要生成的表
            try{

                CodeFactory codeFactory = new CodeFactory();
                codeFactory.setCallBack(this);
                codeFactory.setGlobalConfig(globalConfig);
                codeFactory.invoke("entityTemplate.ftl", "entity");
                codeFactory.invoke("controllerTemplate.ftl", "controller");
                codeFactory.invoke("serviceTemplate.ftl", "service");
                codeFactory.invoke("serviceImplTemplate.ftl", "serviceImpl");
                codeFactory.invoke("mapperTemplate.ftl", "mapper");
                if (StringUtils.isNotBlank(globalConfig.getMapperXmlPath())){
                    codeFactory.invoke("mapperXmlTemplate.ftl", "mapperXml");
                }
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    /**
     * 初始化获取参数
     */
    private void initConfig(){
        if(dataSourceConfig == null){
            throw new RuntimeException("dataSourceConfig is null");
        }
        if(globalConfig == null){
            throw new RuntimeException("globalConfig is null");
        }
        tableInfoList = dataSourceConfig.getTablesInfo(globalConfig.getTableNames());
    }
}
