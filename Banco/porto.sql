-- Tabelas do sistema de porto

CREATE DATABASE IF NOT EXISTS porto;
USE 'porto';

--
-- tabela patio
--

CREATE TABLE 'patio' (
	'posicao' int(4) NOT NULL,
	'ocupado' boolean DEFAULT FALSE,
	PRIMARY KEY ('posicao')
);

CREATE TABLE 'carga' (
	'id' int(11) NOT NULL,
	'Posicao' int(4) NOT NULL,
	'DataChegada' date DEFAULT NULL,
	'LocalChegada' boolean DEFAULT FALSE,
	'TempoPrevisto' date DEFAULT NULL,
	'DataSaida' date DEFAULT NULL,
	'LocalSaida' boolean DEFAULT FALSE,
	'Dono' varchar(100) DEFAULT NULL,
	'Remetente' varchar(100) DEFAULT NULL,
	'Destinatario' varchar(100) DEFAULT NULL,
	PRIMARY KEY ('id', 'Posicao'),
	CONSTRAINT 'fk_carga' FOREIGN KEY ('Posicao') REFERENCES 'patio' ('posicao') ON DELETE NO ACTION ON UPDATE NO ACTION
);
