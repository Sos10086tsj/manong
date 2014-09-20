package com.chinadreamer.manong.sys.resourceOperation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;

@Entity
@Table(name = "sys_resource_operation")
public @Getter @Setter class ResourceOperation extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8226850530655260742L;

	@Column
	private String code;
	
	@Column
	private String name;
}
