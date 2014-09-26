package com.chinadreamer.manong.itinfo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;
import com.chinadreamer.manong.itinfo.constant.InfoCategory;
import com.chinadreamer.manong.itinfo.constant.InfoType;
import com.chinadreamer.manong.user.entity.User;

@Entity
@Table(name = "info_tougao")
public @Getter @Setter class ItTougao extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1551316572072446971L;

	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private InfoCategory category;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private InfoType type;
	
	@Column(name = "source_url")
	private String sourceUrl;
	
	@Column(name = "create_user")
	private String createUsername;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "create_user",referencedColumnName = "username",insertable = false,updatable =false)
	private User createUser;
	
	@Column(name = "create_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate = new Date();
	
	@Column(name = "accepted",columnDefinition = "TINYINT(1)")
	private Boolean accepted = Boolean.FALSE;
	
	@Column(name = "accept_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date acceptDate;
	
	@Column(name = "accept_user")
	private String acceptUsername;
	
	@Column(name = "published",columnDefinition="TINYINT(1)")
	private Boolean published = Boolean.FALSE;
}
