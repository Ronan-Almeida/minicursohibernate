SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema agenda
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `agenda` ;
CREATE SCHEMA IF NOT EXISTS `agenda` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `agenda` ;

-- -----------------------------------------------------
-- Table `agenda`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`endereco` ;

CREATE TABLE IF NOT EXISTS `agenda`.`endereco` (
  `id_endereco` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(9) NOT NULL,
  `logradouro` VARCHAR(100) NOT NULL,
  `numero` VARCHAR(10) NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  UNIQUE INDEX `id_endereco_UNIQUE` (`id_endereco` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`contato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`contato` ;

CREATE TABLE IF NOT EXISTS `agenda`.`contato` (
  `id_contato` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `nascimento` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `fk_endereco` INT NOT NULL,
  `ativo` TINYINT(1) NOT NULL,
  `data_cadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_contato`),
  UNIQUE INDEX `id_contato_UNIQUE` (`id_contato` ASC),
  INDEX `fk_contato_endereco_idx` (`fk_endereco` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_contato_endereco`
    FOREIGN KEY (`fk_endereco`)
    REFERENCES `agenda`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`telefone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`telefone` ;

CREATE TABLE IF NOT EXISTS `agenda`.`telefone` (
  `id_telefone` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(15) NOT NULL,
  `fk_contato` INT NOT NULL,
  PRIMARY KEY (`id_telefone`),
  UNIQUE INDEX `id_telefone_UNIQUE` (`id_telefone` ASC),
  INDEX `fk_telefone_contato_idx` (`fk_contato` ASC),
  CONSTRAINT `fk_telefone_contato`
    FOREIGN KEY (`fk_contato`)
    REFERENCES `agenda`.`contato` (`id_contato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`especialidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`especialidade` ;

CREATE TABLE IF NOT EXISTS `agenda`.`especialidade` (
  `id_especialidade` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `detalhes` VARCHAR(100) NULL,
  PRIMARY KEY (`id_especialidade`),
  UNIQUE INDEX `id_especialidade_UNIQUE` (`id_especialidade` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`contato_especialidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`contato_especialidade` ;

CREATE TABLE IF NOT EXISTS `agenda`.`contato_especialidade` (
  `fk_contato` INT NOT NULL,
  `fk_especialidade` INT NOT NULL,
  PRIMARY KEY (`fk_contato`, `fk_especialidade`),
  INDEX `fk_contato_especialidade_especialidade_idx` (`fk_especialidade` ASC),
  CONSTRAINT `fk_contato_especialidade_contato`
    FOREIGN KEY (`fk_contato`)
    REFERENCES `agenda`.`contato` (`id_contato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contato_especialidade_especialidade`
    FOREIGN KEY (`fk_especialidade`)
    REFERENCES `agenda`.`especialidade` (`id_especialidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
