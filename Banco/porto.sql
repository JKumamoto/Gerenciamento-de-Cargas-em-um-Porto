-- Tabelas do sistema de porto

CREATE DATABASE IF NOT EXISTS `porto`;
USE `porto`;

DROP TABLE IF EXISTS `carga`;
DROP TABLE IF EXISTS `patio`;
DROP TABLE IF EXISTS `funcionario`;

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

--
-- tabela funcionario
--

CREATE TABLE `funcionario` (
	`CPF` bigint(15) NOT NULL,
	`RG` int(10) DEFAULT NULL,
	`nome` varchar(100) DEFAULT NULL,
	`endereco` varchar(400) DEFAULT NULL,
	`fone` int(10) DEFAULT NULL,
	`data_nasc` date DEFAULT NULL,
	`email` varchar(100) DEFAULT NULL,
	`administrador` boolean DEFAULT FALSE,
	`senha` varchar(30) DEFAULT NULL,
	PRIMARY KEY (`CPF`)
);

-- Cria o admin
INSERT INTO `funcionario` VALUES (1234567890, 123456789, 
	'Admin', '', 12345678, null, '', true, 'admin');

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


-- Saida
delimiter $$
drop procedure if exists sp_saida_carga $$
create procedure sp_saida_carga(id int(11), data date, local boolean, pos int(4))
begin
	UPDATE carga SET Posicao=1000, DataSaida=data, LocalSaida=local WHERE carga.id=id;
	UPDATE patio SET ocupado=false WHERE patio.posicao=pos;
end $$


call sp_novo_patio(1001);

