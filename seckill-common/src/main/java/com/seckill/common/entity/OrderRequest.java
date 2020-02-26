package com.seckill.common.entity;

/**
 * 传入RabbitMQ的订单消息
 */
public class OrderRequest {

    private Long userId;

    private Long shopId;

    private Long seckillProductId;

    public OrderRequest() {
    }

    public OrderRequest(Long userId, Long shopId, Long seckillProductId) {
        this.userId = userId;
        this.shopId = shopId;
        this.seckillProductId = seckillProductId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSeckillProductId() {
        return seckillProductId;
    }

    public void setSeckillProductId(Long seckillProductId) {
        this.seckillProductId = seckillProductId;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "userId=" + userId +
                ", shopId=" + shopId +
                ", seckillProductId=" + seckillProductId +
                '}';
    }
}
