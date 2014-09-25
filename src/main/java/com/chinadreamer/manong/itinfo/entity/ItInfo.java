package com.chinadreamer.manong.itinfo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

import com.chinadreamer.manong.common.BaseEntity;
import com.chinadreamer.manong.user.entity.User;

@Entity
@Table(name = "info_list")
public @Getter @Setter class ItInfo extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1551316572072446971L;
	
	@Column(name = "tougao_id")
	private Long tougaoId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tougao_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ItTougao tougao;
	
	@Column
	private Long hits = 0l;
	
	@Column(name = "top",columnDefinition = "TINYINT(1)")
	private Boolean top = Boolean.FALSE;
	
	@Column(name = "accept_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date acceptDate = new Date();
	
	@Column(name = "accept_user")
	private String acceptUsername;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accept_user", referencedColumnName = "username", insertable = false, updatable = false)
	private User acceptUser;
}
