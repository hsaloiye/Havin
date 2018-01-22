package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
