package com.chinadreamer.manong.schedule;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chinadreamer.manong.itinfo.service.ItTouGaoService;

@Component
public class CleanInfoTask {
	
	@Resource
	private ItTouGaoService itTouGaoService;
	
	@Scheduled(cron = "0 0 0  * * SUN ")
	public void cleanInfo(){
		this.itTouGaoService.cleanInfo();
	}
}
