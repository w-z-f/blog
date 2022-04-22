package edu.tjdz.blog.service.sensitive;

import com.github.houbb.sensitive.word.api.IWordDeny;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyWordDeny implements IWordDeny {

    @Override
    public List<String> deny() {
        List<String> list =    new ArrayList<String>();
        try {

            String path = ResourceUtils.getURL("classpath:").getPath();
            BufferedReader read = new BufferedReader(new FileReader(path + "edu/tjdz/blog/service/sensitive/pornographic.txt"));
            String line;
            while ((line =read.readLine()) !=null){
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
