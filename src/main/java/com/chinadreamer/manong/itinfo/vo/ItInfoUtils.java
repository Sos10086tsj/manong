package com.chinadreamer.manong.itinfo.vo;

import org.springframework.util.StringUtils;

import com.chinadreamer.manong.itinfo.constant.InfoCategory;
import com.chinadreamer.manong.itinfo.constant.InfoType;
import com.chinadreamer.manong.itinfo.entity.ItTougao;

public class ItInfoUtils {
	public static ItTougao converItTougao(String title, String content, String category,
			String type, String sourceUrl,String createUsername) {
		ItTougao itTougao = new ItTougao();
		itTougao.setTitle(title);
		itTougao.setContent(content);
		itTougao.setCategory(InfoCategory.getInfoCategory(category));
		itTougao.setType(InfoType.getInfoType(type));
		if (!StringUtils.isEmpty(sourceUrl)) {
			itTougao.setSourceUrl(sourceUrl);
		}
		itTougao.setCreateUsername(createUsername);
		return itTougao;
	}
}
