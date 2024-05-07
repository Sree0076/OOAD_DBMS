-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: contracts
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `contracts`
--

DROP TABLE IF EXISTS `contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contracts` (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `client_id` int DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `balance_amount` decimal(10,2) DEFAULT NULL,
  `status` enum('Active','Inactive','Expired') DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `milestone_type` enum('Monthly','Quaterly','Weekly','Yearly') DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `client_id` (`client_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`),
  CONSTRAINT `contracts_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employees` (`id`),
  CONSTRAINT `contracts_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts`
--

LOCK TABLES `contracts` WRITE;
/*!40000 ALTER TABLE `contracts` DISABLE KEYS */;
INSERT INTO `contracts` VALUES (21,1,'2023-01-01','2023-12-31',5000.00,2500.00,'Active','2022-12-14 18:30:00','2023-01-10',1,2,'Monthly'),(22,2,'2023-03-01','2023-08-31',3000.00,1500.00,'Active','2023-02-14 18:30:00','2023-03-10',2,1,'Quaterly'),(23,3,'2023-05-01','2023-10-31',7000.00,3500.00,'Active','2023-04-14 18:30:00','2023-05-10',3,2,'Weekly'),(24,4,'2023-07-01','2023-12-31',4500.00,2000.00,'Active','2023-06-14 18:30:00','2023-07-10',4,1,'Yearly'),(25,5,'2023-09-01','2024-02-28',6000.00,3000.00,'Active','2023-08-14 18:30:00','2023-09-10',5,2,'Monthly'),(26,6,'2023-11-01','2024-04-30',5500.00,2750.00,'Active','2023-10-14 18:30:00','2023-11-10',1,3,'Quaterly'),(27,7,'2024-01-01','2024-06-30',8000.00,4000.00,'Active','2023-12-14 18:30:00','2024-01-10',2,3,'Weekly'),(28,8,'2024-03-01','2024-08-31',4000.00,2000.00,'Active','2024-02-14 18:30:00','2024-03-10',3,4,'Yearly'),(29,9,'2024-05-01','2024-10-31',6500.00,3250.00,'Active','2024-04-14 18:30:00','2024-05-10',4,5,'Monthly'),(30,10,'2024-07-01','2024-12-31',5000.00,2500.00,'Active','2024-06-14 18:30:00','2024-07-10',5,4,'Quaterly'),(31,1,'2023-01-01','2023-12-31',5000.00,2500.00,'Active','2022-12-14 18:30:00','2023-01-10',1,2,'Monthly'),(32,10,'2023-01-01','2023-12-31',50000.00,NULL,'Active',NULL,NULL,4,4,'Monthly'),(33,10,'2023-01-01','2023-12-01',5000000.00,NULL,'Active','2024-05-02 18:30:00','2024-05-03',4,4,'Monthly'),(34,9,'2024-05-03','2025-05-03',50000.00,NULL,'Active','2024-05-02 18:30:00','2024-05-03',4,4,'Monthly');
/*!40000 ALTER TABLE `contracts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:14:31
