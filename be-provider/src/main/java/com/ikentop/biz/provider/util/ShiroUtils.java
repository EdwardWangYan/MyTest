package com.ikentop.biz.provider.util;

import com.ikentop.biz.provider.constant.SessionAttr;
import com.ikentop.biz.provider.exception.AccountUnauthenticatedException;
import com.ikentop.biz.provider.exception.NoSuchSessionAttributeException;
import com.ikentop.biz.provider.exception.SessionNullException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * todo:: test
 *
 * @author : tac
 * @since : 12/09/2017
 */
public abstract class ShiroUtils {
    public static Session currentSession() {
        Subject subject = SecurityUtils.getSubject();
        if (!isAuthenticatedOrRemembered(subject)) {
            throw new AccountUnauthenticatedException();
        }
        Session session = subject.getSession(false);
        if (session != null) {
            return session;
        }
        throw new SessionNullException();
    }

    public static Object getSessionAttribute(String key) {
        return getSessionAttribute(key, Object.class);
    }

    public static <T> T getSessionAttribute(SessionAttr attr, Class<T> clazz) {
        return getSessionAttribute(attr.getKey(), clazz);
    }

    public static <T extends Object> T getSessionAttribute(String key, Class<T> clazz) {
        Object o = currentSession().getAttribute(key);
        if (o == null) {
            throw new NoSuchSessionAttributeException(key);
        }
        return clazz.cast(o);
    }

    private static boolean isAuthenticatedOrRemembered(Subject subject) {
        return subject != null && (subject.isAuthenticated() || subject.isRemembered());
    }
}
