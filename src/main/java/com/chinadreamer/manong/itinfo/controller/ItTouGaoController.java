package com.chinadreamer.manong.itinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinadreamer.manong.itinfo.constant.InfoConstant;
import com.chinadreamer.manong.itinfo.service.ItTouGaoService;

@Controller
@RequestMapping(value = "itInfo")
public class ItTouGaoController {
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
	
	@RequestMapping(value = "acceptTougao", method = RequestMethod.GET)
	@ResponseBody
	public void acceptTougao(Model model,@RequestParam("id") Long id){
		this.itTouGaoService.acceptTougao(id);
	}
	
	@RequestMapping(value = "accept/infos", method = RequestMethod.GET)
	public String getAcceptedInfos(Model model,HttpServletRequest request){
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNum = StringUtils.isEmpty(pageNumStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_NUM : Integer.valueOf(pageNumStr);
		int pageSize = StringUtils.isEmpty(pageSizeStr) ? InfoConstant.DEFAULT_SEARCH_PAGE_SIZE : Integer.valueOf(pageSizeStr);
		model.addAttribute("tougaoPage", this.itTouGaoService.getAcceptedTougaos(pageNum, pageSize));
		return "itinfo/acceptInfos";
	}
	
	@RequestMapping(value = "accept/cancel/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void cancelAcceptedInfo(Model model,@PathVariable("id") Long id){
		this.itTouGaoService.cancelAcceptTougao(id);
	}
	
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
