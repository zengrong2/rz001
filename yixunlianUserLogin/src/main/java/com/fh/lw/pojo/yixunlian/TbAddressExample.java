package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAddressExample() {
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

        public Criteria andCitycodeIsNull() {
            addCriterion("citycode is null");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNotNull() {
            addCriterion("citycode is not null");
            return (Criteria) this;
        }

        public Criteria andCitycodeEqualTo(String value) {
            addCriterion("citycode =", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotEqualTo(String value) {
            addCriterion("citycode <>", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThan(String value) {
            addCriterion("citycode >", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("citycode >=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThan(String value) {
            addCriterion("citycode <", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThanOrEqualTo(String value) {
            addCriterion("citycode <=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLike(String value) {
            addCriterion("citycode like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotLike(String value) {
            addCriterion("citycode not like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeIn(List<String> values) {
            addCriterion("citycode in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotIn(List<String> values) {
            addCriterion("citycode not in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeBetween(String value1, String value2) {
            addCriterion("citycode between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotBetween(String value1, String value2) {
            addCriterion("citycode not between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("cityname is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("cityname is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("cityname =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("cityname <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("cityname >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("cityname >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("cityname <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("cityname <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("cityname like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("cityname not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("cityname in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("cityname not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("cityname between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("cityname not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andPidcodeIsNull() {
            addCriterion("pidcode is null");
            return (Criteria) this;
        }

        public Criteria andPidcodeIsNotNull() {
            addCriterion("pidcode is not null");
            return (Criteria) this;
        }

        public Criteria andPidcodeEqualTo(String value) {
            addCriterion("pidcode =", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeNotEqualTo(String value) {
            addCriterion("pidcode <>", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeGreaterThan(String value) {
            addCriterion("pidcode >", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeGreaterThanOrEqualTo(String value) {
            addCriterion("pidcode >=", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeLessThan(String value) {
            addCriterion("pidcode <", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeLessThanOrEqualTo(String value) {
            addCriterion("pidcode <=", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeLike(String value) {
            addCriterion("pidcode like", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeNotLike(String value) {
            addCriterion("pidcode not like", value, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeIn(List<String> values) {
            addCriterion("pidcode in", values, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeNotIn(List<String> values) {
            addCriterion("pidcode not in", values, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeBetween(String value1, String value2) {
            addCriterion("pidcode between", value1, value2, "pidcode");
            return (Criteria) this;
        }

        public Criteria andPidcodeNotBetween(String value1, String value2) {
            addCriterion("pidcode not between", value1, value2, "pidcode");
            return (Criteria) this;
        }

        public Criteria andSimplenameIsNull() {
            addCriterion("simplename is null");
            return (Criteria) this;
        }

        public Criteria andSimplenameIsNotNull() {
            addCriterion("simplename is not null");
            return (Criteria) this;
        }

        public Criteria andSimplenameEqualTo(String value) {
            addCriterion("simplename =", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotEqualTo(String value) {
            addCriterion("simplename <>", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameGreaterThan(String value) {
            addCriterion("simplename >", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameGreaterThanOrEqualTo(String value) {
            addCriterion("simplename >=", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameLessThan(String value) {
            addCriterion("simplename <", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameLessThanOrEqualTo(String value) {
            addCriterion("simplename <=", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameLike(String value) {
            addCriterion("simplename like", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotLike(String value) {
            addCriterion("simplename not like", value, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameIn(List<String> values) {
            addCriterion("simplename in", values, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotIn(List<String> values) {
            addCriterion("simplename not in", values, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameBetween(String value1, String value2) {
            addCriterion("simplename between", value1, value2, "simplename");
            return (Criteria) this;
        }

        public Criteria andSimplenameNotBetween(String value1, String value2) {
            addCriterion("simplename not between", value1, value2, "simplename");
            return (Criteria) this;
        }

        public Criteria andCitylevelIsNull() {
            addCriterion("citylevel is null");
            return (Criteria) this;
        }

        public Criteria andCitylevelIsNotNull() {
            addCriterion("citylevel is not null");
            return (Criteria) this;
        }

        public Criteria andCitylevelEqualTo(Integer value) {
            addCriterion("citylevel =", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelNotEqualTo(Integer value) {
            addCriterion("citylevel <>", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelGreaterThan(Integer value) {
            addCriterion("citylevel >", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("citylevel >=", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelLessThan(Integer value) {
            addCriterion("citylevel <", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelLessThanOrEqualTo(Integer value) {
            addCriterion("citylevel <=", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelIn(List<Integer> values) {
            addCriterion("citylevel in", values, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelNotIn(List<Integer> values) {
            addCriterion("citylevel not in", values, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelBetween(Integer value1, Integer value2) {
            addCriterion("citylevel between", value1, value2, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelNotBetween(Integer value1, Integer value2) {
            addCriterion("citylevel not between", value1, value2, "citylevel");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNull() {
            addCriterion("areacode is null");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNotNull() {
            addCriterion("areacode is not null");
            return (Criteria) this;
        }

        public Criteria andAreacodeEqualTo(String value) {
            addCriterion("areacode =", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotEqualTo(String value) {
            addCriterion("areacode <>", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThan(String value) {
            addCriterion("areacode >", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThanOrEqualTo(String value) {
            addCriterion("areacode >=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThan(String value) {
            addCriterion("areacode <", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThanOrEqualTo(String value) {
            addCriterion("areacode <=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLike(String value) {
            addCriterion("areacode like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotLike(String value) {
            addCriterion("areacode not like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeIn(List<String> values) {
            addCriterion("areacode in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotIn(List<String> values) {
            addCriterion("areacode not in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeBetween(String value1, String value2) {
            addCriterion("areacode between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotBetween(String value1, String value2) {
            addCriterion("areacode not between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPyIsNull() {
            addCriterion("py is null");
            return (Criteria) this;
        }

        public Criteria andPyIsNotNull() {
            addCriterion("py is not null");
            return (Criteria) this;
        }

        public Criteria andPyEqualTo(String value) {
            addCriterion("py =", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotEqualTo(String value) {
            addCriterion("py <>", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyGreaterThan(String value) {
            addCriterion("py >", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyGreaterThanOrEqualTo(String value) {
            addCriterion("py >=", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyLessThan(String value) {
            addCriterion("py <", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyLessThanOrEqualTo(String value) {
            addCriterion("py <=", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyLike(String value) {
            addCriterion("py like", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotLike(String value) {
            addCriterion("py not like", value, "py");
            return (Criteria) this;
        }

        public Criteria andPyIn(List<String> values) {
            addCriterion("py in", values, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotIn(List<String> values) {
            addCriterion("py not in", values, "py");
            return (Criteria) this;
        }

        public Criteria andPyBetween(String value1, String value2) {
            addCriterion("py between", value1, value2, "py");
            return (Criteria) this;
        }

        public Criteria andPyNotBetween(String value1, String value2) {
            addCriterion("py not between", value1, value2, "py");
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