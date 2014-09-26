package com.chinadreamer.manong.homepage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinadreamer.manong.celebrity.service.CelebrityTougaoService;
import com.chinadreamer.manong.itinfo.service.ItTouGaoService;

@Controller
@RequestMapping(value = "home")
public class HomepageController {
	@Resource
	private ItTouGaoService itTouGaoService;
	@Resource
	private CelebrityTougaoService celebrityTougaoService;
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(Model model){
		model.addAttribute("infos", this.itTouGaoService.getAcceptedTougaos(0, 20));
		model.addAttribute("celebrities", this.celebrityTougaoService.getAcceptedCelebrities(0, 20));
		return "homepage/homepage";
	}
}
