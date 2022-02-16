package com.example.spring.quartz.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "scheduler_job_info")
public class SchedulerJobInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String jobName;
    private String jobGroup;
    private String jobStatus;
    private String jobClass;
    private String cronExpression;
    private String description;
    private String interfaceName;
    private Long repeatTime;
    private Boolean cronJob;
}
