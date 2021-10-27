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
        String url = "jdbc:mysql://106.52.106.211:3306/mall?useSSL=true";
//        return url.contains("?") ? "1" : "2";
        System.out.println(url.substring(0, url.indexOf("?")));
//        convertURL(url);
 }

    private String convertURL(String url) {
        String converted = new StringBuilder(url).reverse().toString();
        System.out.println(converted);
        String dbName = new StringBuilder(converted.substring(0, converted.indexOf("/"))).reverse().toString();
        System.out.println(dbName);
        return null;
    }
}
//