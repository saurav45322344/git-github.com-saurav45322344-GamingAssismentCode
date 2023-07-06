package com.ManyToManyhibernatejpa.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ManyToManyhibernatejpa.entity.Game;
import com.ManyToManyhibernatejpa.entity.GameRequest;
import com.ManyToManyhibernatejpa.entity.LoginScreen;
import com.ManyToManyhibernatejpa.service.GameService;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

	//	@Autowired
	//	private GameService gameService;

	private final GameService gameService;

	public LoginController(GameService gameService) {
		this.gameService = gameService;

	}


	@GetMapping("/login")
	public ResponseEntity<com.ManyToManyhibernatejpa.entity.User> logins(@RequestParam("username") String username, @RequestParam("password") String password) {
		com.ManyToManyhibernatejpa.entity.User user = gameService.login(username, password);
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
	}

	//If user name is correct then sucessfuly login

	@PostMapping("/loginn")
	public ResponseEntity<String> login(@RequestBody LoginScreen loginScreen) {
		String username = loginScreen.getUserName();
		String password = loginScreen.getPassword();


		if ("admin".equals(username) && "admin12".equals(password)) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.badRequest().body("Invalid username or password");
		}
	}


	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/play")
	public ResponseEntity<Game> playGame(@RequestBody GameRequest gameRequest, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		Game game = gameService.playGame((com.ManyToManyhibernatejpa.entity.User) user, gameRequest.getCoinsPicked());
		return ResponseEntity.ok(game);
	}


	@GetMapping("/game/history")
	public String gameHistory(Model model) {
		User user = getUserFromSession();
		List<Game> gameHistory = gameService.getGameHistory(user);
		model.addAttribute("gameHistory", gameHistory);
		return "game_history";
	}


	private User getUserFromSession() {
		return null;
	}

}


