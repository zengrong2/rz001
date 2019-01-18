package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdActivityprojectandacsignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdActivityprojectandacsignExample() {
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

        public Criteria andActivityprojectIdIsNull() {
            addCriterion("activityproject_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdIsNotNull() {
            addCriterion("activityproject_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdEqualTo(String value) {
            addCriterion("activityproject_id =", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdNotEqualTo(String value) {
            addCriterion("activityproject_id <>", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdGreaterThan(String value) {
            addCriterion("activityproject_id >", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityproject_id >=", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdLessThan(String value) {
            addCriterion("activityproject_id <", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdLessThanOrEqualTo(String value) {
            addCriterion("activityproject_id <=", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdLike(String value) {
            addCriterion("activityproject_id like", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdNotLike(String value) {
            addCriterion("activityproject_id not like", value, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdIn(List<String> values) {
            addCriterion("activityproject_id in", values, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdNotIn(List<String> values) {
            addCriterion("activityproject_id not in", values, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdBetween(String value1, String value2) {
            addCriterion("activityproject_id between", value1, value2, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectIdNotBetween(String value1, String value2) {
            addCriterion("activityproject_id not between", value1, value2, "activityprojectId");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameIsNull() {
            addCriterion("activityproject_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameIsNotNull() {
            addCriterion("activityproject_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameEqualTo(String value) {
            addCriterion("activityproject_name =", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameNotEqualTo(String value) {
            addCriterion("activityproject_name <>", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameGreaterThan(String value) {
            addCriterion("activityproject_name >", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameGreaterThanOrEqualTo(String value) {
            addCriterion("activityproject_name >=", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameLessThan(String value) {
            addCriterion("activityproject_name <", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameLessThanOrEqualTo(String value) {
            addCriterion("activityproject_name <=", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameLike(String value) {
            addCriterion("activityproject_name like", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameNotLike(String value) {
            addCriterion("activityproject_name not like", value, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameIn(List<String> values) {
            addCriterion("activityproject_name in", values, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameNotIn(List<String> values) {
            addCriterion("activityproject_name not in", values, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameBetween(String value1, String value2) {
            addCriterion("activityproject_name between", value1, value2, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectNameNotBetween(String value1, String value2) {
            addCriterion("activityproject_name not between", value1, value2, "activityprojectName");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyIsNull() {
            addCriterion("activityproject_money is null");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyIsNotNull() {
            addCriterion("activityproject_money is not null");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyEqualTo(Long value) {
            addCriterion("activityproject_money =", value, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyNotEqualTo(Long value) {
            addCriterion("activityproject_money <>", value, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyGreaterThan(Long value) {
            addCriterion("activityproject_money >", value, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("activityproject_money >=", value, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyLessThan(Long value) {
            addCriterion("activityproject_money <", value, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyLessThanOrEqualTo(Long value) {
            addCriterion("activityproject_money <=", value, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyIn(List<Long> values) {
            addCriterion("activityproject_money in", values, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyNotIn(List<Long> values) {
            addCriterion("activityproject_money not in", values, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyBetween(Long value1, Long value2) {
            addCriterion("activityproject_money between", value1, value2, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andActivityprojectMoneyNotBetween(Long value1, Long value2) {
            addCriterion("activityproject_money not between", value1, value2, "activityprojectMoney");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdIsNull() {
            addCriterion("uAndactivityEnroll_id is null");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdIsNotNull() {
            addCriterion("uAndactivityEnroll_id is not null");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdEqualTo(String value) {
            addCriterion("uAndactivityEnroll_id =", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdNotEqualTo(String value) {
            addCriterion("uAndactivityEnroll_id <>", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdGreaterThan(String value) {
            addCriterion("uAndactivityEnroll_id >", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdGreaterThanOrEqualTo(String value) {
            addCriterion("uAndactivityEnroll_id >=", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdLessThan(String value) {
            addCriterion("uAndactivityEnroll_id <", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdLessThanOrEqualTo(String value) {
            addCriterion("uAndactivityEnroll_id <=", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdLike(String value) {
            addCriterion("uAndactivityEnroll_id like", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdNotLike(String value) {
            addCriterion("uAndactivityEnroll_id not like", value, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdIn(List<String> values) {
            addCriterion("uAndactivityEnroll_id in", values, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdNotIn(List<String> values) {
            addCriterion("uAndactivityEnroll_id not in", values, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdBetween(String value1, String value2) {
            addCriterion("uAndactivityEnroll_id between", value1, value2, "uandactivityenrollId");
            return (Criteria) this;
        }

        public Criteria andUandactivityenrollIdNotBetween(String value1, String value2) {
            addCriterion("uAndactivityEnroll_id not between", value1, value2, "uandactivityenrollId");
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