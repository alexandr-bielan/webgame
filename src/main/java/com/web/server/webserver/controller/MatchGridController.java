package com.web.server.webserver.controller;

import com.web.server.webserver.domain.MatchGrid;
import com.web.server.webserver.service.MatchGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("match-grid")
public class MatchGridController {
    private final MatchGridService matchGridService;

    @Autowired
    public MatchGridController(MatchGridService matchGridService) {
        this.matchGridService = matchGridService;
    }

    @PostMapping(value = "/match")
    public void save(@RequestBody MatchGrid matchGrid) {
        matchGridService.save(matchGrid);
    }

    @PutMapping(value = "/match")
    public void update(@RequestBody MatchGrid matchGrid) {
        matchGridService.update(matchGrid);
    }

    @DeleteMapping(value = "/match/{id}")
    public void deleteById(@PathVariable("id") int id) {
        matchGridService.deleteById(id);
    }

    @GetMapping(value = "/launch-grid/{id}")
    public List<MatchGrid> getGrid(@PathVariable("id") int id) {

        return matchGridService.saveMatchGrid(id);
    }

    @GetMapping(value = "/match/{id}")
    public MatchGrid findById(@PathVariable("id") int id) {
        return matchGridService.findById(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> exceptionHandler(ConstraintViolationException ex) {

        return new ResponseEntity<>("Message " + ex.getMessage(), HttpStatus.ALREADY_REPORTED);
    }
}
