package edu.tjdz.blog.dao;


import edu.tjdz.blog.beans.bean.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {


    List<Job> list();
}
