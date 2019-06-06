CREATE DATABASE  IF NOT EXISTS `lojagabenricks` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lojagabenricks`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 192.168.1.222    Database: lojagabenricks
-- ------------------------------------------------------
-- Server version	5.7.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `itempedido`
--

DROP TABLE IF EXISTS `itempedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itempedido` (
  `iditempedido` int(11) NOT NULL AUTO_INCREMENT,
  `idproduto` int(11) NOT NULL,
  `idpedido` int(11) NOT NULL,
  `qtdItem` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`iditempedido`,`idproduto`,`idpedido`),
  KEY `idproduto` (`idproduto`),
  KEY `idpedido` (`idpedido`),
  CONSTRAINT `itempedido_ibfk_1` FOREIGN KEY (`idproduto`) REFERENCES `produto` (`idproduto`),
  CONSTRAINT `itempedido_ibfk_2` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itempedido`
--

LOCK TABLES `itempedido` WRITE;
/*!40000 ALTER TABLE `itempedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `itempedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-06 13:13:23
