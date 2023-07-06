package com.ManyToManyhibernatejpa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ManyToManyhibernatejpa.entity.Game;
import com.ManyToManyhibernatejpa.service.GameService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LostController {

	private final GameService gameService;

	public LostController(GameService gameService) {
		this.gameService = gameService;
	}


	@GetMapping("/game_end")
	public String showLostScreen(Model model) {
		HttpSession user = (HttpSession) gameService.getUserFromSession(null);
		List<Game> gameHistory = gameService.getGameHistory((org.apache.catalina.User) user);

		model.addAttribute("gameHistory", gameHistory);
		return "game_end";
	}

//	@PostMapping("/play-again")
//	public String playAgain() {
//		return "redirect:/game-play";
//	}
	@PostMapping("/play-again")
    public String playAgain(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            // Handle unauthorized access or redirect to login
            return "redirect:/login";
        }
        return "redirect:/game-play";
    }
}
