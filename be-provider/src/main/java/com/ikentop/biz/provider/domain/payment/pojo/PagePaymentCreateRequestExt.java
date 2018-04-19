package com.ikentop.biz.provider.domain.payment.pojo;

import java.util.HashMap;

/**
 * @author tac
 * @since 04/01/2018
 */
public abstract class PagePaymentCreateRequestExt extends HashMap<String, Object> {
    public abstract void initDefault();

    protected String toS(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
