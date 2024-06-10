CREATE DATABASE  IF NOT EXISTS `estagio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `estagio`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: estagio
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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id_aluno` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `periodo` varchar(45) NOT NULL,
  `escola_id` int DEFAULT NULL,
  `curso_id` int DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  KEY `curso_id_idx` (`curso_id`),
  KEY `escola_id_idx` (`escola_id`),
  CONSTRAINT `curso_id` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id_curso`),
  CONSTRAINT `escola_id` FOREIGN KEY (`escola_id`) REFERENCES `escola` (`id_escola`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (2,'Kaio','(21) 9999-9999','Noturno',NULL,NULL),(3,'Mariah','(99) 9999-9999','Noturno',NULL,NULL),(4,'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA','(21) 6465-4645','Noturno',NULL,NULL),(5,'Rangel','(11) 1111-1','Noturno',1,1);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_vaga`
--

DROP TABLE IF EXISTS `aluno_vaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno_vaga` (
  `aluno_id` int NOT NULL,
  `vaga_id` int NOT NULL,
  PRIMARY KEY (`vaga_id`,`aluno_id`),
  KEY `aluno_id_idx` (`aluno_id`),
  KEY `vaga_id_idx` (`vaga_id`),
  CONSTRAINT `aluno_id` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id_aluno`),
  CONSTRAINT `vaga_id` FOREIGN KEY (`vaga_id`) REFERENCES `vaga` (`id_vaga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_vaga`
--

LOCK TABLES `aluno_vaga` WRITE;
/*!40000 ALTER TABLE `aluno_vaga` DISABLE KEYS */;
INSERT INTO `aluno_vaga` VALUES (2,1),(2,2),(3,1);
/*!40000 ALTER TABLE `aluno_vaga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `periodo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Informática',NULL),(3,'Administração','Noite');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id_empresa` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `contato` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Faetec','faetec1@gmail.com'),(2,'Nike','niketeste@gmail.com');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola`
--

DROP TABLE IF EXISTS `escola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escola` (
  `id_escola` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  PRIMARY KEY (`id_escola`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola`
--

LOCK TABLES `escola` WRITE;
/*!40000 ALTER TABLE `escola` DISABLE KEYS */;
INSERT INTO `escola` VALUES (1,'AAA','AAA','AAAA','AAAA','AAAAAA','7');
/*!40000 ALTER TABLE `escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','<< Flyway Baseline >>','BASELINE','<< Flyway Baseline >>',NULL,'root','2024-04-22 23:31:20',0,1),(2,'1','estagio','SQL','V1__estagio.sql',495765351,'root','2024-05-07 23:53:19',278,1),(3,'2','estagio','SQL','V2__estagio.sql',1002021297,'root','2024-05-22 18:46:46',12097,1),(4,'3','estagio','SQL','V3__estagio.sql',1732030035,'root','2024-05-22 21:46:53',424,1),(5,'4','estagio.sql','SQL','V4__estagio.sql.sql',-294732447,'root','2024-05-23 22:20:05',368,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissao` (
  `id_permissao` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_permissao`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (1,'administrador'),(2,'aluno'),(5,'empresa');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `senha` varchar(1000) NOT NULL,
  `empresa_id` int DEFAULT NULL,
  `aluno_id` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `escola_id_idx` (`empresa_id`),
  KEY `fk_usuario_aluno_idx` (`aluno_id`),
  CONSTRAINT ` fk_usuario_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id_empresa`),
  CONSTRAINT `fk_usuario_aluno` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id_aluno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Kaio','99999999999','$2a$10$Hyh7x9pPOY5hW/EmR3RpE.dhABdNibJRo/Y5kFEooxSfLc3tZf0RK',1,2),(2,'Mariah','11111111111','$2a$10$17I75NBkE3P6DJPxIPBKIe3UcpBsc9713xRp8CFnixyXD62fdg9sK',2,3),(3,'Alisson','22222222222','$2a$10$24ds1W25c1JDThgyohJHNuAXzuLAW0ktAN7GX0EKU/DvS6vQLmWO6',2,4);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_permissao`
--

DROP TABLE IF EXISTS `usuario_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_permissao` (
  `usuario_id` int DEFAULT NULL,
  `permissao_id` int DEFAULT NULL,
  KEY `usuario_id` (`usuario_id`),
  KEY `permissao_id` (`permissao_id`),
  CONSTRAINT `fk_usuario_permissao_id_permissao` FOREIGN KEY (`permissao_id`) REFERENCES `permissao` (`id_permissao`),
  CONSTRAINT `fk_usuario_permissao_id_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_permissao`
--

LOCK TABLES `usuario_permissao` WRITE;
/*!40000 ALTER TABLE `usuario_permissao` DISABLE KEYS */;
INSERT INTO `usuario_permissao` VALUES (1,1),(2,5),(3,2);
/*!40000 ALTER TABLE `usuario_permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaga`
--

DROP TABLE IF EXISTS `vaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaga` (
  `id_vaga` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `valor_bolsa` varchar(45) NOT NULL,
  `beneficios` varchar(45) NOT NULL,
  `curso` varchar(45) NOT NULL,
  `empresa_id` int DEFAULT NULL,
  PRIMARY KEY (`id_vaga`),
  KEY `fk_vaga_empresa_idx` (`empresa_id`),
  CONSTRAINT `fk_vaga_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga`
--

LOCK TABLES `vaga` WRITE;
/*!40000 ALTER TABLE `vaga` DISABLE KEYS */;
INSERT INTO `vaga` VALUES (1,'Suporte','33','5','Informatica',1),(2,'Programador','6','4','4',2);
/*!40000 ALTER TABLE `vaga` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-29 21:36:53
