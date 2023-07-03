-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema vote_pet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema vote_pet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vote_pet` DEFAULT CHARACTER SET utf8 ;
USE `vote_pet` ;

-- -----------------------------------------------------
-- Table `vote_pet`.`PETS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vote_pet`.`PETS` (
    `PET_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `NAME` VARCHAR(45) NOT NULL,
    `IMAGE_URL` VARCHAR(200) NOT NULL,
    `TITLE` VARCHAR(200) NOT NULL,
    `DESCRIPTION` TEXT NOT NULL,
    `VOTE_COUNT` INT(11) NULL DEFAULT NULL,
    `CREATED_BY` VARCHAR(45) NULL DEFAULT NULL,
    `CREATE_DATE_TIME` DATETIME NULL DEFAULT NULL,
    `MODIFIED_BY` VARCHAR(45) NULL DEFAULT NULL,
    `MODIFIED_DATE_TIME` DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (`PET_ID`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 13
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `vote_pet`.`LIKES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vote_pet`.`LIKES` (
    `LIKE_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `PET_ID` BIGINT(20) NOT NULL,
    `STATUS` BIT NOT NULL,
    `USER_ID` VARCHAR(50) NOT NULL,
    `CREATED_BY` VARCHAR(45) NULL DEFAULT NULL,
    `CREATE_DATE_TIME` DATETIME NULL DEFAULT NULL,
    `MODIFIED_BY` VARCHAR(45) NULL DEFAULT NULL,
    `MODIFIED_DATE_TIME` DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (`LIKE_ID`),
    CONSTRAINT `fk_like_pet`
    FOREIGN KEY (`PET_ID`)
    REFERENCES `vote_pet`.`PETS` (`PET_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    AUTO_INCREMENT = 13
    DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
