INSERT INTO Tournament (name, numberOfParticipants,  numberOfGames, isActive, version)
VALUES ('football', 1, 1, TRUE, 1);

INSERT INTO Game (participantOnePoints, participantTwoPoints, tournament_fk_id, version)
VALUES ( 1, 1, 1, 1);

INSERT INTO Participant (name, game_fk_id, tournament_fk_id, version)
VALUES ('Tarzheman', 1, 1, 1);


