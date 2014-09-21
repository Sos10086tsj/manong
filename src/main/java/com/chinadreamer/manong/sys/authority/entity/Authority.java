package com.chinadreamer.manong.sys.authority.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;

@Entity
@Table(name = "sys_authority")
public @Getter @Setter class Authority extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column(name = "outdated",columnDefinition = "TINYINT(1)")
	private Boolean outdated = Boolean.FALSE;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "authority")
	private List<AuthResOperMapping> authResOperMappings;
}
