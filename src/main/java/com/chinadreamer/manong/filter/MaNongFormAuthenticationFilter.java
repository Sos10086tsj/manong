package com.chinadreamer.manong.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MaNongFormAuthenticationFilter extends FormAuthenticationFilter{
	private static final Logger LOGGER =  Logger.getLogger(MaNongFormAuthenticationFilter.class);
	/* 
     *  主要是针对登入成功的处理方法。对于请求头是AJAX的之间返回JSON字符串。 
     */  
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest
				.getHeader("X-Requested-With"))) {// 不是ajax请求
			issueSuccessRedirect(request, response);
		} else {
			httpServletResponse.setCharacterEncoding("UTF-8");
			PrintWriter out = httpServletResponse.getWriter();
			out.println("{success:true,message:'login success'}");
			out.flush();
			out.close();
		}
		return false;
	}
	
	/** 
     * 主要是处理登入失败的方法 
     */  
    @Override  
    protected boolean onLoginFailure(AuthenticationToken token,  
            AuthenticationException e, ServletRequest request,  
            ServletResponse response) {  
        if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request)  
                .getHeader("X-Requested-With"))) {// 不是ajax请求  
            setFailureAttribute(request, e);  
            return true;  
        }  
        try {  
            response.setCharacterEncoding("UTF-8");  
            PrintWriter out = response.getWriter();  
            String message = e.getClass().getSimpleName();  
            if ("IncorrectCredentialsException".equals(message)) {  
                out.println("{success:false,message:'Incorrect password!'}");  
            } else if ("UnknownAccountException".equals(message)) {  
                out.println("{success:false,message:'Account not exists!'}");  
            } else if ("LockedAccountException".equals(message)) {  
                out.println("{success:false,message:'Account is frozen!'}");  
            } else {  
                out.println("{success:false,message:'Unkonw error!'}");  
            }  
            out.flush();  
            out.close();  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
        return false;  
    }  
    
    /** 
     * 所有请求都会经过的方法。 
     */  
    @Override  
    protected boolean onAccessDenied(ServletRequest request,  
            ServletResponse response) throws Exception {  
  
        if (isLoginRequest(request, response)) {  
            if (isLoginSubmission(request, response)) {  
                if (LOGGER.isTraceEnabled()) {  
                	LOGGER.trace("Login submission detected.  Attempting to execute login.");  
                }  
                return executeLogin(request, response);  
            } else {  
                if (LOGGER.isTraceEnabled()) {  
                	LOGGER.trace("Login page view.");  
                }  
                return true;  
            }  
        } else {  
            if (LOGGER.isTraceEnabled()) {  
            	LOGGER.trace("Attempting to access a path which requires authentication.  Forwarding to the "  
                        + "Authentication url [" + getLoginUrl() + "]");  
            }  
            if (!"XMLHttpRequest"  
                    .equalsIgnoreCase(((HttpServletRequest) request)  
                            .getHeader("X-Requested-With"))) {// 不是ajax请求  
                saveRequestAndRedirectToLogin(request, response);  
            } else {  
                return true;
            }  
            return false;  
        }  
    }  
}
