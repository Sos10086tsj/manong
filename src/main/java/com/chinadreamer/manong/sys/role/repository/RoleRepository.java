package com.chinadreamer.manong.sys.role.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.chinadreamer.manong.sys.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
