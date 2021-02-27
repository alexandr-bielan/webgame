package com.web.server.webserver.service.impl;

import com.web.server.webserver.domain.Game;
import com.web.server.webserver.repository.GameRepository;
import com.web.server.webserver.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }

    @Override
    public void deleteById(int id) {
        gameRepository.deleteById(id);
    }

    @Override
    public void update(Game game) {
        gameRepository.save(game);
    }

    @Override
    public Game findById(int id) {
        return gameRepository.findById(id);
    }
}
