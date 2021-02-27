package com.web.server.webserver.controller;

import com.web.server.webserver.domain.Participant;
import com.web.server.webserver.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("participants")
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping(value = "/attendee")
    public void save(@RequestBody Participant participant) {
        participantService.save(participant);
    }

    @PutMapping(value = "/attendee")
    public void update(@RequestBody Participant participant) {
        participantService.update(participant);
    }

    @DeleteMapping(value = "/attendee/{id}")
    public void deleteById(@PathVariable("id") int participantId) {
        participantService.deleteById(participantId);
    }

    @GetMapping(value = "/attendee/{id}")
    public Participant findById(@PathVariable("id") int id) {
        return participantService.findById(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> exceptionHandler(ConstraintViolationException ex) {

        return new ResponseEntity<>("Message " + ex.getMessage(), HttpStatus.ALREADY_REPORTED);
    }
}
