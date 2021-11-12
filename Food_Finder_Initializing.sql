-- MySQL Script generated by MySQL Workbench
-- Fri Nov 12 14:06:22 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`DietaryRestriction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DietaryRestriction` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DietaryRestriction` (
  `glutenFree` TINYINT NOT NULL,
  `vegan` TINYINT NOT NULL,
  `vegetarian` TINYINT NOT NULL,
  `noPeanut` TINYINT NOT NULL,
  `lactoseFree` TINYINT NOT NULL,
  `kosher` TINYINT NOT NULL,
  `noEgg` TINYINT NOT NULL,
  `noSoy` TINYINT NOT NULL,
  `restrictionID` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`restrictionID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `restrictionID_UNIQUE` ON `mydb`.`DietaryRestriction` (`restrictionID` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`location` ;

CREATE TABLE IF NOT EXISTS `mydb`.`location` (
  `locationID` INT NOT NULL,
  `locationName` VARCHAR(45) NOT NULL,
  `latitude` DECIMAL(10,2) NOT NULL,
  `longtitude` DECIMAL(10,2) NOT NULL,
  `InOrOutDoor` TINYINT NOT NULL,
  PRIMARY KEY (`locationID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`event` ;

CREATE TABLE IF NOT EXISTS `mydb`.`event` (
  `eventID` INT NOT NULL AUTO_INCREMENT,
  `foodName` VARCHAR(45) NOT NULL,
  `availableUntil` DATETIME NOT NULL,
  `foodDescription` VARCHAR(250) NOT NULL,
  `roomNumber` VARCHAR(45) NULL,
  `restrictionID` INT NOT NULL,
  `locationID` INT NOT NULL,
  PRIMARY KEY (`eventID`),
  CONSTRAINT `fk_event_DietaryRestriction`
    FOREIGN KEY (`restrictionID`)
    REFERENCES `mydb`.`DietaryRestriction` (`restrictionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_location1`
    FOREIGN KEY (`locationID`)
    REFERENCES `mydb`.`location` (`locationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `eventID_UNIQUE` ON `mydb`.`event` (`eventID` ASC) VISIBLE;

CREATE INDEX `fk_event_DietaryRestriction_idx` ON `mydb`.`event` (`restrictionID` ASC) VISIBLE;

CREATE INDEX `fk_event_location1_idx` ON `mydb`.`event` (`locationID` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
