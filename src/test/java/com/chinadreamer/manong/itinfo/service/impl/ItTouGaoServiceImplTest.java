package com.chinadreamer.manong.itinfo.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.domain.Page;

import com.chinadreamer.manong.common.BaseTest;
import com.chinadreamer.manong.itinfo.entity.ItTougao;
import com.chinadreamer.manong.itinfo.service.ItTouGaoService;

public class ItTouGaoServiceImplTest extends BaseTest{
	@Resource
	private ItTouGaoService itTouGaoService;
	@Test
	public void testGetNewTougaos() {
		Page<ItTougao> page =  this.itTouGaoService.getNewTougaos(0, 10);
		assertNotNull(page);
		for (ItTougao itTougao : page) {
			System.out.println(itTougao.getTitle());
		}
	}

}
