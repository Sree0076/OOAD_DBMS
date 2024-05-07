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
-- Table structure for table `milestone`
--

DROP TABLE IF EXISTS `milestone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milestone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contract_id` int DEFAULT NULL,
  `milestone_no` int DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `amount` double(13,3) DEFAULT NULL,
  `status` enum('TODO','InProgress','Done') DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `contract_id` (`contract_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `milestone_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `contracts` (`contract_id`),
  CONSTRAINT `milestone_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employees` (`id`),
  CONSTRAINT `milestone_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone`
--

LOCK TABLES `milestone` WRITE;
/*!40000 ALTER TABLE `milestone` DISABLE KEYS */;
INSERT INTO `milestone` VALUES (1,21,1,'2023-01-05','2023-01-10',1000.000,'Done','2023-01-01','2023-01-09 18:30:00',1,2),(2,21,2,'2023-02-05','2023-02-10',1500.000,'Done','2023-01-25','2023-02-04 18:30:00',2,1),(3,21,3,'2023-03-05','2023-03-10',2000.000,'Done','2023-02-25',NULL,1,NULL),(4,22,1,'2023-04-05','2023-04-10',1200.000,'TODO','2023-04-01',NULL,3,NULL),(5,22,2,'2023-05-05','2023-05-10',1800.000,'TODO','2023-05-01',NULL,3,NULL),(6,22,3,'2023-06-05','2023-06-10',2500.000,'TODO','2023-06-01',NULL,3,NULL),(7,23,1,'2023-07-05','2023-07-10',900.000,'TODO','2023-07-01',NULL,4,NULL),(8,23,2,'2023-08-05','2023-08-10',1500.000,'TODO','2023-08-01',NULL,4,NULL),(9,23,3,'2023-09-05','2023-09-10',2000.000,'TODO','2023-09-01',NULL,4,NULL),(10,21,4,'2024-05-03','2024-06-03',500.000,'InProgress',NULL,NULL,4,4),(11,21,5,'2024-05-03','2024-06-03',5000.000,'TODO',NULL,NULL,4,4);
/*!40000 ALTER TABLE `milestone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:14:32
