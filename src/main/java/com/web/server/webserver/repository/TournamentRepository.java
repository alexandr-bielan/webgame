package com.web.server.webserver.repository;

import com.web.server.webserver.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    Tournament findById(int id);

    void deleteById(int id);


}
