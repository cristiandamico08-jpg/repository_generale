CREATE DATABASE IF NOT EXISTS BibliotecaPrestiti;
USE BibliotecaPrestiti;

CREATE TABLE Editore (
    CodEditore CHAR(5) PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL,
    Sede VARCHAR(50),
    SitoWeb VARCHAR(50)
) ENGINE = INNODB;

CREATE TABLE Studente (
    Matricola INT AUTO_INCREMENT PRIMARY KEY,
    Cognome VARCHAR(50) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
    Classe CHAR(5) NOT NULL,
    Email VARCHAR(50) NOT NULL
) ENGINE = INNODB;

CREATE TABLE Libro (
    ISBN CHAR(13) PRIMARY KEY,
    Titolo VARCHAR(50) NOT NULL,
    AnnoPubblicazione INT NOT NULL,
    Genere VARCHAR(50) NOT NULL,
    Prezzo FLOAT NOT NULL,
    CodEditore VARCHAR(50) NOT NULL,
    FOREIGN KEY (CodEditore) REFERENCES Editore(CodEditore)
    	ON DELETE NO ACTION
    	ON UPDATE CASCADE,
    MatricolaStudente INT,
    FOREIGN KEY (MatricolaStudente) REFERENCES Studente(Matricola)
    	ON DELETE SET NULL
) ENGINE = INNODB;