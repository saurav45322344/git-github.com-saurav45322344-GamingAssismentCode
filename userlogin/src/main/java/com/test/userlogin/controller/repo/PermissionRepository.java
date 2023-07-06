package com.test.userlogin.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.userlogin.controller.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
