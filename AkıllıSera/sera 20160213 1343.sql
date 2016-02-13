-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sera
--

CREATE DATABASE IF NOT EXISTS sera;
USE sera;

--
-- Definition of table `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
CREATE TABLE `kullanici` (
  `ad` varchar(15) NOT NULL DEFAULT '',
  `parola` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kullanici`
--

/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` (`ad`,`parola`) VALUES 
 ('',''),
 ('halil','ar?'),
 ('murat toraman','06angara'),
 ('tuncay','y?g?t');
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;


--
-- Definition of table `sera`
--

DROP TABLE IF EXISTS `sera`;
CREATE TABLE `sera` (
  `port` int(10) unsigned NOT NULL,
  `IP` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `sera_ad` varchar(45) NOT NULL,
  `sera_adres` varchar(200) NOT NULL,
  `urun_cinsi` varchar(45) NOT NULL,
  `sera_sicaklik` int(11) NOT NULL,
  `sera_nem` int(11) NOT NULL,
  PRIMARY KEY (`sera_ad`),
  KEY `FK_sera_1` (`urun_cinsi`),
  CONSTRAINT `FK_sera_1` FOREIGN KEY (`urun_cinsi`) REFERENCES `uruntablosu` (`urun_cinsi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sera`
--

/*!40000 ALTER TABLE `sera` DISABLE KEYS */;
INSERT INTO `sera` (`port`,`IP`,`sera_ad`,`sera_adres`,`urun_cinsi`,`sera_sicaklik`,`sera_nem`) VALUES 
 (8080,0x3139322E3136382E3135322E31,'abccc','hjfhgfgh','Domates',56,32),
 (8080,0x3139322E3136382E312E3337,'asdkl','aksljdl','Biber',52,38),
 (8080,0x3139322E3136382E312E3337,'fdgdfg','asdasd','Domates',645,23),
 (8080,0x3139322E3136382E3135322E31,'SDÜ','SDÜ Çünür','Domates',30,50);
/*!40000 ALTER TABLE `sera` ENABLE KEYS */;


--
-- Definition of table `uruntablosu`
--

DROP TABLE IF EXISTS `uruntablosu`;
CREATE TABLE `uruntablosu` (
  `urun_cinsi` varchar(45) NOT NULL,
  `urun_sicaklik` int(10) unsigned NOT NULL,
  `urun_nem` int(10) unsigned NOT NULL,
  PRIMARY KEY (`urun_cinsi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uruntablosu`
--

/*!40000 ALTER TABLE `uruntablosu` DISABLE KEYS */;
INSERT INTO `uruntablosu` (`urun_cinsi`,`urun_sicaklik`,`urun_nem`) VALUES 
 ('Biber',17,15),
 ('Domates',24,12);
/*!40000 ALTER TABLE `uruntablosu` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
