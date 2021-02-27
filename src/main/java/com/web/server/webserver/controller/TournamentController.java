package com.web.server.webserver.controller;


import com.web.server.webserver.domain.Tournament;
import com.web.server.webserver.service.TournamentService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.web.server.webserver.service.MatchGridService;


@RestController
@RequestMapping("tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(value = "/tourney")
    public void save(@RequestBody Tournament tournament) {
        tournamentService.save(tournament);
    }

    @PutMapping(value = "/tourney")
    public void update(@RequestBody Tournament tournament) {
        tournamentService.update(tournament);
    }

    @PostMapping(value = "/launch-tourney")
    public void launchTourney(@RequestBody Tournament tournament) {
        tournamentService.update(tournament);
    }

    @DeleteMapping(value = "/tourney/{id}")
    public void deleteById(@PathVariable("id") int tournamentId) {
        tournamentService.deleteById(tournamentId);
    }

    @GetMapping(value = "/tourney/{id}")
    public Tournament findById(@PathVariable("id") int id) {
        return tournamentService.findById(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> exceptionHandler(ConstraintViolationException ex) {

        return new ResponseEntity<>("Message " + ex.getMessage(), HttpStatus.ALREADY_REPORTED);
    }
}
