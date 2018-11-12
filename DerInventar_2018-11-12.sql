# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: DerInventar
# Generation Time: 2018-11-12 07:36:29 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ausleiher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ausleiher`;

CREATE TABLE `ausleiher` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nachname` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `vorname` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

LOCK TABLES `ausleiher` WRITE;
/*!40000 ALTER TABLE `ausleiher` DISABLE KEYS */;

INSERT INTO `ausleiher` (`id`, `nachname`, `vorname`)
VALUES
	(16,'Torsten','Klarre'),
	(17,'Hiddelston','Tom'),
	(18,'Derus','Dude'),
	(19,'Orb','Karsten'),
	(20,'Hoooo','Hey'),
	(21,'Tomatenkopf','Eryk'),
	(22,'Hinda','Ronda');

/*!40000 ALTER TABLE `ausleiher` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table leihobjektausleiher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `leihobjektausleiher`;

CREATE TABLE `leihobjektausleiher` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `lid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



# Dump of table leihobjekte
# ------------------------------------------------------------

DROP TABLE IF EXISTS `leihobjekte`;

CREATE TABLE `leihobjekte` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `beschreibung` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

LOCK TABLES `leihobjekte` WRITE;
/*!40000 ALTER TABLE `leihobjekte` DISABLE KEYS */;

INSERT INTO `leihobjekte` (`id`, `name`, `beschreibung`)
VALUES
	(1,'Dampflockomotive','Tut tut'),
	(2,'Stein','Gesteinsbrocken'),
	(3,'Tomate','Ein richtig tolles Gemüse'),
	(4,'Krasses Teil','Wirklich das beste aller Zeit'),
	(5,'Bürste','Kämmt zuverlässig deinen klasse Hund');

/*!40000 ALTER TABLE `leihobjekte` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
