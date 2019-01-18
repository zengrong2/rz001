package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdActivitysignAdditemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdActivitysignAdditemExample() {
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

        public Criteria andActivitysignAdditemIsNull() {
            addCriterion("activitySign_additem is null");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemIsNotNull() {
            addCriterion("activitySign_additem is not null");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemEqualTo(String value) {
            addCriterion("activitySign_additem =", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemNotEqualTo(String value) {
            addCriterion("activitySign_additem <>", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemGreaterThan(String value) {
            addCriterion("activitySign_additem >", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemGreaterThanOrEqualTo(String value) {
            addCriterion("activitySign_additem >=", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemLessThan(String value) {
            addCriterion("activitySign_additem <", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemLessThanOrEqualTo(String value) {
            addCriterion("activitySign_additem <=", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemLike(String value) {
            addCriterion("activitySign_additem like", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemNotLike(String value) {
            addCriterion("activitySign_additem not like", value, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemIn(List<String> values) {
            addCriterion("activitySign_additem in", values, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemNotIn(List<String> values) {
            addCriterion("activitySign_additem not in", values, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemBetween(String value1, String value2) {
            addCriterion("activitySign_additem between", value1, value2, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemNotBetween(String value1, String value2) {
            addCriterion("activitySign_additem not between", value1, value2, "activitysignAdditem");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextIsNull() {
            addCriterion("activitySign_additemContext is null");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextIsNotNull() {
            addCriterion("activitySign_additemContext is not null");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextEqualTo(String value) {
            addCriterion("activitySign_additemContext =", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextNotEqualTo(String value) {
            addCriterion("activitySign_additemContext <>", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextGreaterThan(String value) {
            addCriterion("activitySign_additemContext >", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextGreaterThanOrEqualTo(String value) {
            addCriterion("activitySign_additemContext >=", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextLessThan(String value) {
            addCriterion("activitySign_additemContext <", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextLessThanOrEqualTo(String value) {
            addCriterion("activitySign_additemContext <=", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextLike(String value) {
            addCriterion("activitySign_additemContext like", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextNotLike(String value) {
            addCriterion("activitySign_additemContext not like", value, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextIn(List<String> values) {
            addCriterion("activitySign_additemContext in", values, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextNotIn(List<String> values) {
            addCriterion("activitySign_additemContext not in", values, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextBetween(String value1, String value2) {
            addCriterion("activitySign_additemContext between", value1, value2, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivitysignAdditemcontextNotBetween(String value1, String value2) {
            addCriterion("activitySign_additemContext not between", value1, value2, "activitysignAdditemcontext");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(String value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(String value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(String value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(String value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(String value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(String value) {
            addCriterion("activity_id like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(String value) {
            addCriterion("activity_id not like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<String> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<String> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(String value1, String value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(String value1, String value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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