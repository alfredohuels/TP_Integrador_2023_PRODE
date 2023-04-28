CREATE DATABASE  IF NOT EXISTS `pronosticospartidos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pronosticospartidos`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pronosticospartidos
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `participantes`
--

DROP TABLE IF EXISTS `participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participantes` (
  `id_participante` int NOT NULL AUTO_INCREMENT,
  `Apellido` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_participante`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
INSERT INTO `participantes` VALUES (1,'Gonzalez','Mariana'),(2,'Perez','Pedro'),(3,'Alarcon','Micaela');
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronosticos`
--

DROP TABLE IF EXISTS `pronosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronosticos` (
  `id_pronosticos` int NOT NULL AUTO_INCREMENT,
  `id_Equipo1` int NOT NULL,
  `gana_1` int NOT NULL,
  `empata` int NOT NULL,
  `gana_2` int NOT NULL,
  `id_Equipo2` int NOT NULL,
  `id_participante` int NOT NULL,
  PRIMARY KEY (`id_pronosticos`),
  KEY `id_participante_idx` (`id_participante`),
  CONSTRAINT `id_participante` FOREIGN KEY (`id_participante`) REFERENCES `participantes` (`id_participante`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronosticos`
--

LOCK TABLES `pronosticos` WRITE;
/*!40000 ALTER TABLE `pronosticos` DISABLE KEYS */;
INSERT INTO `pronosticos` VALUES (1,1,1,0,0,2,1),(2,3,0,1,0,4,1),(3,1,1,0,0,4,1),(4,2,0,0,1,3,1),(5,1,1,0,0,2,2),(6,3,0,0,1,4,2),(7,1,1,0,0,4,2),(8,2,0,1,0,3,2),(9,1,0,0,1,2,3),(10,3,0,1,0,4,3),(11,1,1,0,0,4,3),(12,2,0,0,1,3,3),(13,5,1,0,0,6,1),(14,7,0,0,1,8,1),(15,5,0,0,1,7,1),(16,8,0,1,0,6,1),(17,5,1,0,0,6,2),(18,7,0,0,1,8,2),(19,5,0,0,1,7,2),(20,8,0,1,0,6,2),(21,5,0,0,1,6,3),(22,7,0,0,1,8,3),(23,5,0,0,1,7,3),(24,8,0,1,0,6,3),(25,8,1,0,0,9,1),(26,1,1,0,0,10,1),(27,11,1,0,0,3,1),(28,12,1,0,0,7,1),(29,8,1,0,0,9,2),(30,1,1,0,0,10,2),(31,11,1,0,0,3,2),(32,12,1,0,0,7,2),(33,8,0,1,0,9,3),(34,1,0,0,1,10,3),(35,11,0,1,0,3,3),(36,12,0,0,1,7,3),(37,13,0,1,0,14,1),(38,15,0,0,1,16,1),(39,17,0,1,0,18,1),(40,19,0,0,1,20,1),(41,13,0,1,0,14,2),(42,15,1,0,0,16,2),(43,17,0,1,0,18,2),(44,19,1,0,0,20,2),(45,13,0,1,0,14,3),(46,15,1,0,0,16,3),(47,17,0,1,0,18,3),(48,19,1,0,0,20,3);
/*!40000 ALTER TABLE `pronosticos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-21 23:05:05
