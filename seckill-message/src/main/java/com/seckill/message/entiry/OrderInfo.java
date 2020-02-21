package com.seckill.message.entiry;

public class OrderInfo {

    private String orderName;

    public OrderInfo() {
    }

    public OrderInfo(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderName='" + orderName + '\'' +
                '}';
    }
}
