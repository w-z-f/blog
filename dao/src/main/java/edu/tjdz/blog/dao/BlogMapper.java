package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.net.Inet4Address;
import java.util.List;

@Mapper
public interface BlogMapper<T> {

    List<Blog> listAllBlog(int start,int limit,String articleId,String typeId,Integer recommended);

    Integer countAllBlog(int start,int limit,String articleId,String typeId,Integer recommended);

    int addBlog(Blog blog);

    int deleteBlogByBlogId(Integer blogId);

    Integer getArticleIdByBlogId(Integer blogId);

    Integer updateBlogByBlogId(Blog blog);

    Blog getBlogByBlogId(Integer blogId);


    Integer updateBlogVeiw(List<Blog> blog);

    List<Blog> listBlogByBlogId(List<String> ids);
}
