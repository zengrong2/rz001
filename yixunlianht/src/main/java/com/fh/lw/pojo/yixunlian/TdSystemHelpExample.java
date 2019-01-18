package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdSystemHelpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdSystemHelpExample() {
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

        public Criteria andSystemHelpIdIsNull() {
            addCriterion("system_help_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdIsNotNull() {
            addCriterion("system_help_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdEqualTo(String value) {
            addCriterion("system_help_id =", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdNotEqualTo(String value) {
            addCriterion("system_help_id <>", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdGreaterThan(String value) {
            addCriterion("system_help_id >", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdGreaterThanOrEqualTo(String value) {
            addCriterion("system_help_id >=", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdLessThan(String value) {
            addCriterion("system_help_id <", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdLessThanOrEqualTo(String value) {
            addCriterion("system_help_id <=", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdLike(String value) {
            addCriterion("system_help_id like", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdNotLike(String value) {
            addCriterion("system_help_id not like", value, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdIn(List<String> values) {
            addCriterion("system_help_id in", values, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdNotIn(List<String> values) {
            addCriterion("system_help_id not in", values, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdBetween(String value1, String value2) {
            addCriterion("system_help_id between", value1, value2, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpIdNotBetween(String value1, String value2) {
            addCriterion("system_help_id not between", value1, value2, "systemHelpId");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeIsNull() {
            addCriterion("system_help_type is null");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeIsNotNull() {
            addCriterion("system_help_type is not null");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeEqualTo(String value) {
            addCriterion("system_help_type =", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeNotEqualTo(String value) {
            addCriterion("system_help_type <>", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeGreaterThan(String value) {
            addCriterion("system_help_type >", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("system_help_type >=", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeLessThan(String value) {
            addCriterion("system_help_type <", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeLessThanOrEqualTo(String value) {
            addCriterion("system_help_type <=", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeLike(String value) {
            addCriterion("system_help_type like", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeNotLike(String value) {
            addCriterion("system_help_type not like", value, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeIn(List<String> values) {
            addCriterion("system_help_type in", values, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeNotIn(List<String> values) {
            addCriterion("system_help_type not in", values, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeBetween(String value1, String value2) {
            addCriterion("system_help_type between", value1, value2, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpTypeNotBetween(String value1, String value2) {
            addCriterion("system_help_type not between", value1, value2, "systemHelpType");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextIsNull() {
            addCriterion("system_help_context is null");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextIsNotNull() {
            addCriterion("system_help_context is not null");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextEqualTo(String value) {
            addCriterion("system_help_context =", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextNotEqualTo(String value) {
            addCriterion("system_help_context <>", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextGreaterThan(String value) {
            addCriterion("system_help_context >", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextGreaterThanOrEqualTo(String value) {
            addCriterion("system_help_context >=", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextLessThan(String value) {
            addCriterion("system_help_context <", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextLessThanOrEqualTo(String value) {
            addCriterion("system_help_context <=", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextLike(String value) {
            addCriterion("system_help_context like", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextNotLike(String value) {
            addCriterion("system_help_context not like", value, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextIn(List<String> values) {
            addCriterion("system_help_context in", values, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextNotIn(List<String> values) {
            addCriterion("system_help_context not in", values, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextBetween(String value1, String value2) {
            addCriterion("system_help_context between", value1, value2, "systemHelpContext");
            return (Criteria) this;
        }

        public Criteria andSystemHelpContextNotBetween(String value1, String value2) {
            addCriterion("system_help_context not between", value1, value2, "systemHelpContext");
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