package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.List;

public class TdHomekeywordslogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdHomekeywordslogExample() {
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

        public Criteria andHomekeywordsIdIsNull() {
            addCriterion("homekeywords_id is null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdIsNotNull() {
            addCriterion("homekeywords_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdEqualTo(String value) {
            addCriterion("homekeywords_id =", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdNotEqualTo(String value) {
            addCriterion("homekeywords_id <>", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdGreaterThan(String value) {
            addCriterion("homekeywords_id >", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdGreaterThanOrEqualTo(String value) {
            addCriterion("homekeywords_id >=", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdLessThan(String value) {
            addCriterion("homekeywords_id <", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdLessThanOrEqualTo(String value) {
            addCriterion("homekeywords_id <=", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdLike(String value) {
            addCriterion("homekeywords_id like", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdNotLike(String value) {
            addCriterion("homekeywords_id not like", value, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdIn(List<String> values) {
            addCriterion("homekeywords_id in", values, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdNotIn(List<String> values) {
            addCriterion("homekeywords_id not in", values, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdBetween(String value1, String value2) {
            addCriterion("homekeywords_id between", value1, value2, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsIdNotBetween(String value1, String value2) {
            addCriterion("homekeywords_id not between", value1, value2, "homekeywordsId");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameIsNull() {
            addCriterion("homekeywords_name is null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameIsNotNull() {
            addCriterion("homekeywords_name is not null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameEqualTo(String value) {
            addCriterion("homekeywords_name =", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameNotEqualTo(String value) {
            addCriterion("homekeywords_name <>", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameGreaterThan(String value) {
            addCriterion("homekeywords_name >", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameGreaterThanOrEqualTo(String value) {
            addCriterion("homekeywords_name >=", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameLessThan(String value) {
            addCriterion("homekeywords_name <", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameLessThanOrEqualTo(String value) {
            addCriterion("homekeywords_name <=", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameLike(String value) {
            addCriterion("homekeywords_name like", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameNotLike(String value) {
            addCriterion("homekeywords_name not like", value, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameIn(List<String> values) {
            addCriterion("homekeywords_name in", values, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameNotIn(List<String> values) {
            addCriterion("homekeywords_name not in", values, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameBetween(String value1, String value2) {
            addCriterion("homekeywords_name between", value1, value2, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsNameNotBetween(String value1, String value2) {
            addCriterion("homekeywords_name not between", value1, value2, "homekeywordsName");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlIsNull() {
            addCriterion("homekeywords_imgurl is null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlIsNotNull() {
            addCriterion("homekeywords_imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlEqualTo(String value) {
            addCriterion("homekeywords_imgurl =", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlNotEqualTo(String value) {
            addCriterion("homekeywords_imgurl <>", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlGreaterThan(String value) {
            addCriterion("homekeywords_imgurl >", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("homekeywords_imgurl >=", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlLessThan(String value) {
            addCriterion("homekeywords_imgurl <", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlLessThanOrEqualTo(String value) {
            addCriterion("homekeywords_imgurl <=", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlLike(String value) {
            addCriterion("homekeywords_imgurl like", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlNotLike(String value) {
            addCriterion("homekeywords_imgurl not like", value, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlIn(List<String> values) {
            addCriterion("homekeywords_imgurl in", values, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlNotIn(List<String> values) {
            addCriterion("homekeywords_imgurl not in", values, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlBetween(String value1, String value2) {
            addCriterion("homekeywords_imgurl between", value1, value2, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsImgurlNotBetween(String value1, String value2) {
            addCriterion("homekeywords_imgurl not between", value1, value2, "homekeywordsImgurl");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderIsNull() {
            addCriterion("homekeywords_order is null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderIsNotNull() {
            addCriterion("homekeywords_order is not null");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderEqualTo(Integer value) {
            addCriterion("homekeywords_order =", value, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderNotEqualTo(Integer value) {
            addCriterion("homekeywords_order <>", value, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderGreaterThan(Integer value) {
            addCriterion("homekeywords_order >", value, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("homekeywords_order >=", value, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderLessThan(Integer value) {
            addCriterion("homekeywords_order <", value, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderLessThanOrEqualTo(Integer value) {
            addCriterion("homekeywords_order <=", value, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderIn(List<Integer> values) {
            addCriterion("homekeywords_order in", values, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderNotIn(List<Integer> values) {
            addCriterion("homekeywords_order not in", values, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderBetween(Integer value1, Integer value2) {
            addCriterion("homekeywords_order between", value1, value2, "homekeywordsOrder");
            return (Criteria) this;
        }

        public Criteria andHomekeywordsOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("homekeywords_order not between", value1, value2, "homekeywordsOrder");
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