package com.chinadreamer.manong.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;
import com.chinadreamer.manong.user.constant.UserStatus;

@Entity
@Table(name = "sys_user")
public @Getter @Setter class User extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4864743006826851462L;

	/**
	 * 用户名
	 */
	@Column
	private String username;
	public void setUsername(String username){
		//can not update username
		return;
	}
	
	/**
	 * 密码
	 */
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private UserStatus status;
}
