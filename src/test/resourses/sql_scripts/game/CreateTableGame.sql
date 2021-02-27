CREATE TABLE IF NOT EXISTS Tournament (
tournament_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
version INT,
name VARCHAR(32),
numberOfParticipants INT,
numberOfGames INT,
isActive BIT(1));

ALTER TABLE Tournament auto_increment = 1;

CREATE TABLE IF NOT EXISTS Game (
game_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
version INT,
startTime time,
finishTime time,
participantOnePoints INT,
participantTwoPoints INT,
tournament_fk_id INT NULL,
FOREIGN KEY (tournament_fk_id) REFERENCES Tournament(tournament_id));

ALTER TABLE Game auto_increment = 1;