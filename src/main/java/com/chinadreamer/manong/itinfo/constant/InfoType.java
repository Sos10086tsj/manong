package com.chinadreamer.manong.itinfo.constant;

import lombok.Getter;

public enum InfoType {
	ORIGIN("ORIGIN","原创"),
	REPRINT("REPRINT","转载"),
	TRANSLATE("TRANSLATE","翻译");
	
	private final @Getter String type;
	private final @Getter String description;
	
	private InfoType(String type,String description) {
		this.type = type;
		this.description = description;
	}
	
	public static InfoType getInfoType(String type) {
		return (InfoType)InfoType.valueOf(InfoType.class, type);
	}
}
