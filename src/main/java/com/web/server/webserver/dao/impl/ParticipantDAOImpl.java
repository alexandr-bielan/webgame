package com.web.server.webserver.dao.impl;


import com.web.server.webserver.dao.ParticipantDAO;
import com.web.server.webserver.domain.Participant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Participant participant) {
        em.persist(participant);
    }

    @Override
    public void update(Participant participant) {
        Participant mergeParticipant = em.merge(participant);
        em.persist(mergeParticipant);
    }

    @Override
    public void deleteById(int id) {
        Participant participant = em.getReference(Participant.class, id);
        em.remove(participant);
    }

    @Override
    public Participant findById(int id) {
        return em.find(Participant.class, id);
    }
}
