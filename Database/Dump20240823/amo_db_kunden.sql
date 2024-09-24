-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: amo_db
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `kunden`
--

DROP TABLE IF EXISTS `kunden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kunden` (
  `kunden_nr` int NOT NULL AUTO_INCREMENT,
  `vorname` varchar(255) DEFAULT NULL,
  `nachname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kunden_nr`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunden`
--

LOCK TABLES `kunden` WRITE;
/*!40000 ALTER TABLE `kunden` DISABLE KEYS */;
INSERT INTO `kunden` VALUES (1,'Anna','Schmidt','anna.schmidt@gmail.com','Musterstrasse 12, 10115 Berlin'),(2,'Max','Müller','max.mueller@hotmail.com','Beispielweg 8, 80333 München'),(3,'Julia','Fischer','julia.fischer@yahoo.de','Hauptstrasse 47, 50667 Köln'),(4,'Jan','Weber','jan.weber@outlook.com','Hafenstrasse 5, 20457 Hamburg'),(5,'Lena','Wagner','lena.wagner@gmail.com','Brunnenallee 24, 70173 Stuttgart'),(6,'Lucas','Bauer','lucas.bauer@t-online.de','Altstadtgasse 14, 60311 Frankfurt'),(7,'Sarah','Wolf','sarah.wolf@web.de','Neustadtplatz 11, 01067 Dresden'),(8,'Paul','Neumann','paul.neumann@aol.com','Schlossstrasse 23, 24103 Kiel'),(9,'Mia','Zimmermann','mia.zimmermann@freenet.de','Marktplatz 7, 89073 Ulm'),(10,'Felix','Schneider','felix.schneider@gmx.de','Ringstrasse 21, 28195 Bremen'),(11,'Sophie','Maier','sophie.maier@icloud.com','Bahnhofstrasse 16, 99084 Erfurt'),(12,'Tim','Richter','tim.richter@live.de','Lindenstrasse 30, 04109 Leipzig'),(13,'Mohammad Abid','Erfan','aqua@inge-zbbs.de','sare chawk'),(14,'Milad','Akbari','cyan@inge-zbbs.de','pole sokhta');
/*!40000 ALTER TABLE `kunden` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-23 16:10:00
