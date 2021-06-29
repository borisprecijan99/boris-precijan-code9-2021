CREATE SCHEMA IF NOT EXISTS `tennis_courts`;
USE `tennis_courts`;

DROP TABLE IF EXISTS `tennis_court`;

CREATE TABLE `tennis_court` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tennis_court` VALUES (1, 'Arthur Ashe Stadium'),
								  (2, 'Wimbledon Centre Court'),
                                  (3, 'Court Philippe Chatrier'),
                                  (4, 'O2 Arena'),
                                  (5, 'Indian Wells Tennis Garden');