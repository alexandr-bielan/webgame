package com.web.server.webserver.service;

import com.web.server.webserver.domain.Participant;

public interface ParticipantService extends CRUDService<Participant>{
    Participant findById(int id);

}
