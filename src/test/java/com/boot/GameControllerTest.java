package com.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.GameController;
import com.boot.model.Game;
import com.boot.repository.GameRepository;

public class GameControllerTest extends TestBase{
	
	@InjectMocks
	private GameController controller;
	
	@Mock
	private GameRepository gameRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void list_shoudReturnAListOfAllGames() {
		Game game1Mock = new Game();
		game1Mock.setId(1L);
		Game game2Mock = new Game();
		game2Mock.setId(2L);
		List <Game> expectedList = new ArrayList<Game>();
		expectedList.add(game1Mock);
		expectedList.add(game2Mock);
		when(gameRepository.findAll()).thenReturn(expectedList);
		
		List <Game> actualList = controller.list();
		
		verify(gameRepository).findAll();
		assertThat(actualList.size(), is(2));
		assert(actualList.contains(game1Mock));
		assert(actualList.contains(game2Mock));
	}
	
	//TODO figure out how the saveAndFlush works - why doesnt' this work without the mock?
	@Test
	public void create_shouldAddANewGameToTheDatabase(){
		Game addedGame = new Game(3L, "NewGame", "Imaginary", "1", 0, 0, "testOnly");
		assert(!controller.list().contains(addedGame));
		when(gameRepository.saveAndFlush(addedGame)).thenReturn(addedGame);
		
		Game actualGame = controller.create(addedGame);
		
		verify(gameRepository).saveAndFlush(addedGame);
		assertThat(actualGame, is(addedGame));
		//assertThat(controller.list().size(), is(1));
		
		controller.delete(3L);
	}
	
	@Test
	public void get_shouldReturnGameAtSpecifiedId() {
		Game gameMock = new Game();
		gameMock.setId(1L);
		when(gameRepository.findOne(1L)).thenReturn(gameMock);
		
		Game game = controller.get(1L);
		
		verify(gameRepository).findOne(1L);
		assertThat(game.getId(), is(1L));
	}
	
	@Test
	public void update_shouldUpdateTheSpecifiedGameEntry() {
		Game mockGame = new Game(1L, "NewGame", "Imaginary", "1", 0, 0, "testOnly");
		when(gameRepository.saveAndFlush(mockGame)).thenReturn(mockGame);
		controller.create(mockGame);
		
		when(gameRepository.findOne(1L)).thenReturn(mockGame);
		Game updatedMockGame = new Game(1L, "OurGame", "Imaginary", "1", 0, 0, "testOnly");
		when(gameRepository.saveAndFlush(updatedMockGame)).thenReturn(updatedMockGame);
		
		Game actualUpdatedGame = controller.update(1L, updatedMockGame);
		verify(gameRepository).findOne(1L);
		
		assertThat(actualUpdatedGame.getName(), is("OurGame"));
		
	}
	//Gave up on testing this...stopped at verifying delete is called
	//TODO: better understand how to test add and delete from mock DB calls
	@Test
	public void delete_shouldRemoveTheSpecifiedGame() {
		Game mockGame = new Game(2L, "NewGame", "Imaginary", "1 hour", 0, 0, "testOnly");
		when(gameRepository.findOne(2L)).thenReturn(mockGame);
		
		controller.delete(2L);
		verify(gameRepository).findOne(2L);
		
		verify(gameRepository,  times(1)).delete(mockGame);
	}

}
