package com.web.server.webserver.service;

import com.web.server.webserver.domain.Tournament;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
 @SpringBootTest

@Sql(scripts = {"classpath:sql_scripts/tournament/CreateTableTournament.sql",
        "classpath:sql_scripts/tournament/TruncateTableTournament.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class TournamentServiceTest {

    @Autowired
    private TournamentService service;

    @Test
    public void shouldSaveTournament() {
        Tournament tournament = new Tournament("Soccer");

        service.save(tournament);

        Tournament tournament1 = service.findById(1);

        Assert.assertEquals(tournament, tournament1);
    }

    @Test
    public void shouldDeleteTournament() {
        Tournament tournament = new Tournament("Soccer");

        service.save(tournament);

        service.deleteById(1);

        Assert.assertTrue(service.findById(1) == null);
    }

    @Test
    public void shouldFindTournament() {
        Tournament tournament = new Tournament("Soccer");

        service.save(tournament);

        Tournament tournament1 = service.findById(1);

        Assert.assertEquals(tournament1.getId(), 1);
    }

    @Test
    public void shouldUpdateTournament() {
        Tournament tournament = new Tournament("Soccer");

        service.save(tournament);

        tournament.setId(1);

        service.update(tournament);

        Tournament updatedTournament = service.findById(1);

        Assert.assertEquals(updatedTournament.getId(), 1);
    }
}
