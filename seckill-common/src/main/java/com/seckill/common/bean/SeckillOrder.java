package com.seckill.common.bean;

import java.math.BigDecimal;
import java.util.Date;

public class SeckillOrder {
    private Long id;

    private Long seckillProductId;

    private Long productId;

    private BigDecimal payAmount;

    private Long userId;

    private Long shopId;

    private Date createTime;

    private Date payTime;

    private Integer payStatus;

    private Integer payType;

    private String receivingAdress;

    private String receivingPhone;

    private String receivingName;

    private String tradeSerialNumber;

    private Long seckillNum;

    private Integer orderFlag;

    private Long seckillUserResultId;

    private Date createdTime;

    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeckillProductId() {
        return seckillProductId;
    }

    public void setSeckillProductId(Long seckillProductId) {
        this.seckillProductId = seckillProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getReceivingAdress() {
        return receivingAdress;
    }

    public void setReceivingAdress(String receivingAdress) {
        this.receivingAdress = receivingAdress == null ? null : receivingAdress.trim();
    }

    public String getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(String receivingPhone) {
        this.receivingPhone = receivingPhone == null ? null : receivingPhone.trim();
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName == null ? null : receivingName.trim();
    }

    public String getTradeSerialNumber() {
        return tradeSerialNumber;
    }

    public void setTradeSerialNumber(String tradeSerialNumber) {
        this.tradeSerialNumber = tradeSerialNumber == null ? null : tradeSerialNumber.trim();
    }

    public Long getSeckillNum() {
        return seckillNum;
    }

    public void setSeckillNum(Long seckillNum) {
        this.seckillNum = seckillNum;
    }

    public Integer getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    public Long getSeckillUserResultId() {
        return seckillUserResultId;
    }

    public void setSeckillUserResultId(Long seckillUserResultId) {
        this.seckillUserResultId = seckillUserResultId;
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