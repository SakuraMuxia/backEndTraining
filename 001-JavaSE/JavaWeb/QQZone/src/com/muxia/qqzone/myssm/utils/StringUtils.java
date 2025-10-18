package com.muxia.qqzone.myssm.utils;

public class StringUtils {
    /**
     * 判断字符串是否为null或空字符串
     *
     * @param str 待检查字符串
     * @return true 表示为空或null，false 表示非空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 判断字符串是否非空
     *
     * @param str 待检查字符串
     * @return true 表示非空，false 表示空或null
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
