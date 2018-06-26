-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 26-Jun-2018 às 10:57
-- Versão do servidor: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `delivery`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text,
  `logradouro` text,
  `numero` int(11) DEFAULT NULL,
  `bairro` text,
  `cep` text,
  `celular` text,
  `telefone` text,
  `cpf` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `logradouro`, `numero`, `bairro`, `cep`, `celular`, `telefone`, `cpf`) VALUES
(9, 'Alexandre', 'Rua A', 10, 'Santa Luzia', '36050-100', '32991309811', '3232319504', '12345678910'),
(10, 'Camila', '456', 97, '468', '541', '213', '231321', '2132'),
(11, '2', '2', 2, '2', '2', '22', '22', '2'),
(12, '155', '1', 1, '1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientecnpj`
--

DROP TABLE IF EXISTS `clientecnpj`;
CREATE TABLE IF NOT EXISTS `clientecnpj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `logradouro` text NOT NULL,
  `numero` int(11) NOT NULL,
  `bairro` text NOT NULL,
  `cep` text NOT NULL,
  `celular` text NOT NULL,
  `telefone` text NOT NULL,
  `cnpj` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientecnpj`
--

INSERT INTO `clientecnpj` (`id`, `nome`, `logradouro`, `numero`, `bairro`, `cep`, `celular`, `telefone`, `cnpj`) VALUES
(5, 'Bahamas', 'Avenida Rio Branco', 135, 'Manoel Honorio', '36040-100', '', '', '01412354000195'),
(6, 'Bão Burgão', 'Rua A', 10, 'Santa Luzia', '36040-100', '32991309811', '3232319504', '456789123000125');

-- --------------------------------------------------------

--
-- Estrutura da tabela `encomenda`
--

DROP TABLE IF EXISTS `encomenda`;
CREATE TABLE IF NOT EXISTS `encomenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text,
  `peso` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `logradouro` text,
  `numero` int(11) DEFAULT NULL,
  `bairro` text,
  `cep` text,
  `id_entregador` int(11) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `situacao` text,
  `data_pedido` text,
  `data_entrega` text,
  `memento` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id_cliente_fk` (`id_cliente`),
  KEY `entregador_id_entregador_fk` (`id_entregador`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `encomenda`
--

INSERT INTO `encomenda` (`id`, `descricao`, `peso`, `id_cliente`, `logradouro`, `numero`, `bairro`, `cep`, `id_entregador`, `valor`, `situacao`, `data_pedido`, `data_entrega`, `memento`) VALUES
(8, 'Guarda Roupa', 90, 9, 'Rua A', 10, 'Santa Luzia', '36040-100', 9, 145, 'Em trânsito', '10052018', '10052018', 'Expedida -> Em trânsito -> Pendente -> Em trânsito');

-- --------------------------------------------------------

--
-- Estrutura da tabela `entregador`
--

DROP TABLE IF EXISTS `entregador`;
CREATE TABLE IF NOT EXISTS `entregador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text,
  `situacao` text,
  `id_veiculo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_veiculo` (`id_veiculo`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `entregador`
--

INSERT INTO `entregador` (`id`, `nome`, `situacao`, `id_veiculo`) VALUES
(9, 'Victor', 'Em serviço', 12),
(10, 'Kaio', 'Disponível', 13);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `logradouro`, `numero`, `bairro`, `cep`, `telefone`, `celular`, `cpf`) VALUES
(1, '2', '2', 2, '2', '2', '2', '2', '2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `montador`
--

DROP TABLE IF EXISTS `montador`;
CREATE TABLE IF NOT EXISTS `montador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `situacao` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `montador`
--

INSERT INTO `montador` (`id`, `nome`, `situacao`) VALUES
(5, 'Ramon', 'Disponível'),
(6, 'Jorginho', 'Disponível');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hora` varchar(255) NOT NULL,
  `dataPedido` varchar(255) DEFAULT NULL,
  `valorPedido` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `hora`, `dataPedido`, `valorPedido`) VALUES
(1, '1', '1', '1'),
(2, '2', '2', '2'),
(3, '4564', '123564', '1231'),
(4, '5564', '45644', '546');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pizza`
--

DROP TABLE IF EXISTS `pizza`;
CREATE TABLE IF NOT EXISTS `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `ingrediente` varchar(100) NOT NULL,
  `precoMedia` double NOT NULL,
  `precoFamilia` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pizza`
--

INSERT INTO `pizza` (`id`, `nome`, `ingrediente`, `precoMedia`, `precoFamilia`) VALUES
(1, 'Portuguesa', 'Mussarela, presunto, cebola e azeitonas', 38, 42),
(2, 'Calabresa', 'Mussarela, calabresa, cebola e azeitonas', 38, 42);

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
CREATE TABLE IF NOT EXISTS `veiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placa` text,
  `marca` text,
  `modelo` text,
  `situacao` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `veiculo`
--

INSERT INTO `veiculo` (`id`, `placa`, `marca`, `modelo`, `situacao`) VALUES
(12, 'XYZ1234', 'Scania', 'ABC', 'Disponível'),
(13, 'QWE7894', 'Volvo', 'XYZ', 'Disponível');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
