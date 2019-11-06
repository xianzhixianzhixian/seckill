package com.seckill.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具
 */
public class MD5Util {

    public static final String MD5KEY = "seckill";
    /**
     * 根据传入的值进行加密
     * @param text
     * @param key
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        String encodeStr = DigestUtils.md5Hex(text + key);
        return encodeStr;
    }

    /**
     * 验证密码是否正确
     * @param text
     * @param key
     * @param md5
     * @return
     * @throws Exception
     */
    public static Boolean verify(String text, String key, String md5) throws Exception {
        String md5Text = md5(text, key);
        if (md5Text.equalsIgnoreCase(md5)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(md5("123456", "seckill"));
    }
}
