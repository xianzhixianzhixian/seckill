package com.seckill.product.entity;

public class SeckillUnique{
    private Long userId;
    private Long seckillProductId;

    public SeckillUnique(Long userId,Long seckillProductId){
        this.userId = userId;
        this.seckillProductId = seckillProductId;
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
        return "SeckillUnique{" +
                "userId=" + userId +
                ", seckillProductId=" + seckillProductId +
                '}';
    }

    //TODO 解决hash中Long转Integer精度问题
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SeckillUnique that = (SeckillUnique) o;

        if (userId != that.userId) {
            return false;
        }
        return seckillProductId == that.seckillProductId;

    }

    @Override
    public int hashCode() {
        Integer result = Integer.valueOf(userId + "");
        result = 31 * result + Integer.valueOf(seckillProductId + "");
        return result;
    }
}
