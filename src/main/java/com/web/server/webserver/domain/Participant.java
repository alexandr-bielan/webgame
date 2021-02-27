package com.web.server.webserver.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Participant {
    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")

    private int id;

    @Column(unique = true)
    @Size(min = 5, message = "Name should be from 5 to 344344 symbol ")
    private String name;

    @ManyToOne
    @JoinColumn(name = "game_fk_id")
    //   @Valid
    private Game game;

    @ManyToOne
    @JoinColumn(name = "tournament_fk_id")
    // @Valid
    private Tournament tournament;

    public Participant() {
    }

    public Participant(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return version == that.version &&
                id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(game, that.game) &&
                Objects.equals(tournament, that.tournament);
    }
}
