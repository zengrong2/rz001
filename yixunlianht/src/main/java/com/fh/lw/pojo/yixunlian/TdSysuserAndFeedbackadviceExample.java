package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.List;

public class TdSysuserAndFeedbackadviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdSysuserAndFeedbackadviceExample() {
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

        public Criteria andSysuserAndfeedbackadviceIdIsNull() {
            addCriterion("sysuser_andfeedbackadvice_id is null");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdIsNotNull() {
            addCriterion("sysuser_andfeedbackadvice_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdEqualTo(String value) {
            addCriterion("sysuser_andfeedbackadvice_id =", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdNotEqualTo(String value) {
            addCriterion("sysuser_andfeedbackadvice_id <>", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdGreaterThan(String value) {
            addCriterion("sysuser_andfeedbackadvice_id >", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("sysuser_andfeedbackadvice_id >=", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdLessThan(String value) {
            addCriterion("sysuser_andfeedbackadvice_id <", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdLessThanOrEqualTo(String value) {
            addCriterion("sysuser_andfeedbackadvice_id <=", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdLike(String value) {
            addCriterion("sysuser_andfeedbackadvice_id like", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdNotLike(String value) {
            addCriterion("sysuser_andfeedbackadvice_id not like", value, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdIn(List<String> values) {
            addCriterion("sysuser_andfeedbackadvice_id in", values, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdNotIn(List<String> values) {
            addCriterion("sysuser_andfeedbackadvice_id not in", values, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdBetween(String value1, String value2) {
            addCriterion("sysuser_andfeedbackadvice_id between", value1, value2, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserAndfeedbackadviceIdNotBetween(String value1, String value2) {
            addCriterion("sysuser_andfeedbackadvice_id not between", value1, value2, "sysuserAndfeedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdIsNull() {
            addCriterion("sysuser_id is null");
            return (Criteria) this;
        }

        public Criteria andSysuserIdIsNotNull() {
            addCriterion("sysuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysuserIdEqualTo(String value) {
            addCriterion("sysuser_id =", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdNotEqualTo(String value) {
            addCriterion("sysuser_id <>", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdGreaterThan(String value) {
            addCriterion("sysuser_id >", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdGreaterThanOrEqualTo(String value) {
            addCriterion("sysuser_id >=", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdLessThan(String value) {
            addCriterion("sysuser_id <", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdLessThanOrEqualTo(String value) {
            addCriterion("sysuser_id <=", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdLike(String value) {
            addCriterion("sysuser_id like", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdNotLike(String value) {
            addCriterion("sysuser_id not like", value, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdIn(List<String> values) {
            addCriterion("sysuser_id in", values, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdNotIn(List<String> values) {
            addCriterion("sysuser_id not in", values, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdBetween(String value1, String value2) {
            addCriterion("sysuser_id between", value1, value2, "sysuserId");
            return (Criteria) this;
        }

        public Criteria andSysuserIdNotBetween(String value1, String value2) {
            addCriterion("sysuser_id not between", value1, value2, "sysuserId");
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

        public Criteria andFeedbackadviceIdIsNull() {
            addCriterion("feedbackadvice_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdIsNotNull() {
            addCriterion("feedbackadvice_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdEqualTo(String value) {
            addCriterion("feedbackadvice_id =", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdNotEqualTo(String value) {
            addCriterion("feedbackadvice_id <>", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdGreaterThan(String value) {
            addCriterion("feedbackadvice_id >", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("feedbackadvice_id >=", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdLessThan(String value) {
            addCriterion("feedbackadvice_id <", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdLessThanOrEqualTo(String value) {
            addCriterion("feedbackadvice_id <=", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdLike(String value) {
            addCriterion("feedbackadvice_id like", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdNotLike(String value) {
            addCriterion("feedbackadvice_id not like", value, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdIn(List<String> values) {
            addCriterion("feedbackadvice_id in", values, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdNotIn(List<String> values) {
            addCriterion("feedbackadvice_id not in", values, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdBetween(String value1, String value2) {
            addCriterion("feedbackadvice_id between", value1, value2, "feedbackadviceId");
            return (Criteria) this;
        }

        public Criteria andFeedbackadviceIdNotBetween(String value1, String value2) {
            addCriterion("feedbackadvice_id not between", value1, value2, "feedbackadviceId");
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