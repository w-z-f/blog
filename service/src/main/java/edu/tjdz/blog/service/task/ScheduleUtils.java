package edu.tjdz.blog.service.task;

import edu.tjdz.blog.beans.bean.Job;
import org.quartz.*;

public class ScheduleUtils {

    static final String JOB_PARAM_KEY ="";



        public static Trigger getTriggr(Scheduler scheduler,String triggerKey) throws SchedulerException {
            TriggerKey triggerKey1 = new TriggerKey(triggerKey);
            Trigger trigger = scheduler.getTrigger(triggerKey1);
            return trigger;
        }



        public static void createJob(Scheduler scheduler, Job job) throws SchedulerException {
            JobDetail jobDetailBuild = JobBuilder.newJob(MyJob.class).withIdentity("" + job.getId()).build();
            jobDetailBuild.getJobDataMap().put(JOB_PARAM_KEY,job);

            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression()).withMisfireHandlingInstructionDoNothing();
            Trigger Triggerbuild = TriggerBuilder.newTrigger().withIdentity(job.getId() + "").withSchedule(cronScheduleBuilder).build();

            scheduler.scheduleJob(jobDetailBuild,Triggerbuild);
        }




    public boolean resumeJob(Integer jobKey,Scheduler scheduler) {
        boolean result = true;
        try {
            scheduler.resumeJob(JobKey.jobKey(jobKey+""));
        } catch (SchedulerException e) {
            result = false;
        }
        return result;
    }


    public boolean pauseJob(Integer jobKey,Scheduler scheduler) {
        boolean result = true;
        try {
            scheduler.pauseJob(JobKey.jobKey(jobKey+""));
        } catch (SchedulerException e) {
            result = false;
        }
        return result;
    }



    public static void updateJob(Scheduler scheduler,Integer triggerKey,String cronExpression) throws SchedulerException {
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(new TriggerKey(triggerKey + ""));

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
        trigger =    trigger.getTriggerBuilder().withIdentity(triggerKey+"").withSchedule(cronScheduleBuilder).build();
        scheduler.rescheduleJob(new TriggerKey(triggerKey + ""), trigger);
    }




}
