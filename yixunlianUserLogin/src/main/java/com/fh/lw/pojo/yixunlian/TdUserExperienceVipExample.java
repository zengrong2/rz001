package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TdUserExperienceVipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdUserExperienceVipExample() {
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

        public Criteria andExperienceVipIdIsNull() {
            addCriterion("experience_vip_id is null");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdIsNotNull() {
            addCriterion("experience_vip_id is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdEqualTo(String value) {
            addCriterion("experience_vip_id =", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdNotEqualTo(String value) {
            addCriterion("experience_vip_id <>", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdGreaterThan(String value) {
            addCriterion("experience_vip_id >", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdGreaterThanOrEqualTo(String value) {
            addCriterion("experience_vip_id >=", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdLessThan(String value) {
            addCriterion("experience_vip_id <", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdLessThanOrEqualTo(String value) {
            addCriterion("experience_vip_id <=", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdLike(String value) {
            addCriterion("experience_vip_id like", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdNotLike(String value) {
            addCriterion("experience_vip_id not like", value, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdIn(List<String> values) {
            addCriterion("experience_vip_id in", values, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdNotIn(List<String> values) {
            addCriterion("experience_vip_id not in", values, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdBetween(String value1, String value2) {
            addCriterion("experience_vip_id between", value1, value2, "experienceVipId");
            return (Criteria) this;
        }

        public Criteria andExperienceVipIdNotBetween(String value1, String value2) {
            addCriterion("experience_vip_id not between", value1, value2, "experienceVipId");
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

        public Criteria andExperienceVipStarttimeIsNull() {
            addCriterion("experience_vip_starttime is null");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeIsNotNull() {
            addCriterion("experience_vip_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("experience_vip_starttime =", value, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("experience_vip_starttime <>", value, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("experience_vip_starttime >", value, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("experience_vip_starttime >=", value, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("experience_vip_starttime <", value, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("experience_vip_starttime <=", value, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("experience_vip_starttime in", values, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("experience_vip_starttime not in", values, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("experience_vip_starttime between", value1, value2, "experienceVipStarttime");
            return (Criteria) this;
        }

        public Criteria andExperienceVipStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("experience_vip_starttime not between", value1, value2, "experienceVipStarttime");
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