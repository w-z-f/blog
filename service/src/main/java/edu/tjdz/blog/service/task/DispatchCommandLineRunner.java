package edu.tjdz.blog.service.task;


import edu.tjdz.blog.beans.bean.Job;
import edu.tjdz.blog.dao.JobMapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
@Slf4j
public class DispatchCommandLineRunner implements CommandLineRunner {
    @Resource
    private Scheduler scheduler;

    @Autowired
    JobMapper jobMapper;

    @Override
    public void run(String... args) throws Exception {

        List<Job> list = jobMapper.list();
        System.out.println(list);
        for (Job job : list) {
            Trigger triggr = (Trigger) ScheduleUtils.getTriggr(scheduler, job.getId() + "");
            if (triggr != null){
            ScheduleUtils.updateJob(scheduler,job.getId(),job.getCronExpression());
            }else {
                ScheduleUtils.createJob(scheduler,job);
            }

        }


    }
}
