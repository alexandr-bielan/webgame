package com.web.server.webserver.service;

import com.web.server.webserver.domain.MatchGrid;
import java.util.ArrayList;
import java.util.List;

public interface MatchGridService extends CRUDService<MatchGrid> {
    MatchGrid findById(int id);

    ArrayList<String> findParticipants(int i);

    List<MatchGrid> saveMatchGrid(int i);
}
