package com.chinadreamer.manong.sys.role.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;
import com.chinadreamer.manong.sys.authority.entity.Authority;

@Entity
@Table(name = "role_auth_mapping")
public @Getter @Setter class RoleAuthMapping extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -597255401954357893L;

	@Column(name = "role_code")
	private String roleCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "role_code",referencedColumnName = "code",insertable = false, updatable = false)
	private Role role;
	
	@Column(name = "auth_code")
	private String authCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "auth_code",referencedColumnName = "code",insertable = false, updatable = false)
	private Authority authority;
}
