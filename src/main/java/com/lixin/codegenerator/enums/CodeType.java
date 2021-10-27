package com.lixin.codegenerator.enums;

/**
 * @author lixn
 * @ClassName CodeType
 * @Description TODO
 * @create 2021/8/20 10:16 上午
 **/
public enum CodeType {
    controller,
    service,
    serviceImpl,
    mapper,
    mapperXml,
    entity,
    entityExample // 兼容mybatis-plus
    ;

    private String type;

    public String getValue()
    {
        return this.type;
    }
}
