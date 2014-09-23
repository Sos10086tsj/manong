package com.chinadreamer.manong.itinfo.service.impl;

import java.util.Calendar;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.add(Calendar.DAY_OF_MONTH, -14);
		pageNum = (pageNum > 0 ? pageNum - 1 : pageNum);
		return this.repository.findByCreateDateGreaterThan(cal.getTime(), new PageRequest(pageNum, pageSize));
	}

}
