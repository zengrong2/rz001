package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdTaxrevenueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdTaxrevenueExample() {
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

        public Criteria andTaxrevenueIdIsNull() {
            addCriterion("taxrevenue_id is null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdIsNotNull() {
            addCriterion("taxrevenue_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdEqualTo(String value) {
            addCriterion("taxrevenue_id =", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotEqualTo(String value) {
            addCriterion("taxrevenue_id <>", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdGreaterThan(String value) {
            addCriterion("taxrevenue_id >", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdGreaterThanOrEqualTo(String value) {
            addCriterion("taxrevenue_id >=", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdLessThan(String value) {
            addCriterion("taxrevenue_id <", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdLessThanOrEqualTo(String value) {
            addCriterion("taxrevenue_id <=", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdLike(String value) {
            addCriterion("taxrevenue_id like", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotLike(String value) {
            addCriterion("taxrevenue_id not like", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdIn(List<String> values) {
            addCriterion("taxrevenue_id in", values, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotIn(List<String> values) {
            addCriterion("taxrevenue_id not in", values, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdBetween(String value1, String value2) {
            addCriterion("taxrevenue_id between", value1, value2, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotBetween(String value1, String value2) {
            addCriterion("taxrevenue_id not between", value1, value2, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateIsNull() {
            addCriterion("taxrevenue_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateIsNotNull() {
            addCriterion("taxrevenue_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateEqualTo(Long value) {
            addCriterion("taxrevenue_rate =", value, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateNotEqualTo(Long value) {
            addCriterion("taxrevenue_rate <>", value, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateGreaterThan(Long value) {
            addCriterion("taxrevenue_rate >", value, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateGreaterThanOrEqualTo(Long value) {
            addCriterion("taxrevenue_rate >=", value, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateLessThan(Long value) {
            addCriterion("taxrevenue_rate <", value, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateLessThanOrEqualTo(Long value) {
            addCriterion("taxrevenue_rate <=", value, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateIn(List<Long> values) {
            addCriterion("taxrevenue_rate in", values, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateNotIn(List<Long> values) {
            addCriterion("taxrevenue_rate not in", values, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateBetween(Long value1, Long value2) {
            addCriterion("taxrevenue_rate between", value1, value2, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueRateNotBetween(Long value1, Long value2) {
            addCriterion("taxrevenue_rate not between", value1, value2, "taxrevenueRate");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusIsNull() {
            addCriterion("taxrevenue_status is null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusIsNotNull() {
            addCriterion("taxrevenue_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusEqualTo(Integer value) {
            addCriterion("taxrevenue_status =", value, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusNotEqualTo(Integer value) {
            addCriterion("taxrevenue_status <>", value, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusGreaterThan(Integer value) {
            addCriterion("taxrevenue_status >", value, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("taxrevenue_status >=", value, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusLessThan(Integer value) {
            addCriterion("taxrevenue_status <", value, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusLessThanOrEqualTo(Integer value) {
            addCriterion("taxrevenue_status <=", value, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusIn(List<Integer> values) {
            addCriterion("taxrevenue_status in", values, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusNotIn(List<Integer> values) {
            addCriterion("taxrevenue_status not in", values, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusBetween(Integer value1, Integer value2) {
            addCriterion("taxrevenue_status between", value1, value2, "taxrevenueStatus");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("taxrevenue_status not between", value1, value2, "taxrevenueStatus");
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