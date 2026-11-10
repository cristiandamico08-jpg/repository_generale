CREATE DATABASE IF NOT EXISTS gantt_wbs_db;
USE gantt_wbs_db;

CREATE TABLE progetti (
    id_progetto INT PRIMARY KEY AUTO_INCREMENT,
    nome_progetto VARCHAR(100) NOT NULL,
    cliente VARCHAR(100)
    ) ENGINE = INNODB;
    
CREATE TABLE wbs_fasi (
    id_fase INT PRIMARY KEY AUTO_INCREMENT,
    id_progetto INT NOT NULL,
    FOREIGN KEY (id_progetto) REFERENCES progetti(id_progetto)
    	ON DELETE CASCADE,
    nome_fase VARCHAR(100) NOT NULL,
    ore_preventivate DECIMAL(6, 2) NOT NULL,
    data_inizio_prevista DATE NOT NULL,
    data_fine_prevista DATE NOT NULL,
    responsabile VARCHAR(100)
    ) ENGINE = INNODB;
    
CREATE TABLE registro_ore (
    id_registro INT PRIMARY KEY NOT NULL,
    id_fase INT NOT NULL,
    FOREIGN KEY (id_fase) REFERENCES wbs_fasi(id_fase)
    	ON DELETE CASCADE,
    nome_dipendente VARCHAR(100) NOT NULL,
    data_lavoro DATE NOT NULL,
    ore_lavorate DECIMAL(5, 2) NOT NULL CHECK (ore_lavorate > 0),
    nota_attivita TEXT
    ) ENGINE = INNODB;