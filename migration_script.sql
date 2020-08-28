-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: web_customer_tracker
-- Source Schemata: web_customer_tracker
-- Created: Fri Aug 28 20:50:36 2020
-- Workbench Version: 8.0.15
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema web_customer_tracker
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `web_customer_tracker` ;
CREATE SCHEMA IF NOT EXISTS `web_customer_tracker` ;

-- ----------------------------------------------------------------------------
-- Table web_customer_tracker.customer
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_customer_tracker`.`customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `fist_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;
SET FOREIGN_KEY_CHECKS = 1;
