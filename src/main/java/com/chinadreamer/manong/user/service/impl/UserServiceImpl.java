package com.chinadreamer.manong.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinadreamer.manong.common.Encryption;
import com.chinadreamer.manong.user.constant.UserStatus;
import com.chinadreamer.manong.user.entity.User;
import com.chinadreamer.manong.user.repository.UserRepository;
import com.chinadreamer.manong.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserRepository repository;
	@Override
	public User userLogin(String username, String password) {
		User user = this.repository.findByUsernameAndPassword(username, Encryption.md5L32(password));
		if (null == user) {
			throw new RuntimeException("user not exists or info error");
		}
		if (user.getStatus().equals(UserStatus.INACTIVE)) {
			throw new RuntimeException("user is frozen");
		}
		return user;
	}
	@Override
	public User findUser(String username) {
		return this.repository.findByUsername(username);
	}
	
}
