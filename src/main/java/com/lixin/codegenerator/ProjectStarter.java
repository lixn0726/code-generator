package com.lixin.codegenerator;

import com.lixin.codegenerator.facade.GeneratorManager;

/**
 * Description: 入口函数
 * date: 2021/10/28 3:32 下午
 *
 * @author lixn
 */
public class ProjectStarter {
    public static void main(String[] args) {
        GeneratorManager manager = GeneratorManager.getInstance();
        manager.process();
    }
}
