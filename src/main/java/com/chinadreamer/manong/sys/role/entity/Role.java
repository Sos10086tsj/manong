package com.chinadreamer.manong.sys.role.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;

@Entity
@Table(name = "sys_role")
public @Getter @Setter class Role extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 651221047031303322L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column(name = "is_system",columnDefinition = "TINYINT(1)")
	private Boolean isSystem;
}
