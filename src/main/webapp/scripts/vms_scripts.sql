create database vms;

use vms;

CREATE TABLE `vms`.`login` (
  `loginId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`loginId`));
  
INSERT INTO `vms`.`login` (`username`, `password`) VALUES ('admin', 'admin');

CREATE TABLE `vms`.`babyDetails` (
  `babyId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `fatherName` VARCHAR(255) NULL,
  `motherName` VARCHAR(255) NULL,
  `placeOfBirth` varchar(255) NULL,
  PRIMARY KEY (`babyId`));

desc babydetails;

CREATE TABLE `vms`.`booking` (
  `bookingId` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `doctorName` VARCHAR(255) NULL,
  `vaccinationType` VARCHAR(255) NULL,
  `babyId` INT NULL,
  PRIMARY KEY (`bookingId`),
  INDEX `baby_booking_fk_idx` (`babyId` ASC) VISIBLE,
  CONSTRAINT `baby_booking_fk`
    FOREIGN KEY (`babyId`)
    REFERENCES `vms`.`babydetails` (`babyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);