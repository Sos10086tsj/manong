package com.chinadreamer.manong.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "home")
public class HomepageController {
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(Model model){
		model.addAttribute("info", "新闻");
		return "homepage/homepage";
	}
}
