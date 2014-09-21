package com.chinadreamer.manong.user.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.chinadreamer.manong.common.BaseTest;
import com.chinadreamer.manong.sys.authority.entity.AuthResOperMapping;
import com.chinadreamer.manong.sys.role.entity.RoleAuthMapping;
import com.chinadreamer.manong.user.entity.User;
import com.chinadreamer.manong.user.entity.UserRoleMapping;
import com.chinadreamer.manong.user.service.UserService;

public class UserServiceImplTest extends BaseTest{
	@Resource
	private UserService userService;
	@Test
	public void testFindUserRoles() {
		User user = this.userService.findUser("test");
		assertNotNull(user);
		for (UserRoleMapping userRoleMapping : user.getUserRoles()) {
			System.out.println(userRoleMapping.getRole().getName());
			for (RoleAuthMapping roleAuthMapping : userRoleMapping.getRole().getRoleAuths()) {
				System.out.println(roleAuthMapping.getAuthority().getName());
				for (AuthResOperMapping authResOperMapping : roleAuthMapping.getAuthority().getAuthResOperMappings()) {
					System.out.println(authResOperMapping.getResource().getName());
				}
			}
		}
	}

}
