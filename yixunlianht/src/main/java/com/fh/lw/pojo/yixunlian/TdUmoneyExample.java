package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdUmoneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdUmoneyExample() {
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

        public Criteria andAlreadyPresentedIsNull() {
            addCriterion("already_presented is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedIsNotNull() {
            addCriterion("already_presented is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedEqualTo(BigDecimal value) {
            addCriterion("already_presented =", value, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedNotEqualTo(BigDecimal value) {
            addCriterion("already_presented <>", value, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedGreaterThan(BigDecimal value) {
            addCriterion("already_presented >", value, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("already_presented >=", value, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedLessThan(BigDecimal value) {
            addCriterion("already_presented <", value, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("already_presented <=", value, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedIn(List<BigDecimal> values) {
            addCriterion("already_presented in", values, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedNotIn(List<BigDecimal> values) {
            addCriterion("already_presented not in", values, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("already_presented between", value1, value2, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andAlreadyPresentedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("already_presented not between", value1, value2, "alreadyPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedIsNull() {
            addCriterion("can_presented is null");
            return (Criteria) this;
        }

        public Criteria andCanPresentedIsNotNull() {
            addCriterion("can_presented is not null");
            return (Criteria) this;
        }

        public Criteria andCanPresentedEqualTo(BigDecimal value) {
            addCriterion("can_presented =", value, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedNotEqualTo(BigDecimal value) {
            addCriterion("can_presented <>", value, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedGreaterThan(BigDecimal value) {
            addCriterion("can_presented >", value, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("can_presented >=", value, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedLessThan(BigDecimal value) {
            addCriterion("can_presented <", value, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("can_presented <=", value, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedIn(List<BigDecimal> values) {
            addCriterion("can_presented in", values, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedNotIn(List<BigDecimal> values) {
            addCriterion("can_presented not in", values, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("can_presented between", value1, value2, "canPresented");
            return (Criteria) this;
        }

        public Criteria andCanPresentedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("can_presented not between", value1, value2, "canPresented");
            return (Criteria) this;
        }

        public Criteria andToRaisedIsNull() {
            addCriterion("to_raised is null");
            return (Criteria) this;
        }

        public Criteria andToRaisedIsNotNull() {
            addCriterion("to_raised is not null");
            return (Criteria) this;
        }

        public Criteria andToRaisedEqualTo(BigDecimal value) {
            addCriterion("to_raised =", value, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedNotEqualTo(BigDecimal value) {
            addCriterion("to_raised <>", value, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedGreaterThan(BigDecimal value) {
            addCriterion("to_raised >", value, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("to_raised >=", value, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedLessThan(BigDecimal value) {
            addCriterion("to_raised <", value, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("to_raised <=", value, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedIn(List<BigDecimal> values) {
            addCriterion("to_raised in", values, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedNotIn(List<BigDecimal> values) {
            addCriterion("to_raised not in", values, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("to_raised between", value1, value2, "toRaised");
            return (Criteria) this;
        }

        public Criteria andToRaisedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("to_raised not between", value1, value2, "toRaised");
            return (Criteria) this;
        }

        public Criteria andPayTaxesIsNull() {
            addCriterion("pay_taxes is null");
            return (Criteria) this;
        }

        public Criteria andPayTaxesIsNotNull() {
            addCriterion("pay_taxes is not null");
            return (Criteria) this;
        }

        public Criteria andPayTaxesEqualTo(BigDecimal value) {
            addCriterion("pay_taxes =", value, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesNotEqualTo(BigDecimal value) {
            addCriterion("pay_taxes <>", value, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesGreaterThan(BigDecimal value) {
            addCriterion("pay_taxes >", value, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_taxes >=", value, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesLessThan(BigDecimal value) {
            addCriterion("pay_taxes <", value, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_taxes <=", value, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesIn(List<BigDecimal> values) {
            addCriterion("pay_taxes in", values, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesNotIn(List<BigDecimal> values) {
            addCriterion("pay_taxes not in", values, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_taxes between", value1, value2, "payTaxes");
            return (Criteria) this;
        }

        public Criteria andPayTaxesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_taxes not between", value1, value2, "payTaxes");
            return (Criteria) this;
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

        public Criteria andPutMoneyIsNull() {
            addCriterion("put_money is null");
            return (Criteria) this;
        }

        public Criteria andPutMoneyIsNotNull() {
            addCriterion("put_money is not null");
            return (Criteria) this;
        }

        public Criteria andPutMoneyEqualTo(BigDecimal value) {
            addCriterion("put_money =", value, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyNotEqualTo(BigDecimal value) {
            addCriterion("put_money <>", value, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyGreaterThan(BigDecimal value) {
            addCriterion("put_money >", value, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("put_money >=", value, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyLessThan(BigDecimal value) {
            addCriterion("put_money <", value, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("put_money <=", value, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyIn(List<BigDecimal> values) {
            addCriterion("put_money in", values, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyNotIn(List<BigDecimal> values) {
            addCriterion("put_money not in", values, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("put_money between", value1, value2, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("put_money not between", value1, value2, "putMoney");
            return (Criteria) this;
        }

        public Criteria andPutTimeIsNull() {
            addCriterion("put_time is null");
            return (Criteria) this;
        }

        public Criteria andPutTimeIsNotNull() {
            addCriterion("put_time is not null");
            return (Criteria) this;
        }

        public Criteria andPutTimeEqualTo(Date value) {
            addCriterion("put_time =", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeNotEqualTo(Date value) {
            addCriterion("put_time <>", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeGreaterThan(Date value) {
            addCriterion("put_time >", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("put_time >=", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeLessThan(Date value) {
            addCriterion("put_time <", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeLessThanOrEqualTo(Date value) {
            addCriterion("put_time <=", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeIn(List<Date> values) {
            addCriterion("put_time in", values, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeNotIn(List<Date> values) {
            addCriterion("put_time not in", values, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeBetween(Date value1, Date value2) {
            addCriterion("put_time between", value1, value2, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeNotBetween(Date value1, Date value2) {
            addCriterion("put_time not between", value1, value2, "putTime");
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

        public Criteria andActualarrivalAmountIsNull() {
            addCriterion("actualarrival_amount is null");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountIsNotNull() {
            addCriterion("actualarrival_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountEqualTo(BigDecimal value) {
            addCriterion("actualarrival_amount =", value, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountNotEqualTo(BigDecimal value) {
            addCriterion("actualarrival_amount <>", value, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountGreaterThan(BigDecimal value) {
            addCriterion("actualarrival_amount >", value, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actualarrival_amount >=", value, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountLessThan(BigDecimal value) {
            addCriterion("actualarrival_amount <", value, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actualarrival_amount <=", value, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountIn(List<BigDecimal> values) {
            addCriterion("actualarrival_amount in", values, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountNotIn(List<BigDecimal> values) {
            addCriterion("actualarrival_amount not in", values, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actualarrival_amount between", value1, value2, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andActualarrivalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actualarrival_amount not between", value1, value2, "actualarrivalAmount");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdIsNull() {
            addCriterion("taxrevenue_id is null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdIsNotNull() {
            addCriterion("taxrevenue_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdEqualTo(String value) {
            addCriterion("taxrevenue_id =", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotEqualTo(String value) {
            addCriterion("taxrevenue_id <>", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdGreaterThan(String value) {
            addCriterion("taxrevenue_id >", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdGreaterThanOrEqualTo(String value) {
            addCriterion("taxrevenue_id >=", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdLessThan(String value) {
            addCriterion("taxrevenue_id <", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdLessThanOrEqualTo(String value) {
            addCriterion("taxrevenue_id <=", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdLike(String value) {
            addCriterion("taxrevenue_id like", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotLike(String value) {
            addCriterion("taxrevenue_id not like", value, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdIn(List<String> values) {
            addCriterion("taxrevenue_id in", values, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotIn(List<String> values) {
            addCriterion("taxrevenue_id not in", values, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdBetween(String value1, String value2) {
            addCriterion("taxrevenue_id between", value1, value2, "taxrevenueId");
            return (Criteria) this;
        }

        public Criteria andTaxrevenueIdNotBetween(String value1, String value2) {
            addCriterion("taxrevenue_id not between", value1, value2, "taxrevenueId");
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