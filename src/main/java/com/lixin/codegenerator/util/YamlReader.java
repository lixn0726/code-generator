package com.lixin.codegenerator.util;

import com.lixin.codegenerator.common.Constant;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.LinkedHashMap;

/**
 * Description: Yaml读取器
 * date: 2021/10/27 9:11 上午
 *
 * @author lixn
 */
public class YamlReader {
    public static LinkedHashMap<String, Object> convertYaml2Map() {
        InputStream in = YamlReader.class.getResourceAsStream(Constant.YAML_PATH);
        LinkedHashMap<String, Object> sourceMap = new Yaml().load(in);
        return sourceMap;
    }

    public static String getString(LinkedHashMap<String, Object> sourceMap, String key) {
        String[] keys = key.split("[.]");
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) sourceMap.clone();
        int length = keys.length;
        Object resultValue = null;
        for (int i = 0; i < length; i++) {
            Object value = map.get(keys[i]);
            if (i < length - 1) {
                map = ((LinkedHashMap<String, Object>) value);
            } else if (value == null) {
                System.out.println("key is not exists");
            } else {
                resultValue = value;
            }
        }
        return resultValue.toString();
    }
}
