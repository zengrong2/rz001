package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdBackstageSettingExtractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdBackstageSettingExtractExample() {
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

        public Criteria andBackstageSettingExtractIdIsNull() {
            addCriterion("backstage_setting_extract_id is null");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdIsNotNull() {
            addCriterion("backstage_setting_extract_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdEqualTo(String value) {
            addCriterion("backstage_setting_extract_id =", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdNotEqualTo(String value) {
            addCriterion("backstage_setting_extract_id <>", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdGreaterThan(String value) {
            addCriterion("backstage_setting_extract_id >", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdGreaterThanOrEqualTo(String value) {
            addCriterion("backstage_setting_extract_id >=", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdLessThan(String value) {
            addCriterion("backstage_setting_extract_id <", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdLessThanOrEqualTo(String value) {
            addCriterion("backstage_setting_extract_id <=", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdLike(String value) {
            addCriterion("backstage_setting_extract_id like", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdNotLike(String value) {
            addCriterion("backstage_setting_extract_id not like", value, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdIn(List<String> values) {
            addCriterion("backstage_setting_extract_id in", values, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdNotIn(List<String> values) {
            addCriterion("backstage_setting_extract_id not in", values, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdBetween(String value1, String value2) {
            addCriterion("backstage_setting_extract_id between", value1, value2, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andBackstageSettingExtractIdNotBetween(String value1, String value2) {
            addCriterion("backstage_setting_extract_id not between", value1, value2, "backstageSettingExtractId");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNull() {
            addCriterion("extract_type is null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNotNull() {
            addCriterion("extract_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeEqualTo(String value) {
            addCriterion("extract_type =", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotEqualTo(String value) {
            addCriterion("extract_type <>", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThan(String value) {
            addCriterion("extract_type >", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("extract_type >=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThan(String value) {
            addCriterion("extract_type <", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThanOrEqualTo(String value) {
            addCriterion("extract_type <=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLike(String value) {
            addCriterion("extract_type like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotLike(String value) {
            addCriterion("extract_type not like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIn(List<String> values) {
            addCriterion("extract_type in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotIn(List<String> values) {
            addCriterion("extract_type not in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeBetween(String value1, String value2) {
            addCriterion("extract_type between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotBetween(String value1, String value2) {
            addCriterion("extract_type not between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractReteIsNull() {
            addCriterion("extract_rete is null");
            return (Criteria) this;
        }

        public Criteria andExtractReteIsNotNull() {
            addCriterion("extract_rete is not null");
            return (Criteria) this;
        }

        public Criteria andExtractReteEqualTo(Long value) {
            addCriterion("extract_rete =", value, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteNotEqualTo(Long value) {
            addCriterion("extract_rete <>", value, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteGreaterThan(Long value) {
            addCriterion("extract_rete >", value, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteGreaterThanOrEqualTo(Long value) {
            addCriterion("extract_rete >=", value, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteLessThan(Long value) {
            addCriterion("extract_rete <", value, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteLessThanOrEqualTo(Long value) {
            addCriterion("extract_rete <=", value, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteIn(List<Long> values) {
            addCriterion("extract_rete in", values, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteNotIn(List<Long> values) {
            addCriterion("extract_rete not in", values, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteBetween(Long value1, Long value2) {
            addCriterion("extract_rete between", value1, value2, "extractRete");
            return (Criteria) this;
        }

        public Criteria andExtractReteNotBetween(Long value1, Long value2) {
            addCriterion("extract_rete not between", value1, value2, "extractRete");
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