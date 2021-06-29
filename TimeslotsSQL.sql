CREATE SCHEMA IF NOT EXISTS `timeslots`;
USE `timeslots`;

DROP TABLE IF EXISTS `payment_method`;

CREATE TABLE IF NOT EXISTS `payment_method` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;

DROP TABLE IF EXISTS `timeslot`;

CREATE TABLE IF NOT EXISTS `timeslot` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tennis_player_id` INT NOT NULL,
  `tennis_court_id` INT NOT NULL,
  `date_of_reservation` DATE NOT NULL,
  `duration` INT NOT NULL,
  `time_of_reservation` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

ALTER TABLE `timeslot` ADD CONSTRAINT `uq_timeslot` UNIQUE(`tennis_player_id`, `date_of_reservation`);

DROP TABLE IF EXISTS `paid_for_tennis_player` ;

CREATE TABLE IF NOT EXISTS `paid_for_tennis_player` (
  `tennis_player_id` INT NOT NULL,
  `payment_method_id` INT NOT NULL,
  PRIMARY KEY (`tennis_player_id`),
  INDEX `fk_paid_for_tennis_player_payment_method_idx` (`payment_method_id` ASC) VISIBLE,
  CONSTRAINT `fk_paid_for_tennis_player_payment_method`
    FOREIGN KEY (`payment_method_id`)
    REFERENCES `payment_method` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `payment_method` VALUES (1, 'CASH'), (2, 'CREDIT CARD');