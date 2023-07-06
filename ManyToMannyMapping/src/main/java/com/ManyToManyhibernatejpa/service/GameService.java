package com.ManyToManyhibernatejpa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ManyToManyhibernatejpa.entity.Game;
import com.ManyToManyhibernatejpa.entity.User;
import com.ManyToManyhibernatejpa.repository.GameRepository;
import com.ManyToManyhibernatejpa.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class GameService {


	private final UserRepository userRepository;
	private final GameRepository gameRepository;

	public GameService(UserRepository userRepository, GameRepository gameRepository) {
		this.userRepository = userRepository;
		this.gameRepository = gameRepository;
	}

	public User login(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	public Game playGame(User user, int coinsPicked) {
		int remainingCoins = 21 - coinsPicked;

		if (remainingCoins <= 1) {
			// User loses
			Game game = new Game();
			game.setUser(user);
			game.setCoinsPicked(coinsPicked);
			game.setResult("Lost");
			game.setTimestamp(LocalDateTime.now());
			gameRepository.save(game);
			return game;
		}

		int aiCoinsPicked = remainingCoins % 5;

		Game game = new Game();
		game.setUser(user);
		game.setCoinsPicked(coinsPicked);
		game.setResult("Won");
		game.setTimestamp(LocalDateTime.now());
		gameRepository.save(game);
		return game;
	}


	public List<Game> getGameHistory(org.apache.catalina.User user) {
		return gameRepository.findByUserOrderByTimestampDesc(user);
	}
	public User getUserFromSession(HttpSession session) {
		return (User) session.getAttribute("user");
	}


}
