package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdCreditratingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdCreditratingExample() {
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

        public Criteria andCreditrdIdIsNull() {
            addCriterion("creditrd_id is null");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdIsNotNull() {
            addCriterion("creditrd_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdEqualTo(String value) {
            addCriterion("creditrd_id =", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdNotEqualTo(String value) {
            addCriterion("creditrd_id <>", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdGreaterThan(String value) {
            addCriterion("creditrd_id >", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("creditrd_id >=", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdLessThan(String value) {
            addCriterion("creditrd_id <", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdLessThanOrEqualTo(String value) {
            addCriterion("creditrd_id <=", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdLike(String value) {
            addCriterion("creditrd_id like", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdNotLike(String value) {
            addCriterion("creditrd_id not like", value, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdIn(List<String> values) {
            addCriterion("creditrd_id in", values, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdNotIn(List<String> values) {
            addCriterion("creditrd_id not in", values, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdBetween(String value1, String value2) {
            addCriterion("creditrd_id between", value1, value2, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditrdIdNotBetween(String value1, String value2) {
            addCriterion("creditrd_id not between", value1, value2, "creditrdId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingIsNull() {
            addCriterion("credit_rating is null");
            return (Criteria) this;
        }

        public Criteria andCreditRatingIsNotNull() {
            addCriterion("credit_rating is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRatingEqualTo(Integer value) {
            addCriterion("credit_rating =", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingNotEqualTo(Integer value) {
            addCriterion("credit_rating <>", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingGreaterThan(Integer value) {
            addCriterion("credit_rating >", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_rating >=", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingLessThan(Integer value) {
            addCriterion("credit_rating <", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingLessThanOrEqualTo(Integer value) {
            addCriterion("credit_rating <=", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingIn(List<Integer> values) {
            addCriterion("credit_rating in", values, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingNotIn(List<Integer> values) {
            addCriterion("credit_rating not in", values, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingBetween(Integer value1, Integer value2) {
            addCriterion("credit_rating between", value1, value2, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_rating not between", value1, value2, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxIsNull() {
            addCriterion("creditrating_max is null");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxIsNotNull() {
            addCriterion("creditrating_max is not null");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxEqualTo(Integer value) {
            addCriterion("creditrating_max =", value, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxNotEqualTo(Integer value) {
            addCriterion("creditrating_max <>", value, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxGreaterThan(Integer value) {
            addCriterion("creditrating_max >", value, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("creditrating_max >=", value, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxLessThan(Integer value) {
            addCriterion("creditrating_max <", value, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxLessThanOrEqualTo(Integer value) {
            addCriterion("creditrating_max <=", value, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxIn(List<Integer> values) {
            addCriterion("creditrating_max in", values, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxNotIn(List<Integer> values) {
            addCriterion("creditrating_max not in", values, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxBetween(Integer value1, Integer value2) {
            addCriterion("creditrating_max between", value1, value2, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("creditrating_max not between", value1, value2, "creditratingMax");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixIsNull() {
            addCriterion("creditrating_mix is null");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixIsNotNull() {
            addCriterion("creditrating_mix is not null");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixEqualTo(Integer value) {
            addCriterion("creditrating_mix =", value, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixNotEqualTo(Integer value) {
            addCriterion("creditrating_mix <>", value, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixGreaterThan(Integer value) {
            addCriterion("creditrating_mix >", value, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixGreaterThanOrEqualTo(Integer value) {
            addCriterion("creditrating_mix >=", value, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixLessThan(Integer value) {
            addCriterion("creditrating_mix <", value, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixLessThanOrEqualTo(Integer value) {
            addCriterion("creditrating_mix <=", value, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixIn(List<Integer> values) {
            addCriterion("creditrating_mix in", values, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixNotIn(List<Integer> values) {
            addCriterion("creditrating_mix not in", values, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixBetween(Integer value1, Integer value2) {
            addCriterion("creditrating_mix between", value1, value2, "creditratingMix");
            return (Criteria) this;
        }

        public Criteria andCreditratingMixNotBetween(Integer value1, Integer value2) {
            addCriterion("creditrating_mix not between", value1, value2, "creditratingMix");
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