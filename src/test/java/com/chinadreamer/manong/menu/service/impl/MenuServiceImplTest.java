package com.chinadreamer.manong.menu.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.chinadreamer.manong.common.BaseTest;
import com.chinadreamer.manong.menu.service.MenuService;
import com.chinadreamer.manong.menu.vo.MenuItem;

public class MenuServiceImplTest extends BaseTest{
	@Resource
	private MenuService menuService;
	@Test
	public void testFindUserMenuItems() {
		List<MenuItem> menuItems = this.menuService.findUserMenuItems("test");
		assertNotNull(menuItems);
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem.getName());
			for (MenuItem subMenuItem : menuItem.getChildItems()) {
				System.out.println(subMenuItem.getName());
			}
		}
	}

}
