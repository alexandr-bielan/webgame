package com.web.server.webserver.service;

import com.web.server.webserver.domain.Game;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"classpath:sql_scripts/game/CreateTableGame.sql",
        "classpath:sql_scripts/game/TruncateTableGame.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class GameServiceTest {

    @Autowired
    private GameService service;

    @Test
    public void shouldSaveGame() {
        Game game = new Game();

        service.save(game);

        Game game1 = service.findById(1);

        Assert.assertEquals(game, game1);
    }

    @Test
    public void shouldDeleteGame() {
        Game game = new Game();

        service.save(game);

        service.deleteById(1);

        Assert.assertTrue(service.findById(1) == null);
    }

    @Test
    public void shouldFindGame() {
        Game game = new Game();

        service.save(game);

        Game game1 = service.findById(1);

        Assert.assertEquals(game1.getId(), 1);
    }

    @Test
    public void shouldUpdateGame() {
        Game game = new Game();

        service.save(game);

        game.setId(1);

        service.update(game);

        Game updatedGame = service.findById(1);

        Assert.assertEquals(updatedGame.getId(), 1);
    }
}
