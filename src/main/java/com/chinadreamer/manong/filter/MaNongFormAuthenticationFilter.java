package com.chinadreamer.manong.filter;

import lombok.Getter;
import lombok.Setter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MaNongFormAuthenticationFilter extends FormAuthenticationFilter{
	
	private @Getter @Setter String defaultSuccessUrl;

	@Override
	public String getSuccessUrl() {
        return getDefaultSuccessUrl();
    }
	
}
