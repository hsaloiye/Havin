package com.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.GameController;
import com.boot.model.Game;
import com.boot.repository.GameRepository;

public class GameControllerTest {
	
	@InjectMocks
	private GameController controller;
	
	@Mock
	private GameRepository gameRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testListGame() {
		
		
	}
	@Test
	public void testGameGet() {
		Game gameMock = new Game();
		gameMock.setId(1L);
		when(gameRepository.findOne(1L)).thenReturn(gameMock);
		Game game = controller.get(1L);
		
		verify(gameRepository).findOne(1L);
		
		//assertEquals(1L, game.getId());
		assertThat(game.getId(), is(1L));
	}
	
	

}
