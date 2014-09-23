package com.chinadreamer.manong.itinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinadreamer.manong.itinfo.service.ItTouGaoService;

@Controller
@RequestMapping(value = "itinfo")
public class ItTouGaoController {
	@Resource
	private ItTouGaoService itTouGaoService;
	
	@RequestMapping(value = "showCreateForm",method = RequestMethod.GET)
	public String showCreateForm(Model model){
		return "itinfo/tougao/createTougao";
	}
	
	@RequestMapping(value = "createTougao",method = RequestMethod.POST)
	public String createTougao(Model model,HttpServletRequest request){
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		String sourceUrl = request.getParameter("sourceUrl");
		model.addAttribute("itTougao", this.itTouGaoService.saveItTougao(title, content, category, type, sourceUrl));
		return "itinfo/tougao/tougaoDetail";
	}
}
