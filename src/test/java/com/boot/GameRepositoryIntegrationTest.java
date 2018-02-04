package com.boot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.boot.model.Game;
import com.boot.repository.GameRepository;

public class GameRepositoryIntegrationTest extends TestBase {
	
	@Autowired
	GameRepository gameRepository;
	
	@Test
	public void testFindAll() {
		List<Game> games = gameRepository.findAll();
		assertThat(games.size(), is(greaterThanOrEqualTo(0)));
	}

}
