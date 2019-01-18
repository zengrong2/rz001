package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdUtypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdUtypeExample() {
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

        public Criteria andUtypeIdIsNull() {
            addCriterion("utype_id is null");
            return (Criteria) this;
        }

        public Criteria andUtypeIdIsNotNull() {
            addCriterion("utype_id is not null");
            return (Criteria) this;
        }

        public Criteria andUtypeIdEqualTo(String value) {
            addCriterion("utype_id =", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotEqualTo(String value) {
            addCriterion("utype_id <>", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdGreaterThan(String value) {
            addCriterion("utype_id >", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("utype_id >=", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdLessThan(String value) {
            addCriterion("utype_id <", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdLessThanOrEqualTo(String value) {
            addCriterion("utype_id <=", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdLike(String value) {
            addCriterion("utype_id like", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotLike(String value) {
            addCriterion("utype_id not like", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdIn(List<String> values) {
            addCriterion("utype_id in", values, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotIn(List<String> values) {
            addCriterion("utype_id not in", values, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdBetween(String value1, String value2) {
            addCriterion("utype_id between", value1, value2, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotBetween(String value1, String value2) {
            addCriterion("utype_id not between", value1, value2, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserDayIsNull() {
            addCriterion("user_day is null");
            return (Criteria) this;
        }

        public Criteria andUserDayIsNotNull() {
            addCriterion("user_day is not null");
            return (Criteria) this;
        }

        public Criteria andUserDayEqualTo(String value) {
            addCriterion("user_day =", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayNotEqualTo(String value) {
            addCriterion("user_day <>", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayGreaterThan(String value) {
            addCriterion("user_day >", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayGreaterThanOrEqualTo(String value) {
            addCriterion("user_day >=", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayLessThan(String value) {
            addCriterion("user_day <", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayLessThanOrEqualTo(String value) {
            addCriterion("user_day <=", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayLike(String value) {
            addCriterion("user_day like", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayNotLike(String value) {
            addCriterion("user_day not like", value, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayIn(List<String> values) {
            addCriterion("user_day in", values, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayNotIn(List<String> values) {
            addCriterion("user_day not in", values, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayBetween(String value1, String value2) {
            addCriterion("user_day between", value1, value2, "userDay");
            return (Criteria) this;
        }

        public Criteria andUserDayNotBetween(String value1, String value2) {
            addCriterion("user_day not between", value1, value2, "userDay");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeIsNull() {
            addCriterion("utype_charge is null");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeIsNotNull() {
            addCriterion("utype_charge is not null");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeEqualTo(Integer value) {
            addCriterion("utype_charge =", value, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeNotEqualTo(Integer value) {
            addCriterion("utype_charge <>", value, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeGreaterThan(Integer value) {
            addCriterion("utype_charge >", value, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("utype_charge >=", value, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeLessThan(Integer value) {
            addCriterion("utype_charge <", value, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeLessThanOrEqualTo(Integer value) {
            addCriterion("utype_charge <=", value, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeIn(List<Integer> values) {
            addCriterion("utype_charge in", values, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeNotIn(List<Integer> values) {
            addCriterion("utype_charge not in", values, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeBetween(Integer value1, Integer value2) {
            addCriterion("utype_charge between", value1, value2, "utypeCharge");
            return (Criteria) this;
        }

        public Criteria andUtypeChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("utype_charge not between", value1, value2, "utypeCharge");
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