package com.chinadreamer.manong.index.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinadreamer.manong.common.ShiroUtils;
import com.chinadreamer.manong.menu.service.MenuService;

@Controller
public class IndexController {
	@Resource
	private MenuService menuService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String defaultPage(Model model){
		return "redirect:index";
	}
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login(Model model){
		return "login";
	}
	
	@RequestMapping(value = "index",method = RequestMethod.GET)
	public String index(Model model){
		String username = ShiroUtils.getUser().getUsername();
		model.addAttribute("menuItems", this.menuService.findUserMenuItems(username));
		return "index";
	}
	
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String logout(Model model){
		ShiroUtils.logout();
		return "login";
	}
}
