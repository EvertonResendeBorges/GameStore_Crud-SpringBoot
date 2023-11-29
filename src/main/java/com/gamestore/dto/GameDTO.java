package com.gamestore.dto;

import java.io.Serializable;

import com.gamestore.entities.Game;

public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String genrer;
	private String platform;
	private Double price;
	private Integer release;
	private String description;
	
	public GameDTO() {
		
	}

	public GameDTO(Long id, String name, String genrer, String platform, Double price, Integer release,
			String description) {
		this.id = id;
		this.name = name;
		this.genrer = genrer;
		this.platform = platform;
		this.price = price;
		this.release = release;
		this.description = description;
	}
	
	public GameDTO(Game entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.genrer = entity.getGenrer();
		this.platform = entity.getPlatform();
		this.price = entity.getPrice();
		this.release = entity.getRelease();
		this.description = entity.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenrer() {
		return genrer;
	}

	public void setGenrer(String genrer) {
		this.genrer = genrer;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getRelease() {
		return release;
	}

	public void setRelease(Integer release) {
		this.release = release;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
