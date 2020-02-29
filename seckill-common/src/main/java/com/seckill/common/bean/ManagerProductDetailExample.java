package com.seckill.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerProductDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagerProductDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductPalceIsNull() {
            addCriterion("product_palce is null");
            return (Criteria) this;
        }

        public Criteria andProductPalceIsNotNull() {
            addCriterion("product_palce is not null");
            return (Criteria) this;
        }

        public Criteria andProductPalceEqualTo(String value) {
            addCriterion("product_palce =", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceNotEqualTo(String value) {
            addCriterion("product_palce <>", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceGreaterThan(String value) {
            addCriterion("product_palce >", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceGreaterThanOrEqualTo(String value) {
            addCriterion("product_palce >=", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceLessThan(String value) {
            addCriterion("product_palce <", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceLessThanOrEqualTo(String value) {
            addCriterion("product_palce <=", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceLike(String value) {
            addCriterion("product_palce like", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceNotLike(String value) {
            addCriterion("product_palce not like", value, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceIn(List<String> values) {
            addCriterion("product_palce in", values, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceNotIn(List<String> values) {
            addCriterion("product_palce not in", values, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceBetween(String value1, String value2) {
            addCriterion("product_palce between", value1, value2, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductPalceNotBetween(String value1, String value2) {
            addCriterion("product_palce not between", value1, value2, "productPalce");
            return (Criteria) this;
        }

        public Criteria andProductBrandIsNull() {
            addCriterion("product_brand is null");
            return (Criteria) this;
        }

        public Criteria andProductBrandIsNotNull() {
            addCriterion("product_brand is not null");
            return (Criteria) this;
        }

        public Criteria andProductBrandEqualTo(String value) {
            addCriterion("product_brand =", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandNotEqualTo(String value) {
            addCriterion("product_brand <>", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandGreaterThan(String value) {
            addCriterion("product_brand >", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandGreaterThanOrEqualTo(String value) {
            addCriterion("product_brand >=", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandLessThan(String value) {
            addCriterion("product_brand <", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandLessThanOrEqualTo(String value) {
            addCriterion("product_brand <=", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandLike(String value) {
            addCriterion("product_brand like", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandNotLike(String value) {
            addCriterion("product_brand not like", value, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandIn(List<String> values) {
            addCriterion("product_brand in", values, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandNotIn(List<String> values) {
            addCriterion("product_brand not in", values, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandBetween(String value1, String value2) {
            addCriterion("product_brand between", value1, value2, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductBrandNotBetween(String value1, String value2) {
            addCriterion("product_brand not between", value1, value2, "productBrand");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionIsNull() {
            addCriterion("product_decsrption is null");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionIsNotNull() {
            addCriterion("product_decsrption is not null");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionEqualTo(String value) {
            addCriterion("product_decsrption =", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionNotEqualTo(String value) {
            addCriterion("product_decsrption <>", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionGreaterThan(String value) {
            addCriterion("product_decsrption >", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionGreaterThanOrEqualTo(String value) {
            addCriterion("product_decsrption >=", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionLessThan(String value) {
            addCriterion("product_decsrption <", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionLessThanOrEqualTo(String value) {
            addCriterion("product_decsrption <=", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionLike(String value) {
            addCriterion("product_decsrption like", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionNotLike(String value) {
            addCriterion("product_decsrption not like", value, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionIn(List<String> values) {
            addCriterion("product_decsrption in", values, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionNotIn(List<String> values) {
            addCriterion("product_decsrption not in", values, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionBetween(String value1, String value2) {
            addCriterion("product_decsrption between", value1, value2, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductDecsrptionNotBetween(String value1, String value2) {
            addCriterion("product_decsrption not between", value1, value2, "productDecsrption");
            return (Criteria) this;
        }

        public Criteria andProductWeightIsNull() {
            addCriterion("product_weight is null");
            return (Criteria) this;
        }

        public Criteria andProductWeightIsNotNull() {
            addCriterion("product_weight is not null");
            return (Criteria) this;
        }

        public Criteria andProductWeightEqualTo(String value) {
            addCriterion("product_weight =", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightNotEqualTo(String value) {
            addCriterion("product_weight <>", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightGreaterThan(String value) {
            addCriterion("product_weight >", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightGreaterThanOrEqualTo(String value) {
            addCriterion("product_weight >=", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightLessThan(String value) {
            addCriterion("product_weight <", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightLessThanOrEqualTo(String value) {
            addCriterion("product_weight <=", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightLike(String value) {
            addCriterion("product_weight like", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightNotLike(String value) {
            addCriterion("product_weight not like", value, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightIn(List<String> values) {
            addCriterion("product_weight in", values, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightNotIn(List<String> values) {
            addCriterion("product_weight not in", values, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightBetween(String value1, String value2) {
            addCriterion("product_weight between", value1, value2, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductWeightNotBetween(String value1, String value2) {
            addCriterion("product_weight not between", value1, value2, "productWeight");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlIsNull() {
            addCriterion("product_detail_pciture_url is null");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlIsNotNull() {
            addCriterion("product_detail_pciture_url is not null");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlEqualTo(String value) {
            addCriterion("product_detail_pciture_url =", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlNotEqualTo(String value) {
            addCriterion("product_detail_pciture_url <>", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlGreaterThan(String value) {
            addCriterion("product_detail_pciture_url >", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("product_detail_pciture_url >=", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlLessThan(String value) {
            addCriterion("product_detail_pciture_url <", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlLessThanOrEqualTo(String value) {
            addCriterion("product_detail_pciture_url <=", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlLike(String value) {
            addCriterion("product_detail_pciture_url like", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlNotLike(String value) {
            addCriterion("product_detail_pciture_url not like", value, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlIn(List<String> values) {
            addCriterion("product_detail_pciture_url in", values, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlNotIn(List<String> values) {
            addCriterion("product_detail_pciture_url not in", values, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlBetween(String value1, String value2) {
            addCriterion("product_detail_pciture_url between", value1, value2, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andProductDetailPcitureUrlNotBetween(String value1, String value2) {
            addCriterion("product_detail_pciture_url not between", value1, value2, "productDetailPcitureUrl");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackIsNull() {
            addCriterion("specification_and_pack is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackIsNotNull() {
            addCriterion("specification_and_pack is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackEqualTo(String value) {
            addCriterion("specification_and_pack =", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackNotEqualTo(String value) {
            addCriterion("specification_and_pack <>", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackGreaterThan(String value) {
            addCriterion("specification_and_pack >", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackGreaterThanOrEqualTo(String value) {
            addCriterion("specification_and_pack >=", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackLessThan(String value) {
            addCriterion("specification_and_pack <", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackLessThanOrEqualTo(String value) {
            addCriterion("specification_and_pack <=", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackLike(String value) {
            addCriterion("specification_and_pack like", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackNotLike(String value) {
            addCriterion("specification_and_pack not like", value, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackIn(List<String> values) {
            addCriterion("specification_and_pack in", values, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackNotIn(List<String> values) {
            addCriterion("specification_and_pack not in", values, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackBetween(String value1, String value2) {
            addCriterion("specification_and_pack between", value1, value2, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andSpecificationAndPackNotBetween(String value1, String value2) {
            addCriterion("specification_and_pack not between", value1, value2, "specificationAndPack");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}