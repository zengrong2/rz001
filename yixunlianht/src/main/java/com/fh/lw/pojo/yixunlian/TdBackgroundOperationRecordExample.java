package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdBackgroundOperationRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdBackgroundOperationRecordExample() {
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

        public Criteria andBackgroundOperationRecordIdIsNull() {
            addCriterion("background_operation_record_id is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdIsNotNull() {
            addCriterion("background_operation_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdEqualTo(String value) {
            addCriterion("background_operation_record_id =", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdNotEqualTo(String value) {
            addCriterion("background_operation_record_id <>", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdGreaterThan(String value) {
            addCriterion("background_operation_record_id >", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("background_operation_record_id >=", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdLessThan(String value) {
            addCriterion("background_operation_record_id <", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdLessThanOrEqualTo(String value) {
            addCriterion("background_operation_record_id <=", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdLike(String value) {
            addCriterion("background_operation_record_id like", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdNotLike(String value) {
            addCriterion("background_operation_record_id not like", value, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdIn(List<String> values) {
            addCriterion("background_operation_record_id in", values, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdNotIn(List<String> values) {
            addCriterion("background_operation_record_id not in", values, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdBetween(String value1, String value2) {
            addCriterion("background_operation_record_id between", value1, value2, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordIdNotBetween(String value1, String value2) {
            addCriterion("background_operation_record_id not between", value1, value2, "backgroundOperationRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameIsNull() {
            addCriterion("background_operation_record_name is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameIsNotNull() {
            addCriterion("background_operation_record_name is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameEqualTo(String value) {
            addCriterion("background_operation_record_name =", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameNotEqualTo(String value) {
            addCriterion("background_operation_record_name <>", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameGreaterThan(String value) {
            addCriterion("background_operation_record_name >", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameGreaterThanOrEqualTo(String value) {
            addCriterion("background_operation_record_name >=", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameLessThan(String value) {
            addCriterion("background_operation_record_name <", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameLessThanOrEqualTo(String value) {
            addCriterion("background_operation_record_name <=", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameLike(String value) {
            addCriterion("background_operation_record_name like", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameNotLike(String value) {
            addCriterion("background_operation_record_name not like", value, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameIn(List<String> values) {
            addCriterion("background_operation_record_name in", values, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameNotIn(List<String> values) {
            addCriterion("background_operation_record_name not in", values, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameBetween(String value1, String value2) {
            addCriterion("background_operation_record_name between", value1, value2, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andBackgroundOperationRecordNameNotBetween(String value1, String value2) {
            addCriterion("background_operation_record_name not between", value1, value2, "backgroundOperationRecordName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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