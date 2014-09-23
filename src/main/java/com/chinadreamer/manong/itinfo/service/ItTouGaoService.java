package com.chinadreamer.manong.itinfo.service;

import org.springframework.data.domain.Page;

import com.chinadreamer.manong.itinfo.entity.ItTougao;

public interface ItTouGaoService {
	public ItTougao saveItTougao(String title ,String content ,String category ,String type,String sourceUrl);
	public ItTougao saveItTougao(ItTougao itTougao);
	public Page<ItTougao> getNewTougaos(int pageNum, int pageSize);
}
