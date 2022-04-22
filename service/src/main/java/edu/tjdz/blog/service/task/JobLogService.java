package edu.tjdz.blog.service.task;

import edu.tjdz.blog.beans.bean.JobLog;
import edu.tjdz.blog.dao.JobLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobLogService {

    @Autowired
    JobLogMapper jobLogMapper;

    public void save(JobLog jobLog){
        jobLogMapper.save(jobLog);

    }
}
