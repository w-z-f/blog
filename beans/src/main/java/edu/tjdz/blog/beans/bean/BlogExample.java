package edu.tjdz.blog.beans.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public BlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
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

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTagsIdIsNull() {
            addCriterion("tags_id is null");
            return (Criteria) this;
        }

        public Criteria andTagsIdIsNotNull() {
            addCriterion("tags_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagsIdEqualTo(Integer value) {
            addCriterion("tags_id =", value, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdNotEqualTo(Integer value) {
            addCriterion("tags_id <>", value, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdGreaterThan(Integer value) {
            addCriterion("tags_id >", value, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tags_id >=", value, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdLessThan(Integer value) {
            addCriterion("tags_id <", value, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdLessThanOrEqualTo(Integer value) {
            addCriterion("tags_id <=", value, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdIn(List<Integer> values) {
            addCriterion("tags_id in", values, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdNotIn(List<Integer> values) {
            addCriterion("tags_id not in", values, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdBetween(Integer value1, Integer value2) {
            addCriterion("tags_id between", value1, value2, "tagsId");
            return (Criteria) this;
        }

        public Criteria andTagsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tags_id not between", value1, value2, "tagsId");
            return (Criteria) this;
        }

        public Criteria andRecommendedIsNull() {
            addCriterion("recommended is null");
            return (Criteria) this;
        }

        public Criteria andRecommendedIsNotNull() {
            addCriterion("recommended is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendedEqualTo(Integer value) {
            addCriterion("recommended =", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotEqualTo(Integer value) {
            addCriterion("recommended <>", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedGreaterThan(Integer value) {
            addCriterion("recommended >", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommended >=", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedLessThan(Integer value) {
            addCriterion("recommended <", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedLessThanOrEqualTo(Integer value) {
            addCriterion("recommended <=", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedIn(List<Integer> values) {
            addCriterion("recommended in", values, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotIn(List<Integer> values) {
            addCriterion("recommended not in", values, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedBetween(Integer value1, Integer value2) {
            addCriterion("recommended between", value1, value2, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotBetween(Integer value1, Integer value2) {
            addCriterion("recommended not between", value1, value2, "recommended");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(Integer value) {
            addCriterion("reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(Integer value) {
            addCriterion("reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(Integer value) {
            addCriterion("reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(Integer value) {
            addCriterion("reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(Integer value) {
            addCriterion("reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(List<Integer> values) {
            addCriterion("reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(List<Integer> values) {
            addCriterion("reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(Integer value1, Integer value2) {
            addCriterion("reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(Integer value1, Integer value2) {
            addCriterion("reward not between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(Integer value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(Integer value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(Integer value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(Integer value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(Integer value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<Integer> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<Integer> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(Integer value1, Integer value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("info not between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNull() {
            addCriterion("is_comment is null");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNotNull() {
            addCriterion("is_comment is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommentEqualTo(Integer value) {
            addCriterion("is_comment =", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotEqualTo(Integer value) {
            addCriterion("is_comment <>", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThan(Integer value) {
            addCriterion("is_comment >", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_comment >=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThan(Integer value) {
            addCriterion("is_comment <", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThanOrEqualTo(Integer value) {
            addCriterion("is_comment <=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentIn(List<Integer> values) {
            addCriterion("is_comment in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotIn(List<Integer> values) {
            addCriterion("is_comment not in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentBetween(Integer value1, Integer value2) {
            addCriterion("is_comment between", value1, value2, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_comment not between", value1, value2, "isComment");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andViewNumIsNull() {
            addCriterion("view_num is null");
            return (Criteria) this;
        }

        public Criteria andViewNumIsNotNull() {
            addCriterion("view_num is not null");
            return (Criteria) this;
        }

        public Criteria andViewNumEqualTo(Integer value) {
            addCriterion("view_num =", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotEqualTo(Integer value) {
            addCriterion("view_num <>", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThan(Integer value) {
            addCriterion("view_num >", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_num >=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThan(Integer value) {
            addCriterion("view_num <", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThanOrEqualTo(Integer value) {
            addCriterion("view_num <=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumIn(List<Integer> values) {
            addCriterion("view_num in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotIn(List<Integer> values) {
            addCriterion("view_num not in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumBetween(Integer value1, Integer value2) {
            addCriterion("view_num between", value1, value2, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotBetween(Integer value1, Integer value2) {
            addCriterion("view_num not between", value1, value2, "viewNum");
            return (Criteria) this;
        }

        public Criteria andCreTimeIsNull() {
            addCriterion("cre_time is null");
            return (Criteria) this;
        }

        public Criteria andCreTimeIsNotNull() {
            addCriterion("cre_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreTimeEqualTo(Date value) {
            addCriterion("cre_time =", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotEqualTo(Date value) {
            addCriterion("cre_time <>", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeGreaterThan(Date value) {
            addCriterion("cre_time >", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cre_time >=", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeLessThan(Date value) {
            addCriterion("cre_time <", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeLessThanOrEqualTo(Date value) {
            addCriterion("cre_time <=", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeIn(List<Date> values) {
            addCriterion("cre_time in", values, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotIn(List<Date> values) {
            addCriterion("cre_time not in", values, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeBetween(Date value1, Date value2) {
            addCriterion("cre_time between", value1, value2, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotBetween(Date value1, Date value2) {
            addCriterion("cre_time not between", value1, value2, "creTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPublishedIsNull() {
            addCriterion("published is null");
            return (Criteria) this;
        }

        public Criteria andPublishedIsNotNull() {
            addCriterion("published is not null");
            return (Criteria) this;
        }

        public Criteria andPublishedEqualTo(Integer value) {
            addCriterion("published =", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedNotEqualTo(Integer value) {
            addCriterion("published <>", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedGreaterThan(Integer value) {
            addCriterion("published >", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("published >=", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedLessThan(Integer value) {
            addCriterion("published <", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedLessThanOrEqualTo(Integer value) {
            addCriterion("published <=", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedIn(List<Integer> values) {
            addCriterion("published in", values, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedNotIn(List<Integer> values) {
            addCriterion("published not in", values, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedBetween(Integer value1, Integer value2) {
            addCriterion("published between", value1, value2, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedNotBetween(Integer value1, Integer value2) {
            addCriterion("published not between", value1, value2, "published");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated do_not_delete_during_merge Thu Nov 25 14:17:15 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
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