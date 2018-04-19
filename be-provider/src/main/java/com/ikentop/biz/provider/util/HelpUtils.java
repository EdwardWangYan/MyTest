package com.ikentop.biz.provider.util;


import java.io.*;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * 工具类
 *
 * @author 张庆
 * @date 2015年5月22日
 */
public abstract class HelpUtils {
	//private Logger logger =  LoggerFactory.getLogger(this.getClass());

	/**
	 * 大写字母
	 */
	private static Set<Character> capital = new HashSet<Character>();
	/**
	 * 小写字母
	 */
	private static Set<Character> lowercase = new HashSet<Character>();

	static {
		for (int i = 0; i < 26; i++) {
			capital.add(new Character((char) ('A' + i)));
			lowercase.add(new Character((char) ('a' + i)));
		}
	}

	/**
	 * 返回大写字母
	 *
	 * @author 孙少平
	 * @date 2015年8月13日
	 * @return
	 */
	public static Set<Character> getCapital() {
		return capital;
	}

	/**
	 * 返回小写字母
	 *
	 * @author 孙少平
	 * @date 2015年8月13日
	 * @return
	 */
	public static Set<Character> getLowercase() {
		return lowercase;
	}

	/**
	 * 支持 String 数组 Collection 判空，如果为空返回true否则返回false
	 *
	 * @author 孙少平
	 * @date 2015年3月23日
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if (obj instanceof CharSequence) {
			return ((CharSequence) obj).length() == 0;
		}
		if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		}
		if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}
		return false;
	}

    /**
     * 判断是否不是空
     * @param obj 判断空对象
     * @return 空的情况下返回 false，是空的情况下 返回true
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

	/**
	 * 创建类的实例
	 *
	 * @author 孙少平
	 * @date 2015年5月22日
	 * @param clazz
	 * @param className
	 * @return
	 */
	public static <T> T instance(Class<T> clazz, String className) {
		return clazz.cast(instance(className));

	}

	public static Object instance(String className) {
		try {
			return Class.forName(className).newInstance();
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 创建实例
	 *
	 * @author 孙少平
	 * @date 2015年5月23日
	 * @param clazz
	 * @return
	 */
	public static <T> T instance(Class<T> clazz) {
		return instance(clazz, clazz.getName());
	}

	/**
	 * 深层克隆
	 * @author 孙少平
	 * @date 2015年5月25日
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T deepClone(Serializable obj) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			new ObjectOutputStream(baos).writeObject(obj);
			return (T) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回服务器ip地址
	 *
	 * @author 孙少平
	 * @date 2015年6月17日
	 * @return
	 */
	public static String getIpAddress() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			return address.getHostAddress();
		} catch (UnknownHostException e) {
			//log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public static String getUUID() {
		return getUUID(UUID.randomUUID());
	}

	/**
	 * 返回大写的uuid,长度32(81BE245897EA47329E685259FEB2D784)
	 * @author 孙少平
	 * @date 2015年12月12日
	 * @return
	 */
	public static String getUUID(UUID uuid) {
		StringBuilder sb = new StringBuilder();
		sb.append(digits(uuid.getMostSignificantBits() >> 32, 8));
		sb.append(digits(uuid.getMostSignificantBits() >> 16, 4));
		sb.append(digits(uuid.getMostSignificantBits(), 4));
		sb.append(digits(uuid.getLeastSignificantBits() >> 48, 4));
		sb.append(digits(uuid.getLeastSignificantBits(), 12));
		return sb.toString();
	}

	/** Returns val represented by the specified number of hex digits. */
	private static String digits(long val, int digits) {
		long hi = 1L << (digits * 4);
		return Long.toHexString(hi | (val & (hi - 1))).substring(1).toUpperCase();
	}

	/**
	 * 关闭资源
	 *
	 * @author 孙少平
	 * @date 2016年1月7日
	 * @param resource
	 */
	public static void close(AutoCloseable resource) {
		if (!isEmpty(resource)) {
			try {
				resource.close();
			} catch (Exception e) {
				//log.error(e.getMessage(), e);
				throw new RuntimeException(e);
			}
		}
	}
}
