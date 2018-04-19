package com.ikentop.biz.client.util;

import com.google.common.base.Predicate;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author tac
 * @since 26/12/2017
 */
public abstract class EncodeUtils {
    public static Map<String, Object> toQueryMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), (Predicate<Field>) field -> true);
        for (Field field : fields) {
            try {
                String getterName = "get" + initialToUpperCase(field.getName());
                Method getter = obj.getClass().getMethod(getterName);

                Object fieldValue = getter.invoke(obj);
                if (fieldValue == null) {
                    continue;
                }
                map.put(field.getName(), fieldValue);
            } catch (ReflectiveOperationException ignored) {
            }
        }
        return map;
    }

    public static String toQueryString(Object obj) {
        StringBuilder sb = new StringBuilder();
        Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), (Predicate<Field>) field -> true);
        for (Field field : fields) {
            try {
                String getterName = "get" + initialToUpperCase(field.getName());
                Method getter = obj.getClass().getMethod(getterName);
                Object val = getter.invoke(obj);
                if (val == null) {
                    continue;
                }
                String strVal = val.toString();
                sb.append(field.getName());
                sb.append("=");
                sb.append(strVal);
                sb.append("&");
            } catch (ReflectiveOperationException ignored) {
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    static String initialToUpperCase(String fieldName) {
        return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
