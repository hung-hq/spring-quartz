package com.example.spring.quartz.controller;

import com.example.spring.quartz.entity.Message;
import com.example.spring.quartz.entity.SchedulerJobInfo;
import com.example.spring.quartz.service.SchedulerJobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JobController {
    private final SchedulerJobService schedulerJobService;

    @RequestMapping(value = "/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public Object saveOrUpdate(SchedulerJobInfo job) {
        log.info("params, job = {}", job);
        Message message = Message.failure();
        try {
            schedulerJobService.saveOrUpdate(job);
            message = Message.success();
        } catch (Exception e) {
            message.setMsg(e.getMessage());
            log.error("updateCron ex:", e);
        }
        return message;
    }

    @RequestMapping("/metaData")
    public Object metaData() throws SchedulerException {
        return schedulerJobService.getMetaData();
    }

    @RequestMapping("/getAllJobs")
    public Object getAllJobs() throws SchedulerException {
        return schedulerJobService.getAllJobList();
    }

    @RequestMapping(value = "/runJob", method = { RequestMethod.GET, RequestMethod.POST })
    public Object runJob(SchedulerJobInfo job) {
        log.info("params, job = {}", job);
        Message message = Message.failure();
        try {
            schedulerJobService.startJobNow(job);
            message = Message.success();
        } catch (Exception e) {
            message.setMsg(e.getMessage());
            log.error("runJob ex:", e);
        }
        return message;
    }

    @RequestMapping(value = "/pauseJob", method = { RequestMethod.GET, RequestMethod.POST })
    public Object pauseJob(SchedulerJobInfo job) {
        log.info("params, job = {}", job);
        Message message = Message.failure();
        try {
            schedulerJobService.pauseJob(job);
            message = Message.success();
        } catch (Exception e) {
            message.setMsg(e.getMessage());
            log.error("pauseJob ex:", e);
        }
        return message;
    }

    @RequestMapping(value = "/resumeJob", method = { RequestMethod.GET, RequestMethod.POST })
    public Object resumeJob(SchedulerJobInfo job) {
        log.info("params, job = {}", job);
        Message message = Message.failure();
        try {
            schedulerJobService.resumeJob(job);
            message = Message.success();
        } catch (Exception e) {
            message.setMsg(e.getMessage());
            log.error("resumeJob ex:", e);
        }
        return message;
    }

    @RequestMapping(value = "/deleteJob", method = { RequestMethod.GET, RequestMethod.POST })
    public Object deleteJob(SchedulerJobInfo job) {
        log.info("params, job = {}", job);
        Message message = Message.failure();
        try {
            schedulerJobService.deleteJob(job);
            message = Message.success();
        } catch (Exception e) {
            message.setMsg(e.getMessage());
            log.error("deleteJob ex:", e);
        }
        return message;
    }
}
