package com.ikentop.biz.provider.constant;

import com.ikentop.biz.provider.model.bo.UserInfo4Session;

/**
 * @author : tac
 * @since : 12/09/2017
 */
public enum SessionAttr {
    USER_INFO("user_info", UserInfo4Session.class)

    ;


    private String key;
    /**
     * @deprecated 该字段暂时无实际作用，仅做指示作用（指示attr对应的object的具体类型）
     */
    private Class clazz;

    SessionAttr(String key, Class clazz) {
        this.key = key;
        this.clazz = clazz;
    }

    public String getKey() {
        return key;
    }

    public Class getClazz() {
        return clazz;
    }
}
