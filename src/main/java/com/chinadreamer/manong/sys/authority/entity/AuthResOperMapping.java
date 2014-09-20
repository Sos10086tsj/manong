package com.chinadreamer.manong.sys.authority.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;
import com.chinadreamer.manong.sys.resource.entity.Resource;
import com.chinadreamer.manong.sys.resourceOperation.entity.ResourceOperation;

@Entity
@Table(name = "auth_res_oper_mapping")
public @Getter @Setter class AuthResOperMapping extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5684028372084887977L;

	@Column(name = "authority_code")
	private String authorityCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authority_code",referencedColumnName="code",insertable = false, updatable = false)
	private Authority authority;
	
	@Column(name = "resource_code")
	private String resourceCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_code",referencedColumnName="code",insertable = false, updatable = false)
	private Resource resource;
	
	@Column(name = "operation_code")
	private String operationCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "operation_code",referencedColumnName="code",insertable = false, updatable = false)
	private ResourceOperation operation;
}
