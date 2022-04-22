package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

   List<Comment> listCommentByArticleId(Integer articleId);

   List<Comment> listChildCommentByParentId(Integer parent_id);

   Integer addComment(Comment comment);

   Comment getCommentByCommentId(Integer commentId);

   int delCommentByCommentId(Integer commentId);


}
