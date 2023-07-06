package com.test.userlogin.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.userlogin.controller.dto.PermissionDto;

public interface Permissionrepo extends JpaRepository<PermissionDto, Integer> {

}
