CREATE DATABASE IF NOT EXISTS patrimonio;
USE patrimonio;

CREATE TABLE IF NOT EXISTS setor(
codigo INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(20) NOT NULL UNIQUE,
descricao VARCHAR(45));

CREATE TABLE IF NOT EXISTS dispositivo(
patrimonio INT,
serie VARCHAR(45) PRIMARY KEY NOT NULL UNIQUE,
tipo VARCHAR(45) NOT NULL,
marca VARCHAR(20),
modelo VARCHAR(20),
setor INT NOT NULL REFERENCES setor(id),
nome VARCHAR(20),
usuario VARCHAR(50),
CONSTRAINT No_duples UNIQUE (patrimonio, serie));


CREATE TABLE IF NOT EXISTS movimentacao(
id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
setorDestino INT NOT NULL REFERENCES setor(id),
dispositivo VARCHAR(45) NOT NULL REFERENCES dispositivo(serie),
dia TIMESTAMP DEFAULT CURRENT_TIMESTAMP());

UPDATE movimentacao SET setorDestino=6, dispositivo=2055083 WHERE setorDestino=3 AND dispositivo=2000542 AND dataMovimento="2015-05-25 19:56:57";
