package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.List;

public class TdBrowseRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdBrowseRecordsExample() {
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

        public Criteria andBrowseRecordsIdIsNull() {
            addCriterion("browse_records_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdIsNotNull() {
            addCriterion("browse_records_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdEqualTo(String value) {
            addCriterion("browse_records_id =", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdNotEqualTo(String value) {
            addCriterion("browse_records_id <>", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdGreaterThan(String value) {
            addCriterion("browse_records_id >", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdGreaterThanOrEqualTo(String value) {
            addCriterion("browse_records_id >=", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdLessThan(String value) {
            addCriterion("browse_records_id <", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdLessThanOrEqualTo(String value) {
            addCriterion("browse_records_id <=", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdLike(String value) {
            addCriterion("browse_records_id like", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdNotLike(String value) {
            addCriterion("browse_records_id not like", value, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdIn(List<String> values) {
            addCriterion("browse_records_id in", values, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdNotIn(List<String> values) {
            addCriterion("browse_records_id not in", values, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdBetween(String value1, String value2) {
            addCriterion("browse_records_id between", value1, value2, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsIdNotBetween(String value1, String value2) {
            addCriterion("browse_records_id not between", value1, value2, "browseRecordsId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdIsNull() {
            addCriterion("journalism_id is null");
            return (Criteria) this;
        }

        public Criteria andJournalismIdIsNotNull() {
            addCriterion("journalism_id is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismIdEqualTo(String value) {
            addCriterion("journalism_id =", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotEqualTo(String value) {
            addCriterion("journalism_id <>", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdGreaterThan(String value) {
            addCriterion("journalism_id >", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdGreaterThanOrEqualTo(String value) {
            addCriterion("journalism_id >=", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdLessThan(String value) {
            addCriterion("journalism_id <", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdLessThanOrEqualTo(String value) {
            addCriterion("journalism_id <=", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdLike(String value) {
            addCriterion("journalism_id like", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotLike(String value) {
            addCriterion("journalism_id not like", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdIn(List<String> values) {
            addCriterion("journalism_id in", values, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotIn(List<String> values) {
            addCriterion("journalism_id not in", values, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdBetween(String value1, String value2) {
            addCriterion("journalism_id between", value1, value2, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotBetween(String value1, String value2) {
            addCriterion("journalism_id not between", value1, value2, "journalismId");
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

        public Criteria andBrowseRecordsStatusIsNull() {
            addCriterion("browse_records_status is null");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusIsNotNull() {
            addCriterion("browse_records_status is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusEqualTo(Integer value) {
            addCriterion("browse_records_status =", value, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusNotEqualTo(Integer value) {
            addCriterion("browse_records_status <>", value, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusGreaterThan(Integer value) {
            addCriterion("browse_records_status >", value, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_records_status >=", value, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusLessThan(Integer value) {
            addCriterion("browse_records_status <", value, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("browse_records_status <=", value, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusIn(List<Integer> values) {
            addCriterion("browse_records_status in", values, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusNotIn(List<Integer> values) {
            addCriterion("browse_records_status not in", values, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusBetween(Integer value1, Integer value2) {
            addCriterion("browse_records_status between", value1, value2, "browseRecordsStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseRecordsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_records_status not between", value1, value2, "browseRecordsStatus");
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