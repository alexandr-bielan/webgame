package com.web.server.webserver.dao.impl;



import com.web.server.webserver.dao.GameDAO;
import com.web.server.webserver.domain.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GameDAOImpl implements GameDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void save(Game game) {
        em.persist(game);
    }

    @Override
    public void update(Game game) {
        Game mergeGame = em.merge(game);
        em.persist(mergeGame);

    }

    @Override
    public void deleteById(int id) {
        Game game = em.getReference(Game.class, id);
        em.remove(game);
    }

    @Override
    public Game findById(int id) {
        return em.find(Game.class, id);
    }
}
