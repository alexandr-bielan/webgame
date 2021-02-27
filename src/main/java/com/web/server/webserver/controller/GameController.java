package com.web.server.webserver.controller;


import com.web.server.webserver.domain.Game;
import com.web.server.webserver.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(value = "/match")
    public void save(@RequestBody Game game) {
        gameService.save(game);
    }

    @PutMapping(value = "/match")
    public void update(@RequestBody Game game) {
        gameService.update(game);
    }

    @DeleteMapping(value = "/match/{id}")
    public void deleteById(@PathVariable("id") int matchId) {
        gameService.deleteById(matchId);
    }

    @GetMapping(value = "/match/{id}")
    public Game findById(@PathVariable("id") int id) {
        return gameService.findById(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> exceptionHandler(ConstraintViolationException ex) {

        return new ResponseEntity<>("Message " + ex.getMessage(), HttpStatus.ALREADY_REPORTED);
    }
}
