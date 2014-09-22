package com.chinadreamer.manong.support.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "support")
public class SupportContoller {
	@RequestMapping(method = RequestMethod.GET)
	public String userSupport(Model model){
		model.addAttribute("info", "新闻");
		return "support/support";
	}
}
