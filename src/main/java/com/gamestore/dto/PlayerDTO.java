package com.gamestore.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gamestore.entities.Game;
import com.gamestore.entities.Player;

public class PlayerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nick;
	private String email;
	private String password;
	private Double wallet;
	
	private List<GameDTO> games = new ArrayList<>();
	
	public PlayerDTO() {
		
	}

	public PlayerDTO(Long id, String nick, String email, String password, Double wallet) {
		
		this.id = id;
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.wallet = wallet;
	}
	
	public PlayerDTO(Player entity) {
		this.id = entity.getId();
		this.nick = entity.getNick();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
		this.wallet = entity.getWallet();
	}
	
	public PlayerDTO(Player entity, Set<Game> games) {
		this(entity);
		games.forEach(g -> this.games.add(new GameDTO(g)) );
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public List<GameDTO> getGames() {
		return games;
	}

	public void setGames(List<GameDTO> games) {
		this.games = games;
	}
	
}
