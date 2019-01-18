package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TdTryUsemanagervipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdTryUsemanagervipExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTryUsevipIdIsNull() {
            addCriterion("try_useVip_id is null");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdIsNotNull() {
            addCriterion("try_useVip_id is not null");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdEqualTo(String value) {
            addCriterion("try_useVip_id =", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdNotEqualTo(String value) {
            addCriterion("try_useVip_id <>", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdGreaterThan(String value) {
            addCriterion("try_useVip_id >", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdGreaterThanOrEqualTo(String value) {
            addCriterion("try_useVip_id >=", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdLessThan(String value) {
            addCriterion("try_useVip_id <", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdLessThanOrEqualTo(String value) {
            addCriterion("try_useVip_id <=", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdLike(String value) {
            addCriterion("try_useVip_id like", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdNotLike(String value) {
            addCriterion("try_useVip_id not like", value, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdIn(List<String> values) {
            addCriterion("try_useVip_id in", values, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdNotIn(List<String> values) {
            addCriterion("try_useVip_id not in", values, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdBetween(String value1, String value2) {
            addCriterion("try_useVip_id between", value1, value2, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipIdNotBetween(String value1, String value2) {
            addCriterion("try_useVip_id not between", value1, value2, "tryUsevipId");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysIsNull() {
            addCriterion("try_useVip_days is null");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysIsNotNull() {
            addCriterion("try_useVip_days is not null");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysEqualTo(Integer value) {
            addCriterion("try_useVip_days =", value, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysNotEqualTo(Integer value) {
            addCriterion("try_useVip_days <>", value, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysGreaterThan(Integer value) {
            addCriterion("try_useVip_days >", value, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("try_useVip_days >=", value, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysLessThan(Integer value) {
            addCriterion("try_useVip_days <", value, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysLessThanOrEqualTo(Integer value) {
            addCriterion("try_useVip_days <=", value, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysIn(List<Integer> values) {
            addCriterion("try_useVip_days in", values, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysNotIn(List<Integer> values) {
            addCriterion("try_useVip_days not in", values, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysBetween(Integer value1, Integer value2) {
            addCriterion("try_useVip_days between", value1, value2, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("try_useVip_days not between", value1, value2, "tryUsevipDays");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayIsNull() {
            addCriterion("try_useVip_startDay is null");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayIsNotNull() {
            addCriterion("try_useVip_startDay is not null");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayEqualTo(Date value) {
            addCriterionForJDBCDate("try_useVip_startDay =", value, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("try_useVip_startDay <>", value, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayGreaterThan(Date value) {
            addCriterionForJDBCDate("try_useVip_startDay >", value, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("try_useVip_startDay >=", value, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayLessThan(Date value) {
            addCriterionForJDBCDate("try_useVip_startDay <", value, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("try_useVip_startDay <=", value, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayIn(List<Date> values) {
            addCriterionForJDBCDate("try_useVip_startDay in", values, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("try_useVip_startDay not in", values, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("try_useVip_startDay between", value1, value2, "tryUsevipStartday");
            return (Criteria) this;
        }

        public Criteria andTryUsevipStartdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("try_useVip_startDay not between", value1, value2, "tryUsevipStartday");
            return (Criteria) this;
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