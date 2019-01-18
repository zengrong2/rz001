package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdActivitycategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdActivitycategoryExample() {
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

        public Criteria andActivitycategoryIdIsNull() {
            addCriterion("activitycategory_id is null");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdIsNotNull() {
            addCriterion("activitycategory_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdEqualTo(String value) {
            addCriterion("activitycategory_id =", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdNotEqualTo(String value) {
            addCriterion("activitycategory_id <>", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdGreaterThan(String value) {
            addCriterion("activitycategory_id >", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("activitycategory_id >=", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdLessThan(String value) {
            addCriterion("activitycategory_id <", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdLessThanOrEqualTo(String value) {
            addCriterion("activitycategory_id <=", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdLike(String value) {
            addCriterion("activitycategory_id like", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdNotLike(String value) {
            addCriterion("activitycategory_id not like", value, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdIn(List<String> values) {
            addCriterion("activitycategory_id in", values, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdNotIn(List<String> values) {
            addCriterion("activitycategory_id not in", values, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdBetween(String value1, String value2) {
            addCriterion("activitycategory_id between", value1, value2, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryIdNotBetween(String value1, String value2) {
            addCriterion("activitycategory_id not between", value1, value2, "activitycategoryId");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameIsNull() {
            addCriterion("activitycategory_name is null");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameIsNotNull() {
            addCriterion("activitycategory_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameEqualTo(String value) {
            addCriterion("activitycategory_name =", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameNotEqualTo(String value) {
            addCriterion("activitycategory_name <>", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameGreaterThan(String value) {
            addCriterion("activitycategory_name >", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("activitycategory_name >=", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameLessThan(String value) {
            addCriterion("activitycategory_name <", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameLessThanOrEqualTo(String value) {
            addCriterion("activitycategory_name <=", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameLike(String value) {
            addCriterion("activitycategory_name like", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameNotLike(String value) {
            addCriterion("activitycategory_name not like", value, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameIn(List<String> values) {
            addCriterion("activitycategory_name in", values, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameNotIn(List<String> values) {
            addCriterion("activitycategory_name not in", values, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameBetween(String value1, String value2) {
            addCriterion("activitycategory_name between", value1, value2, "activitycategoryName");
            return (Criteria) this;
        }

        public Criteria andActivitycategoryNameNotBetween(String value1, String value2) {
            addCriterion("activitycategory_name not between", value1, value2, "activitycategoryName");
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

        public Criteria andReadingsurveyIdIsNull() {
            addCriterion("readingsurvey_id is null");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdIsNotNull() {
            addCriterion("readingsurvey_id is not null");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdEqualTo(String value) {
            addCriterion("readingsurvey_id =", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotEqualTo(String value) {
            addCriterion("readingsurvey_id <>", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdGreaterThan(String value) {
            addCriterion("readingsurvey_id >", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdGreaterThanOrEqualTo(String value) {
            addCriterion("readingsurvey_id >=", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdLessThan(String value) {
            addCriterion("readingsurvey_id <", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdLessThanOrEqualTo(String value) {
            addCriterion("readingsurvey_id <=", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdLike(String value) {
            addCriterion("readingsurvey_id like", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotLike(String value) {
            addCriterion("readingsurvey_id not like", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdIn(List<String> values) {
            addCriterion("readingsurvey_id in", values, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotIn(List<String> values) {
            addCriterion("readingsurvey_id not in", values, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdBetween(String value1, String value2) {
            addCriterion("readingsurvey_id between", value1, value2, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotBetween(String value1, String value2) {
            addCriterion("readingsurvey_id not between", value1, value2, "readingsurveyId");
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