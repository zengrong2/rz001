package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.List;

public class TdAffectingcreditvalueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdAffectingcreditvalueExample() {
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

        public Criteria andAffectingcreditvalueIdIsNull() {
            addCriterion("affectingcreditvalue_id is null");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdIsNotNull() {
            addCriterion("affectingcreditvalue_id is not null");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdEqualTo(String value) {
            addCriterion("affectingcreditvalue_id =", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdNotEqualTo(String value) {
            addCriterion("affectingcreditvalue_id <>", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdGreaterThan(String value) {
            addCriterion("affectingcreditvalue_id >", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdGreaterThanOrEqualTo(String value) {
            addCriterion("affectingcreditvalue_id >=", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdLessThan(String value) {
            addCriterion("affectingcreditvalue_id <", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdLessThanOrEqualTo(String value) {
            addCriterion("affectingcreditvalue_id <=", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdLike(String value) {
            addCriterion("affectingcreditvalue_id like", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdNotLike(String value) {
            addCriterion("affectingcreditvalue_id not like", value, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdIn(List<String> values) {
            addCriterion("affectingcreditvalue_id in", values, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdNotIn(List<String> values) {
            addCriterion("affectingcreditvalue_id not in", values, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdBetween(String value1, String value2) {
            addCriterion("affectingcreditvalue_id between", value1, value2, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueIdNotBetween(String value1, String value2) {
            addCriterion("affectingcreditvalue_id not between", value1, value2, "affectingcreditvalueId");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameIsNull() {
            addCriterion("affectingcreditvalue_name is null");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameIsNotNull() {
            addCriterion("affectingcreditvalue_name is not null");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameEqualTo(String value) {
            addCriterion("affectingcreditvalue_name =", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameNotEqualTo(String value) {
            addCriterion("affectingcreditvalue_name <>", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameGreaterThan(String value) {
            addCriterion("affectingcreditvalue_name >", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameGreaterThanOrEqualTo(String value) {
            addCriterion("affectingcreditvalue_name >=", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameLessThan(String value) {
            addCriterion("affectingcreditvalue_name <", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameLessThanOrEqualTo(String value) {
            addCriterion("affectingcreditvalue_name <=", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameLike(String value) {
            addCriterion("affectingcreditvalue_name like", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameNotLike(String value) {
            addCriterion("affectingcreditvalue_name not like", value, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameIn(List<String> values) {
            addCriterion("affectingcreditvalue_name in", values, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameNotIn(List<String> values) {
            addCriterion("affectingcreditvalue_name not in", values, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameBetween(String value1, String value2) {
            addCriterion("affectingcreditvalue_name between", value1, value2, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNameNotBetween(String value1, String value2) {
            addCriterion("affectingcreditvalue_name not between", value1, value2, "affectingcreditvalueName");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumIsNull() {
            addCriterion("affectingcreditvalue_num is null");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumIsNotNull() {
            addCriterion("affectingcreditvalue_num is not null");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumEqualTo(Integer value) {
            addCriterion("affectingcreditvalue_num =", value, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumNotEqualTo(Integer value) {
            addCriterion("affectingcreditvalue_num <>", value, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumGreaterThan(Integer value) {
            addCriterion("affectingcreditvalue_num >", value, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("affectingcreditvalue_num >=", value, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumLessThan(Integer value) {
            addCriterion("affectingcreditvalue_num <", value, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumLessThanOrEqualTo(Integer value) {
            addCriterion("affectingcreditvalue_num <=", value, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumIn(List<Integer> values) {
            addCriterion("affectingcreditvalue_num in", values, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumNotIn(List<Integer> values) {
            addCriterion("affectingcreditvalue_num not in", values, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumBetween(Integer value1, Integer value2) {
            addCriterion("affectingcreditvalue_num between", value1, value2, "affectingcreditvalueNum");
            return (Criteria) this;
        }

        public Criteria andAffectingcreditvalueNumNotBetween(Integer value1, Integer value2) {
            addCriterion("affectingcreditvalue_num not between", value1, value2, "affectingcreditvalueNum");
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