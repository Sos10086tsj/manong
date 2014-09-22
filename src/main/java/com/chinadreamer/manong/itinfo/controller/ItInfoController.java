package com.chinadreamer.manong.itinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("itInfo")
public class ItInfoController {
	@RequestMapping(method = RequestMethod.GET)
	public String getItInfo(Model model){
		model.addAttribute("info", "新闻");
		return "itinfo/itinfo";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getItInfoListByType(Model model,HttpServletRequest request){
		model.addAttribute("info", "新闻");
		return "itinfo/infolist";
	}
	
	@RequestMapping(value = "accept", method = RequestMethod.GET)
	public String acceptItInfo(Model model,HttpServletRequest request){
		model.addAttribute("info", "新闻");
		return "itinfo/accept";
	}
}
