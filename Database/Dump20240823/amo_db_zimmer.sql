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
-- Table structure for table `zimmer`
--

DROP TABLE IF EXISTS `zimmer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zimmer` (
  `zimmer_nr` int NOT NULL AUTO_INCREMENT,
  `ausstattung` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `preis_pro_nacht` int DEFAULT NULL,
  PRIMARY KEY (`zimmer_nr`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zimmer`
--

LOCK TABLES `zimmer` WRITE;
/*!40000 ALTER TABLE `zimmer` DISABLE KEYS */;
INSERT INTO `zimmer` VALUES (1,'doppel zimmer','[\"WLAN\", \"Balkon\", \"Terrasse\"]',80),(2,'suite','[\"WLAN\", \"Balkon\", \"Terrasse\", \"Meerblick\"]',150),(3,'einzel zimmer','[\"WLAN\", \"Meerblick\", \"Balkon\"]',50),(4,'doppel zimmer','[\"WLAN\", \"Balkon\", \"Terrasse\"]',80),(5,'doppel zimmer','[\"WLAN\", \"Terrasse\", \"Meerblick\"]',80),(6,'suite','[\"WLAN\", \"Balkon\", \"Terrasse\", \"Meerblick\"]',150),(7,'suite','[\"WLAN\", \"Balkon\", \"Terrasse\", \"Meerblick\"]',150),(8,'einzel zimmer','[\"WLAN\", \"Terrasse\", \"Meerblick\"]',50),(9,'suite','[\"WLAN\", \"Balkon\", \"Terrasse\", \"Meerblick\"]',150),(10,'doppel zimmer','[\"WLAN\", \"Meerblick\", \"Balkon\"]',80),(11,'einzel zimmer','[\"WLAN\", \"Balkon\", \"Terrasse\"]',50),(12,'einzel zimmer','[\"WLAN\", \"Balkon\", \"Terrasse\"]',50),(13,'einzel zimmer','[\"WLAN\", \"Balkon\", \"Meerblick\"]',50),(14,'doppel zimmer','[\"WLAN\", \"Balkon\", \"Terrasse\"]',80),(15,'suite','[\"WLAN\", \"Balkon\", \"Terrasse\", \"Meerblick\"]',150),(16,'suite','[\"WLAN\", \"Balkon\", \"Terrasse\", \"Meerblick\"]',150),(17,'doppel zimmer','[\"WLAN\", \"Terrasse\", \"Meerblick\"]',80),(18,'doppel zimmer','[\"WLAN\", \"Terrasse\", \"Meerblick\"]',80),(19,'suite','[\"WLAN\", \"Balkon\", \"Terrasse\", \"Meerblick\"]',150),(20,'einzel zimmer','[\"WLAN\", \"Meerblick\", \"Terrasse\"]',50);
/*!40000 ALTER TABLE `zimmer` ENABLE KEYS */;
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
