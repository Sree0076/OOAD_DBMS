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
-- Table structure for table `contract_documents`
--

DROP TABLE IF EXISTS `contract_documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_documents` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contract_id` int DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  `document_path` varchar(255) DEFAULT NULL,
  `upload_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `upload_by` int DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `contract_id` (`contract_id`),
  KEY `upload_by` (`upload_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `contract_documents_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `contracts` (`contract_id`),
  CONSTRAINT `contract_documents_ibfk_2` FOREIGN KEY (`upload_by`) REFERENCES `employees` (`id`),
  CONSTRAINT `contract_documents_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_documents`
--

LOCK TABLES `contract_documents` WRITE;
/*!40000 ALTER TABLE `contract_documents` DISABLE KEYS */;
INSERT INTO `contract_documents` VALUES (20,21,'Contract Document 1','/documents/contract1.pdf','2022-12-20','2022-12-20',1,1),(21,22,'Contract Document 2','/documents/contract2.pdf','2023-02-20','2023-02-20',2,2),(22,23,'Contract Document 3','/documents/contract3.pdf','2023-04-20','2023-04-20',3,3),(23,24,'Contract Document 4','/documents/contract4.pdf','2023-06-20','2023-06-20',4,4),(24,25,'Contract Document 5','/documents/contract5.pdf','2023-08-20','2023-08-20',5,5),(25,26,'Contract Document 6','/documents/contract6.pdf','2023-10-20','2023-10-20',1,1),(26,27,'Contract Document 7','/documents/contract7.pdf','2024-01-20','2024-01-20',2,2),(27,28,'Contract Document 8','/documents/contract8.pdf','2024-03-20','2024-03-20',3,3),(28,29,'Contract Document 9','/documents/contract9.pdf','2024-05-20','2024-05-20',4,4),(29,30,'Contract Document 10','/documents/contract10.pdf','2024-05-20','2024-05-20',5,4),(31,32,'contract31','/documents/contract31',NULL,NULL,4,4);
/*!40000 ALTER TABLE `contract_documents` ENABLE KEYS */;
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
