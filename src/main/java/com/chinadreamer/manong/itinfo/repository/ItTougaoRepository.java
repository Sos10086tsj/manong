package com.chinadreamer.manong.itinfo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.chinadreamer.manong.itinfo.entity.ItTougao;

public interface ItTougaoRepository extends JpaRepository<ItTougao, Long>, PagingAndSortingRepository<ItTougao, Long>{
	public Page<ItTougao> findByAcceptedFalseOrderByCreateDateDesc(Pageable pageable);
	public Page<ItTougao> findByAcceptedTrue(Pageable pageable);
	public Page<ItTougao> findByAcceptedTrueOrderByAcceptDateDesc(Pageable pageable);
	public List<ItTougao> findByAcceptedFalseAndCreateDateBefore(Date date);
}
