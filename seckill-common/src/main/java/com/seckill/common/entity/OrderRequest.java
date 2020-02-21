package com.seckill.common.entity;

/**
 * 传入RabbitMQ的订单消息
 */
public class OrderRequest {

    private Long seckillProductId;
    private Long userId;

    public OrderRequest() {
    }

    public OrderRequest(Long seckillProductId, Long userId) {
        this.seckillProductId = seckillProductId;
        this.userId = userId;
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
                "seckillProductId=" + seckillProductId +
                ", userId=" + userId +
                '}';
    }
}
