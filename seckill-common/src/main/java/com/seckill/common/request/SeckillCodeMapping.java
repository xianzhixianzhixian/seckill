package com.seckill.common.request;

/**
 * 返回码定义
 */
public class SeckillCodeMapping {

    /**
     * 成功
     */
    public static final String SUCCESS_CODE = "00";

    /**
     * 缺少参数信息
     */
    public static final String PARAMETER_ERROR = "02";

    /**
     * 程序逻辑校验错误(密码不正确等错误)
     */
    public static final String BUSINESS_FAIL = "03";

    /**
     * 系统错误
     */
    public static final String SYSTEM_ERROR = "99";
}
