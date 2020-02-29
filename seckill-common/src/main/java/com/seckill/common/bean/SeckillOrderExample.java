package com.seckill.common.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeckillOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeckillOrderExample() {
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

        public Criteria andSeckillProductIdIsNull() {
            addCriterion("seckill_product_id is null");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdIsNotNull() {
            addCriterion("seckill_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdEqualTo(Long value) {
            addCriterion("seckill_product_id =", value, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdNotEqualTo(Long value) {
            addCriterion("seckill_product_id <>", value, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdGreaterThan(Long value) {
            addCriterion("seckill_product_id >", value, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("seckill_product_id >=", value, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdLessThan(Long value) {
            addCriterion("seckill_product_id <", value, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdLessThanOrEqualTo(Long value) {
            addCriterion("seckill_product_id <=", value, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdIn(List<Long> values) {
            addCriterion("seckill_product_id in", values, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdNotIn(List<Long> values) {
            addCriterion("seckill_product_id not in", values, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdBetween(Long value1, Long value2) {
            addCriterion("seckill_product_id between", value1, value2, "seckillProductId");
            return (Criteria) this;
        }

        public Criteria andSeckillProductIdNotBetween(Long value1, Long value2) {
            addCriterion("seckill_product_id not between", value1, value2, "seckillProductId");
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

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(BigDecimal value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(BigDecimal value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(BigDecimal value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(BigDecimal value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<BigDecimal> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<BigDecimal> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressIsNull() {
            addCriterion("receiving_adress is null");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressIsNotNull() {
            addCriterion("receiving_adress is not null");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressEqualTo(String value) {
            addCriterion("receiving_adress =", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressNotEqualTo(String value) {
            addCriterion("receiving_adress <>", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressGreaterThan(String value) {
            addCriterion("receiving_adress >", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressGreaterThanOrEqualTo(String value) {
            addCriterion("receiving_adress >=", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressLessThan(String value) {
            addCriterion("receiving_adress <", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressLessThanOrEqualTo(String value) {
            addCriterion("receiving_adress <=", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressLike(String value) {
            addCriterion("receiving_adress like", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressNotLike(String value) {
            addCriterion("receiving_adress not like", value, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressIn(List<String> values) {
            addCriterion("receiving_adress in", values, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressNotIn(List<String> values) {
            addCriterion("receiving_adress not in", values, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressBetween(String value1, String value2) {
            addCriterion("receiving_adress between", value1, value2, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingAdressNotBetween(String value1, String value2) {
            addCriterion("receiving_adress not between", value1, value2, "receivingAdress");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneIsNull() {
            addCriterion("receiving_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneIsNotNull() {
            addCriterion("receiving_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneEqualTo(String value) {
            addCriterion("receiving_phone =", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneNotEqualTo(String value) {
            addCriterion("receiving_phone <>", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneGreaterThan(String value) {
            addCriterion("receiving_phone >", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiving_phone >=", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneLessThan(String value) {
            addCriterion("receiving_phone <", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiving_phone <=", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneLike(String value) {
            addCriterion("receiving_phone like", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneNotLike(String value) {
            addCriterion("receiving_phone not like", value, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneIn(List<String> values) {
            addCriterion("receiving_phone in", values, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneNotIn(List<String> values) {
            addCriterion("receiving_phone not in", values, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneBetween(String value1, String value2) {
            addCriterion("receiving_phone between", value1, value2, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingPhoneNotBetween(String value1, String value2) {
            addCriterion("receiving_phone not between", value1, value2, "receivingPhone");
            return (Criteria) this;
        }

        public Criteria andReceivingNameIsNull() {
            addCriterion("receiving_name is null");
            return (Criteria) this;
        }

        public Criteria andReceivingNameIsNotNull() {
            addCriterion("receiving_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceivingNameEqualTo(String value) {
            addCriterion("receiving_name =", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameNotEqualTo(String value) {
            addCriterion("receiving_name <>", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameGreaterThan(String value) {
            addCriterion("receiving_name >", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiving_name >=", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameLessThan(String value) {
            addCriterion("receiving_name <", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameLessThanOrEqualTo(String value) {
            addCriterion("receiving_name <=", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameLike(String value) {
            addCriterion("receiving_name like", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameNotLike(String value) {
            addCriterion("receiving_name not like", value, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameIn(List<String> values) {
            addCriterion("receiving_name in", values, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameNotIn(List<String> values) {
            addCriterion("receiving_name not in", values, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameBetween(String value1, String value2) {
            addCriterion("receiving_name between", value1, value2, "receivingName");
            return (Criteria) this;
        }

        public Criteria andReceivingNameNotBetween(String value1, String value2) {
            addCriterion("receiving_name not between", value1, value2, "receivingName");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberIsNull() {
            addCriterion("trade_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberIsNotNull() {
            addCriterion("trade_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberEqualTo(String value) {
            addCriterion("trade_serial_number =", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberNotEqualTo(String value) {
            addCriterion("trade_serial_number <>", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberGreaterThan(String value) {
            addCriterion("trade_serial_number >", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("trade_serial_number >=", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberLessThan(String value) {
            addCriterion("trade_serial_number <", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("trade_serial_number <=", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberLike(String value) {
            addCriterion("trade_serial_number like", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberNotLike(String value) {
            addCriterion("trade_serial_number not like", value, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberIn(List<String> values) {
            addCriterion("trade_serial_number in", values, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberNotIn(List<String> values) {
            addCriterion("trade_serial_number not in", values, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberBetween(String value1, String value2) {
            addCriterion("trade_serial_number between", value1, value2, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTradeSerialNumberNotBetween(String value1, String value2) {
            addCriterion("trade_serial_number not between", value1, value2, "tradeSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSeckillNumIsNull() {
            addCriterion("seckill_num is null");
            return (Criteria) this;
        }

        public Criteria andSeckillNumIsNotNull() {
            addCriterion("seckill_num is not null");
            return (Criteria) this;
        }

        public Criteria andSeckillNumEqualTo(Long value) {
            addCriterion("seckill_num =", value, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumNotEqualTo(Long value) {
            addCriterion("seckill_num <>", value, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumGreaterThan(Long value) {
            addCriterion("seckill_num >", value, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumGreaterThanOrEqualTo(Long value) {
            addCriterion("seckill_num >=", value, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumLessThan(Long value) {
            addCriterion("seckill_num <", value, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumLessThanOrEqualTo(Long value) {
            addCriterion("seckill_num <=", value, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumIn(List<Long> values) {
            addCriterion("seckill_num in", values, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumNotIn(List<Long> values) {
            addCriterion("seckill_num not in", values, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumBetween(Long value1, Long value2) {
            addCriterion("seckill_num between", value1, value2, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andSeckillNumNotBetween(Long value1, Long value2) {
            addCriterion("seckill_num not between", value1, value2, "seckillNum");
            return (Criteria) this;
        }

        public Criteria andOrderFlagIsNull() {
            addCriterion("order_flag is null");
            return (Criteria) this;
        }

        public Criteria andOrderFlagIsNotNull() {
            addCriterion("order_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFlagEqualTo(Integer value) {
            addCriterion("order_flag =", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagNotEqualTo(Integer value) {
            addCriterion("order_flag <>", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagGreaterThan(Integer value) {
            addCriterion("order_flag >", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_flag >=", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagLessThan(Integer value) {
            addCriterion("order_flag <", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagLessThanOrEqualTo(Integer value) {
            addCriterion("order_flag <=", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagIn(List<Integer> values) {
            addCriterion("order_flag in", values, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagNotIn(List<Integer> values) {
            addCriterion("order_flag not in", values, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagBetween(Integer value1, Integer value2) {
            addCriterion("order_flag between", value1, value2, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("order_flag not between", value1, value2, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdIsNull() {
            addCriterion("seckill_user_result_id is null");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdIsNotNull() {
            addCriterion("seckill_user_result_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdEqualTo(String value) {
            addCriterion("seckill_user_result_id =", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdNotEqualTo(String value) {
            addCriterion("seckill_user_result_id <>", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdGreaterThan(String value) {
            addCriterion("seckill_user_result_id >", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdGreaterThanOrEqualTo(String value) {
            addCriterion("seckill_user_result_id >=", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdLessThan(String value) {
            addCriterion("seckill_user_result_id <", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdLessThanOrEqualTo(String value) {
            addCriterion("seckill_user_result_id <=", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdLike(String value) {
            addCriterion("seckill_user_result_id like", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdNotLike(String value) {
            addCriterion("seckill_user_result_id not like", value, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdIn(List<String> values) {
            addCriterion("seckill_user_result_id in", values, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdNotIn(List<String> values) {
            addCriterion("seckill_user_result_id not in", values, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdBetween(String value1, String value2) {
            addCriterion("seckill_user_result_id between", value1, value2, "seckillUserResultId");
            return (Criteria) this;
        }

        public Criteria andSeckillUserResultIdNotBetween(String value1, String value2) {
            addCriterion("seckill_user_result_id not between", value1, value2, "seckillUserResultId");
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