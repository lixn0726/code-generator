package com.lixin.codegenerator.config;

import com.lixin.codegenerator.enums.DatabaseColumnType;

/**
 * @author lixn
 * @ClassName ITypeConvert
 * @Description TODO
 * @create 2021/8/20 9:24 上午
 **/
public interface ITypeConvert {
    DatabaseColumnType processTypeConvert(String var1);
}
