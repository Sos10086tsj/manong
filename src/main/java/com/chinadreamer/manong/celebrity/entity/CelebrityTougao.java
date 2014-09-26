package com.chinadreamer.manong.celebrity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;

@Entity
@Table(name = "celebrity_tougao")
public @Getter @Setter class CelebrityTougao extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4449257535115404664L;

	@Column(name = "honor_title")
	private String honorTitle;
	
	@Column
	private String name;
	
	@Column
	private String profile;
	
	@Column
	private String zhuanji;
	
	@Column(name = "resource_url")
	private String resourceUrl;
	
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-ss HH:mm:ss")
	private Date createDate = new Date();
	
	@Column(name = "accepted" ,columnDefinition = "TINYINT(1)")
	private Boolean accepted = Boolean.FALSE;
	
	@Column(name = "accept_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date acceptDate;
	
	@Column(name = "accept_user")
	private String acceptUsername;
	
	@Column(name = "published",columnDefinition="TINYINT(1)")
	private Boolean published = Boolean.FALSE;
	
}
