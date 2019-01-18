package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdActivitysignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdActivitysignExample() {
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

        public Criteria andActivitySignidIsNull() {
            addCriterion("activity_signid is null");
            return (Criteria) this;
        }

        public Criteria andActivitySignidIsNotNull() {
            addCriterion("activity_signid is not null");
            return (Criteria) this;
        }

        public Criteria andActivitySignidEqualTo(String value) {
            addCriterion("activity_signid =", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidNotEqualTo(String value) {
            addCriterion("activity_signid <>", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidGreaterThan(String value) {
            addCriterion("activity_signid >", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidGreaterThanOrEqualTo(String value) {
            addCriterion("activity_signid >=", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidLessThan(String value) {
            addCriterion("activity_signid <", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidLessThanOrEqualTo(String value) {
            addCriterion("activity_signid <=", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidLike(String value) {
            addCriterion("activity_signid like", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidNotLike(String value) {
            addCriterion("activity_signid not like", value, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidIn(List<String> values) {
            addCriterion("activity_signid in", values, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidNotIn(List<String> values) {
            addCriterion("activity_signid not in", values, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidBetween(String value1, String value2) {
            addCriterion("activity_signid between", value1, value2, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignidNotBetween(String value1, String value2) {
            addCriterion("activity_signid not between", value1, value2, "activitySignid");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameIsNull() {
            addCriterion("activity_signname is null");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameIsNotNull() {
            addCriterion("activity_signname is not null");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameEqualTo(String value) {
            addCriterion("activity_signname =", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameNotEqualTo(String value) {
            addCriterion("activity_signname <>", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameGreaterThan(String value) {
            addCriterion("activity_signname >", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_signname >=", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameLessThan(String value) {
            addCriterion("activity_signname <", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameLessThanOrEqualTo(String value) {
            addCriterion("activity_signname <=", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameLike(String value) {
            addCriterion("activity_signname like", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameNotLike(String value) {
            addCriterion("activity_signname not like", value, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameIn(List<String> values) {
            addCriterion("activity_signname in", values, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameNotIn(List<String> values) {
            addCriterion("activity_signname not in", values, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameBetween(String value1, String value2) {
            addCriterion("activity_signname between", value1, value2, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignnameNotBetween(String value1, String value2) {
            addCriterion("activity_signname not between", value1, value2, "activitySignname");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexIsNull() {
            addCriterion("activity_signsex is null");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexIsNotNull() {
            addCriterion("activity_signsex is not null");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexEqualTo(String value) {
            addCriterion("activity_signsex =", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexNotEqualTo(String value) {
            addCriterion("activity_signsex <>", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexGreaterThan(String value) {
            addCriterion("activity_signsex >", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexGreaterThanOrEqualTo(String value) {
            addCriterion("activity_signsex >=", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexLessThan(String value) {
            addCriterion("activity_signsex <", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexLessThanOrEqualTo(String value) {
            addCriterion("activity_signsex <=", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexLike(String value) {
            addCriterion("activity_signsex like", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexNotLike(String value) {
            addCriterion("activity_signsex not like", value, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexIn(List<String> values) {
            addCriterion("activity_signsex in", values, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexNotIn(List<String> values) {
            addCriterion("activity_signsex not in", values, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexBetween(String value1, String value2) {
            addCriterion("activity_signsex between", value1, value2, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignsexNotBetween(String value1, String value2) {
            addCriterion("activity_signsex not between", value1, value2, "activitySignsex");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneIsNull() {
            addCriterion("activity_signphone is null");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneIsNotNull() {
            addCriterion("activity_signphone is not null");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneEqualTo(String value) {
            addCriterion("activity_signphone =", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneNotEqualTo(String value) {
            addCriterion("activity_signphone <>", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneGreaterThan(String value) {
            addCriterion("activity_signphone >", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneGreaterThanOrEqualTo(String value) {
            addCriterion("activity_signphone >=", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneLessThan(String value) {
            addCriterion("activity_signphone <", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneLessThanOrEqualTo(String value) {
            addCriterion("activity_signphone <=", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneLike(String value) {
            addCriterion("activity_signphone like", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneNotLike(String value) {
            addCriterion("activity_signphone not like", value, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneIn(List<String> values) {
            addCriterion("activity_signphone in", values, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneNotIn(List<String> values) {
            addCriterion("activity_signphone not in", values, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneBetween(String value1, String value2) {
            addCriterion("activity_signphone between", value1, value2, "activitySignphone");
            return (Criteria) this;
        }

        public Criteria andActivitySignphoneNotBetween(String value1, String value2) {
            addCriterion("activity_signphone not between", value1, value2, "activitySignphone");
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