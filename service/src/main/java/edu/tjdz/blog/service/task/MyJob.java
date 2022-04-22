package edu.tjdz.blog.service.task;

import edu.tjdz.blog.beans.bean.Job;
import edu.tjdz.blog.beans.bean.JobLog;
import edu.tjdz.blog.dao.JobLogMapper;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Random;

public class MyJob extends QuartzJobBean {




    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        long start = System.currentTimeMillis();
        Job job = (Job) context.getMergedJobDataMap().get(ScheduleUtils.JOB_PARAM_KEY);

        JobLog jobLog = new JobLog();
        jobLog.setId(new Random().nextInt());
        jobLog.setJobId(job.getId());
        jobLog.setBeanName(job.getBeanName());
        jobLog.setParams(job.getParams());
        jobLog.setCreateTime(LocalDateTime.now());

        try{

            Object target = SpringContextUtils.getBean(job.getBeanName());
            Method run = target.getClass().getMethod("run", String.class, String.class, String.class, String.class);
            run.invoke(target,job.getBusinessId()+"",job.getParams(),job.getId()+"",jobLog.getId()+"");


            jobLog.setStatus(1);
        }catch (Exception e){
            e.printStackTrace();
            jobLog.setStatus(0);
            jobLog.setError(e.getMessage());

        }finally {
            int times = (int)(System.currentTimeMillis() - start);
            jobLog.setTimes(times);

            JobLogMapper jobLogMapper = (JobLogMapper) SpringContextUtils.getBean("jobLogMapper");
            jobLogMapper.save(jobLog);


        }





    }
}
