package com.test.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.userlogin.entity.TFolder;


@Repository
public interface TFolderRepository extends JpaRepository<TFolder, Long>{

	TFolder findByfName(String fName);

}
