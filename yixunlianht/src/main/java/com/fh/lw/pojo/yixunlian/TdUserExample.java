package com.fh.lw.pojo.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TdUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdUserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andUNicknameIsNull() {
            addCriterion("u_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUNicknameIsNotNull() {
            addCriterion("u_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUNicknameEqualTo(String value) {
            addCriterion("u_nickname =", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotEqualTo(String value) {
            addCriterion("u_nickname <>", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameGreaterThan(String value) {
            addCriterion("u_nickname >", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("u_nickname >=", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameLessThan(String value) {
            addCriterion("u_nickname <", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameLessThanOrEqualTo(String value) {
            addCriterion("u_nickname <=", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameLike(String value) {
            addCriterion("u_nickname like", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotLike(String value) {
            addCriterion("u_nickname not like", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameIn(List<String> values) {
            addCriterion("u_nickname in", values, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotIn(List<String> values) {
            addCriterion("u_nickname not in", values, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameBetween(String value1, String value2) {
            addCriterion("u_nickname between", value1, value2, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotBetween(String value1, String value2) {
            addCriterion("u_nickname not between", value1, value2, "uNickname");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNull() {
            addCriterion("head_url is null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNotNull() {
            addCriterion("head_url is not null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlEqualTo(String value) {
            addCriterion("head_url =", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotEqualTo(String value) {
            addCriterion("head_url <>", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThan(String value) {
            addCriterion("head_url >", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("head_url >=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThan(String value) {
            addCriterion("head_url <", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("head_url <=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLike(String value) {
            addCriterion("head_url like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotLike(String value) {
            addCriterion("head_url not like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIn(List<String> values) {
            addCriterion("head_url in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotIn(List<String> values) {
            addCriterion("head_url not in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlBetween(String value1, String value2) {
            addCriterion("head_url between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotBetween(String value1, String value2) {
            addCriterion("head_url not between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andUSexIsNull() {
            addCriterion("u_sex is null");
            return (Criteria) this;
        }

        public Criteria andUSexIsNotNull() {
            addCriterion("u_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUSexEqualTo(Integer value) {
            addCriterion("u_sex =", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotEqualTo(Integer value) {
            addCriterion("u_sex <>", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThan(Integer value) {
            addCriterion("u_sex >", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_sex >=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThan(Integer value) {
            addCriterion("u_sex <", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThanOrEqualTo(Integer value) {
            addCriterion("u_sex <=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexIn(List<Integer> values) {
            addCriterion("u_sex in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotIn(List<Integer> values) {
            addCriterion("u_sex not in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexBetween(Integer value1, Integer value2) {
            addCriterion("u_sex between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotBetween(Integer value1, Integer value2) {
            addCriterion("u_sex not between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUbirthdayIsNull() {
            addCriterion("ubirthday is null");
            return (Criteria) this;
        }

        public Criteria andUbirthdayIsNotNull() {
            addCriterion("ubirthday is not null");
            return (Criteria) this;
        }

        public Criteria andUbirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("ubirthday =", value, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("ubirthday <>", value, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("ubirthday >", value, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ubirthday >=", value, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayLessThan(Date value) {
            addCriterionForJDBCDate("ubirthday <", value, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ubirthday <=", value, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("ubirthday in", values, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("ubirthday not in", values, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ubirthday between", value1, value2, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUbirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ubirthday not between", value1, value2, "ubirthday");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUCardIsNull() {
            addCriterion("u_card is null");
            return (Criteria) this;
        }

        public Criteria andUCardIsNotNull() {
            addCriterion("u_card is not null");
            return (Criteria) this;
        }

        public Criteria andUCardEqualTo(String value) {
            addCriterion("u_card =", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotEqualTo(String value) {
            addCriterion("u_card <>", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardGreaterThan(String value) {
            addCriterion("u_card >", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardGreaterThanOrEqualTo(String value) {
            addCriterion("u_card >=", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardLessThan(String value) {
            addCriterion("u_card <", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardLessThanOrEqualTo(String value) {
            addCriterion("u_card <=", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardLike(String value) {
            addCriterion("u_card like", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotLike(String value) {
            addCriterion("u_card not like", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardIn(List<String> values) {
            addCriterion("u_card in", values, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotIn(List<String> values) {
            addCriterion("u_card not in", values, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardBetween(String value1, String value2) {
            addCriterion("u_card between", value1, value2, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotBetween(String value1, String value2) {
            addCriterion("u_card not between", value1, value2, "uCard");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNull() {
            addCriterion("u_phone is null");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNotNull() {
            addCriterion("u_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUPhoneEqualTo(String value) {
            addCriterion("u_phone =", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotEqualTo(String value) {
            addCriterion("u_phone <>", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThan(String value) {
            addCriterion("u_phone >", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("u_phone >=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThan(String value) {
            addCriterion("u_phone <", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThanOrEqualTo(String value) {
            addCriterion("u_phone <=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLike(String value) {
            addCriterion("u_phone like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotLike(String value) {
            addCriterion("u_phone not like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneIn(List<String> values) {
            addCriterion("u_phone in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotIn(List<String> values) {
            addCriterion("u_phone not in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneBetween(String value1, String value2) {
            addCriterion("u_phone between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotBetween(String value1, String value2) {
            addCriterion("u_phone not between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUBalanceIsNull() {
            addCriterion("u_balance is null");
            return (Criteria) this;
        }

        public Criteria andUBalanceIsNotNull() {
            addCriterion("u_balance is not null");
            return (Criteria) this;
        }

        public Criteria andUBalanceEqualTo(Double value) {
            addCriterion("u_balance =", value, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceNotEqualTo(Double value) {
            addCriterion("u_balance <>", value, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceGreaterThan(Double value) {
            addCriterion("u_balance >", value, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("u_balance >=", value, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceLessThan(Double value) {
            addCriterion("u_balance <", value, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceLessThanOrEqualTo(Double value) {
            addCriterion("u_balance <=", value, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceIn(List<Double> values) {
            addCriterion("u_balance in", values, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceNotIn(List<Double> values) {
            addCriterion("u_balance not in", values, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceBetween(Double value1, Double value2) {
            addCriterion("u_balance between", value1, value2, "uBalance");
            return (Criteria) this;
        }

        public Criteria andUBalanceNotBetween(Double value1, Double value2) {
            addCriterion("u_balance not between", value1, value2, "uBalance");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("is_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("is_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(Integer value) {
            addCriterion("is_pay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(Integer value) {
            addCriterion("is_pay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(Integer value) {
            addCriterion("is_pay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(Integer value) {
            addCriterion("is_pay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(Integer value) {
            addCriterion("is_pay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<Integer> values) {
            addCriterion("is_pay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<Integer> values) {
            addCriterion("is_pay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(Integer value1, Integer value2) {
            addCriterion("is_pay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pay not between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNull() {
            addCriterion("is_vip is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("is_vip is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(Integer value) {
            addCriterion("is_vip =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(Integer value) {
            addCriterion("is_vip <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(Integer value) {
            addCriterion("is_vip >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_vip >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(Integer value) {
            addCriterion("is_vip <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(Integer value) {
            addCriterion("is_vip <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<Integer> values) {
            addCriterion("is_vip in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<Integer> values) {
            addCriterion("is_vip not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(Integer value1, Integer value2) {
            addCriterion("is_vip between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(Integer value1, Integer value2) {
            addCriterion("is_vip not between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationIsNull() {
            addCriterion("is_authentication is null");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationIsNotNull() {
            addCriterion("is_authentication is not null");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationEqualTo(Integer value) {
            addCriterion("is_authentication =", value, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationNotEqualTo(Integer value) {
            addCriterion("is_authentication <>", value, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationGreaterThan(Integer value) {
            addCriterion("is_authentication >", value, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_authentication >=", value, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationLessThan(Integer value) {
            addCriterion("is_authentication <", value, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationLessThanOrEqualTo(Integer value) {
            addCriterion("is_authentication <=", value, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationIn(List<Integer> values) {
            addCriterion("is_authentication in", values, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationNotIn(List<Integer> values) {
            addCriterion("is_authentication not in", values, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationBetween(Integer value1, Integer value2) {
            addCriterion("is_authentication between", value1, value2, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andIsAuthenticationNotBetween(Integer value1, Integer value2) {
            addCriterion("is_authentication not between", value1, value2, "isAuthentication");
            return (Criteria) this;
        }

        public Criteria andTyIdIsNull() {
            addCriterion("ty_id is null");
            return (Criteria) this;
        }

        public Criteria andTyIdIsNotNull() {
            addCriterion("ty_id is not null");
            return (Criteria) this;
        }

        public Criteria andTyIdEqualTo(String value) {
            addCriterion("ty_id =", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdNotEqualTo(String value) {
            addCriterion("ty_id <>", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdGreaterThan(String value) {
            addCriterion("ty_id >", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdGreaterThanOrEqualTo(String value) {
            addCriterion("ty_id >=", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdLessThan(String value) {
            addCriterion("ty_id <", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdLessThanOrEqualTo(String value) {
            addCriterion("ty_id <=", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdLike(String value) {
            addCriterion("ty_id like", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdNotLike(String value) {
            addCriterion("ty_id not like", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdIn(List<String> values) {
            addCriterion("ty_id in", values, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdNotIn(List<String> values) {
            addCriterion("ty_id not in", values, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdBetween(String value1, String value2) {
            addCriterion("ty_id between", value1, value2, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdNotBetween(String value1, String value2) {
            addCriterion("ty_id not between", value1, value2, "tyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdIsNull() {
            addCriterion("umoney_id is null");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdIsNotNull() {
            addCriterion("umoney_id is not null");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdEqualTo(String value) {
            addCriterion("umoney_id =", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdNotEqualTo(String value) {
            addCriterion("umoney_id <>", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdGreaterThan(String value) {
            addCriterion("umoney_id >", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdGreaterThanOrEqualTo(String value) {
            addCriterion("umoney_id >=", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdLessThan(String value) {
            addCriterion("umoney_id <", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdLessThanOrEqualTo(String value) {
            addCriterion("umoney_id <=", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdLike(String value) {
            addCriterion("umoney_id like", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdNotLike(String value) {
            addCriterion("umoney_id not like", value, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdIn(List<String> values) {
            addCriterion("umoney_id in", values, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdNotIn(List<String> values) {
            addCriterion("umoney_id not in", values, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdBetween(String value1, String value2) {
            addCriterion("umoney_id between", value1, value2, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUmoneyIdNotBetween(String value1, String value2) {
            addCriterion("umoney_id not between", value1, value2, "umoneyId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdIsNull() {
            addCriterion("utype_id is null");
            return (Criteria) this;
        }

        public Criteria andUtypeIdIsNotNull() {
            addCriterion("utype_id is not null");
            return (Criteria) this;
        }

        public Criteria andUtypeIdEqualTo(String value) {
            addCriterion("utype_id =", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotEqualTo(String value) {
            addCriterion("utype_id <>", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdGreaterThan(String value) {
            addCriterion("utype_id >", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("utype_id >=", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdLessThan(String value) {
            addCriterion("utype_id <", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdLessThanOrEqualTo(String value) {
            addCriterion("utype_id <=", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdLike(String value) {
            addCriterion("utype_id like", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotLike(String value) {
            addCriterion("utype_id not like", value, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdIn(List<String> values) {
            addCriterion("utype_id in", values, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotIn(List<String> values) {
            addCriterion("utype_id not in", values, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdBetween(String value1, String value2) {
            addCriterion("utype_id between", value1, value2, "utypeId");
            return (Criteria) this;
        }

        public Criteria andUtypeIdNotBetween(String value1, String value2) {
            addCriterion("utype_id not between", value1, value2, "utypeId");
            return (Criteria) this;
        }

        public Criteria andEgidIdIsNull() {
            addCriterion("egid_id is null");
            return (Criteria) this;
        }

        public Criteria andEgidIdIsNotNull() {
            addCriterion("egid_id is not null");
            return (Criteria) this;
        }

        public Criteria andEgidIdEqualTo(String value) {
            addCriterion("egid_id =", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdNotEqualTo(String value) {
            addCriterion("egid_id <>", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdGreaterThan(String value) {
            addCriterion("egid_id >", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdGreaterThanOrEqualTo(String value) {
            addCriterion("egid_id >=", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdLessThan(String value) {
            addCriterion("egid_id <", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdLessThanOrEqualTo(String value) {
            addCriterion("egid_id <=", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdLike(String value) {
            addCriterion("egid_id like", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdNotLike(String value) {
            addCriterion("egid_id not like", value, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdIn(List<String> values) {
            addCriterion("egid_id in", values, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdNotIn(List<String> values) {
            addCriterion("egid_id not in", values, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdBetween(String value1, String value2) {
            addCriterion("egid_id between", value1, value2, "egidId");
            return (Criteria) this;
        }

        public Criteria andEgidIdNotBetween(String value1, String value2) {
            addCriterion("egid_id not between", value1, value2, "egidId");
            return (Criteria) this;
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

        public Criteria andMemberidIsNull() {
            addCriterion("memberid is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(String value) {
            addCriterion("memberid =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(String value) {
            addCriterion("memberid <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(String value) {
            addCriterion("memberid >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("memberid >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(String value) {
            addCriterion("memberid <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(String value) {
            addCriterion("memberid <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLike(String value) {
            addCriterion("memberid like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotLike(String value) {
            addCriterion("memberid not like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<String> values) {
            addCriterion("memberid in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<String> values) {
            addCriterion("memberid not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(String value1, String value2) {
            addCriterion("memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(String value1, String value2) {
            addCriterion("memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumIsNull() {
            addCriterion("creditrd_num is null");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumIsNotNull() {
            addCriterion("creditrd_num is not null");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumEqualTo(Integer value) {
            addCriterion("creditrd_num =", value, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumNotEqualTo(Integer value) {
            addCriterion("creditrd_num <>", value, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumGreaterThan(Integer value) {
            addCriterion("creditrd_num >", value, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("creditrd_num >=", value, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumLessThan(Integer value) {
            addCriterion("creditrd_num <", value, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumLessThanOrEqualTo(Integer value) {
            addCriterion("creditrd_num <=", value, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumIn(List<Integer> values) {
            addCriterion("creditrd_num in", values, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumNotIn(List<Integer> values) {
            addCriterion("creditrd_num not in", values, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumBetween(Integer value1, Integer value2) {
            addCriterion("creditrd_num between", value1, value2, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andCreditrdNumNotBetween(Integer value1, Integer value2) {
            addCriterion("creditrd_num not between", value1, value2, "creditrdNum");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidIsNull() {
            addCriterion("userReferee_uid is null");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidIsNotNull() {
            addCriterion("userReferee_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidEqualTo(String value) {
            addCriterion("userReferee_uid =", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidNotEqualTo(String value) {
            addCriterion("userReferee_uid <>", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidGreaterThan(String value) {
            addCriterion("userReferee_uid >", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidGreaterThanOrEqualTo(String value) {
            addCriterion("userReferee_uid >=", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidLessThan(String value) {
            addCriterion("userReferee_uid <", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidLessThanOrEqualTo(String value) {
            addCriterion("userReferee_uid <=", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidLike(String value) {
            addCriterion("userReferee_uid like", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidNotLike(String value) {
            addCriterion("userReferee_uid not like", value, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidIn(List<String> values) {
            addCriterion("userReferee_uid in", values, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidNotIn(List<String> values) {
            addCriterion("userReferee_uid not in", values, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidBetween(String value1, String value2) {
            addCriterion("userReferee_uid between", value1, value2, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUserrefereeUidNotBetween(String value1, String value2) {
            addCriterion("userReferee_uid not between", value1, value2, "userrefereeUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidIsNull() {
            addCriterion("userManager_uid is null");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidIsNotNull() {
            addCriterion("userManager_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidEqualTo(String value) {
            addCriterion("userManager_uid =", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidNotEqualTo(String value) {
            addCriterion("userManager_uid <>", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidGreaterThan(String value) {
            addCriterion("userManager_uid >", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidGreaterThanOrEqualTo(String value) {
            addCriterion("userManager_uid >=", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidLessThan(String value) {
            addCriterion("userManager_uid <", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidLessThanOrEqualTo(String value) {
            addCriterion("userManager_uid <=", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidLike(String value) {
            addCriterion("userManager_uid like", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidNotLike(String value) {
            addCriterion("userManager_uid not like", value, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidIn(List<String> values) {
            addCriterion("userManager_uid in", values, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidNotIn(List<String> values) {
            addCriterion("userManager_uid not in", values, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidBetween(String value1, String value2) {
            addCriterion("userManager_uid between", value1, value2, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andUsermanagerUidNotBetween(String value1, String value2) {
            addCriterion("userManager_uid not between", value1, value2, "usermanagerUid");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontIsNull() {
            addCriterion("introduction_idfront is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontIsNotNull() {
            addCriterion("introduction_idfront is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontEqualTo(String value) {
            addCriterion("introduction_idfront =", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontNotEqualTo(String value) {
            addCriterion("introduction_idfront <>", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontGreaterThan(String value) {
            addCriterion("introduction_idfront >", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontGreaterThanOrEqualTo(String value) {
            addCriterion("introduction_idfront >=", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontLessThan(String value) {
            addCriterion("introduction_idfront <", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontLessThanOrEqualTo(String value) {
            addCriterion("introduction_idfront <=", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontLike(String value) {
            addCriterion("introduction_idfront like", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontNotLike(String value) {
            addCriterion("introduction_idfront not like", value, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontIn(List<String> values) {
            addCriterion("introduction_idfront in", values, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontNotIn(List<String> values) {
            addCriterion("introduction_idfront not in", values, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontBetween(String value1, String value2) {
            addCriterion("introduction_idfront between", value1, value2, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdfrontNotBetween(String value1, String value2) {
            addCriterion("introduction_idfront not between", value1, value2, "introductionIdfront");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackIsNull() {
            addCriterion("introduction_idback is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackIsNotNull() {
            addCriterion("introduction_idback is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackEqualTo(String value) {
            addCriterion("introduction_idback =", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackNotEqualTo(String value) {
            addCriterion("introduction_idback <>", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackGreaterThan(String value) {
            addCriterion("introduction_idback >", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackGreaterThanOrEqualTo(String value) {
            addCriterion("introduction_idback >=", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackLessThan(String value) {
            addCriterion("introduction_idback <", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackLessThanOrEqualTo(String value) {
            addCriterion("introduction_idback <=", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackLike(String value) {
            addCriterion("introduction_idback like", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackNotLike(String value) {
            addCriterion("introduction_idback not like", value, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackIn(List<String> values) {
            addCriterion("introduction_idback in", values, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackNotIn(List<String> values) {
            addCriterion("introduction_idback not in", values, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackBetween(String value1, String value2) {
            addCriterion("introduction_idback between", value1, value2, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionIdbackNotBetween(String value1, String value2) {
            addCriterion("introduction_idback not between", value1, value2, "introductionIdback");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseIsNull() {
            addCriterion("introduction_license is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseIsNotNull() {
            addCriterion("introduction_license is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseEqualTo(String value) {
            addCriterion("introduction_license =", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseNotEqualTo(String value) {
            addCriterion("introduction_license <>", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseGreaterThan(String value) {
            addCriterion("introduction_license >", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("introduction_license >=", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseLessThan(String value) {
            addCriterion("introduction_license <", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseLessThanOrEqualTo(String value) {
            addCriterion("introduction_license <=", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseLike(String value) {
            addCriterion("introduction_license like", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseNotLike(String value) {
            addCriterion("introduction_license not like", value, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseIn(List<String> values) {
            addCriterion("introduction_license in", values, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseNotIn(List<String> values) {
            addCriterion("introduction_license not in", values, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseBetween(String value1, String value2) {
            addCriterion("introduction_license between", value1, value2, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andIntroductionLicenseNotBetween(String value1, String value2) {
            addCriterion("introduction_license not between", value1, value2, "introductionLicense");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayIsNull() {
            addCriterion("pubactivities_ispay is null");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayIsNotNull() {
            addCriterion("pubactivities_ispay is not null");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayEqualTo(Integer value) {
            addCriterion("pubactivities_ispay =", value, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayNotEqualTo(Integer value) {
            addCriterion("pubactivities_ispay <>", value, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayGreaterThan(Integer value) {
            addCriterion("pubactivities_ispay >", value, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pubactivities_ispay >=", value, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayLessThan(Integer value) {
            addCriterion("pubactivities_ispay <", value, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayLessThanOrEqualTo(Integer value) {
            addCriterion("pubactivities_ispay <=", value, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayIn(List<Integer> values) {
            addCriterion("pubactivities_ispay in", values, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayNotIn(List<Integer> values) {
            addCriterion("pubactivities_ispay not in", values, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayBetween(Integer value1, Integer value2) {
            addCriterion("pubactivities_ispay between", value1, value2, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andPubactivitiesIspayNotBetween(Integer value1, Integer value2) {
            addCriterion("pubactivities_ispay not between", value1, value2, "pubactivitiesIspay");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationIsNull() {
            addCriterion("user_isactivation is null");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationIsNotNull() {
            addCriterion("user_isactivation is not null");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationEqualTo(Integer value) {
            addCriterion("user_isactivation =", value, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationNotEqualTo(Integer value) {
            addCriterion("user_isactivation <>", value, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationGreaterThan(Integer value) {
            addCriterion("user_isactivation >", value, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_isactivation >=", value, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationLessThan(Integer value) {
            addCriterion("user_isactivation <", value, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationLessThanOrEqualTo(Integer value) {
            addCriterion("user_isactivation <=", value, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationIn(List<Integer> values) {
            addCriterion("user_isactivation in", values, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationNotIn(List<Integer> values) {
            addCriterion("user_isactivation not in", values, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationBetween(Integer value1, Integer value2) {
            addCriterion("user_isactivation between", value1, value2, "userIsactivation");
            return (Criteria) this;
        }

        public Criteria andUserIsactivationNotBetween(Integer value1, Integer value2) {
            addCriterion("user_isactivation not between", value1, value2, "userIsactivation");
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

        public Criteria andMemberDaysIsNull() {
            addCriterion("member_days is null");
            return (Criteria) this;
        }

        public Criteria andMemberDaysIsNotNull() {
            addCriterion("member_days is not null");
            return (Criteria) this;
        }

        public Criteria andMemberDaysEqualTo(Integer value) {
            addCriterion("member_days =", value, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysNotEqualTo(Integer value) {
            addCriterion("member_days <>", value, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysGreaterThan(Integer value) {
            addCriterion("member_days >", value, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_days >=", value, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysLessThan(Integer value) {
            addCriterion("member_days <", value, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysLessThanOrEqualTo(Integer value) {
            addCriterion("member_days <=", value, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysIn(List<Integer> values) {
            addCriterion("member_days in", values, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysNotIn(List<Integer> values) {
            addCriterion("member_days not in", values, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysBetween(Integer value1, Integer value2) {
            addCriterion("member_days between", value1, value2, "memberDays");
            return (Criteria) this;
        }

        public Criteria andMemberDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("member_days not between", value1, value2, "memberDays");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceIsNull() {
            addCriterion("resource_strategy_isexperience is null");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceIsNotNull() {
            addCriterion("resource_strategy_isexperience is not null");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceEqualTo(Integer value) {
            addCriterion("resource_strategy_isexperience =", value, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceNotEqualTo(Integer value) {
            addCriterion("resource_strategy_isexperience <>", value, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceGreaterThan(Integer value) {
            addCriterion("resource_strategy_isexperience >", value, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_strategy_isexperience >=", value, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceLessThan(Integer value) {
            addCriterion("resource_strategy_isexperience <", value, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceLessThanOrEqualTo(Integer value) {
            addCriterion("resource_strategy_isexperience <=", value, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceIn(List<Integer> values) {
            addCriterion("resource_strategy_isexperience in", values, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceNotIn(List<Integer> values) {
            addCriterion("resource_strategy_isexperience not in", values, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceBetween(Integer value1, Integer value2) {
            addCriterion("resource_strategy_isexperience between", value1, value2, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andResourceStrategyIsexperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_strategy_isexperience not between", value1, value2, "resourceStrategyIsexperience");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeIsNull() {
            addCriterion("experience_time is null");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeIsNotNull() {
            addCriterion("experience_time is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeEqualTo(Date value) {
            addCriterionForJDBCDate("experience_time =", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("experience_time <>", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("experience_time >", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("experience_time >=", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeLessThan(Date value) {
            addCriterionForJDBCDate("experience_time <", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("experience_time <=", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeIn(List<Date> values) {
            addCriterionForJDBCDate("experience_time in", values, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("experience_time not in", values, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("experience_time between", value1, value2, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("experience_time not between", value1, value2, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdIsNull() {
            addCriterion("experienceutype_id is null");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdIsNotNull() {
            addCriterion("experienceutype_id is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdEqualTo(String value) {
            addCriterion("experienceutype_id =", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdNotEqualTo(String value) {
            addCriterion("experienceutype_id <>", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdGreaterThan(String value) {
            addCriterion("experienceutype_id >", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("experienceutype_id >=", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdLessThan(String value) {
            addCriterion("experienceutype_id <", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdLessThanOrEqualTo(String value) {
            addCriterion("experienceutype_id <=", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdLike(String value) {
            addCriterion("experienceutype_id like", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdNotLike(String value) {
            addCriterion("experienceutype_id not like", value, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdIn(List<String> values) {
            addCriterion("experienceutype_id in", values, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdNotIn(List<String> values) {
            addCriterion("experienceutype_id not in", values, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdBetween(String value1, String value2) {
            addCriterion("experienceutype_id between", value1, value2, "experienceutypeId");
            return (Criteria) this;
        }

        public Criteria andExperienceutypeIdNotBetween(String value1, String value2) {
            addCriterion("experienceutype_id not between", value1, value2, "experienceutypeId");
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