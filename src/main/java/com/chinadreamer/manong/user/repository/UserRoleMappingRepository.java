package com.chinadreamer.manong.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinadreamer.manong.user.entity.UserRoleMapping;

public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Long>{
	public List<UserRoleMapping> findByUsername(String username);
}
