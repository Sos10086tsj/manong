package com.chinadreamer.manong.menu.service;

import java.util.List;

import com.chinadreamer.manong.menu.vo.MenuItem;

public interface MenuService {
	public List<MenuItem> findUserMenuItems(String username);
}
