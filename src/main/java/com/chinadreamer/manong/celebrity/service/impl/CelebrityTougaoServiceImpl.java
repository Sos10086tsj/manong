package com.chinadreamer.manong.celebrity.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chinadreamer.manong.celebrity.entity.CelebrityTougao;
import com.chinadreamer.manong.celebrity.repository.CelebrityTougaoRepository;
import com.chinadreamer.manong.celebrity.service.CelebrityTougaoService;

@Service
public class CelebrityTougaoServiceImpl implements CelebrityTougaoService{
	@Resource
	private CelebrityTougaoRepository repository;
	@Override
	public Page<CelebrityTougao> getCelebrities(int pageNum, int pageSize) {
		pageNum = (pageNum > 0 ? pageNum - 1 : pageNum);
		return this.repository.findAll(new PageRequest(pageNum, pageSize));
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
		this.repository.save(tougao);
	}
	@Override
	public void cancelRecruitCelebrity(Long tougaoId) {
		CelebrityTougao tougao = this.repository.findOne(tougaoId);
		tougao.setAccepted(Boolean.FALSE);
		this.repository.save(tougao);
	}

}
