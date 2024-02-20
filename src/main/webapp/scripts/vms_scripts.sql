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