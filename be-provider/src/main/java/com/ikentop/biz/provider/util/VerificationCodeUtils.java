package com.ikentop.biz.provider.util;

import com.ikentop.biz.constant.VerificationCodeType;
import com.ikentop.biz.provider.exception.VerificationCodeTypeIsWrongException;

import java.util.Random;

/**
 * @author Huqiao
 * @since 2018/1/4
 */
public class VerificationCodeUtils {

    /**
     * @param length 验证码的长度
     * @param type   1:纯数字;2:数字和小写字母;3:数字,大小写字母,
     */
    public static String verificationCode(int length, int type) {
        String str = getString(type);
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String verificationCode(int length, VerificationCodeType type) {
        return verificationCode(length, type.val);
    }

    private static String getString(int type) {
        String str;
        if (type == VerificationCodeType.NUMBER.val) {
            str = "0123456789";
        } else if (type == VerificationCodeType.NUM_LOWER_CASE.val) {
            str = "abcdefghijklmnopqrstuvwxyz0123456789";
        } else if (type == VerificationCodeType.NUM_CASE.val) {
            str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        } else {
            throw new VerificationCodeTypeIsWrongException();
        }
        return str;
    }
}
