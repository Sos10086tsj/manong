package com.chinadreamer.manong.menu.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.chinadreamer.manong.menu.vo.MenuItem;

public class MenuUtils {
	
	public static List<MenuItem> generateMenuTree(List<MenuItem> userMenuItems) {
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		Collections.sort(userMenuItems, new MenuItemOrderComparator());
		List<String> keys = new ArrayList<String>();
		for (MenuItem menuItem : userMenuItems) {
			String key = menuItem.getParentCode();
			if (keys.contains(key)) {
				MenuItem item = menuItems.get(keys.indexOf(key));
				item.getChildItems().add(menuItem);
			}else {
				menuItems.add(menuItem);
				keys.add(key);
			}
		}
		return menuItems;
	}
}
