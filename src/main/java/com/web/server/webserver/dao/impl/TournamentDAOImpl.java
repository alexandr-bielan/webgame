package com.web.server.webserver.dao.impl;


import com.web.server.webserver.dao.TournamentDAO;
import com.web.server.webserver.domain.Tournament;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
public class TournamentDAOImpl implements TournamentDAO {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void save(Tournament tournament) {

        em.persist(tournament);
    }

    @Override
    public void update(Tournament tournament) {
        Tournament mergeTournament = em.merge(tournament);
        em.persist(mergeTournament);
    }

    @Override
    public void deleteById(int id) {
        Tournament tournament = em.getReference(Tournament.class, id);
        em.remove(tournament);
    }

    @Override
    public Tournament findById(int id) {

        Query query = em.createNativeQuery(
                "SELECT * FROM Tournament t " +
                "INNER JOIN Participant p " +
                "ON t.tournament_id = p.tournament_fk_id " +
                "WHERE t.tournament_id = ?;", Tournament.class);

        query.setParameter(1, id);

        return (Tournament) query.getSingleResult();
    }
}
