package com.ManyToManyhibernatejpa.repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ManyToManyhibernatejpa.entity.Game;

public interface GameRepository extends JpaRepository<Game,Long > {

	List<Game> findByUserOrderByTimestampDesc(User user);

}
