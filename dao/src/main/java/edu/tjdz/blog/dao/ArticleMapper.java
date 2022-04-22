package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    int addArticle(Article article);

    List<Integer> listArticleIdByLikeTitle(String title);

    Article getArticleByArticleId(Integer article_id);

    int deleteArticleByArticleId(Integer articleId);

    Integer updateArticleByArticleId(Article article);
}
