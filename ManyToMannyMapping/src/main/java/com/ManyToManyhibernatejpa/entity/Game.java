package com.ManyToManyhibernatejpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "games")
public class Game {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false)
	private int coinsPicked;

	@Column(nullable = false)
	private String result;

	@Column(nullable = false)
	private LocalDateTime timestamp;

	public Game() {
		super();
	}

	public Game(Long id, User user, int coinsPicked, String result, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.coinsPicked = coinsPicked;
		this.result = result;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCoinsPicked() {
		return coinsPicked;
	}

	public void setCoinsPicked(int coinsPicked) {
		this.coinsPicked = coinsPicked;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
