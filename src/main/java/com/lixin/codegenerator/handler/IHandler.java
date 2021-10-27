package com.lixin.codegenerator.handler;

import com.lixin.codegenerator.config.entity.IConfig;

import java.util.Map;

/**
 * Description:
 * date: 2021/10/27 2:07 下午
 *
 * @author lixn
 */
public abstract class IHandler {
    public abstract void initConfig(Map<String, Object> args);
}
