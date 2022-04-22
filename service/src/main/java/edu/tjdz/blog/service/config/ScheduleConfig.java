package edu.tjdz.blog.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ScheduleConfig {

    /* #============================================================
    # Configure Main Scheduler Properties
    #===========================================================

    org.quartz.scheduler.instanceName = MyClusteredScheduler
    org.quartz.scheduler.instanceId = AUTO

    #===========================================================
    # Configure ThreadPool
    #===========================================================

    org.quartz.threadPool.class = org.quartz.simpl.SimpleThreadPool
    org.quartz.threadPool.threadCount = 25
    org.quartz.threadPool.threadPriority = 5

    #===========================================================
    # Configure JobStore
    #===========================================================

    org.quartz.jobStore.misfireThreshold = 60000

    org.quartz.jobStore.class = org.quartz.impl.jdbcjobstore.JobStoreTX
    org.quartz.jobStore.driverDelegateClass = org.quartz.impl.jdbcjobstore.oracle.OracleDelegate
    org.quartz.jobStore.useProperties = false
    org.quartz.jobStore.dataSource = myDS
    org.quartz.jobStore.tablePrefix = QRTZ_

    org.quartz.jobStore.isClustered = true
    org.quartz.jobStore.clusterCheckinInterval = 20000

    #===========================================================
    # Configure Datasources
    #===========================================================

    org.quartz.dataSource.myDS.driver = oracle.jdbc.driver.OracleDriver
    org.quartz.dataSource.myDS.URL = jdbc:oracle:thin:@cluster:1521:dev
    org.quartz.dataSource.myDS.user = quartz
    org.quartz.dataSource.myDS.password = quartz
    org.quartz.dataSource.myDS.maxConnections = 5
    org.quartz.dataSource.myDS.validationQuery=select 0 from dual*/

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        Properties properties = new Properties();


        properties.put(" org.quartz.jobStore.class","org.quartz.impl.jdbcjobstore.JobStoreTX");
        schedulerFactoryBean.setQuartzProperties(properties);

        schedulerFactoryBean.setStartupDelay(4);
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setAutoStartup(true);
        return schedulerFactoryBean;


    }
}
