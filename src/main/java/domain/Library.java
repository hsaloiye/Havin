package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Library {
	private List<Game> games;
	
	public Library (){
		games = new ArrayList<Game>();
		String[] gameNames = {"Checkers", "Monopoly", "Dominion", "Splendor"};
		for(String name : gameNames) {
			games.add(new Game(name));
		}	
	}
	
	public Game selectGame() {
		Random randomIndex = new Random();
		Game randomGame = games.get(randomIndex.nextInt(games.size()));
		return randomGame;
	}
	
	
}
