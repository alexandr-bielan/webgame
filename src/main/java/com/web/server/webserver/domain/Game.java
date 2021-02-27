package com.web.server.webserver.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Game {
    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "finish_time")
    private LocalDateTime finishTime;

    private String participantOne;

    private String participantTwo;

    private int participantOnePoints;

    private int participantTwoPoints;

    @ManyToOne
    @JoinColumn(name = "tournament_fk_id")
//    @Valid
    private Tournament tournament;

    public Game() {
    }

    public Game(int participantOnePoints) {
        this.participantOnePoints = participantOnePoints;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public int getParticipantOnePoints() {
        return participantOnePoints;
    }

    public void setParticipantOnePoints(int participantOnePoints) {
        this.participantOnePoints = participantOnePoints;
    }

    public int getParticipantTwoPoints() {
        return participantTwoPoints;
    }

    public void setParticipantTwoPoints(int participantTwoPoints) {
        this.participantTwoPoints = participantTwoPoints;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getParticipantOne() {
        return participantOne;
    }

    public void setParticipantOne(String participantOne) {
        this.participantOne = participantOne;
    }

    public String getParticipantTwo() {
        return participantTwo;
    }

    public void setParticipantTwo(String participantTwo) {
        this.participantTwo = participantTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return version == game.version &&
                id == game.id &&
                participantOnePoints == game.participantOnePoints &&
                participantTwoPoints == game.participantTwoPoints &&
                Objects.equals(startTime, game.startTime) &&
                Objects.equals(finishTime, game.finishTime) &&
                Objects.equals(participantOne, game.participantOne) &&
                Objects.equals(participantTwo, game.participantTwo) &&
                Objects.equals(tournament, game.tournament);
    }
}
