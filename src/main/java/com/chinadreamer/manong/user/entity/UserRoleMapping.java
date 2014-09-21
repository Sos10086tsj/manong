package com.chinadreamer.manong.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;
import com.chinadreamer.manong.sys.role.entity.Role;

@Entity
@Table(name = "user_role_mapping")
public @Getter @Setter class UserRoleMapping extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518527520994883285L;

	@Column
	private String username;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username",referencedColumnName = "username",insertable = false,updatable = false)
	private User user;
	
	@Column(name = "role_code")
	private String roleCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_code",referencedColumnName = "code",insertable = false,updatable = false)
	private Role role;
}
