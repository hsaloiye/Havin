package com.boot.controller;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Game;
import com.boot.repository.GameRepository;

@RestController
@RequestMapping("api/v1/")
public class GameController {
	@Autowired
	private GameRepository gameRepository;
	
	@RequestMapping(value = "games", method = RequestMethod.GET)
	public List<Game> list(){
		return gameRepository.findAll();
	}
	
	@RequestMapping(value = "games", method = RequestMethod.POST)
	public Game create(@RequestBody Game game) {
		return gameRepository.saveAndFlush(game);
	}
	
	@RequestMapping(value = "games/{id}", method = RequestMethod.GET)
	public Game get(@PathVariable Long id) {
		return gameRepository.findOne(id);
	}

	@RequestMapping(value = "games/{id}", method = RequestMethod.PUT)
	public Game update(@PathVariable Long id, @RequestBody Game game) {
		Game existingGame = gameRepository.findOne(id);
		BeanUtils.copyProperties(game, existingGame);
		return gameRepository.saveAndFlush(existingGame);
	}
	
	@RequestMapping(value = "games/{id}", method = RequestMethod.DELETE)
	public Game delete(@PathVariable Long id) {
		Game existingGame = gameRepository.findOne(id);
		gameRepository.delete(existingGame);
		return existingGame;
	}
	
}
	
