-- MySQL Script generated by MySQL Workbench
-- Fri Nov 12 14:06:22 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FreeFoodFinderDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FreeFoodFinderDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FreeFoodFinderDB` DEFAULT CHARACTER SET utf8 ;
USE `FreeFoodFinderDB` ;

-- -----------------------------------------------------
-- Table `FreeFoodFinderDB`.`dietary_restriction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FreeFoodFinderDB`.`dietary_restriction` ;

CREATE TABLE IF NOT EXISTS `FreeFoodFinderDB`.`dietary_restriction` (
  `gluten_free` TINYINT NOT NULL,
  `vegan` TINYINT NOT NULL,
  `vegetarian` TINYINT NOT NULL,
  `no_peanut` TINYINT NOT NULL,
  `lactose_free` TINYINT NOT NULL,
  `kosher` TINYINT NOT NULL,
  `no_egg` TINYINT NOT NULL,
  `no_soy` TINYINT NOT NULL,
  `restrictionID` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`restrictionID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `restrictionID_UNIQUE` ON `FreeFoodFinderDB`.`dietary_restriction` (`restrictionID` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `FreeFoodFinderDB`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FreeFoodFinderDB`.`location` ;

CREATE TABLE IF NOT EXISTS `FreeFoodFinderDB`.`location` (
  `locationID` INT NOT NULL AUTO_INCREMENT,
  `location_name` VARCHAR(45) NOT NULL,
  `latitude` DECIMAL(10,5) NOT NULL,
  `longitude` DECIMAL(10,5) NOT NULL,
  `address` VARCHAR(100),
  `is_outdoor` TINYINT NOT NULL,
  PRIMARY KEY (`locationID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FreeFoodFinderDB`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FreeFoodFinderDB`.`event` ;

CREATE TABLE IF NOT EXISTS `FreeFoodFinderDB`.`event` (
  `eventID` INT NOT NULL AUTO_INCREMENT,
  `food_name` VARCHAR(45) NOT NULL,
  `available_until` DATETIME NOT NULL,
  `food_description` VARCHAR(250) NOT NULL,
  `room_number` VARCHAR(45) NULL,
  `restrictionID` INT NOT NULL,
  `locationID` INT NOT NULL,
  `report_count` INT NOT NULL,
  PRIMARY KEY (`eventID`),
  CONSTRAINT `fk_event_dietary_restriction`
    FOREIGN KEY (`restrictionID`)
    REFERENCES `FreeFoodFinderDB`.`dietary_restriction` (`restrictionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_location1`
    FOREIGN KEY (`locationID`)
    REFERENCES `FreeFoodFinderDB`.`location` (`locationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `eventID_UNIQUE` ON `FreeFoodFinderDB`.`event` (`eventID` ASC) VISIBLE;

CREATE INDEX `fk_event_dietary_restriction_idx` ON `FreeFoodFinderDB`.`event` (`restrictionID` ASC) VISIBLE;

CREATE INDEX `fk_event_location1_idx` ON `FreeFoodFinderDB`.`event` (`locationID` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
