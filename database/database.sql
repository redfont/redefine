/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jrdumayag
 * Created: 05 20, 17
 */
CREATE DATABASE `redfin` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `redfin`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `date_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `date_updated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`));

create trigger user_update before update on users
for each row set NEW.date_updated = CURRENT_TIMESTAMP;

CREATE TABLE `redfin`.`categories` (
  `code` VARCHAR(50) NOT NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC));

create trigger category_update before update on categories
for each row set NEW.date_updated = CURRENT_TIMESTAMP;

ALTER TABLE `redfin`.`categories` 
ADD COLUMN `date_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP AFTER `description`,
ADD COLUMN `date_updated` TIMESTAMP NULL AFTER `date_created`,
ADD COLUMN `created_by` VARCHAR(100) NULL AFTER `date_updated`,
ADD COLUMN `updated_by` VARCHAR(100) NULL AFTER `created_by`;

insert into categories(`code`,`description`,`date_created`) values ('D', 'Dress', CURRENT_TIMESTAMP);
insert into categories(`code`,`description`,`date_created`) values ('S', 'Shorts', CURRENT_TIMESTAMP);

CREATE TABLE `redfin`.`expense_types` (
  `code` VARCHAR(50) NOT NULL,
  `description` VARCHAR(200) NULL,
  `date_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `date_updated` TIMESTAMP NULL,
  `created_by` VARCHAR(100) NULL,
  `updated_by` VARCHAR(100) NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC));

create trigger expense_type_update before update on expense_types
for each row set NEW.date_updated = CURRENT_TIMESTAMP;

CREATE TABLE `redfin`.`contact_types` (
  `code` VARCHAR(50) NOT NULL,
  `description` VARCHAR(200) NULL,
  `date_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `date_updated` TIMESTAMP NULL,
  `created_by` VARCHAR(100) NULL,
  `updated_by` VARCHAR(100) NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC));
USE `redfin`;

DELIMITER $$

DROP TRIGGER IF EXISTS redfin.contact_types_update$$
USE `redfin`$$
CREATE TRIGGER `contact_types_update` BEFORE UPDATE ON `contact_types` 
FOR EACH ROW set NEW.date_updated = CURRENT_TIMESTAMP;
$$
DELIMITER ;

ALTER TABLE `redfin`.`contact_types` 
CHANGE COLUMN `date_created` `date_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ;

CREATE TABLE `redfin`.`persons` (
  `person_id` BIGINT(20) NOT NULL,
  `firstname` VARCHAR(200) NULL,
  `middlename` VARCHAR(200) NULL,
  `lastname` VARCHAR(200) NULL,
  `email` VARCHAR(200) NULL,
  `birthdate` DATE NULL,
  `date_created` TIMESTAMP NULL,
  `date_updated` TIMESTAMP NULL,
  `created_by` VARCHAR(100) NULL,
  `updated_by` VARCHAR(100) NULL,
  PRIMARY KEY (`person_id`));

ALTER TABLE `redfin`.`persons` 
CHANGE COLUMN `person_id` `person_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

create trigger person_update before update on persons
for each row set NEW.date_updated = CURRENT_TIMESTAMP;

CREATE TABLE `redfin`.`addresses` (
  `address_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `address_1` VARCHAR(200) NULL,
  `address_2` VARCHAR(200) NULL,
  `barangay` VARCHAR(200) NULL,
  `city_or_municipality` VARCHAR(200) NULL,
  `province` VARCHAR(200) NULL,
  `postal_code` VARCHAR(20) NULL,
  `created_by` VARCHAR(100) NULL,
  `updated_by` VARCHAR(100) NULL,
  `date_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `date_updated` TIMESTAMP NULL,
  PRIMARY KEY (`address_id`));

create trigger address_update before update on addresses
for each row set NEW.date_updated = CURRENT_TIMESTAMP;

ALTER TABLE `redfin`.`addresses` 
ADD COLUMN `person_id` BIGINT(20) NULL AFTER `address_id`;

alter table `addresses`
add foreign key (`person_id`) references `persons`(`person_id`);

ALTER TABLE `redfin`.`persons` 
ADD COLUMN `is_prospect` TINYINT(1) NULL DEFAULT 1 AFTER `birthdate`;

