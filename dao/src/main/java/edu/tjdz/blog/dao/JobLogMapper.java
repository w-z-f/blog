package edu.tjdz.blog.dao;


import edu.tjdz.blog.beans.bean.JobLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobLogMapper {

    Integer save(JobLog jobLog);


}
