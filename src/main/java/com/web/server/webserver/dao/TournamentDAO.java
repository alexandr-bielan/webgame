package com.web.server.webserver.dao;

import com.web.server.webserver.domain.Tournament;

public interface TournamentDAO extends CrudDAO<Tournament> {
    Tournament findById(int id);
}
