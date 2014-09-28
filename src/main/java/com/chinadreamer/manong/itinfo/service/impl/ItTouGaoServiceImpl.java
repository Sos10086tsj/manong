package com.chinadreamer.manong.itinfo.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chinadreamer.manong.common.ShiroUtils;
import com.chinadreamer.manong.itinfo.entity.ItTougao;
import com.chinadreamer.manong.itinfo.repository.ItTougaoRepository;
import com.chinadreamer.manong.itinfo.service.ItTouGaoService;
import com.chinadreamer.manong.itinfo.vo.ItInfoUtils;

@Service
public class ItTouGaoServiceImpl implements ItTouGaoService{
	@Resource
	private ItTougaoRepository repository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ItTougao saveItTougao(String title, String content, String category,
			String type, String sourceUrl) {
		ItTougao itTougao = ItInfoUtils.converItTougao(title, content, category, type, sourceUrl, ShiroUtils.getUser().getUsername());
		return this.repository.save(itTougao);
	}

	@Override
	public ItTougao saveItTougao(ItTougao itTougao) {
		return this.repository.save(itTougao);
	}

	@Override
	public Page<ItTougao> getNewTougaos(int pageNum, int pageSize) {
		return this.repository.findByAcceptedFalseOrderByCreateDateDesc(this.generatePageable(pageNum, pageSize));
	}

	@Override
	public void acceptTougao(Long id) {
		ItTougao itTougao = this.repository.findOne(id);
		itTougao.setAccepted(true);
		itTougao.setAcceptDate(new Date());
		itTougao.setAcceptUsername(ShiroUtils.getUser().getUsername());
		this.repository.save(itTougao);
	}

	@Override
	public void cancelAcceptTougao(Long id) {
		ItTougao itTougao = this.repository.findOne(id);
		itTougao.setAccepted(Boolean.FALSE);
		itTougao.setAcceptDate(null);
		itTougao.setAcceptUsername(null);
		this.repository.save(itTougao);
	}

	@Override
	public Page<ItTougao> getAcceptedTougaos(int pageNum, int pageSize) {
		return this.repository.findByAcceptedTrueOrderByAcceptDateDesc(this.generatePageable(pageNum, pageSize));
	}

	@Override
	public Page<ItTougao> getAcceptTougaosOrderByAcceptDate(int pageNum,
			int pageSize) {
		return this.repository.findByAcceptedTrueOrderByAcceptDateDesc(this.generatePageable(pageNum, pageSize));
	}

	private Pageable generatePageable(int pageNum, int pageSize){
		pageNum = (pageNum > 0 ? pageNum - 1 : pageNum);
		return new PageRequest(pageNum, pageSize);
	}

	@Override
	public ItTougao findOne(Long tougaoId) {
		return this.repository.findOne(tougaoId);
	}

	@Override
	public Page<ItTougao> getTougaos(int pageNum, int pageSize) {
		return this.repository.findAll(this.generatePageable(pageNum, pageSize));
	}
}
