CREATE DATABASE  IF NOT EXISTS `examen_interfaces` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `examen_interfaces`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: examen_interfaces
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `campeon` bit(1) NOT NULL,
  `fecha_fundacion` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,_binary '','1902-03-06','Real Madrid','https://img.freepik.com/vector-gratis/diseno-logotipo-vectorial-club-futbol_47987-24755.jpg?semt=ais_hybrid&w=740&q=80'),(2,_binary '','1899-11-29','FC Barcelona','https://img.freepik.com/vector-gratis/diseno-logotipo-vectorial-club-futbol_47987-24755.jpg?semt=ais_hybrid&w=740&q=80'),(3,_binary '','1903-04-26','Atlético de Madrid','https://img.freepik.com/vector-gratis/diseno-logotipo-vectorial-club-futbol_47987-24755.jpg?semt=ais_hybrid&w=740&q=80'),(4,_binary '','1898-01-01','Athletic Club','https://img.freepik.com/vector-gratis/diseno-logotipo-vectorial-club-futbol_47987-24755.jpg?semt=ais_hybrid&w=740&q=80'),(5,_binary '','1909-09-07','Real Sociedad','https://img.freepik.com/vector-gratis/diseno-logotipo-vectorial-club-futbol_47987-24755.jpg?semt=ais_hybrid&w=740&q=80'),(6,_binary '','1907-09-12','Real Betis','https://img.freepik.com/vector-gratis/diseno-logotipo-vectorial-club-futbol_47987-24755.jpg?semt=ais_hybrid&w=740&q=80');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `isAdmin` bit(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('admin','123',_binary ''),('arturo','123',_binary '\0'),('atleti_siempre','hash_password_789',_binary '\0'),('cule_de_corazon','hash_password_456',_binary '\0'),('don_osti','hash_password_abc',_binary '\0'),('futbolero_88','hash_password_123',_binary '\0'),('merengue_fan','hash_password_def',_binary '\0'),('turo','123',_binary '\0');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-13 13:53:34
