package com.lixin.codegenerator.execute;

import java.util.Map;

/**
 * @author lixn
 * @ClassName ICallBack
 * @Description TODO
 * @create 2021/8/20 10:02 上午
 **/
public abstract interface ICallBack {
    public abstract Map<String, Object> execute();
}
