package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdShareExample() {
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

        public Criteria andShareIdIsNull() {
            addCriterion("share_id is null");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNotNull() {
            addCriterion("share_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareIdEqualTo(String value) {
            addCriterion("share_id =", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotEqualTo(String value) {
            addCriterion("share_id <>", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThan(String value) {
            addCriterion("share_id >", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThanOrEqualTo(String value) {
            addCriterion("share_id >=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThan(String value) {
            addCriterion("share_id <", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThanOrEqualTo(String value) {
            addCriterion("share_id <=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLike(String value) {
            addCriterion("share_id like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotLike(String value) {
            addCriterion("share_id not like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdIn(List<String> values) {
            addCriterion("share_id in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotIn(List<String> values) {
            addCriterion("share_id not in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdBetween(String value1, String value2) {
            addCriterion("share_id between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotBetween(String value1, String value2) {
            addCriterion("share_id not between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareidStatusIsNull() {
            addCriterion("shareid_status is null");
            return (Criteria) this;
        }

        public Criteria andShareidStatusIsNotNull() {
            addCriterion("shareid_status is not null");
            return (Criteria) this;
        }

        public Criteria andShareidStatusEqualTo(Integer value) {
            addCriterion("shareid_status =", value, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusNotEqualTo(Integer value) {
            addCriterion("shareid_status <>", value, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusGreaterThan(Integer value) {
            addCriterion("shareid_status >", value, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("shareid_status >=", value, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusLessThan(Integer value) {
            addCriterion("shareid_status <", value, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusLessThanOrEqualTo(Integer value) {
            addCriterion("shareid_status <=", value, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusIn(List<Integer> values) {
            addCriterion("shareid_status in", values, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusNotIn(List<Integer> values) {
            addCriterion("shareid_status not in", values, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusBetween(Integer value1, Integer value2) {
            addCriterion("shareid_status between", value1, value2, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andShareidStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("shareid_status not between", value1, value2, "shareidStatus");
            return (Criteria) this;
        }

        public Criteria andSharesendIdIsNull() {
            addCriterion("sharesend_id is null");
            return (Criteria) this;
        }

        public Criteria andSharesendIdIsNotNull() {
            addCriterion("sharesend_id is not null");
            return (Criteria) this;
        }

        public Criteria andSharesendIdEqualTo(String value) {
            addCriterion("sharesend_id =", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdNotEqualTo(String value) {
            addCriterion("sharesend_id <>", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdGreaterThan(String value) {
            addCriterion("sharesend_id >", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdGreaterThanOrEqualTo(String value) {
            addCriterion("sharesend_id >=", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdLessThan(String value) {
            addCriterion("sharesend_id <", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdLessThanOrEqualTo(String value) {
            addCriterion("sharesend_id <=", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdLike(String value) {
            addCriterion("sharesend_id like", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdNotLike(String value) {
            addCriterion("sharesend_id not like", value, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdIn(List<String> values) {
            addCriterion("sharesend_id in", values, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdNotIn(List<String> values) {
            addCriterion("sharesend_id not in", values, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdBetween(String value1, String value2) {
            addCriterion("sharesend_id between", value1, value2, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharesendIdNotBetween(String value1, String value2) {
            addCriterion("sharesend_id not between", value1, value2, "sharesendId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdIsNull() {
            addCriterion("shareget_id is null");
            return (Criteria) this;
        }

        public Criteria andSharegetIdIsNotNull() {
            addCriterion("shareget_id is not null");
            return (Criteria) this;
        }

        public Criteria andSharegetIdEqualTo(String value) {
            addCriterion("shareget_id =", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdNotEqualTo(String value) {
            addCriterion("shareget_id <>", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdGreaterThan(String value) {
            addCriterion("shareget_id >", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdGreaterThanOrEqualTo(String value) {
            addCriterion("shareget_id >=", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdLessThan(String value) {
            addCriterion("shareget_id <", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdLessThanOrEqualTo(String value) {
            addCriterion("shareget_id <=", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdLike(String value) {
            addCriterion("shareget_id like", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdNotLike(String value) {
            addCriterion("shareget_id not like", value, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdIn(List<String> values) {
            addCriterion("shareget_id in", values, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdNotIn(List<String> values) {
            addCriterion("shareget_id not in", values, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdBetween(String value1, String value2) {
            addCriterion("shareget_id between", value1, value2, "sharegetId");
            return (Criteria) this;
        }

        public Criteria andSharegetIdNotBetween(String value1, String value2) {
            addCriterion("shareget_id not between", value1, value2, "sharegetId");
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

        public Criteria andSharingRecordsDeleteIsNull() {
            addCriterion("sharing_records_delete is null");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteIsNotNull() {
            addCriterion("sharing_records_delete is not null");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteEqualTo(Integer value) {
            addCriterion("sharing_records_delete =", value, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteNotEqualTo(Integer value) {
            addCriterion("sharing_records_delete <>", value, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteGreaterThan(Integer value) {
            addCriterion("sharing_records_delete >", value, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("sharing_records_delete >=", value, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteLessThan(Integer value) {
            addCriterion("sharing_records_delete <", value, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("sharing_records_delete <=", value, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteIn(List<Integer> values) {
            addCriterion("sharing_records_delete in", values, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteNotIn(List<Integer> values) {
            addCriterion("sharing_records_delete not in", values, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("sharing_records_delete between", value1, value2, "sharingRecordsDelete");
            return (Criteria) this;
        }

        public Criteria andSharingRecordsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("sharing_records_delete not between", value1, value2, "sharingRecordsDelete");
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