package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class RestaurantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RestaurantExample() {
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

        public Criteria andRestaurantNameIsNull() {
            addCriterion("restaurant_name is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameIsNotNull() {
            addCriterion("restaurant_name is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameEqualTo(String value) {
            addCriterion("restaurant_name =", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameNotEqualTo(String value) {
            addCriterion("restaurant_name <>", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameGreaterThan(String value) {
            addCriterion("restaurant_name >", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_name >=", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameLessThan(String value) {
            addCriterion("restaurant_name <", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameLessThanOrEqualTo(String value) {
            addCriterion("restaurant_name <=", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameLike(String value) {
            addCriterion("restaurant_name like", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameNotLike(String value) {
            addCriterion("restaurant_name not like", value, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameIn(List<String> values) {
            addCriterion("restaurant_name in", values, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameNotIn(List<String> values) {
            addCriterion("restaurant_name not in", values, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameBetween(String value1, String value2) {
            addCriterion("restaurant_name between", value1, value2, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantNameNotBetween(String value1, String value2) {
            addCriterion("restaurant_name not between", value1, value2, "restaurantName");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressIsNull() {
            addCriterion("restaurant_address is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressIsNotNull() {
            addCriterion("restaurant_address is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressEqualTo(String value) {
            addCriterion("restaurant_address =", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressNotEqualTo(String value) {
            addCriterion("restaurant_address <>", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressGreaterThan(String value) {
            addCriterion("restaurant_address >", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_address >=", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressLessThan(String value) {
            addCriterion("restaurant_address <", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressLessThanOrEqualTo(String value) {
            addCriterion("restaurant_address <=", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressLike(String value) {
            addCriterion("restaurant_address like", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressNotLike(String value) {
            addCriterion("restaurant_address not like", value, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressIn(List<String> values) {
            addCriterion("restaurant_address in", values, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressNotIn(List<String> values) {
            addCriterion("restaurant_address not in", values, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressBetween(String value1, String value2) {
            addCriterion("restaurant_address between", value1, value2, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantAddressNotBetween(String value1, String value2) {
            addCriterion("restaurant_address not between", value1, value2, "restaurantAddress");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeIsNull() {
            addCriterion("restaurant_notice is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeIsNotNull() {
            addCriterion("restaurant_notice is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeEqualTo(String value) {
            addCriterion("restaurant_notice =", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeNotEqualTo(String value) {
            addCriterion("restaurant_notice <>", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeGreaterThan(String value) {
            addCriterion("restaurant_notice >", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_notice >=", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeLessThan(String value) {
            addCriterion("restaurant_notice <", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeLessThanOrEqualTo(String value) {
            addCriterion("restaurant_notice <=", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeLike(String value) {
            addCriterion("restaurant_notice like", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeNotLike(String value) {
            addCriterion("restaurant_notice not like", value, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeIn(List<String> values) {
            addCriterion("restaurant_notice in", values, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeNotIn(List<String> values) {
            addCriterion("restaurant_notice not in", values, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeBetween(String value1, String value2) {
            addCriterion("restaurant_notice between", value1, value2, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantNoticeNotBetween(String value1, String value2) {
            addCriterion("restaurant_notice not between", value1, value2, "restaurantNotice");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountIsNull() {
            addCriterion("restaurant_account is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountIsNotNull() {
            addCriterion("restaurant_account is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountEqualTo(String value) {
            addCriterion("restaurant_account =", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountNotEqualTo(String value) {
            addCriterion("restaurant_account <>", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountGreaterThan(String value) {
            addCriterion("restaurant_account >", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_account >=", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountLessThan(String value) {
            addCriterion("restaurant_account <", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountLessThanOrEqualTo(String value) {
            addCriterion("restaurant_account <=", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountLike(String value) {
            addCriterion("restaurant_account like", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountNotLike(String value) {
            addCriterion("restaurant_account not like", value, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountIn(List<String> values) {
            addCriterion("restaurant_account in", values, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountNotIn(List<String> values) {
            addCriterion("restaurant_account not in", values, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountBetween(String value1, String value2) {
            addCriterion("restaurant_account between", value1, value2, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantAccountNotBetween(String value1, String value2) {
            addCriterion("restaurant_account not between", value1, value2, "restaurantAccount");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordIsNull() {
            addCriterion("restaurant_password is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordIsNotNull() {
            addCriterion("restaurant_password is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordEqualTo(String value) {
            addCriterion("restaurant_password =", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordNotEqualTo(String value) {
            addCriterion("restaurant_password <>", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordGreaterThan(String value) {
            addCriterion("restaurant_password >", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_password >=", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordLessThan(String value) {
            addCriterion("restaurant_password <", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordLessThanOrEqualTo(String value) {
            addCriterion("restaurant_password <=", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordLike(String value) {
            addCriterion("restaurant_password like", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordNotLike(String value) {
            addCriterion("restaurant_password not like", value, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordIn(List<String> values) {
            addCriterion("restaurant_password in", values, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordNotIn(List<String> values) {
            addCriterion("restaurant_password not in", values, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordBetween(String value1, String value2) {
            addCriterion("restaurant_password between", value1, value2, "restaurantPassword");
            return (Criteria) this;
        }

        public Criteria andRestaurantPasswordNotBetween(String value1, String value2) {
            addCriterion("restaurant_password not between", value1, value2, "restaurantPassword");
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