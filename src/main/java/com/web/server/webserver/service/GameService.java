package com.web.server.webserver.service;

import com.web.server.webserver.domain.Game;

public interface GameService extends CRUDService<Game> {
    Game findById(int id);
}
