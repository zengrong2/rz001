package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdBackgroundTransferRecordoutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdBackgroundTransferRecordoutExample() {
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

        public Criteria andBackgroundTransferRecordIdIsNull() {
            addCriterion("background_transfer_record_id is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdIsNotNull() {
            addCriterion("background_transfer_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdEqualTo(String value) {
            addCriterion("background_transfer_record_id =", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdNotEqualTo(String value) {
            addCriterion("background_transfer_record_id <>", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdGreaterThan(String value) {
            addCriterion("background_transfer_record_id >", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("background_transfer_record_id >=", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdLessThan(String value) {
            addCriterion("background_transfer_record_id <", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdLessThanOrEqualTo(String value) {
            addCriterion("background_transfer_record_id <=", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdLike(String value) {
            addCriterion("background_transfer_record_id like", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdNotLike(String value) {
            addCriterion("background_transfer_record_id not like", value, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdIn(List<String> values) {
            addCriterion("background_transfer_record_id in", values, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdNotIn(List<String> values) {
            addCriterion("background_transfer_record_id not in", values, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdBetween(String value1, String value2) {
            addCriterion("background_transfer_record_id between", value1, value2, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferRecordIdNotBetween(String value1, String value2) {
            addCriterion("background_transfer_record_id not between", value1, value2, "backgroundTransferRecordId");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyIsNull() {
            addCriterion("background_transfer_money is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyIsNotNull() {
            addCriterion("background_transfer_money is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyEqualTo(Long value) {
            addCriterion("background_transfer_money =", value, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyNotEqualTo(Long value) {
            addCriterion("background_transfer_money <>", value, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyGreaterThan(Long value) {
            addCriterion("background_transfer_money >", value, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("background_transfer_money >=", value, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyLessThan(Long value) {
            addCriterion("background_transfer_money <", value, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyLessThanOrEqualTo(Long value) {
            addCriterion("background_transfer_money <=", value, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyIn(List<Long> values) {
            addCriterion("background_transfer_money in", values, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyNotIn(List<Long> values) {
            addCriterion("background_transfer_money not in", values, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyBetween(Long value1, Long value2) {
            addCriterion("background_transfer_money between", value1, value2, "backgroundTransferMoney");
            return (Criteria) this;
        }

        public Criteria andBackgroundTransferMoneyNotBetween(Long value1, Long value2) {
            addCriterion("background_transfer_money not between", value1, value2, "backgroundTransferMoney");
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