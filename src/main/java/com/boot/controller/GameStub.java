package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.model.Game;

public class GameStub {
	private static Map<Long, Game> games = new HashMap<Long, Game>();
	private static Long idIndex = 3L;

	//populate initial games
	static {
		Game a = new Game(1L, "Monopoly", "A vicious game that destroys friendships", "3 hours", 2, 6, "Classic");
		games.put(1L, a);
		Game b = new Game(2L, "Risk", "World Domination. Enough said.", "1 hours", 2, 6, "Strategy");
		games.put(2L, b);
		Game c = new Game(3L, "Chess", "A classic game of the kings", "45 minutes", 2, 2, "Strategy");
		games.put(3L, c);
	}

	public static List<Game> list() {
		return new ArrayList<Game>(games.values());
	}

	public static Game create(Game game) {
		idIndex += idIndex;
		game.setId(idIndex);
		games.put(idIndex, game);
		return game;
	}

	public static Game get(Long id) {
		return games.get(id);
	}

	public static Game update(Long id, Game game) {
		games.put(id, game);
		return game;
	}

	public static Game delete(Long id) {
		return games.remove(id);
	}
}
