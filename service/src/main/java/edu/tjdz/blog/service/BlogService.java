package edu.tjdz.blog.service;

import edu.tjdz.blog.beans.bean.Article;
import edu.tjdz.blog.beans.bean.Blog;
import edu.tjdz.common.vo.ResultVO;

import java.util.Date;

public interface BlogService {

    ResultVO listAllBlog(int page ,int limit,String title,String type,Integer recommended);

    ResultVO addBlog(String title, String content, String articleImg,
                     int userId, int source, String typeId, String tagId, int recommended,
                     int reward, int info, int isComment, int commentId, int viewNum,
                     Date creTime,Date updateTime,int published);


    ResultVO deleteBlog(Integer blogId);

    ResultVO updateBlog(Blog blog, Article article);

    ResultVO getBlog(Integer blogId);


}
