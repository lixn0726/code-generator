package com.lixin.codegenerator.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author lixn
 * @ClassName CommonUtils
 * @Description TODO
 * @create 2021/8/20 9:49 上午
 **/
public class CommonUtils {
    /**
     * 字符串首字母变为小写
     */
    public static String lowerFirstChar(String str) {
//        if (Character.isLowerCase(str.charAt(0))) {
//            return str;
//        } else {
//            return Character.toLowerCase(str.charAt(0)) + str.substring(1);
//        }
        // ------ simplify
        return Character.isLowerCase(str.charAt(0)) ? str : Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     *  将字符串去下划线，改为驼峰式命名
     */
    public static String getNoUnderlineStr(String strKey) {
        if (strKey.contains("_")) {
            String[] keyArray = strKey.split("_");
            StringBuffer sb = new StringBuffer();
            boolean flag = false;
            for (String key : keyArray) {
                if (flag) {
                    sb.append(StringUtils.capitalize(key));
                } else {
                    flag = true;
                    sb.append(key);
                }
            }
            strKey = sb.toString();
        }
        return strKey;
    }

    /**
     * 去掉字符串指定的前缀
     */
    public static String removePrefix(String str, String[] prefix) {
        if (StringUtils.isEmpty(str)) {
            return "";
        } else {
            if (null != prefix) {
                String[] prefixArray = prefix;

                for(int i = 0; i < prefix.length; ++i) {
                    String pf = prefixArray[i];
                    if (str.toLowerCase().matches("^" + pf.toLowerCase() + ".*")) {
                        return str.substring(pf.length());
                    }
                }
            }

            return str;
        }
    }

    /**
     * 格式化时间
     */
    public static String getFormatTime(String pattern, Date date) {
        SimpleDateFormat sdf =new SimpleDateFormat(pattern);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return sdf.format(date ==null ?new Date() : date);
    }
}
