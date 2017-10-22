package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void setNameTest(){
		Game game = new Game();
		
		game.setName("Dominion");
		
		assertEquals("Dominion", game.getName());
	}
	
	@Test
	public void getNameTest() {
		Game game = new Game("Checkers");
		
		assertEquals("Checkers", game.getName());
	}
}
