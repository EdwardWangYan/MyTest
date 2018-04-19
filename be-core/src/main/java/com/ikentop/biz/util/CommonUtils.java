package com.ikentop.biz.util;

/**
 * @author : Huqiao
 * @since : 2017/11/28
 */
public class CommonUtils {
    public static String nullUUID() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(0);
        }
        return sb.toString();
    }
}
