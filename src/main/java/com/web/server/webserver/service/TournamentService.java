package com.web.server.webserver.service;

import com.web.server.webserver.domain.Tournament;

public interface TournamentService extends CRUDService<Tournament> {
    Tournament findById(int id);
    /*void launchTourney(Tournament tournament);*/

}
