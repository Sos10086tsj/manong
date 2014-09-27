package com.chinadreamer.manong.itinfo.service;

import org.springframework.data.domain.Page;

import com.chinadreamer.manong.itinfo.entity.ItTougao;

public interface ItTouGaoService {
	/**
	 * 保存投稿
	 * @param title
	 * @param content
	 * @param category
	 * @param type
	 * @param sourceUrl
	 * @return
	 */
	public ItTougao saveItTougao(String title ,String content ,String category ,String type,String sourceUrl);
	/**
	 * 保存投稿
	 * @param itTougao
	 * @return
	 */
	public ItTougao saveItTougao(ItTougao itTougao);
	/**
	 * 获取未录用新投稿
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<ItTougao> getNewTougaos(int pageNum, int pageSize);
	/**
	 * 获取已录用投稿列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<ItTougao> getAcceptedTougaos(int pageNum, int pageSize);
	/**
	 * 录用投稿
	 * @param id
	 */
	public void acceptTougao(Long id);
	/**
	 * 取消录用投稿
	 * @param id
	 */
	public void cancelAcceptTougao(Long id);
	
	/**
	 * 获得最新的投稿
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<ItTougao> getAcceptTougaosOrderByAcceptDate(int pageNum, int pageSize);
	
	public ItTougao findOne(Long tougaoId);
}
