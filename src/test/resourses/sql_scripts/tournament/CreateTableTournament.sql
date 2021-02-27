CREATE TABLE IF NOT EXISTS Tournament (
tournament_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
version INT,
name VARCHAR(32),
numberOfParticipants INT,
numberOfGames INT,
isActive BIT(1));

ALTER TABLE Tournament auto_increment = 1;

