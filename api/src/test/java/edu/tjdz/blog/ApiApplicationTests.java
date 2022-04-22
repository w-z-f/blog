package edu.tjdz.blog;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import edu.tjdz.blog.dao.BlogMapper;
import edu.tjdz.blog.dao.UsersMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

    @Autowired
    private SensitiveWordBs sensitiveWordBs;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    BlogMapper blogMapper;

    @Test
    void contextLoads() {
        String title = "";
        String type = "";


        if ( (title != null && !"".equals(title)) &&  (type != null && !"".equals(type))){
            System.out.println(111111);


            /*if ((titleId == null || "".equals(titleId)) && (typeId == null || "".equals(typeId))){
                System.out.println(2222222);
                PagerHelp pagerHelp = null;
                return new ResultVO(Code.SUCCESS,"没有查询结果",pagerHelp);
            }*/
        }

    }

    @Test
    void getBlogByBlogId(){
        HashMap map = new HashMap();
       map.put(1,1);
       map.put(2,2);

        System.out.println(map.get(1));
    }

}
