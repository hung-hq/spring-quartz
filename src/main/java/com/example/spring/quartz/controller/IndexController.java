package com.example.spring.quartz.controller;

import com.example.spring.quartz.entity.SchedulerJobInfo;
import com.example.spring.quartz.service.SchedulerJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    private SchedulerJobService schedulerJobService;

    @GetMapping("/index")
    public String index(Model model) {
        List<SchedulerJobInfo> jobList = schedulerJobService.getAllJobList();
        model.addAttribute("jobs", jobList);
        return "index";
    }

    @Autowired
    public void setSchedulerJobService(SchedulerJobService schedulerJobService) {
        this.schedulerJobService = schedulerJobService;
    }
}
