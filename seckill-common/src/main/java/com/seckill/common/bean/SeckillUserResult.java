package com.seckill.common.bean;

import java.util.Date;

public class SeckillUserResult {
    private Long id;

    private Long userId;

    private Long productId;

    private Long seckillProductId;

    private Integer result;

    private String resultData;

    private Date seckillTime;

    private String orderId;

    private Date createdTime;

    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSeckillProductId() {
        return seckillProductId;
    }

    public void setSeckillProductId(Long seckillProductId) {
        this.seckillProductId = seckillProductId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData == null ? null : resultData.trim();
    }

    public Date getSeckillTime() {
        return seckillTime;
    }

    public void setSeckillTime(Date seckillTime) {
        this.seckillTime = seckillTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}