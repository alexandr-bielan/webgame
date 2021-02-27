package com.web.server.webserver.repository;

import com.web.server.webserver.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findById(int id);

    void deleteById(int id);
}
