-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 17-Mar-2018 às 03:02
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `imoveis`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bairro`
--

CREATE TABLE IF NOT EXISTS `bairro` (
  `codigobai` int(6) NOT NULL AUTO_INCREMENT,
  `nomebai` varchar(80) NOT NULL,
  PRIMARY KEY (`codigobai`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `bairro`
--

INSERT INTO `bairro` (`codigobai`, `nomebai`) VALUES
(1, 'Barris'),
(2, 'Pituba');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `codigocli` int(6) NOT NULL AUTO_INCREMENT,
  `nomecli` varchar(80) NOT NULL,
  `celularcli` varchar(20) NOT NULL,
  `whatsappcli` int(1) NOT NULL,
  `emailcli` varchar(80) NOT NULL,
  `senhacli` varchar(20) NOT NULL,
  PRIMARY KEY (`codigocli`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`codigocli`, `nomecli`, `celularcli`, `whatsappcli`, `emailcli`, `senhacli`) VALUES
(1, 'Elton Riva', '996469564', 1, 'notleamil@hotmail.com', 'infogames0405'),
(2, 'Elton Riva Moura Lima', '991261598', 1, 'notleamil@gmail.com', 'infogames0405');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE IF NOT EXISTS `contato` (
  `codigocon` int(10) NOT NULL AUTO_INCREMENT,
  `nomecon` varchar(80) NOT NULL,
  `emailcon` varchar(80) NOT NULL,
  `observacaocon` varchar(255) NOT NULL,
  PRIMARY KEY (`codigocon`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`codigocon`, `nomecon`, `emailcon`, `observacaocon`) VALUES
(1, 'Elton Riva', 'notleamil@hotmail.com', 'Aguardando cliente'),
(2, 'Elton Riva Moura Lima', 'notleamil@gmail.com', 'Aguardando prazo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `corretor`
--

CREATE TABLE IF NOT EXISTS `corretor` (
  `codigocor` int(6) NOT NULL AUTO_INCREMENT,
  `nomecor` varchar(80) NOT NULL,
  `celularcor` varchar(20) NOT NULL,
  `whatsappcor` int(1) NOT NULL,
  `emailcor` varchar(80) NOT NULL,
  `senhacor` varchar(20) NOT NULL,
  `crecicor` varchar(10) NOT NULL,
  PRIMARY KEY (`codigocor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `corretor`
--

INSERT INTO `corretor` (`codigocor`, `nomecor`, `celularcor`, `whatsappcor`, `emailcor`, `senhacor`, `crecicor`) VALUES
(1, 'Elton Riva', '996469564', 1, 'notleamil@corretor.com', 'infogames0405', '136676-F'),
(2, 'Elton Riva Moura Lima', '991261598', 1, 'eltonlima@corretor.com', 'infogames0405', '24860-F');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `codigofunc` int(6) NOT NULL AUTO_INCREMENT,
  `nomefunc` varchar(80) NOT NULL,
  `celularfunc` varchar(20) NOT NULL,
  `whatsappfunc` int(1) NOT NULL,
  `emailfunc` varchar(80) NOT NULL,
  `senhafunc` varchar(20) NOT NULL,
  PRIMARY KEY (`codigofunc`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`codigofunc`, `nomefunc`, `celularfunc`, `whatsappfunc`, `emailfunc`, `senhafunc`) VALUES
(1, 'Elton Riva', '996469564', 1, 'notleamil@funcionario.com', 'infogames0405'),
(2, 'Elton Riva Moura Lima', '991261598', 1, 'eltonlima@funcionario.com', 'infogames0405');

-- --------------------------------------------------------

--
-- Estrutura da tabela `imovel`
--

CREATE TABLE IF NOT EXISTS `imovel` (
  `codigoimo` int(6) NOT NULL AUTO_INCREMENT,
  `codigobai` int(6) NOT NULL,
  `enderecoimo` varchar(80) NOT NULL,
  `cepimo` varchar(20) NOT NULL,
  `fotoimo` varchar(80) NOT NULL,
  PRIMARY KEY (`codigoimo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `imovel`
--

INSERT INTO `imovel` (`codigoimo`, `codigobai`, `enderecoimo`, `cepimo`, `fotoimo`) VALUES
(1, 1, 'Rua General Labatut', '40070100', 'Nenhuma'),
(2, 2, 'Alameda Pádua', '41830480', 'Nenhuma');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
