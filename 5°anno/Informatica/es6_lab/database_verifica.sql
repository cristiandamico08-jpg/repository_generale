CREATE DATABASE IF NOT EXISTS SportOvunque;
USE SportOvunque;

CREATE TABLE Palestra (
    idPal INT PRIMARY KEY,
    nomePal VARCHAR(50) NOT NULL,
    indirizzo VARCHAR(50) NOT NULL,
    citta VARCHAR(50) NOT NULL,
    latit DOUBLE NOT NULL,
    longi DOUBLE NOT NULL,
    quota DOUBLE NOT NULL
    ) ENGINE = INNODB;
    
CREATE TABLE Proposta (
    idProp INT PRIMARY KEY,
    numPosti INT NOT NULL,
    giornoPorp VARCHAR(50) NOT NULL,
    oraProp VARCHAR(50) NOT NULL,
    prezzo DOUBLE NOT NULL,
   	idPal INT NOT NULL,
    FOREIGN KEY (idPal) REFERENCES Palestra(idPal)
    	ON DELETE CASCADE
    	ON UPDATE CASCADE
    ) ENGINE = INNODB;
    
CREATE TABLE Prenotata (
    idPren INT PRIMARY KEY,
    postiLiberi INT NOT NULL,
    dataLezione VARCHAR(50) NOT NULL,
    idProp INT NOT NULL,
    FOREIGN KEY (idProp) REFERENCES Proposta(idProp)
    	ON DELETE CASCADE
    	ON UPDATE CASCADE
    ) ENGINE = INNODB;
    
CREATE TABLE Abbonato (
    nickname VARCHAR(50) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR (50) NOT NULL,
    idPren INT NOT NULL,
    FOREIGN KEY (idPren) REFERENCES Prenotata(idPren)
    	ON DELETE CASCADE
    	ON UPDATE CASCADE
    ) ENGINE = INNODB;
    
CREATE TABLE Attivita (
    idAtt INT PRIMARY KEY,
    tipoAtt VARCHAR(50) NOT NULL,
    idProp INT NOT NULL,
    FOREIGN KEY (idProp) REFERENCES Proposta(idProp)
    	ON DELETE CASCADE
    	ON UPDATE CASCADE
    ) ENGINE = INNODB;