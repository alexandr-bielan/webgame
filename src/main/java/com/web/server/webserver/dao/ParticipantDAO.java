package com.web.server.webserver.dao;

import com.web.server.webserver.domain.Participant;

public interface ParticipantDAO extends CrudDAO<Participant> {
    Participant findById(int id);

}
