package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdVipMemberCurriculumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdVipMemberCurriculumExample() {
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

        public Criteria andVipMemberCurriculumIdIsNull() {
            addCriterion("vip_member_curriculum_id is null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdIsNotNull() {
            addCriterion("vip_member_curriculum_id is not null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdEqualTo(String value) {
            addCriterion("vip_member_curriculum_id =", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdNotEqualTo(String value) {
            addCriterion("vip_member_curriculum_id <>", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdGreaterThan(String value) {
            addCriterion("vip_member_curriculum_id >", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdGreaterThanOrEqualTo(String value) {
            addCriterion("vip_member_curriculum_id >=", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdLessThan(String value) {
            addCriterion("vip_member_curriculum_id <", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdLessThanOrEqualTo(String value) {
            addCriterion("vip_member_curriculum_id <=", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdLike(String value) {
            addCriterion("vip_member_curriculum_id like", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdNotLike(String value) {
            addCriterion("vip_member_curriculum_id not like", value, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdIn(List<String> values) {
            addCriterion("vip_member_curriculum_id in", values, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdNotIn(List<String> values) {
            addCriterion("vip_member_curriculum_id not in", values, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdBetween(String value1, String value2) {
            addCriterion("vip_member_curriculum_id between", value1, value2, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIdNotBetween(String value1, String value2) {
            addCriterion("vip_member_curriculum_id not between", value1, value2, "vipMemberCurriculumId");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameIsNull() {
            addCriterion("vip_member_curriculum_name is null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameIsNotNull() {
            addCriterion("vip_member_curriculum_name is not null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameEqualTo(String value) {
            addCriterion("vip_member_curriculum_name =", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameNotEqualTo(String value) {
            addCriterion("vip_member_curriculum_name <>", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameGreaterThan(String value) {
            addCriterion("vip_member_curriculum_name >", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameGreaterThanOrEqualTo(String value) {
            addCriterion("vip_member_curriculum_name >=", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameLessThan(String value) {
            addCriterion("vip_member_curriculum_name <", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameLessThanOrEqualTo(String value) {
            addCriterion("vip_member_curriculum_name <=", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameLike(String value) {
            addCriterion("vip_member_curriculum_name like", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameNotLike(String value) {
            addCriterion("vip_member_curriculum_name not like", value, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameIn(List<String> values) {
            addCriterion("vip_member_curriculum_name in", values, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameNotIn(List<String> values) {
            addCriterion("vip_member_curriculum_name not in", values, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameBetween(String value1, String value2) {
            addCriterion("vip_member_curriculum_name between", value1, value2, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumNameNotBetween(String value1, String value2) {
            addCriterion("vip_member_curriculum_name not between", value1, value2, "vipMemberCurriculumName");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionIsNull() {
            addCriterion("vip_member_curriculum_introduction is null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionIsNotNull() {
            addCriterion("vip_member_curriculum_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionEqualTo(String value) {
            addCriterion("vip_member_curriculum_introduction =", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionNotEqualTo(String value) {
            addCriterion("vip_member_curriculum_introduction <>", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionGreaterThan(String value) {
            addCriterion("vip_member_curriculum_introduction >", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("vip_member_curriculum_introduction >=", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionLessThan(String value) {
            addCriterion("vip_member_curriculum_introduction <", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionLessThanOrEqualTo(String value) {
            addCriterion("vip_member_curriculum_introduction <=", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionLike(String value) {
            addCriterion("vip_member_curriculum_introduction like", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionNotLike(String value) {
            addCriterion("vip_member_curriculum_introduction not like", value, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionIn(List<String> values) {
            addCriterion("vip_member_curriculum_introduction in", values, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionNotIn(List<String> values) {
            addCriterion("vip_member_curriculum_introduction not in", values, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionBetween(String value1, String value2) {
            addCriterion("vip_member_curriculum_introduction between", value1, value2, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumIntroductionNotBetween(String value1, String value2) {
            addCriterion("vip_member_curriculum_introduction not between", value1, value2, "vipMemberCurriculumIntroduction");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceIsNull() {
            addCriterion("vip_member_curriculum_price is null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceIsNotNull() {
            addCriterion("vip_member_curriculum_price is not null");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceEqualTo(BigDecimal value) {
            addCriterion("vip_member_curriculum_price =", value, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceNotEqualTo(BigDecimal value) {
            addCriterion("vip_member_curriculum_price <>", value, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceGreaterThan(BigDecimal value) {
            addCriterion("vip_member_curriculum_price >", value, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_member_curriculum_price >=", value, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceLessThan(BigDecimal value) {
            addCriterion("vip_member_curriculum_price <", value, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_member_curriculum_price <=", value, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceIn(List<BigDecimal> values) {
            addCriterion("vip_member_curriculum_price in", values, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceNotIn(List<BigDecimal> values) {
            addCriterion("vip_member_curriculum_price not in", values, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_member_curriculum_price between", value1, value2, "vipMemberCurriculumPrice");
            return (Criteria) this;
        }

        public Criteria andVipMemberCurriculumPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_member_curriculum_price not between", value1, value2, "vipMemberCurriculumPrice");
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