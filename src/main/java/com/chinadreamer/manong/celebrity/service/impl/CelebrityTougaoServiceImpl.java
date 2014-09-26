package com.chinadreamer.manong.celebrity.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chinadreamer.manong.celebrity.entity.CelebrityTougao;
import com.chinadreamer.manong.celebrity.repository.CelebrityTougaoRepository;
import com.chinadreamer.manong.celebrity.service.CelebrityTougaoService;
import com.chinadreamer.manong.common.ShiroUtils;

@Service
public class CelebrityTougaoServiceImpl implements CelebrityTougaoService{
	@Resource
	private CelebrityTougaoRepository repository;
	@Override
	public Page<CelebrityTougao> getCelebrities(int pageNum, int pageSize) {
		return this.repository.findAll(this.generatePageable(pageNum, pageSize));
	}
	@Override
	public CelebrityTougao saveCelebrityTougao(String honorTitle, String name,
			String profile, String zhuanji, String resourceUrl) {
		CelebrityTougao tougao = new CelebrityTougao();
		tougao.setHonorTitle(honorTitle);
		tougao.setName(name);
		tougao.setProfile(profile);
		tougao.setZhuanji(zhuanji);
		tougao.setResourceUrl(resourceUrl);
		return this.repository.save(tougao);
	}
	@Override
	public void recruitCelebrity(Long tougaoId) {
		CelebrityTougao tougao = this.repository.findOne(tougaoId);
		tougao.setAccepted(Boolean.TRUE);
		tougao.setAcceptDate(new Date());
		tougao.setAcceptUsername(ShiroUtils.getUser().getUsername());
		this.repository.save(tougao);
	}
	@Override
	public void cancelRecruitCelebrity(Long tougaoId) {
		CelebrityTougao tougao = this.repository.findOne(tougaoId);
		tougao.setAccepted(Boolean.FALSE);
		tougao.setAcceptDate(null);
		tougao.setAcceptUsername(null);
		this.repository.save(tougao);
	}
	@Override
	public Page<CelebrityTougao> getAcceptedCelebrities(int pageNum,
			int pageSize) {
		return this.repository.findByAcceptedTrueOrderByAcceptDateAsc(this.generatePageable(pageNum, pageSize));
	}

	private Pageable generatePageable(int pageNum, int pageSize){
		pageNum = (pageNum > 0 ? pageNum - 1 : pageNum);
		return new PageRequest(pageNum, pageSize);
	}
}
