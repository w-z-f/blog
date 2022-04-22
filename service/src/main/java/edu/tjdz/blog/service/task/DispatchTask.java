package edu.tjdz.blog.service.task;


import edu.tjdz.blog.beans.bean.Blog;
import edu.tjdz.blog.beans.utils.BizAssert;
import edu.tjdz.blog.dao.BlogMapper;
import edu.tjdz.common.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.hutool.core.lang.Console.log;

@Component
@Slf4j
public class DispatchTask {

    @Resource(name="getRedisTemplate")
    RedisTemplate template;

    @Autowired
    BlogMapper blogmapper;

    public void run(String businessId,String params,String jobId,String logId){
            DispatchTask.log.info("DispatchTask执行了。。。。");
        Map entries = template.opsForHash().entries(Constant.VIEWS);

      if(!entries.isEmpty()){
          ArrayList<String> ids = new ArrayList<>();
          StringBuilder builder = new StringBuilder("(");
          entries.forEach((k,v)->{
              ids.add((String)k);
          });
          List<Blog> list = blogmapper.listBlogByBlogId(ids);
       if (list != null && !list.isEmpty())  {
           ArrayList<Blog> arr = new ArrayList<>();
           for (Blog blog : list) {
               blog.setViewNum( blog.getViewNum()+(Integer) entries.get(blog.getBlogId().toString()));
               arr.add(blog);
           }
           blogmapper.updateBlogVeiw(arr);
           template.delete(Constant.VIEWS);
       }else {
           log("没有博客需要更新");
       }

      }
      }


}
