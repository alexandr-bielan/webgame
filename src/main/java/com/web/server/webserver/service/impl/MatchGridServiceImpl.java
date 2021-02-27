package com.web.server.webserver.service.impl;

import com.web.server.webserver.domain.MatchGrid;
import com.web.server.webserver.domain.Participant;
import com.web.server.webserver.repository.MatchGridRepository;
import com.web.server.webserver.repository.ParticipantRepository;
import com.web.server.webserver.service.MatchGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class MatchGridServiceImpl implements MatchGridService {
    private MatchGridRepository matchGridRepository;
    @Autowired
    private ParticipantRepository participantRepository;


    @Autowired
    public MatchGridServiceImpl(MatchGridRepository matchGridRepository) {
        this.matchGridRepository = matchGridRepository;
    }

    public MatchGridServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public void save(MatchGrid matchGrid) {
        matchGridRepository.save(matchGrid);
    }

    @Override
    public void deleteById(int id) {
        matchGridRepository.deleteById(id);
    }

    @Override
    public void update(MatchGrid matchGrid) {
        matchGridRepository.save(matchGrid);
    }

    @Override
    public MatchGrid findById(int id) {
        return matchGridRepository.findById(id);
    }

    @Override
    public ArrayList<String> findParticipants(int i) {

        HashSet<Participant> participantsForTournament = participantRepository.findParticipantByTournamentId(1);

        if (((participantsForTournament.size()) & ((participantsForTournament.size() - 1))) !=0 ){
            throw new IllegalArgumentException("Number of Participants should be 8, 16, 32 etc. ");
        } else{

            ArrayList<String> participants = new ArrayList<>();

            for (Participant prt : participantsForTournament) {
                participants.add(prt.getName());
            }

            for (int j = participantsForTournament.size(); j < participantsForTournament.size() * 2 - 1; j++) {
                participants.add(j, "Winner of Match " + (j + 1 - participantsForTournament.size()));
            }

            return participants;
        }
    }

    @Override
    public List<MatchGrid> saveMatchGrid(int id) {
        ArrayList<String> list = findParticipants(1);

        List<MatchGrid> matchGrid = new ArrayList<>();

        for (int j = 0; j < list.size() / 2; j++) {
            matchGrid.add(new MatchGrid());
        }

        for (int k = 0; k < list.size() - 1; ) {

            for (MatchGrid m : matchGrid) {
                m.setParticipantOne(list.get(k++));
                m.setParticipantTwo(list.get(k++));
                m.setParticipantOnePoints(0);
                m.setParticipantTwoPoints(0);
            }
        }

        for (MatchGrid m : matchGrid
                ) {
            System.out.print(m.getParticipantOne() + " ");
            System.out.print(m.getParticipantTwo() + " ");
            System.out.print(m.getParticipantOnePoints() + " ");
            System.out.println(m.getParticipantTwoPoints());

        }

        for (MatchGrid m : matchGrid) {
            save(m);
        }
        return matchGrid;
    }
}
