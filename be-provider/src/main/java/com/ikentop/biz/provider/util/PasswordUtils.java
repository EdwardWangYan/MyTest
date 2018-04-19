package com.ikentop.biz.provider.util;

import java.util.Random;

/**
 * @author : Huqiao
 * @since : 2017/9/8
 */
public class PasswordUtils {

    private static final int length = 8;

    /**
     * 获取8位随机数(包含数字和大小写字母)
     * @return 随机生成8位密码字符串
     */
    public static String createPassWord(){
        int random = createRandomInt();
        return createPassWord(random);
    }

    private static String createPassWord(int random){
        Random rd = new Random(random);
        final int  maxNum = 62;
        StringBuilder sb = new StringBuilder();
        int rdGet;//取得随机数
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y' ,'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        int count=0;
        while(count < length){
            rdGet = Math.abs(rd.nextInt(maxNum));//生成的数最大为62-1
            if (rdGet >= 0 && rdGet < str.length) {
                sb.append(str[rdGet]);
                count ++;
            }
        }
        return sb.toString();
    }

    private static int createRandomInt(){
        //得到0.0到1.0之间的数字，并扩大100000倍
        double temp = Math.random()*100000;
        //如果数据等于100000，则减少1
        if(temp>=100000){
            temp = 99999;
        }
        int tempint = (int)Math.ceil(temp);
        return tempint;
    }
}
