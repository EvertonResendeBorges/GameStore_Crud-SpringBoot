package com.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestore.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
