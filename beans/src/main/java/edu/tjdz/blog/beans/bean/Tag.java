package edu.tjdz.blog.beans.bean;

import java.io.Serializable;

public class Tag implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.tag_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private Integer tagId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.tag
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private String tag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tag
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public Tag(Integer tagId, String tag) {
        this.tagId = tagId;
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public Tag() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.tag_id
     *
     * @return the value of tag.tag_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.tag_id
     *
     * @param tagId the value for tag.tag_id
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.tag
     *
     * @return the value of tag.tag
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.tag
     *
     * @param tag the value for tag.tag
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Thu Nov 25 14:17:15 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", tag=").append(tag);
        sb.append("]");
        return sb.toString();
    }
}