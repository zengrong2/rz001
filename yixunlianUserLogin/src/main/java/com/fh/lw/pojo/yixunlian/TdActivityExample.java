package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdActivityExample() {
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

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
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

        public Criteria andActivitysignStarttimeIsNull() {
            addCriterion("activitysign_starttime is null");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeIsNotNull() {
            addCriterion("activitysign_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeEqualTo(Date value) {
            addCriterion("activitysign_starttime =", value, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeNotEqualTo(Date value) {
            addCriterion("activitysign_starttime <>", value, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeGreaterThan(Date value) {
            addCriterion("activitysign_starttime >", value, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activitysign_starttime >=", value, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeLessThan(Date value) {
            addCriterion("activitysign_starttime <", value, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("activitysign_starttime <=", value, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeIn(List<Date> values) {
            addCriterion("activitysign_starttime in", values, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeNotIn(List<Date> values) {
            addCriterion("activitysign_starttime not in", values, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeBetween(Date value1, Date value2) {
            addCriterion("activitysign_starttime between", value1, value2, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("activitysign_starttime not between", value1, value2, "activitysignStarttime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeIsNull() {
            addCriterion("activitysign_endtime is null");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeIsNotNull() {
            addCriterion("activitysign_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeEqualTo(Date value) {
            addCriterion("activitysign_endtime =", value, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeNotEqualTo(Date value) {
            addCriterion("activitysign_endtime <>", value, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeGreaterThan(Date value) {
            addCriterion("activitysign_endtime >", value, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activitysign_endtime >=", value, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeLessThan(Date value) {
            addCriterion("activitysign_endtime <", value, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("activitysign_endtime <=", value, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeIn(List<Date> values) {
            addCriterion("activitysign_endtime in", values, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeNotIn(List<Date> values) {
            addCriterion("activitysign_endtime not in", values, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeBetween(Date value1, Date value2) {
            addCriterion("activitysign_endtime between", value1, value2, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitysignEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("activitysign_endtime not between", value1, value2, "activitysignEndtime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeIsNull() {
            addCriterion("activitystart_time is null");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeIsNotNull() {
            addCriterion("activitystart_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeEqualTo(Date value) {
            addCriterion("activitystart_time =", value, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeNotEqualTo(Date value) {
            addCriterion("activitystart_time <>", value, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeGreaterThan(Date value) {
            addCriterion("activitystart_time >", value, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activitystart_time >=", value, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeLessThan(Date value) {
            addCriterion("activitystart_time <", value, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeLessThanOrEqualTo(Date value) {
            addCriterion("activitystart_time <=", value, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeIn(List<Date> values) {
            addCriterion("activitystart_time in", values, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeNotIn(List<Date> values) {
            addCriterion("activitystart_time not in", values, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeBetween(Date value1, Date value2) {
            addCriterion("activitystart_time between", value1, value2, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivitystartTimeNotBetween(Date value1, Date value2) {
            addCriterion("activitystart_time not between", value1, value2, "activitystartTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeIsNull() {
            addCriterion("activityend_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeIsNotNull() {
            addCriterion("activityend_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeEqualTo(Date value) {
            addCriterion("activityend_time =", value, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeNotEqualTo(Date value) {
            addCriterion("activityend_time <>", value, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeGreaterThan(Date value) {
            addCriterion("activityend_time >", value, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activityend_time >=", value, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeLessThan(Date value) {
            addCriterion("activityend_time <", value, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeLessThanOrEqualTo(Date value) {
            addCriterion("activityend_time <=", value, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeIn(List<Date> values) {
            addCriterion("activityend_time in", values, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeNotIn(List<Date> values) {
            addCriterion("activityend_time not in", values, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeBetween(Date value1, Date value2) {
            addCriterion("activityend_time between", value1, value2, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityendTimeNotBetween(Date value1, Date value2) {
            addCriterion("activityend_time not between", value1, value2, "activityendTime");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsIsNull() {
            addCriterion("activity_countpersons is null");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsIsNotNull() {
            addCriterion("activity_countpersons is not null");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsEqualTo(Integer value) {
            addCriterion("activity_countpersons =", value, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsNotEqualTo(Integer value) {
            addCriterion("activity_countpersons <>", value, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsGreaterThan(Integer value) {
            addCriterion("activity_countpersons >", value, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_countpersons >=", value, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsLessThan(Integer value) {
            addCriterion("activity_countpersons <", value, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsLessThanOrEqualTo(Integer value) {
            addCriterion("activity_countpersons <=", value, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsIn(List<Integer> values) {
            addCriterion("activity_countpersons in", values, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsNotIn(List<Integer> values) {
            addCriterion("activity_countpersons not in", values, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsBetween(Integer value1, Integer value2) {
            addCriterion("activity_countpersons between", value1, value2, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityCountpersonsNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_countpersons not between", value1, value2, "activityCountpersons");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusIsNull() {
            addCriterion("\"activity_ chargestatus\" is null");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusIsNotNull() {
            addCriterion("\"activity_ chargestatus\" is not null");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusEqualTo(Integer value) {
            addCriterion("\"activity_ chargestatus\" =", value, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusNotEqualTo(Integer value) {
            addCriterion("\"activity_ chargestatus\" <>", value, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusGreaterThan(Integer value) {
            addCriterion("\"activity_ chargestatus\" >", value, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"activity_ chargestatus\" >=", value, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusLessThan(Integer value) {
            addCriterion("\"activity_ chargestatus\" <", value, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusLessThanOrEqualTo(Integer value) {
            addCriterion("\"activity_ chargestatus\" <=", value, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusIn(List<Integer> values) {
            addCriterion("\"activity_ chargestatus\" in", values, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusNotIn(List<Integer> values) {
            addCriterion("\"activity_ chargestatus\" not in", values, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusBetween(Integer value1, Integer value2) {
            addCriterion("\"activity_ chargestatus\" between", value1, value2, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("\"activity_ chargestatus\" not between", value1, value2, "activityChargestatus");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodIsNull() {
            addCriterion("activity_chargemethod is null");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodIsNotNull() {
            addCriterion("activity_chargemethod is not null");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodEqualTo(Integer value) {
            addCriterion("activity_chargemethod =", value, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodNotEqualTo(Integer value) {
            addCriterion("activity_chargemethod <>", value, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodGreaterThan(Integer value) {
            addCriterion("activity_chargemethod >", value, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_chargemethod >=", value, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodLessThan(Integer value) {
            addCriterion("activity_chargemethod <", value, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodLessThanOrEqualTo(Integer value) {
            addCriterion("activity_chargemethod <=", value, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodIn(List<Integer> values) {
            addCriterion("activity_chargemethod in", values, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodNotIn(List<Integer> values) {
            addCriterion("activity_chargemethod not in", values, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodBetween(Integer value1, Integer value2) {
            addCriterion("activity_chargemethod between", value1, value2, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityChargemethodNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_chargemethod not between", value1, value2, "activityChargemethod");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNull() {
            addCriterion("activity_type is null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNotNull() {
            addCriterion("activity_type is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeEqualTo(Integer value) {
            addCriterion("activity_type =", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotEqualTo(Integer value) {
            addCriterion("activity_type <>", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThan(Integer value) {
            addCriterion("activity_type >", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_type >=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThan(Integer value) {
            addCriterion("activity_type <", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("activity_type <=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIn(List<Integer> values) {
            addCriterion("activity_type in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotIn(List<Integer> values) {
            addCriterion("activity_type not in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeBetween(Integer value1, Integer value2) {
            addCriterion("activity_type between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_type not between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeIsNull() {
            addCriterion("province_citycode is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeIsNotNull() {
            addCriterion("province_citycode is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeEqualTo(String value) {
            addCriterion("province_citycode =", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeNotEqualTo(String value) {
            addCriterion("province_citycode <>", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeGreaterThan(String value) {
            addCriterion("province_citycode >", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_citycode >=", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeLessThan(String value) {
            addCriterion("province_citycode <", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeLessThanOrEqualTo(String value) {
            addCriterion("province_citycode <=", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeLike(String value) {
            addCriterion("province_citycode like", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeNotLike(String value) {
            addCriterion("province_citycode not like", value, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeIn(List<String> values) {
            addCriterion("province_citycode in", values, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeNotIn(List<String> values) {
            addCriterion("province_citycode not in", values, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeBetween(String value1, String value2) {
            addCriterion("province_citycode between", value1, value2, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andProvinceCitycodeNotBetween(String value1, String value2) {
            addCriterion("province_citycode not between", value1, value2, "provinceCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeIsNull() {
            addCriterion("city_citycode is null");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeIsNotNull() {
            addCriterion("city_citycode is not null");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeEqualTo(String value) {
            addCriterion("city_citycode =", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotEqualTo(String value) {
            addCriterion("city_citycode <>", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeGreaterThan(String value) {
            addCriterion("city_citycode >", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_citycode >=", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeLessThan(String value) {
            addCriterion("city_citycode <", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeLessThanOrEqualTo(String value) {
            addCriterion("city_citycode <=", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeLike(String value) {
            addCriterion("city_citycode like", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotLike(String value) {
            addCriterion("city_citycode not like", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeIn(List<String> values) {
            addCriterion("city_citycode in", values, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotIn(List<String> values) {
            addCriterion("city_citycode not in", values, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeBetween(String value1, String value2) {
            addCriterion("city_citycode between", value1, value2, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotBetween(String value1, String value2) {
            addCriterion("city_citycode not between", value1, value2, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeIsNull() {
            addCriterion("area_citycode is null");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeIsNotNull() {
            addCriterion("area_citycode is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeEqualTo(String value) {
            addCriterion("area_citycode =", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeNotEqualTo(String value) {
            addCriterion("area_citycode <>", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeGreaterThan(String value) {
            addCriterion("area_citycode >", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_citycode >=", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeLessThan(String value) {
            addCriterion("area_citycode <", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeLessThanOrEqualTo(String value) {
            addCriterion("area_citycode <=", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeLike(String value) {
            addCriterion("area_citycode like", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeNotLike(String value) {
            addCriterion("area_citycode not like", value, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeIn(List<String> values) {
            addCriterion("area_citycode in", values, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeNotIn(List<String> values) {
            addCriterion("area_citycode not in", values, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeBetween(String value1, String value2) {
            addCriterion("area_citycode between", value1, value2, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andAreaCitycodeNotBetween(String value1, String value2) {
            addCriterion("area_citycode not between", value1, value2, "areaCitycode");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlIsNull() {
            addCriterion("activity_coverImgurl is null");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlIsNotNull() {
            addCriterion("activity_coverImgurl is not null");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlEqualTo(String value) {
            addCriterion("activity_coverImgurl =", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlNotEqualTo(String value) {
            addCriterion("activity_coverImgurl <>", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlGreaterThan(String value) {
            addCriterion("activity_coverImgurl >", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("activity_coverImgurl >=", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlLessThan(String value) {
            addCriterion("activity_coverImgurl <", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlLessThanOrEqualTo(String value) {
            addCriterion("activity_coverImgurl <=", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlLike(String value) {
            addCriterion("activity_coverImgurl like", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlNotLike(String value) {
            addCriterion("activity_coverImgurl not like", value, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlIn(List<String> values) {
            addCriterion("activity_coverImgurl in", values, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlNotIn(List<String> values) {
            addCriterion("activity_coverImgurl not in", values, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlBetween(String value1, String value2) {
            addCriterion("activity_coverImgurl between", value1, value2, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityCoverimgurlNotBetween(String value1, String value2) {
            addCriterion("activity_coverImgurl not between", value1, value2, "activityCoverimgurl");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractIsNull() {
            addCriterion("activity_isextract is null");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractIsNotNull() {
            addCriterion("activity_isextract is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractEqualTo(Integer value) {
            addCriterion("activity_isextract =", value, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractNotEqualTo(Integer value) {
            addCriterion("activity_isextract <>", value, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractGreaterThan(Integer value) {
            addCriterion("activity_isextract >", value, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_isextract >=", value, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractLessThan(Integer value) {
            addCriterion("activity_isextract <", value, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractLessThanOrEqualTo(Integer value) {
            addCriterion("activity_isextract <=", value, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractIn(List<Integer> values) {
            addCriterion("activity_isextract in", values, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractNotIn(List<Integer> values) {
            addCriterion("activity_isextract not in", values, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractBetween(Integer value1, Integer value2) {
            addCriterion("activity_isextract between", value1, value2, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityIsextractNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_isextract not between", value1, value2, "activityIsextract");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlIsNull() {
            addCriterion("activity_detailsurl is null");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlIsNotNull() {
            addCriterion("activity_detailsurl is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlEqualTo(String value) {
            addCriterion("activity_detailsurl =", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlNotEqualTo(String value) {
            addCriterion("activity_detailsurl <>", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlGreaterThan(String value) {
            addCriterion("activity_detailsurl >", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlGreaterThanOrEqualTo(String value) {
            addCriterion("activity_detailsurl >=", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlLessThan(String value) {
            addCriterion("activity_detailsurl <", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlLessThanOrEqualTo(String value) {
            addCriterion("activity_detailsurl <=", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlLike(String value) {
            addCriterion("activity_detailsurl like", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlNotLike(String value) {
            addCriterion("activity_detailsurl not like", value, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlIn(List<String> values) {
            addCriterion("activity_detailsurl in", values, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlNotIn(List<String> values) {
            addCriterion("activity_detailsurl not in", values, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlBetween(String value1, String value2) {
            addCriterion("activity_detailsurl between", value1, value2, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivityDetailsurlNotBetween(String value1, String value2) {
            addCriterion("activity_detailsurl not between", value1, value2, "activityDetailsurl");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdIsNull() {
            addCriterion("activitymusic_id is null");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdIsNotNull() {
            addCriterion("activitymusic_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdEqualTo(String value) {
            addCriterion("activitymusic_id =", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdNotEqualTo(String value) {
            addCriterion("activitymusic_id <>", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdGreaterThan(String value) {
            addCriterion("activitymusic_id >", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdGreaterThanOrEqualTo(String value) {
            addCriterion("activitymusic_id >=", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdLessThan(String value) {
            addCriterion("activitymusic_id <", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdLessThanOrEqualTo(String value) {
            addCriterion("activitymusic_id <=", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdLike(String value) {
            addCriterion("activitymusic_id like", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdNotLike(String value) {
            addCriterion("activitymusic_id not like", value, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdIn(List<String> values) {
            addCriterion("activitymusic_id in", values, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdNotIn(List<String> values) {
            addCriterion("activitymusic_id not in", values, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdBetween(String value1, String value2) {
            addCriterion("activitymusic_id between", value1, value2, "activitymusicId");
            return (Criteria) this;
        }

        public Criteria andActivitymusicIdNotBetween(String value1, String value2) {
            addCriterion("activitymusic_id not between", value1, value2, "activitymusicId");
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

        public Criteria andOnlineStatusIsNull() {
            addCriterion("online_status is null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNotNull() {
            addCriterion("online_status is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusEqualTo(Integer value) {
            addCriterion("online_status =", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotEqualTo(Integer value) {
            addCriterion("online_status <>", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThan(Integer value) {
            addCriterion("online_status >", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("online_status >=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThan(Integer value) {
            addCriterion("online_status <", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThanOrEqualTo(Integer value) {
            addCriterion("online_status <=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIn(List<Integer> values) {
            addCriterion("online_status in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotIn(List<Integer> values) {
            addCriterion("online_status not in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusBetween(Integer value1, Integer value2) {
            addCriterion("online_status between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("online_status not between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusIsNull() {
            addCriterion("activity_signupstatus is null");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusIsNotNull() {
            addCriterion("activity_signupstatus is not null");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusEqualTo(Integer value) {
            addCriterion("activity_signupstatus =", value, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusNotEqualTo(Integer value) {
            addCriterion("activity_signupstatus <>", value, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusGreaterThan(Integer value) {
            addCriterion("activity_signupstatus >", value, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_signupstatus >=", value, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusLessThan(Integer value) {
            addCriterion("activity_signupstatus <", value, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusLessThanOrEqualTo(Integer value) {
            addCriterion("activity_signupstatus <=", value, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusIn(List<Integer> values) {
            addCriterion("activity_signupstatus in", values, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusNotIn(List<Integer> values) {
            addCriterion("activity_signupstatus not in", values, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusBetween(Integer value1, Integer value2) {
            addCriterion("activity_signupstatus between", value1, value2, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivitySignupstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_signupstatus not between", value1, value2, "activitySignupstatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNull() {
            addCriterion("activity_status is null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNotNull() {
            addCriterion("activity_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusEqualTo(Integer value) {
            addCriterion("activity_status =", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotEqualTo(Integer value) {
            addCriterion("activity_status <>", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThan(Integer value) {
            addCriterion("activity_status >", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_status >=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThan(Integer value) {
            addCriterion("activity_status <", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThanOrEqualTo(Integer value) {
            addCriterion("activity_status <=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIn(List<Integer> values) {
            addCriterion("activity_status in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotIn(List<Integer> values) {
            addCriterion("activity_status not in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusBetween(Integer value1, Integer value2) {
            addCriterion("activity_status between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_status not between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeIsNull() {
            addCriterion("activity_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeIsNotNull() {
            addCriterion("activity_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeEqualTo(String value) {
            addCriterion("activity_qrcode =", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeNotEqualTo(String value) {
            addCriterion("activity_qrcode <>", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeGreaterThan(String value) {
            addCriterion("activity_qrcode >", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("activity_qrcode >=", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeLessThan(String value) {
            addCriterion("activity_qrcode <", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeLessThanOrEqualTo(String value) {
            addCriterion("activity_qrcode <=", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeLike(String value) {
            addCriterion("activity_qrcode like", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeNotLike(String value) {
            addCriterion("activity_qrcode not like", value, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeIn(List<String> values) {
            addCriterion("activity_qrcode in", values, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeNotIn(List<String> values) {
            addCriterion("activity_qrcode not in", values, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeBetween(String value1, String value2) {
            addCriterion("activity_qrcode between", value1, value2, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andActivityQrcodeNotBetween(String value1, String value2) {
            addCriterion("activity_qrcode not between", value1, value2, "activityQrcode");
            return (Criteria) this;
        }

        public Criteria andShareAbstractIsNull() {
            addCriterion("share_abstract is null");
            return (Criteria) this;
        }

        public Criteria andShareAbstractIsNotNull() {
            addCriterion("share_abstract is not null");
            return (Criteria) this;
        }

        public Criteria andShareAbstractEqualTo(String value) {
            addCriterion("share_abstract =", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractNotEqualTo(String value) {
            addCriterion("share_abstract <>", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractGreaterThan(String value) {
            addCriterion("share_abstract >", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractGreaterThanOrEqualTo(String value) {
            addCriterion("share_abstract >=", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractLessThan(String value) {
            addCriterion("share_abstract <", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractLessThanOrEqualTo(String value) {
            addCriterion("share_abstract <=", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractLike(String value) {
            addCriterion("share_abstract like", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractNotLike(String value) {
            addCriterion("share_abstract not like", value, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractIn(List<String> values) {
            addCriterion("share_abstract in", values, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractNotIn(List<String> values) {
            addCriterion("share_abstract not in", values, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractBetween(String value1, String value2) {
            addCriterion("share_abstract between", value1, value2, "shareAbstract");
            return (Criteria) this;
        }

        public Criteria andShareAbstractNotBetween(String value1, String value2) {
            addCriterion("share_abstract not between", value1, value2, "shareAbstract");
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