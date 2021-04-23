package com.web.server.webserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
public class Tournament {
    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private int id;

    @Column(unique = true)
    @Size(min = 5, message = "Name should be from 5 to 344344 symbol ")
    private String name;

    @JsonProperty(value = "isActive")
    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "number_of_participants")
    private Integer numberOfParticipants;

    @Column(name = "number_of_games")
    private Integer numberOfGames;


    public Tournament() {
    }

    public Tournament(String name) {
        this.name = name;
    }

    public Integer getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(Integer numberOfGames) {
        this.numberOfGames = numberOfGames;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return version == that.version &&
                id == that.id &&
                isActive == that.isActive &&
                Objects.equals(name, that.name);
    }


}
