package com.chinadreamer.manong.itinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinadreamer.manong.itinfo.entity.ItInfo;

public interface ItInfoRepository extends JpaRepository<ItInfo, Long>{
	public ItInfo findByTougaoId(Long tougaoId);
}
