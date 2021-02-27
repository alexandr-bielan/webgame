package com.web.server.webserver.repository;

import com.web.server.webserver.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashSet;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    Participant findById(int id);

    @Query(value = "DELETE p " +
            "FROM Participant p " +
            "INNER JOIN Tournament t " +
            "ON p.tournament_fk_id  =  t.tournament_id\n" +
            "WHERE p.participant_id = id " +
            "AND t.is_active = false ", nativeQuery = true)
    void deleteById(int id);

    HashSet<Participant> findParticipantByTournamentId(int id);

}
