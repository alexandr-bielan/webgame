package com.web.server.webserver.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MatchGrid {
    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_grid_id")
    private int id;

    private String participantOne;

    private String participantTwo;

    private int participantOnePoints;

    private int participantTwoPoints;

    @ManyToOne
    @JoinColumn(name = "tournament_fk_id")
    private Tournament tournament;

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
        MatchGrid matchGrid = (MatchGrid) o;
        return version == matchGrid.version &&
                id == matchGrid.id &&
                participantOnePoints == matchGrid.participantOnePoints &&
                participantTwoPoints == matchGrid.participantTwoPoints &&
                Objects.equals(participantOne, matchGrid.participantOne) &&
                Objects.equals(participantTwo, matchGrid.participantTwo) &&
                Objects.equals(tournament, matchGrid.tournament);
    }


}
