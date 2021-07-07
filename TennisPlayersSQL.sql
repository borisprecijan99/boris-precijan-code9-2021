CREATE SCHEMA IF NOT EXISTS `tennis_players`;
USE `tennis_players`;

DROP TABLE IF EXISTS `tennis_player`;

CREATE TABLE `tennis_player` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tennis_player` VALUES (1, 'Novak', 'Djokovic', '1987-05-22', 'nole1987@gmail.com'),
									(2, 'Serena', 'Williams', '1981-11-26', 'serena@gmail.com'),
                                    (3, 'Rafael', 'Nadal', '1986-06-03', 'nadal@gmail.com'),
                                    (4, 'Roger', 'Federer', '1981-08-08', 'federer@gmail.com'),
                                    (5, 'Andrew', 'Murray', '1987-05-15', 'murray@gmail.com');