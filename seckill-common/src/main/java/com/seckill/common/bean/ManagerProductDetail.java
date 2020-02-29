package com.seckill.common.bean;

import java.util.Date;

public class ManagerProductDetail {
    private Long id;

    private Long productId;

    private String productPalce;

    private String productBrand;

    private String productDecsrption;

    private String productWeight;

    private String productDetailPcitureUrl;

    private String specificationAndPack;

    private Date createdTime;

    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductPalce() {
        return productPalce;
    }

    public void setProductPalce(String productPalce) {
        this.productPalce = productPalce == null ? null : productPalce.trim();
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    public String getProductDecsrption() {
        return productDecsrption;
    }

    public void setProductDecsrption(String productDecsrption) {
        this.productDecsrption = productDecsrption == null ? null : productDecsrption.trim();
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight == null ? null : productWeight.trim();
    }

    public String getProductDetailPcitureUrl() {
        return productDetailPcitureUrl;
    }

    public void setProductDetailPcitureUrl(String productDetailPcitureUrl) {
        this.productDetailPcitureUrl = productDetailPcitureUrl == null ? null : productDetailPcitureUrl.trim();
    }

    public String getSpecificationAndPack() {
        return specificationAndPack;
    }

    public void setSpecificationAndPack(String specificationAndPack) {
        this.specificationAndPack = specificationAndPack == null ? null : specificationAndPack.trim();
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

    @Override
    public String toString() {
        return "ManagerProductDetail{" +
                "id=" + id +
                ", productId=" + productId +
                ", productPalce='" + productPalce + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productDecsrption='" + productDecsrption + '\'' +
                ", productWeight='" + productWeight + '\'' +
                ", productDetailPcitureUrl='" + productDetailPcitureUrl + '\'' +
                ", specificationAndPack='" + specificationAndPack + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}