ALTER TABLE `redfin`.`persons` 
ADD COLUMN `address_1` VARCHAR(200) NULL AFTER `birthdate`,
ADD COLUMN `address_2` VARCHAR(200) NULL AFTER `address_1`,
ADD COLUMN `barangay` VARCHAR(200) NULL AFTER `address_2`,
ADD COLUMN `city_or_municipality` VARCHAR(200) NULL AFTER `barangay`,
ADD COLUMN `postal_code` VARCHAR(20) NULL AFTER `city_or_municipality`,
ADD COLUMN `is_supplier` TINYINT(1) NULL DEFAULT 0 AFTER `is_prospect`,
ADD COLUMN `is_customer` TINYINT(1) NULL DEFAULT 0 AFTER `is_supplier`;

drop table addresses;

CREATE TABLE `redfin`.`ledgers` (
  `ledger_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `description` VARCHAR(500) NULL,
  PRIMARY KEY (`ledger_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5;

CREATE TABLE `redfin`.`control_accounts` (
  `control_account_id` INT NOT NULL AUTO_INCREMENT,
  `ledger_id` INT NULL,
  `title` VARCHAR(200) NULL,
  `description` VARCHAR(500) NULL,
  PRIMARY KEY (`control_account_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5;

alter table `redfin`.`control_accounts`
add foreign key (`ledger_id`) references `ledgers`(`ledger_id`);

CREATE TABLE `redfin`.`ledger_subsidiaries` (
  `ledger_subsidiary_id` INT NOT NULL,
  `control_account_id` INT NULL,
  `account_name` VARCHAR(200) NULL,
  `description` VARCHAR(500) NULL,
  PRIMARY KEY (`ledger_subsidiary_id`),
  UNIQUE INDEX `account_name_UNIQUE` (`account_name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5;

alter table `redfin`.`ledger_subsidiaries`
add foreign key (`control_account_id`) references `control_accounts`(`control_account_id`);

ALTER TABLE `redfin`.`ledger_subsidiaries` 
CHANGE COLUMN `ledger_subsidiary_id` `ledger_subsidiary_id` INT(11) NOT NULL AUTO_INCREMENT ;

INSERT INTO `redfin`.`ledgers`(`ledger_id`,`title`,`description`) VALUES (null,'Assests',null);
INSERT INTO `redfin`.`ledgers`(`ledger_id`,`title`,`description`) VALUES (null,'Liabilities',null);

INSERT INTO `redfin`.`control_accounts` (`control_account_id`,`ledger_id`,`title`,`description`) VALUES (null,5,'Cash and Cash Equivalent',null);
INSERT INTO `redfin`.`ledger_subsidiaries`(`ledger_subsidiary_id`,`control_account_id`,`account_name`,`description`) VALUES (null,5,'Cash',null);

ALTER TABLE `redfin`.`control_accounts` 
ADD COLUMN `account_no` VARCHAR(50) NULL DEFAULT NULL AFTER `ledger_id`,
ADD UNIQUE INDEX `account_no_UNIQUE` (`account_no` ASC);

ALTER TABLE `redfin`.`control_accounts` 
DROP FOREIGN KEY `control_accounts_ibfk_1`;

alter table control_accounts drop column `ledger_id`;

drop table ledgers;

ALTER TABLE `redfin`.`ledger_subsidiaries` 
CHANGE COLUMN `ledger_subsidiary_id` `ctrl_acct_subsidiary_id` INT(11) NOT NULL AUTO_INCREMENT ,
ADD COLUMN `account_no` VARCHAR(50) NULL DEFAULT NULL AFTER `control_account_id`,
ADD UNIQUE INDEX `account_no_UNIQUE` (`account_no` ASC), RENAME TO  `redfin`.`control_acct_subsidiaries` ;

ALTER TABLE `redfin`.`control_acct_subsidiaries` 
RENAME TO  `redfin`.`ctrl_acct_subsidiaries` ;

INSERT INTO `redfin`.`control_accounts` (`account_no`, `title`, `description`) VALUES ('1001', 'CASH AND CASH EQUIVALENT', 'Cash');
INSERT INTO `redfin`.`ctrl_acct_subsidiaries` (`control_account_id`, `account_no`, `account_name`, `description`) VALUES ('5', '1001-1', 'CASH IN BANK', 'BDO');

