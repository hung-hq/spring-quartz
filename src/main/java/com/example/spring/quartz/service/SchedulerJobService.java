package com.example.spring.quartz.service;

import com.example.spring.quartz.entity.SchedulerJobInfo;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;

import java.util.List;

public interface SchedulerJobService {
    SchedulerMetaData getMetaData() throws SchedulerException;

    List<SchedulerJobInfo> getAllJobList();

    boolean deleteJob(SchedulerJobInfo jobInfo);

    boolean pauseJob(SchedulerJobInfo jobInfo);

    boolean resumeJob(SchedulerJobInfo jobInfo);

    boolean startJobNow(SchedulerJobInfo jobInfo);

    void saveOrUpdate(SchedulerJobInfo scheduleJob) throws Exception;
}
