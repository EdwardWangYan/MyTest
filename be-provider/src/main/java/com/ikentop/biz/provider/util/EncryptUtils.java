package com.ikentop.biz.provider.util;

import com.ikentop.biz.provider.config.shiro.ShiroConfiguration;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Huqiao
 * @since 2017/9/5
 */
public class EncryptUtils {

    public static final String HASH_ALGORITHM_NAME = ShiroConfiguration.HASH_ALGORITHM_NAME;
    public static final int HASH_ITERATIONS = ShiroConfiguration.HASH_ITERATIONS;

    public static String encryptPassword(String password, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toHex();
    }

    public static String getSalt(String username) {
        String[] beforeShuffle = new String[]{"1", "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = username + afterShuffle.substring(5, 9);
        return result;
    }
}
