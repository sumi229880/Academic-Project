-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema final
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `final` DEFAULT CHARACTER SET utf8 ;
USE `final` ;

-- -----------------------------------------------------
-- Table `final`.`user_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final`.`user_table` (
  `USER_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` VARCHAR(50) NOT NULL,
  `FIRST_NAME` VARCHAR(30) NOT NULL,
  `HUSKY_ID` VARCHAR(9) NOT NULL,
  `LAST_NAME` VARCHAR(30) NOT NULL,
  `PASSWORD` VARCHAR(255) NOT NULL,
  `PHONE` VARCHAR(10) NOT NULL,
  `USERNAME` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`USER_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `USER_ID` ON `final`.`user_table` (`USER_ID` ASC);

CREATE UNIQUE INDEX `EMAIL` ON `final`.`user_table` (`EMAIL` ASC);

CREATE UNIQUE INDEX `HUSKY_ID` ON `final`.`user_table` (`HUSKY_ID` ASC);

CREATE UNIQUE INDEX `USERNAME` ON `final`.`user_table` (`USERNAME` ASC);

CREATE UNIQUE INDEX `HUSKY_ID_2` ON `final`.`user_table` (`HUSKY_ID` ASC);

CREATE UNIQUE INDEX `EMAIL_2` ON `final`.`user_table` (`EMAIL` ASC);

CREATE UNIQUE INDEX `USERNAME_2` ON `final`.`user_table` (`USERNAME` ASC);


-- -----------------------------------------------------
-- Table `final`.`advertisements_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final`.`advertisements_table` (
  `ADVERT_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `CATEGORY` VARCHAR(30) NOT NULL,
  `DESCRIPITION` TEXT NOT NULL,
  `EMAIL` VARCHAR(30) NOT NULL,
  `PHOTOS` TEXT NOT NULL,
  `PRICE` DOUBLE NOT NULL,
  `TITLE` VARCHAR(100) NOT NULL,
  `YEAR_OLD` VARCHAR(255) NOT NULL,
  `USER_ID` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ADVERT_ID`),
  CONSTRAINT `FK7548F73D6BE39614`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `final`.`user_table` (`USER_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 47
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `ADVERT_ID` ON `final`.`advertisements_table` (`ADVERT_ID` ASC);

CREATE INDEX `FK7548F73D6BE39614` ON `final`.`advertisements_table` (`USER_ID` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
