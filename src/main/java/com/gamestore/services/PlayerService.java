package com.gamestore.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamestore.dto.PlayerDTO;
import com.gamestore.entities.Player;
//import com.gamestore.repositories.GameRepository;
import com.gamestore.repositories.PlayerRepository;
import com.gamestore.services.exceptions.DatabaseException;
import com.gamestore.services.exceptions.ResourceNotFoundException;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;
	
	//@Autowired
	//private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public Page<PlayerDTO> findAllPaged(PageRequest pageRequest) {
		Page<Player> list = repository.findAll(pageRequest);
		return list.map(x -> new PlayerDTO(x));
	}

	@Transactional(readOnly = true)
	public PlayerDTO findById(Long id) {
		Optional<Player> obj = repository.findById(id);
		Player entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PlayerDTO(entity, entity.getGames());
	}

	@Transactional
	public PlayerDTO insert(PlayerDTO dto) {
		Player entity = new Player();
		entity.setNick(dto.getNick());
		entity = repository.save(entity);
		return new PlayerDTO(entity);
	}

	@Transactional
	public PlayerDTO update(Long id, PlayerDTO dto) {
		try {
			Player entity = repository.getOne(id); //Em versões mais recentes virou 'getReferenceById'
			entity.setNick(dto.getNick());
			entity = repository.save(entity);
			return new PlayerDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
