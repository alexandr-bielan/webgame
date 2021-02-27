package com.web.server.webserver.service;

import com.web.server.webserver.domain.Participant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

@Sql(scripts = {"classpath:sql_scripts/participant/CreateTablePart.sql",
        "classpath:sql_scripts/participant/TruncateTablePart.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class ParticipantServiceTest {

    @Autowired
    private ParticipantService service;

    @Test
    public void shouldSaveParticipant() {
        Participant participant = new Participant();

        service.save(participant);

        Participant participant1 = service.findById(1);

        Assert.assertEquals(participant, participant1);
    }

    @Test
    public void shouldDeleteParticipant() {
        Participant participant = new Participant();

        service.save(participant);

        service.deleteById(1);

        Assert.assertTrue(service.findById(1) == null);
    }

    @Test
    public void shouldFindParticipant() {
        Participant participant = new Participant();

        service.save(participant);

        Participant participant1 = service.findById(1);

        Assert.assertEquals(participant1.getId(), 1);
    }

    @Test
    public void shouldUpdateParticipant() {
        Participant participant = new Participant();

        service.save(participant);

        participant.setId(1);

        service.update(participant);

        Participant updatedParticipant = service.findById(1);

        Assert.assertEquals(updatedParticipant.getId(), 1);
    }
}
