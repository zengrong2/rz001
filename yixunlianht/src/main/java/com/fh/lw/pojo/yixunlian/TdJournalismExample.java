package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdJournalismExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdJournalismExample() {
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

        public Criteria andJournalismIdIsNull() {
            addCriterion("journalism_id is null");
            return (Criteria) this;
        }

        public Criteria andJournalismIdIsNotNull() {
            addCriterion("journalism_id is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismIdEqualTo(String value) {
            addCriterion("journalism_id =", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotEqualTo(String value) {
            addCriterion("journalism_id <>", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdGreaterThan(String value) {
            addCriterion("journalism_id >", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdGreaterThanOrEqualTo(String value) {
            addCriterion("journalism_id >=", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdLessThan(String value) {
            addCriterion("journalism_id <", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdLessThanOrEqualTo(String value) {
            addCriterion("journalism_id <=", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdLike(String value) {
            addCriterion("journalism_id like", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotLike(String value) {
            addCriterion("journalism_id not like", value, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdIn(List<String> values) {
            addCriterion("journalism_id in", values, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotIn(List<String> values) {
            addCriterion("journalism_id not in", values, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdBetween(String value1, String value2) {
            addCriterion("journalism_id between", value1, value2, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismIdNotBetween(String value1, String value2) {
            addCriterion("journalism_id not between", value1, value2, "journalismId");
            return (Criteria) this;
        }

        public Criteria andJournalismNameIsNull() {
            addCriterion("journalism_name is null");
            return (Criteria) this;
        }

        public Criteria andJournalismNameIsNotNull() {
            addCriterion("journalism_name is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismNameEqualTo(String value) {
            addCriterion("journalism_name =", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameNotEqualTo(String value) {
            addCriterion("journalism_name <>", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameGreaterThan(String value) {
            addCriterion("journalism_name >", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameGreaterThanOrEqualTo(String value) {
            addCriterion("journalism_name >=", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameLessThan(String value) {
            addCriterion("journalism_name <", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameLessThanOrEqualTo(String value) {
            addCriterion("journalism_name <=", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameLike(String value) {
            addCriterion("journalism_name like", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameNotLike(String value) {
            addCriterion("journalism_name not like", value, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameIn(List<String> values) {
            addCriterion("journalism_name in", values, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameNotIn(List<String> values) {
            addCriterion("journalism_name not in", values, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameBetween(String value1, String value2) {
            addCriterion("journalism_name between", value1, value2, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismNameNotBetween(String value1, String value2) {
            addCriterion("journalism_name not between", value1, value2, "journalismName");
            return (Criteria) this;
        }

        public Criteria andJournalismDateIsNull() {
            addCriterion("journalism_date is null");
            return (Criteria) this;
        }

        public Criteria andJournalismDateIsNotNull() {
            addCriterion("journalism_date is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismDateEqualTo(Date value) {
            addCriterion("journalism_date =", value, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateNotEqualTo(Date value) {
            addCriterion("journalism_date <>", value, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateGreaterThan(Date value) {
            addCriterion("journalism_date >", value, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateGreaterThanOrEqualTo(Date value) {
            addCriterion("journalism_date >=", value, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateLessThan(Date value) {
            addCriterion("journalism_date <", value, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateLessThanOrEqualTo(Date value) {
            addCriterion("journalism_date <=", value, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateIn(List<Date> values) {
            addCriterion("journalism_date in", values, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateNotIn(List<Date> values) {
            addCriterion("journalism_date not in", values, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateBetween(Date value1, Date value2) {
            addCriterion("journalism_date between", value1, value2, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismDateNotBetween(Date value1, Date value2) {
            addCriterion("journalism_date not between", value1, value2, "journalismDate");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameIsNull() {
            addCriterion("journalism_sysoName is null");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameIsNotNull() {
            addCriterion("journalism_sysoName is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameEqualTo(String value) {
            addCriterion("journalism_sysoName =", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameNotEqualTo(String value) {
            addCriterion("journalism_sysoName <>", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameGreaterThan(String value) {
            addCriterion("journalism_sysoName >", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameGreaterThanOrEqualTo(String value) {
            addCriterion("journalism_sysoName >=", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameLessThan(String value) {
            addCriterion("journalism_sysoName <", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameLessThanOrEqualTo(String value) {
            addCriterion("journalism_sysoName <=", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameLike(String value) {
            addCriterion("journalism_sysoName like", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameNotLike(String value) {
            addCriterion("journalism_sysoName not like", value, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameIn(List<String> values) {
            addCriterion("journalism_sysoName in", values, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameNotIn(List<String> values) {
            addCriterion("journalism_sysoName not in", values, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameBetween(String value1, String value2) {
            addCriterion("journalism_sysoName between", value1, value2, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismSysonameNotBetween(String value1, String value2) {
            addCriterion("journalism_sysoName not between", value1, value2, "journalismSysoname");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesIsNull() {
            addCriterion("journalism_browsingtimes is null");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesIsNotNull() {
            addCriterion("journalism_browsingtimes is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesEqualTo(Integer value) {
            addCriterion("journalism_browsingtimes =", value, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesNotEqualTo(Integer value) {
            addCriterion("journalism_browsingtimes <>", value, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesGreaterThan(Integer value) {
            addCriterion("journalism_browsingtimes >", value, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("journalism_browsingtimes >=", value, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesLessThan(Integer value) {
            addCriterion("journalism_browsingtimes <", value, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesLessThanOrEqualTo(Integer value) {
            addCriterion("journalism_browsingtimes <=", value, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesIn(List<Integer> values) {
            addCriterion("journalism_browsingtimes in", values, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesNotIn(List<Integer> values) {
            addCriterion("journalism_browsingtimes not in", values, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesBetween(Integer value1, Integer value2) {
            addCriterion("journalism_browsingtimes between", value1, value2, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismBrowsingtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("journalism_browsingtimes not between", value1, value2, "journalismBrowsingtimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesIsNull() {
            addCriterion("journalism_sharetimes is null");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesIsNotNull() {
            addCriterion("journalism_sharetimes is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesEqualTo(Integer value) {
            addCriterion("journalism_sharetimes =", value, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesNotEqualTo(Integer value) {
            addCriterion("journalism_sharetimes <>", value, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesGreaterThan(Integer value) {
            addCriterion("journalism_sharetimes >", value, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("journalism_sharetimes >=", value, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesLessThan(Integer value) {
            addCriterion("journalism_sharetimes <", value, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesLessThanOrEqualTo(Integer value) {
            addCriterion("journalism_sharetimes <=", value, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesIn(List<Integer> values) {
            addCriterion("journalism_sharetimes in", values, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesNotIn(List<Integer> values) {
            addCriterion("journalism_sharetimes not in", values, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesBetween(Integer value1, Integer value2) {
            addCriterion("journalism_sharetimes between", value1, value2, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismSharetimesNotBetween(Integer value1, Integer value2) {
            addCriterion("journalism_sharetimes not between", value1, value2, "journalismSharetimes");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlIsNull() {
            addCriterion("journalism_url is null");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlIsNotNull() {
            addCriterion("journalism_url is not null");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlEqualTo(String value) {
            addCriterion("journalism_url =", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlNotEqualTo(String value) {
            addCriterion("journalism_url <>", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlGreaterThan(String value) {
            addCriterion("journalism_url >", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlGreaterThanOrEqualTo(String value) {
            addCriterion("journalism_url >=", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlLessThan(String value) {
            addCriterion("journalism_url <", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlLessThanOrEqualTo(String value) {
            addCriterion("journalism_url <=", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlLike(String value) {
            addCriterion("journalism_url like", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlNotLike(String value) {
            addCriterion("journalism_url not like", value, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlIn(List<String> values) {
            addCriterion("journalism_url in", values, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlNotIn(List<String> values) {
            addCriterion("journalism_url not in", values, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlBetween(String value1, String value2) {
            addCriterion("journalism_url between", value1, value2, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andJournalismUrlNotBetween(String value1, String value2) {
            addCriterion("journalism_url not between", value1, value2, "journalismUrl");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdIsNull() {
            addCriterion("readingsurvey_id is null");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdIsNotNull() {
            addCriterion("readingsurvey_id is not null");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdEqualTo(String value) {
            addCriterion("readingsurvey_id =", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotEqualTo(String value) {
            addCriterion("readingsurvey_id <>", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdGreaterThan(String value) {
            addCriterion("readingsurvey_id >", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdGreaterThanOrEqualTo(String value) {
            addCriterion("readingsurvey_id >=", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdLessThan(String value) {
            addCriterion("readingsurvey_id <", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdLessThanOrEqualTo(String value) {
            addCriterion("readingsurvey_id <=", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdLike(String value) {
            addCriterion("readingsurvey_id like", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotLike(String value) {
            addCriterion("readingsurvey_id not like", value, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdIn(List<String> values) {
            addCriterion("readingsurvey_id in", values, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotIn(List<String> values) {
            addCriterion("readingsurvey_id not in", values, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdBetween(String value1, String value2) {
            addCriterion("readingsurvey_id between", value1, value2, "readingsurveyId");
            return (Criteria) this;
        }

        public Criteria andReadingsurveyIdNotBetween(String value1, String value2) {
            addCriterion("readingsurvey_id not between", value1, value2, "readingsurveyId");
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