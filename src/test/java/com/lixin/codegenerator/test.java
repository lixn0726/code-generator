package com.lixin.codegenerator;

import com.lixin.codegenerator.util.CommonUtils;
import org.junit.jupiter.api.Test;

/**
 * @author lixn
 * @ClassName test
 * @Description TODO
 * @create 2021/8/20 10:55 上午
 **/
public class test {
    @Test
    public void test() {
        String str = "random_number";
        System.out.println(CommonUtils.getNoUnderlineStr(str));
    }
}
