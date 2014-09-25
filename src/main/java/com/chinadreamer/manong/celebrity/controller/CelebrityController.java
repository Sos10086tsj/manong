package com.chinadreamer.manong.celebrity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "celebrity")
public class CelebrityController {
	@RequestMapping(method = RequestMethod.GET)
	public String getCelebrity(Model model){
		model.addAttribute("info", "新闻");
		return "celebrity/celebrity";
	}
	
	@RequestMapping(value = "recruit", method = RequestMethod.GET)
	public String recruitCelebrity(Model model,HttpServletRequest request){
		model.addAttribute("info", "新闻");
		return "itinfo/recruit";
	}
}
