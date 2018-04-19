package com.ikentop.biz.constant;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author : tac
 * @since : 18/09/2017
 */
public enum Gender {
    UNKNOWN(0),
    MALE(1),
    FEMALE(2);

    private int val;

    public int getVal() {
        return val;
    }

    Gender(int val) {
        this.val = val;
    }

    public static Gender transform(int val) {
        switch (val) {
            case 0:
                return Gender.UNKNOWN;
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    @Override
    public String toString() {
        switch (val) {
            case 0:
                return "未知";
            case 1:
                return "男";
            case 2:
                return "女";
            default:
                throw new NotImplementedException();
        }
    }
}
