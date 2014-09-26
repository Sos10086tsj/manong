package com.chinadreamer.manong.celebrity.service;

import org.springframework.data.domain.Page;

import com.chinadreamer.manong.celebrity.entity.CelebrityTougao;

public interface CelebrityTougaoService {
	public Page<CelebrityTougao> getCelebrities(int pageNum, int pageSize);
	public CelebrityTougao saveCelebrityTougao(String honorTitle,String name,String profile,
			String zhuanji,String resourceUrl);
	public void recruitCelebrity(Long tougaoId);
	public void cancelRecruitCelebrity(Long tougaoId);
	public Page<CelebrityTougao> getAcceptedCelebrities(int pageNum, int pageSize);
}
