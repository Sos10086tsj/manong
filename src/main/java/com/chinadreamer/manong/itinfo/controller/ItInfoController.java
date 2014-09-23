package com.chinadreamer.manong.itinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinadreamer.manong.itinfo.constant.InfoConstant;
import com.chinadreamer.manong.itinfo.service.ItTouGaoService;

@Controller
@RequestMapping("itInfo")
public class ItInfoController {
	
	@Resource
	private ItTouGaoService itTouGaoService;
	
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
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNum = StringUtils.isEmpty(pageNumStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_NUM : Integer.valueOf(pageNumStr);
		int pageSize = StringUtils.isEmpty(pageSizeStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_SIZE : Integer.valueOf(pageSizeStr);
		model.addAttribute("tougaoPage", this.itTouGaoService.getNewTougaos(pageNum, pageSize));
		return "itinfo/accept";
	}
}
