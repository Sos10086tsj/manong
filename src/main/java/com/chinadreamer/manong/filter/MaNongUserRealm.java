package com.chinadreamer.manong.filter;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinadreamer.manong.user.entity.User;
import com.chinadreamer.manong.user.service.UserService;

public class MaNongUserRealm extends AuthorizingRealm{
	
	private final static Logger LOGGER = Logger.getLogger(AuthorizingRealm.class);

	@Autowired
	private UserService userService;
	
	public MaNongUserRealm(){
		super();
		LOGGER.info(" init user realm ");
		setAuthenticationTokenClass(UsernamePasswordToken.class);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
      
      return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        User user;
        try {
			user = this.userService.userLogin(username, password);
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage(),e);
		}
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password.toCharArray(), getName());
		return info;
	}

}
