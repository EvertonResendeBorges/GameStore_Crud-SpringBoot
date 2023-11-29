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

import com.gamestore.dto.GameDTO;
import com.gamestore.entities.Game;
import com.gamestore.repositories.GameRepository;
import com.gamestore.services.exceptions.DatabaseException;
import com.gamestore.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public Page<GameDTO> findAllPaged(PageRequest pageRequest) {
		Page<Game> list = repository.findAll(pageRequest);
		return list.map(x -> new GameDTO(x));
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Optional<Game> obj = repository.findById(id);
		Game entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new GameDTO(entity);
	}

	@Transactional
	public GameDTO insert(GameDTO dto) {
		Game entity = new Game();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new GameDTO(entity);
	}

	@Transactional
	public GameDTO update(Long id, GameDTO dto) {
		try {
			Game entity = repository.getOne(id); //Em versões mais recentes virou 'getReferenceById'
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new GameDTO(entity);
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
