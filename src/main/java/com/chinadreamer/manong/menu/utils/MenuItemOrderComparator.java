package com.chinadreamer.manong.menu.utils;

import java.util.Comparator;

import com.chinadreamer.manong.menu.vo.MenuItem;

public class MenuItemOrderComparator implements Comparator<MenuItem>{

	@Override
	public int compare(MenuItem o1, MenuItem o2) {
		if (o1.getHierarchy().equals(o2.getHierarchy())) {
			return o1.getSubHierarchy().compareTo(o2.getSubHierarchy());
		}
		return o1.getHierarchy().compareTo(o2.getHierarchy());
	}

}
