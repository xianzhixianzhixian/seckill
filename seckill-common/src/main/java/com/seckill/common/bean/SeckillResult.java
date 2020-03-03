package com.seckill.common.bean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seckill.common.constant.SeckillReturnCodeType;

import java.util.List;

/**
 * 交易请求的结果类
 */
public class SeckillResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private String status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static SeckillResult build(String status, String msg, Object data) {
        return new SeckillResult(status, msg, data);
    }

    public static SeckillResult ok(Object data) {
        return new SeckillResult(data);
    }

    public static SeckillResult ok() {
        return new SeckillResult(null);
    }

    public SeckillResult() {

    }

    public static SeckillResult build(String status, String msg) {
        return new SeckillResult(status, msg, null);
    }

    public SeckillResult(String status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;
    }

    public SeckillResult(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public SeckillResult(Object data) {
        this.status = SeckillReturnCodeType.SUCCESS_CODE;
        this.msg = "交易成功";
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为SeckillResult对象
     *
     * @param jsonData json数据
     * @param clazz SeckillResult中的object类型
     * @return
     */
    public static SeckillResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, SeckillResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(String.valueOf(jsonNode.get("status")), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static SeckillResult format(String json) {
        try {
            return MAPPER.readValue(json, SeckillResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static SeckillResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(String.valueOf(jsonNode.get("status")), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
