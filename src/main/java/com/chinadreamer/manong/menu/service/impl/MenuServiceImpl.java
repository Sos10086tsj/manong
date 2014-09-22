package com.chinadreamer.manong.menu.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinadreamer.manong.menu.service.MenuService;
import com.chinadreamer.manong.menu.utils.MenuUtils;
import com.chinadreamer.manong.menu.vo.MenuItem;
import com.chinadreamer.manong.sys.authority.entity.AuthResOperMapping;
import com.chinadreamer.manong.sys.role.entity.RoleAuthMapping;
import com.chinadreamer.manong.user.entity.UserRoleMapping;
import com.chinadreamer.manong.user.repository.UserRoleMappingRepository;

@Service
public class MenuServiceImpl implements MenuService{

	@Resource
	private UserRoleMappingRepository userRoleMappingRepository;
	@Override
	public List<MenuItem> findUserMenuItems(String username) {
		
		List<UserRoleMapping> userRoleMappings = this.userRoleMappingRepository.findByUsername(username);
		//1. get all resources
		List<com.chinadreamer.manong.sys.resource.entity.Resource> resources = 
				new ArrayList<com.chinadreamer.manong.sys.resource.entity.Resource>();
		for (UserRoleMapping userRoleMapping : userRoleMappings) {
			Set<AuthResOperMapping> authResOperMappings = new HashSet<AuthResOperMapping>();
			for (RoleAuthMapping roleAuthMapping : userRoleMapping.getRole().getRoleAuths()) {
				authResOperMappings.addAll(roleAuthMapping.getAuthority().getAuthResOperMappings());
			}
			for (AuthResOperMapping authResOperMapping : authResOperMappings) {
				resources.add(authResOperMapping.getResource());
			}
		}
		//generate tree
		List<MenuItem> userMenuItems = new ArrayList<MenuItem>();
		for (com.chinadreamer.manong.sys.resource.entity.Resource resource : resources) {
			if (resource.getShow()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setCode(resource.getCode());
				menuItem.setParentCode(resource.getParentCode());
				menuItem.setName(resource.getName());
				menuItem.setUrl(resource.getUrl());
				menuItem.setHierarchy(resource.getHierarchy());
				menuItem.setSubHierarchy(resource.getSubHierarchy());
				menuItem.setChildItems(new ArrayList<MenuItem>());
				userMenuItems.add(menuItem);
			}
		}
		return MenuUtils.generateMenuTree(userMenuItems);
	}

	
}
