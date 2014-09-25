package com.chinadreamer.manong.itinfo.service.impl;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chinadreamer.manong.common.ShiroUtils;
import com.chinadreamer.manong.itinfo.entity.ItInfo;
import com.chinadreamer.manong.itinfo.entity.ItTougao;
import com.chinadreamer.manong.itinfo.repository.ItInfoRepository;
import com.chinadreamer.manong.itinfo.repository.ItTougaoRepository;
import com.chinadreamer.manong.itinfo.service.ItTouGaoService;
import com.chinadreamer.manong.itinfo.vo.ItInfoUtils;

@Service
public class ItTouGaoServiceImpl implements ItTouGaoService{
	@Resource
	private ItTougaoRepository repository;
	@Resource
	private ItInfoRepository itInfoRepository;
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
		pageNum = (pageNum > 0 ? pageNum - 1 : pageNum);
		return this.repository.findByAcceptedFalse(new PageRequest(pageNum, pageSize));
	}

	@Override
	public void acceptTougao(Long id) {
		ItInfo itInfo = new ItInfo();
		itInfo.setAcceptUsername(ShiroUtils.getUser().getUsername());
		itInfo.setTougaoId(id);
		this.itInfoRepository.save(itInfo);
		ItTougao itTougao = this.repository.findOne(id);
		itTougao.setAccepted(true);
		this.repository.save(itTougao);
	}

	@Override
	public void cancelAcceptTougao(Long id) {
		ItTougao itTougao = this.repository.findOne(id);
		itTougao.setAccepted(Boolean.FALSE);
		this.repository.save(itTougao);
		ItInfo itInfo = this.itInfoRepository.findByTougaoId(id);
		this.itInfoRepository.delete(itInfo);
	}

	@Override
	public Page<ItTougao> getAcceptedTougaos(int pageNum, int pageSize) {
		pageNum = (pageNum > 0 ? pageNum - 1 : pageNum);
		return this.repository.findByAcceptedTrue(new PageRequest(pageNum, pageSize));
	}

}
