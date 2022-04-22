package edu.tjdz.blog.beans.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.blog_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.user_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.source
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.article_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.type_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer typeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.tags_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private String tagsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.recommended
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer recommended;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.reward
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer reward;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.info
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer info;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.is_comment
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer isComment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.comment_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer commentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.view_num
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer viewNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.cre_time
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Date creTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.update_time
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.published
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer published;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */

    private Users users;
    private Article article;
    private Type type;
    private List<Comment> comments;

    private List<Tag> tags;

    private static final long serialVersionUID = 1L;


    public Blog(Integer blogId, Integer userId, Integer source, Integer articleId, Integer typeId, String tagsId, Integer recommended, Integer reward, Integer info, Integer isComment, Integer commentId, Integer viewNum, Date creTime, Date updateTime, Integer published) {
        this.blogId = blogId;
        this.userId = userId;
        this.source = source;
        this.articleId = articleId;
        this.typeId = typeId;
        this.tagsId = tagsId;
        this.recommended = recommended;
        this.reward = reward;
        this.info = info;
        this.isComment = isComment;
        this.commentId = commentId;
        this.viewNum = viewNum;
        this.creTime = creTime;
        this.updateTime = updateTime;
        this.published = published;
    }
}