package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdUserprofitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdUserprofitExample() {
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

        public Criteria andProfitIdIsNull() {
            addCriterion("profit_id is null");
            return (Criteria) this;
        }

        public Criteria andProfitIdIsNotNull() {
            addCriterion("profit_id is not null");
            return (Criteria) this;
        }

        public Criteria andProfitIdEqualTo(String value) {
            addCriterion("profit_id =", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdNotEqualTo(String value) {
            addCriterion("profit_id <>", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdGreaterThan(String value) {
            addCriterion("profit_id >", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdGreaterThanOrEqualTo(String value) {
            addCriterion("profit_id >=", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdLessThan(String value) {
            addCriterion("profit_id <", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdLessThanOrEqualTo(String value) {
            addCriterion("profit_id <=", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdLike(String value) {
            addCriterion("profit_id like", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdNotLike(String value) {
            addCriterion("profit_id not like", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdIn(List<String> values) {
            addCriterion("profit_id in", values, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdNotIn(List<String> values) {
            addCriterion("profit_id not in", values, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdBetween(String value1, String value2) {
            addCriterion("profit_id between", value1, value2, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdNotBetween(String value1, String value2) {
            addCriterion("profit_id not between", value1, value2, "profitId");
            return (Criteria) this;
        }

        public Criteria andAcMoneyIsNull() {
            addCriterion("ac_money is null");
            return (Criteria) this;
        }

        public Criteria andAcMoneyIsNotNull() {
            addCriterion("ac_money is not null");
            return (Criteria) this;
        }

        public Criteria andAcMoneyEqualTo(Integer value) {
            addCriterion("ac_money =", value, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyNotEqualTo(Integer value) {
            addCriterion("ac_money <>", value, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyGreaterThan(Integer value) {
            addCriterion("ac_money >", value, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ac_money >=", value, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyLessThan(Integer value) {
            addCriterion("ac_money <", value, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("ac_money <=", value, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyIn(List<Integer> values) {
            addCriterion("ac_money in", values, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyNotIn(List<Integer> values) {
            addCriterion("ac_money not in", values, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyBetween(Integer value1, Integer value2) {
            addCriterion("ac_money between", value1, value2, "acMoney");
            return (Criteria) this;
        }

        public Criteria andAcMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("ac_money not between", value1, value2, "acMoney");
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

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
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

        public Criteria andRecordingtimeEndIsNull() {
            addCriterion("recordingtime_end is null");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndIsNotNull() {
            addCriterion("recordingtime_end is not null");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndEqualTo(Date value) {
            addCriterion("recordingtime_end =", value, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndNotEqualTo(Date value) {
            addCriterion("recordingtime_end <>", value, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndGreaterThan(Date value) {
            addCriterion("recordingtime_end >", value, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("recordingtime_end >=", value, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndLessThan(Date value) {
            addCriterion("recordingtime_end <", value, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndLessThanOrEqualTo(Date value) {
            addCriterion("recordingtime_end <=", value, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndIn(List<Date> values) {
            addCriterion("recordingtime_end in", values, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndNotIn(List<Date> values) {
            addCriterion("recordingtime_end not in", values, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndBetween(Date value1, Date value2) {
            addCriterion("recordingtime_end between", value1, value2, "recordingtimeEnd");
            return (Criteria) this;
        }

        public Criteria andRecordingtimeEndNotBetween(Date value1, Date value2) {
            addCriterion("recordingtime_end not between", value1, value2, "recordingtimeEnd");
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