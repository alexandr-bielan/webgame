package com.web.server.webserver.service.impl;

import com.web.server.webserver.domain.Tournament;
import com.web.server.webserver.repository.TournamentRepository;
import com.web.server.webserver.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    public TournamentServiceImpl() {
    }

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public void save(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    @Override
    public void deleteById(int id) {
        tournamentRepository.deleteById(id);
    }

    @Override
    public void update(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    @Override
    public Tournament findById(int id) {
        return tournamentRepository.findById(id);
    }
}
