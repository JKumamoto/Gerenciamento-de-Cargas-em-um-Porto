-- Tabelas do sistema de porto

CREATE DATABASE IF NOT EXISTS `porto`;
USE `porto`;

DROP TABLE IF EXISTS `carga`;
DROP TABLE IF EXISTS `patio`;

--
-- tabela patio
--

CREATE TABLE `patio` (
	`posicao` int(4) NOT NULL,
	`ocupado` boolean DEFAULT FALSE,
	PRIMARY KEY (`posicao`)
);

--
-- tabela carga
--

CREATE TABLE `carga` (
	`id` int(11) NOT NULL,
	`Posicao` int(4) NOT NULL,
	`DataChegada` date DEFAULT NULL,
	`LocalChegada` boolean DEFAULT FALSE,
	`TempoPrevisto` date DEFAULT NULL,
	`DataSaida` date DEFAULT NULL,
	`LocalSaida` boolean DEFAULT FALSE,
	`Dono` varchar(100) DEFAULT NULL,
	`Remetente` varchar(100) DEFAULT NULL,
	`Destinatario` varchar(100) DEFAULT NULL,
	PRIMARY KEY (`id`, `Posicao`),
	CONSTRAINT `fk_carga` FOREIGN KEY (`Posicao`) REFERENCES `patio` (`posicao`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


-- Cria o patio

delimiter $$
drop procedure if exists sp_novo_patio $$
create procedure sp_novo_patio(tamanho int(4))
begin
	declare codigo int;
	set codigo=0;

	while (codigo<tamanho) do
		INSERT INTO `patio` VALUES (codigo, false);
		set codigo=codigo+1;
	end while;

end $$

call sp_novo_patio(1001);

