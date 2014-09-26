package com.chinadreamer.manong.celebrity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chinadreamer.manong.celebrity.entity.CelebrityTougao;

public interface CelebrityTougaoRepository extends JpaRepository<CelebrityTougao, Long>{
	public Page<CelebrityTougao> findByAcceptedTrueOrderByAcceptDateAsc(Pageable pageable);
}
