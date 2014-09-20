package com.chinadreamer.manong.sys.resource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;

@Entity
@Table(name = "sys_resource")
public @Getter @Setter class Resource extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4590247572326546625L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String url;
	
	@Column
	private Integer hierarchy;
	
	@Column(name = "sub_hierarchy")
	private Integer subHierarchy;
	
	@Column(name = "show",columnDefinition = "TINYINT(1)")
	private Boolean show = Boolean.TRUE;
}
