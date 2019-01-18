package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdSendgetmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdSendgetmailExample() {
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

        public Criteria andMailIdIsNull() {
            addCriterion("mail_id is null");
            return (Criteria) this;
        }

        public Criteria andMailIdIsNotNull() {
            addCriterion("mail_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailIdEqualTo(String value) {
            addCriterion("mail_id =", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotEqualTo(String value) {
            addCriterion("mail_id <>", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdGreaterThan(String value) {
            addCriterion("mail_id >", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdGreaterThanOrEqualTo(String value) {
            addCriterion("mail_id >=", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdLessThan(String value) {
            addCriterion("mail_id <", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdLessThanOrEqualTo(String value) {
            addCriterion("mail_id <=", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdLike(String value) {
            addCriterion("mail_id like", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotLike(String value) {
            addCriterion("mail_id not like", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdIn(List<String> values) {
            addCriterion("mail_id in", values, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotIn(List<String> values) {
            addCriterion("mail_id not in", values, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdBetween(String value1, String value2) {
            addCriterion("mail_id between", value1, value2, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotBetween(String value1, String value2) {
            addCriterion("mail_id not between", value1, value2, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andSenduserIdIsNull() {
            addCriterion("senduser_id is null");
            return (Criteria) this;
        }

        public Criteria andSenduserIdIsNotNull() {
            addCriterion("senduser_id is not null");
            return (Criteria) this;
        }

        public Criteria andSenduserIdEqualTo(String value) {
            addCriterion("senduser_id =", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdNotEqualTo(String value) {
            addCriterion("senduser_id <>", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdGreaterThan(String value) {
            addCriterion("senduser_id >", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdGreaterThanOrEqualTo(String value) {
            addCriterion("senduser_id >=", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdLessThan(String value) {
            addCriterion("senduser_id <", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdLessThanOrEqualTo(String value) {
            addCriterion("senduser_id <=", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdLike(String value) {
            addCriterion("senduser_id like", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdNotLike(String value) {
            addCriterion("senduser_id not like", value, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdIn(List<String> values) {
            addCriterion("senduser_id in", values, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdNotIn(List<String> values) {
            addCriterion("senduser_id not in", values, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdBetween(String value1, String value2) {
            addCriterion("senduser_id between", value1, value2, "senduserId");
            return (Criteria) this;
        }

        public Criteria andSenduserIdNotBetween(String value1, String value2) {
            addCriterion("senduser_id not between", value1, value2, "senduserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdIsNull() {
            addCriterion("getuser_id is null");
            return (Criteria) this;
        }

        public Criteria andGetuserIdIsNotNull() {
            addCriterion("getuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andGetuserIdEqualTo(String value) {
            addCriterion("getuser_id =", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdNotEqualTo(String value) {
            addCriterion("getuser_id <>", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdGreaterThan(String value) {
            addCriterion("getuser_id >", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdGreaterThanOrEqualTo(String value) {
            addCriterion("getuser_id >=", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdLessThan(String value) {
            addCriterion("getuser_id <", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdLessThanOrEqualTo(String value) {
            addCriterion("getuser_id <=", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdLike(String value) {
            addCriterion("getuser_id like", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdNotLike(String value) {
            addCriterion("getuser_id not like", value, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdIn(List<String> values) {
            addCriterion("getuser_id in", values, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdNotIn(List<String> values) {
            addCriterion("getuser_id not in", values, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdBetween(String value1, String value2) {
            addCriterion("getuser_id between", value1, value2, "getuserId");
            return (Criteria) this;
        }

        public Criteria andGetuserIdNotBetween(String value1, String value2) {
            addCriterion("getuser_id not between", value1, value2, "getuserId");
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