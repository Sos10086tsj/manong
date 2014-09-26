package com.chinadreamer.manong.celebrity.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinadreamer.manong.celebrity.entity.CelebrityTougao;
import com.chinadreamer.manong.celebrity.service.CelebrityTougaoService;
import com.chinadreamer.manong.itinfo.constant.InfoConstant;

@Controller
@RequestMapping(value = "celebrity")
public class CelebrityController {
	
	@Resource
	private CelebrityTougaoService celebrityTougaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCelebrity(Model model){
		model.addAttribute("info", "新闻");
		return "celebrity/celebrity";
	}
	
	@RequestMapping(value = "recruit", method = RequestMethod.GET)
	public String recruitCelebrity(Model model,HttpServletRequest request){
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNum = StringUtils.isEmpty(pageNumStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_NUM : Integer.valueOf(pageNumStr);
		int pageSize = StringUtils.isEmpty(pageSizeStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_SIZE : Integer.valueOf(pageSizeStr);
		model.addAttribute("tougaoPage",this.celebrityTougaoService.getCelebrities(pageNum, pageSize));
		return "celebrity/recruit";
	}
	
	@RequestMapping(value = "recruitTougao",method = RequestMethod.GET)
	@ResponseBody
	public void recruitTougao(Model model,@RequestParam("id")Long id){
		this.celebrityTougaoService.recruitCelebrity(id);
	}
	
	@RequestMapping(value = "cancelRecruitTougao",method = RequestMethod.GET)
	@ResponseBody
	public void cancelRecruitTougao(Model model,@RequestParam("id")Long id){
		this.celebrityTougaoService.cancelRecruitCelebrity(id);
	}
	
	@RequestMapping(value = "showCreate",method = RequestMethod.GET)
	public String showCreate(Model model){
		return "celebrity/tougao/create";
	}
	
	@RequestMapping(value = "submitTougao",method = RequestMethod.POST)
	public String submitTougao(Model model,HttpServletRequest request){
		String honorTitle = request.getParameter("honorTitle");
		String name = request.getParameter("name");
		String profile = request.getParameter("profile");
		String zhuanji = request.getParameter("zhuanji");
		String resourceUrl = request.getParameter("resourceUrl");
		CelebrityTougao tougao = this.celebrityTougaoService
				.saveCelebrityTougao(honorTitle, name, profile, zhuanji, resourceUrl);
		model.addAttribute("tougao", tougao);
		return "celebrity/tougao/detail";
	}
	
	@RequestMapping(value = "acceptList", method = RequestMethod.GET)
	public String acceptList(Model model,HttpServletRequest request){
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNum = StringUtils.isEmpty(pageNumStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_NUM : Integer.valueOf(pageNumStr);
		int pageSize = StringUtils.isEmpty(pageSizeStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_SIZE : Integer.valueOf(pageSizeStr);
		model.addAttribute("tougaoPage",this.celebrityTougaoService.getCelebrities(pageNum, pageSize));
		return "celebrity/recruit";
	}
}
