package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdSystembulletinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdSystembulletinExample() {
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

        public Criteria andSystembulletinIdIsNull() {
            addCriterion("systembulletin_id is null");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdIsNotNull() {
            addCriterion("systembulletin_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdEqualTo(String value) {
            addCriterion("systembulletin_id =", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdNotEqualTo(String value) {
            addCriterion("systembulletin_id <>", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdGreaterThan(String value) {
            addCriterion("systembulletin_id >", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdGreaterThanOrEqualTo(String value) {
            addCriterion("systembulletin_id >=", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdLessThan(String value) {
            addCriterion("systembulletin_id <", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdLessThanOrEqualTo(String value) {
            addCriterion("systembulletin_id <=", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdLike(String value) {
            addCriterion("systembulletin_id like", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdNotLike(String value) {
            addCriterion("systembulletin_id not like", value, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdIn(List<String> values) {
            addCriterion("systembulletin_id in", values, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdNotIn(List<String> values) {
            addCriterion("systembulletin_id not in", values, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdBetween(String value1, String value2) {
            addCriterion("systembulletin_id between", value1, value2, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinIdNotBetween(String value1, String value2) {
            addCriterion("systembulletin_id not between", value1, value2, "systembulletinId");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlIsNull() {
            addCriterion("systembulletin_url is null");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlIsNotNull() {
            addCriterion("systembulletin_url is not null");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlEqualTo(String value) {
            addCriterion("systembulletin_url =", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlNotEqualTo(String value) {
            addCriterion("systembulletin_url <>", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlGreaterThan(String value) {
            addCriterion("systembulletin_url >", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlGreaterThanOrEqualTo(String value) {
            addCriterion("systembulletin_url >=", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlLessThan(String value) {
            addCriterion("systembulletin_url <", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlLessThanOrEqualTo(String value) {
            addCriterion("systembulletin_url <=", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlLike(String value) {
            addCriterion("systembulletin_url like", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlNotLike(String value) {
            addCriterion("systembulletin_url not like", value, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlIn(List<String> values) {
            addCriterion("systembulletin_url in", values, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlNotIn(List<String> values) {
            addCriterion("systembulletin_url not in", values, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlBetween(String value1, String value2) {
            addCriterion("systembulletin_url between", value1, value2, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystembulletinUrlNotBetween(String value1, String value2) {
            addCriterion("systembulletin_url not between", value1, value2, "systembulletinUrl");
            return (Criteria) this;
        }

        public Criteria andSystemStatusIsNull() {
            addCriterion("system_status is null");
            return (Criteria) this;
        }

        public Criteria andSystemStatusIsNotNull() {
            addCriterion("system_status is not null");
            return (Criteria) this;
        }

        public Criteria andSystemStatusEqualTo(Integer value) {
            addCriterion("system_status =", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusNotEqualTo(Integer value) {
            addCriterion("system_status <>", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusGreaterThan(Integer value) {
            addCriterion("system_status >", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("system_status >=", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusLessThan(Integer value) {
            addCriterion("system_status <", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusLessThanOrEqualTo(Integer value) {
            addCriterion("system_status <=", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusIn(List<Integer> values) {
            addCriterion("system_status in", values, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusNotIn(List<Integer> values) {
            addCriterion("system_status not in", values, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusBetween(Integer value1, Integer value2) {
            addCriterion("system_status between", value1, value2, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("system_status not between", value1, value2, "systemStatus");
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