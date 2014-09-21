package com.chinadreamer.manong.menu.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class MenuItem {
	private String code;
	private String name;
	private String url;
	private Integer hierarchy;
	private Integer subHierarchy;
	private List<MenuItem> childItems;
}
