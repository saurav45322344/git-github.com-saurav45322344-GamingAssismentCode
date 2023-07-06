package com.test.userlogin.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.userlogin.controller.entity.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Integer> {

}
