package com.web.server.webserver.dao;

import com.web.server.webserver.domain.Game;

public interface GameDAO extends CrudDAO<Game> {
    Game findById(int id);
}
