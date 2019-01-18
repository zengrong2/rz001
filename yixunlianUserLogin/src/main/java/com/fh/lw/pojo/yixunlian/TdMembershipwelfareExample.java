package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdMembershipwelfareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdMembershipwelfareExample() {
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

        public Criteria andWelfareIdIsNull() {
            addCriterion("welfare_id is null");
            return (Criteria) this;
        }

        public Criteria andWelfareIdIsNotNull() {
            addCriterion("welfare_id is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareIdEqualTo(String value) {
            addCriterion("welfare_id =", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdNotEqualTo(String value) {
            addCriterion("welfare_id <>", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdGreaterThan(String value) {
            addCriterion("welfare_id >", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdGreaterThanOrEqualTo(String value) {
            addCriterion("welfare_id >=", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdLessThan(String value) {
            addCriterion("welfare_id <", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdLessThanOrEqualTo(String value) {
            addCriterion("welfare_id <=", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdLike(String value) {
            addCriterion("welfare_id like", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdNotLike(String value) {
            addCriterion("welfare_id not like", value, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdIn(List<String> values) {
            addCriterion("welfare_id in", values, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdNotIn(List<String> values) {
            addCriterion("welfare_id not in", values, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdBetween(String value1, String value2) {
            addCriterion("welfare_id between", value1, value2, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareIdNotBetween(String value1, String value2) {
            addCriterion("welfare_id not between", value1, value2, "welfareId");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlIsNull() {
            addCriterion("welfare_imgurl is null");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlIsNotNull() {
            addCriterion("welfare_imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlEqualTo(String value) {
            addCriterion("welfare_imgurl =", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlNotEqualTo(String value) {
            addCriterion("welfare_imgurl <>", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlGreaterThan(String value) {
            addCriterion("welfare_imgurl >", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("welfare_imgurl >=", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlLessThan(String value) {
            addCriterion("welfare_imgurl <", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlLessThanOrEqualTo(String value) {
            addCriterion("welfare_imgurl <=", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlLike(String value) {
            addCriterion("welfare_imgurl like", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlNotLike(String value) {
            addCriterion("welfare_imgurl not like", value, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlIn(List<String> values) {
            addCriterion("welfare_imgurl in", values, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlNotIn(List<String> values) {
            addCriterion("welfare_imgurl not in", values, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlBetween(String value1, String value2) {
            addCriterion("welfare_imgurl between", value1, value2, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareImgurlNotBetween(String value1, String value2) {
            addCriterion("welfare_imgurl not between", value1, value2, "welfareImgurl");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountIsNull() {
            addCriterion("welfare_sharecount is null");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountIsNotNull() {
            addCriterion("welfare_sharecount is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountEqualTo(Integer value) {
            addCriterion("welfare_sharecount =", value, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountNotEqualTo(Integer value) {
            addCriterion("welfare_sharecount <>", value, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountGreaterThan(Integer value) {
            addCriterion("welfare_sharecount >", value, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("welfare_sharecount >=", value, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountLessThan(Integer value) {
            addCriterion("welfare_sharecount <", value, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountLessThanOrEqualTo(Integer value) {
            addCriterion("welfare_sharecount <=", value, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountIn(List<Integer> values) {
            addCriterion("welfare_sharecount in", values, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountNotIn(List<Integer> values) {
            addCriterion("welfare_sharecount not in", values, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountBetween(Integer value1, Integer value2) {
            addCriterion("welfare_sharecount between", value1, value2, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareSharecountNotBetween(Integer value1, Integer value2) {
            addCriterion("welfare_sharecount not between", value1, value2, "welfareSharecount");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleIsNull() {
            addCriterion("welfare_title is null");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleIsNotNull() {
            addCriterion("welfare_title is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleEqualTo(String value) {
            addCriterion("welfare_title =", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleNotEqualTo(String value) {
            addCriterion("welfare_title <>", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleGreaterThan(String value) {
            addCriterion("welfare_title >", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleGreaterThanOrEqualTo(String value) {
            addCriterion("welfare_title >=", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleLessThan(String value) {
            addCriterion("welfare_title <", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleLessThanOrEqualTo(String value) {
            addCriterion("welfare_title <=", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleLike(String value) {
            addCriterion("welfare_title like", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleNotLike(String value) {
            addCriterion("welfare_title not like", value, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleIn(List<String> values) {
            addCriterion("welfare_title in", values, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleNotIn(List<String> values) {
            addCriterion("welfare_title not in", values, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleBetween(String value1, String value2) {
            addCriterion("welfare_title between", value1, value2, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareTitleNotBetween(String value1, String value2) {
            addCriterion("welfare_title not between", value1, value2, "welfareTitle");
            return (Criteria) this;
        }

        public Criteria andWelfareContextIsNull() {
            addCriterion("welfare_context is null");
            return (Criteria) this;
        }

        public Criteria andWelfareContextIsNotNull() {
            addCriterion("welfare_context is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareContextEqualTo(String value) {
            addCriterion("welfare_context =", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextNotEqualTo(String value) {
            addCriterion("welfare_context <>", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextGreaterThan(String value) {
            addCriterion("welfare_context >", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextGreaterThanOrEqualTo(String value) {
            addCriterion("welfare_context >=", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextLessThan(String value) {
            addCriterion("welfare_context <", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextLessThanOrEqualTo(String value) {
            addCriterion("welfare_context <=", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextLike(String value) {
            addCriterion("welfare_context like", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextNotLike(String value) {
            addCriterion("welfare_context not like", value, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextIn(List<String> values) {
            addCriterion("welfare_context in", values, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextNotIn(List<String> values) {
            addCriterion("welfare_context not in", values, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextBetween(String value1, String value2) {
            addCriterion("welfare_context between", value1, value2, "welfareContext");
            return (Criteria) this;
        }

        public Criteria andWelfareContextNotBetween(String value1, String value2) {
            addCriterion("welfare_context not between", value1, value2, "welfareContext");
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

        public Criteria andWelfareConditionIsNull() {
            addCriterion("welfare_condition is null");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionIsNotNull() {
            addCriterion("welfare_condition is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionEqualTo(Integer value) {
            addCriterion("welfare_condition =", value, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionNotEqualTo(Integer value) {
            addCriterion("welfare_condition <>", value, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionGreaterThan(Integer value) {
            addCriterion("welfare_condition >", value, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("welfare_condition >=", value, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionLessThan(Integer value) {
            addCriterion("welfare_condition <", value, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionLessThanOrEqualTo(Integer value) {
            addCriterion("welfare_condition <=", value, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionIn(List<Integer> values) {
            addCriterion("welfare_condition in", values, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionNotIn(List<Integer> values) {
            addCriterion("welfare_condition not in", values, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionBetween(Integer value1, Integer value2) {
            addCriterion("welfare_condition between", value1, value2, "welfareCondition");
            return (Criteria) this;
        }

        public Criteria andWelfareConditionNotBetween(Integer value1, Integer value2) {
            addCriterion("welfare_condition not between", value1, value2, "welfareCondition");
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