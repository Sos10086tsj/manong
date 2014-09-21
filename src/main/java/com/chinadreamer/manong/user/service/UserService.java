package com.chinadreamer.manong.user.service;

import com.chinadreamer.manong.user.entity.User;

public interface UserService {
	public User userLogin(String username, String password);
	
	public User findUser(String username);
}
