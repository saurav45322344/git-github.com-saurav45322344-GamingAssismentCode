package com.ManyToManyhibernatejpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ManyToManyhibernatejpa.entity.Game;
import com.ManyToManyhibernatejpa.entity.User;
import com.ManyToManyhibernatejpa.service.GameService;

@Controller
public class GameController {


	private final GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping("/game-play")
	public String showGamePlayScreen(Model model) {
		model.addAttribute("coinsLeft", 21);
		return "game-play";
	}

	@PostMapping("/game-play")
	public String playGame(
			@RequestParam int coinsPicked,
			Model model
			) {
		User user = gameService.getUserFromSession(null);
		Game game = gameService.playGame(user, coinsPicked);

		if (game.getResult().equals("Lost")) {
			return "redirect:/game-end";
		} else {
			model.addAttribute("aiCoinsPicked", game.getCoinsPicked());
			return "game-play";
		}
	}


}
