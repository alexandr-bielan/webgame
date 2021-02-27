package com.web.server.webserver.service.impl;

import com.web.server.webserver.domain.Participant;
import com.web.server.webserver.repository.ParticipantRepository;
import com.web.server.webserver.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public void save(Participant participant) {
        participantRepository.save(participant);
    }

    @Override
    public void deleteById(int id) {
        participantRepository.deleteById(id);
    }

    @Override
    public void update(Participant participant) {
        participantRepository.save(participant);
    }

    @Override
    public Participant findById(int id) {
        return participantRepository.findById(id);
    }
}
