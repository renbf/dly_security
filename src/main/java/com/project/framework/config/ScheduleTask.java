package com.project.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.web.service.ITEarlyWarningReportService;

/**
 * 
 * @author rbf
 *
 */
@Component
@Configuration
@EnableScheduling
public class ScheduleTask {
	private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

	@Autowired
	private ITEarlyWarningReportService tEarlyWarningReportService;
	
	//每天1点执行
	@Scheduled(cron = "0 0 1 * * ?")
	private void configureTasks() {
		log.info("1点定时任务开始");
		tEarlyWarningReportService.taskOver();
	}
}
