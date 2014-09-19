package com.chinadreamer.manong.user.constant;

import lombok.Getter;


public @Getter enum UserStatus {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE");
	
	private final String code;
	
	private UserStatus(String code){
		this.code = code;
	}
	
	public static UserStatus getUserStatus(String code) {
		return (UserStatus)UserStatus.valueOf(UserStatus.class, code);
	}
}
