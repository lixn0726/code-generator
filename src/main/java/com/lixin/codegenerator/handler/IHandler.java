package com.lixin.codegenerator.handler;

import com.lixin.codegenerator.config.IConfig;

/**
 * Description: 处理器统一接口
 * date: 2021/10/27 2:07 下午
 *
 * @author lixn
 */
public abstract class IHandler<T> {
    public abstract IConfig init(T t);
}
