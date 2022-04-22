package edu.tjdz.blog.service.impl;

import edu.tjdz.blog.beans.bean.Article;
import edu.tjdz.blog.beans.bean.Blog;
import edu.tjdz.blog.beans.bean.Tag;
import edu.tjdz.blog.beans.bean.Type;
import edu.tjdz.blog.beans.utils.BizAssert;
import edu.tjdz.blog.dao.ArticleMapper;
import edu.tjdz.blog.dao.BlogMapper;
import edu.tjdz.blog.dao.TagMapper;
import edu.tjdz.blog.dao.TypeMapper;
import edu.tjdz.blog.service.BlogService;
import edu.tjdz.common.constant.Constant;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.PagerHelp;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    TagMapper tagMapper;

    @Resource(name="getRedisTemplate")
    RedisTemplate template;

    @Override
    public ResultVO listAllBlog(int page, int limit,String title,String type,Integer recommended) {
        System.out.println(recommended);
        System.out.println("page:"+page+"limit:"+limit);

        String titleId = null;
        String typeId = null;

        if(title != null && title != ""){
            StringBuffer stringBuffer = new StringBuffer();
            List<Integer> list = articleMapper.listArticleIdByLikeTitle(title);
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                if( i != list.size()-1 ){
                    stringBuffer.append(list.get(i)+",");
                }else {
                    stringBuffer.append(list.get(i));
                }
            }
            titleId =  stringBuffer.toString();
        }

        if(type != null && type != ""){
            StringBuffer stringBuffer = new StringBuffer();
            List<Integer> list = typeMapper.listTypeIdByType(type);
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                if( i != list.size()-1 ){
                    stringBuffer.append(list.get(i)+",");
                }else {
                    stringBuffer.append(list.get(i));
                }
            }
            typeId =  stringBuffer.toString();
        }

        if ( (title != null && !"".equals(title)) && (type != null && !"".equals(type))){
            System.out.println(111111);
            if ((titleId == null || "".equals(titleId)) || (typeId == null || "".equals(typeId))){
                System.out.println(2222222);
                PagerHelp pagerHelp = new PagerHelp(0,null);
                return new ResultVO(Code.SUCCESS,"没有查询结果",pagerHelp);
            }
        }else if((title != null && !"".equals(title)) || (type != null && !"".equals(type))){
            if ((titleId == null || "".equals(titleId)) && (typeId == null || "".equals(typeId))){
                PagerHelp pagerHelp = new PagerHelp(0,null);
                return new ResultVO(Code.SUCCESS,"没有查询结果",pagerHelp);
            }
        }


        int start = (page-1)*limit;
        System.out.println("start:"+start+"limit:"+limit);
        Integer totalCount = blogMapper.countAllBlog(start, limit,titleId,typeId,recommended);
        System.out.println(totalCount);
        List<Blog> articles = blogMapper.listAllBlog(start, limit,titleId,typeId,recommended);
        System.out.println(articles);
        PagerHelp pagerHelp = new PagerHelp(totalCount, articles);
        return new ResultVO(Code.SUCCESS,"",pagerHelp);
    }

    @Override
    public ResultVO addBlog(String title, String content, String articleImg,
                            int userId, int source, String type, String tags,
                            int recommended, int reward, int info, int isComment,
                            int commentId, int viewNum, Date creTime, Date updateTime, int published) {

        Article article = new Article(0, title, articleImg, content);
        articleMapper.addArticle(article);

        Type getType = typeMapper.getTypeByType(type);
        Integer typeId;
        if(getType == null){
          Type addType = new Type(0,type);
          typeMapper.addType(addType);
       typeId = addType.getTypeId();
        }else {
           typeId = getType.getTypeId();
        }

       /*Tag getTag = tagMapper.getTagByTag(tags);
        Integer tagId;
        if(getTag == null){
          Tag addTag =  new Tag(0,tags);
            tagMapper.addTag(addTag);
            tagId = addTag.getTagId();
        }else {
            tagId = getTag.getTagId();
        }*/
        String tagId="";
       tags = tags.replaceAll("[\"]","");
        String[] tagArr = tags.substring(1, tags.length() - 1).split(",");
        List<Tag> tagObjList = tagMapper.listTag();
        ArrayList<String> tagList = new ArrayList<>();
        for (Tag tag : tagObjList) {
            tagList.add(tag.getTag());
        }
        /*for (String tag : tagArr) {
            boolean isContain = tagList.contains(tag);
            if (isContain){
               tagId += tagMapper.getTagByTag(tag).getTagId()+",";


            }else {
               tagId = tagMapper.addTag(new Tag(0, tag))+"";
            }

        }*/
        for (int i = 0; i < tagArr.length; i++) {
            boolean isContain = tagList.contains(tagArr[i]);
            if (isContain){
                 if (i == tagArr.length-1){
                     tagId += tagMapper.getTagByTag(tagArr[i]).getTagId()+"";
                 }else {
                     tagId += tagMapper.getTagByTag(tagArr[i]).getTagId()+",";
                 }
            }else {
                Tag tag = new Tag(0, tagArr[i]);
                if (i == tagArr.length-1){
                    tagMapper.addTag(tag);
                    tagId += tag.getTagId()+"";
                }else {
                    tagMapper.addTag(tag);
                    tagId +=tag.getTagId()+",";
                }

            }

        }



        Blog blog = new Blog(0, userId, source, article.getArticleId(),
                typeId, tagId, recommended, reward, info, isComment, commentId, viewNum,
                creTime, updateTime, published);
        int i = blogMapper.addBlog(blog);
        ResultVO resultVO;
        if(i==1){
            resultVO = new ResultVO(Code.SUCCESS,"成功",null);
            return resultVO;
        }
        return resultVO = new ResultVO(Code.Fail,"失败",null);
    }

    @Override
    public ResultVO deleteBlog(Integer blogId) {
        Integer articleId = blogMapper.getArticleIdByBlogId(blogId);
        blogMapper.deleteBlogByBlogId(blogId);
        articleMapper.deleteArticleByArticleId(articleId);
        return new ResultVO(Code.SUCCESS,"",null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO getBlog(Integer blogId) {
        BizAssert.isTrue(blogId != null && blogId >0);
        Blog blog = blogMapper.getBlogByBlogId(blogId);
        BizAssert.notNull(blog);
        template.opsForHash().increment(Constant.VIEWS,""+blogId,1);
        return new ResultVO(Code.SUCCESS,"",blog);
    }

    @Override
    public ResultVO updateBlog(Blog blog, Article article) {
        blogMapper.updateBlogByBlogId(blog);
        articleMapper.updateArticleByArticleId(article);
        return new ResultVO(Code.SUCCESS,"",null);
    }
}

