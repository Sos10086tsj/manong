package com.chinadreamer.manong.itinfo.constant;

import lombok.Getter;

public enum InfoCategory {
	INFO("INFO","资讯"),
	MANAGE("MANAGE","管理经验"),
	TECHNIC("TECHNIC","技术分享");
	
	private final @Getter String category;
	private final @Getter String description;
	
	private InfoCategory(String category,String description){
		this.category = category;
		this.description = description;
	}
	
	public static InfoCategory getInfoCategory(String category) {
		return (InfoCategory)InfoCategory.valueOf(InfoCategory.class, category);
	}
}
