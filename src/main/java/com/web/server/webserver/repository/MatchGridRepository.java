package com.web.server.webserver.repository;

import com.web.server.webserver.domain.MatchGrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MatchGridRepository extends JpaRepository<MatchGrid, Integer> {
    MatchGrid findById(int id);

    void deleteById(int id);

    @Query(value = "SELECT * FROM MATCH_GRID", nativeQuery = true)
    List<MatchGrid> findAll();

}
