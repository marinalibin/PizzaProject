CREATE DATABASE  IF NOT EXISTS `pizzadb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pizzadb`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzadb
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `crusttypes`
--

DROP TABLE IF EXISTS `crusttypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crusttypes` (
  `crustTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`crustTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crusttypes`
--

LOCK TABLES `crusttypes` WRITE;
/*!40000 ALTER TABLE `crusttypes` DISABLE KEYS */;
INSERT INTO `crusttypes` VALUES (1,'Thin Crust'),(2,'Handmade Pan'),(3,'Original'),(4,'Gluten'),(5,'Chicago Style');
/*!40000 ALTER TABLE `crusttypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `houseNumber` int(11) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `province` varchar(2) DEFAULT NULL,
  `postalCode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Grigory','Libin ','  5458 ',' gl@gmail.com ',412,'  Main ','NB',' E3E5A5'),(2,'Grigory','Libin ','5458','gl@gmail.com',412,'Main','NB','E3E5A5'),(3,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(4,'aer','arg','58946','arg@jbef.com',12,'wef','NB','e3b 3b4'),(5,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','AB','e3b 3b4'),(6,'Marina','Libin','5064760950','monaliza190386@gmail.com',52,' Douglas Crescent ','BC','V6Z 1Y8'),(7,'Marina','Libin','5064760950','monaliza190386@gmail.com',52,' Douglas Crescent street','NB','E3C 1Y8'),(8,'Marina','Libin','5064760950','monaliza190386@gmail.com',52,' Douglas Crescent street','NB','E3C 1Y8'),(9,'Sara','Johns','5064760950','s@gmail.com',458,', Priestman st. unit 17','NB','E3B 3B4'),(10,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(11,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(12,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(13,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(14,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(15,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(16,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(17,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4'),(18,'Grigory','Libin','5068970587','grigorylibin@gmail.com',458,'Priestman','NB','e3b 3b4');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','12345');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `totalPrice` float NOT NULL DEFAULT '0',
  `deliveryDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `placedDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customerId` int(11) NOT NULL,
  `orderStatus` varchar(45) NOT NULL DEFAULT 'PENDING',
  PRIMARY KEY (`orderId`),
  KEY `customeridFK_idx` (`customerId`),
  CONSTRAINT `customeridFK` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pizza` (
  `pizzaId` int(11) NOT NULL AUTO_INCREMENT,
  `sizeId` int(11) NOT NULL,
  `isFinished` tinyint(4) NOT NULL DEFAULT '0',
  `crustTypeId` int(11) NOT NULL,
  `price` float NOT NULL,
  `orderId` int(11) NOT NULL,
  PRIMARY KEY (`pizzaId`),
  KEY `crusttypeFK_idx` (`crustTypeId`),
  KEY `sizeidFK_idx` (`sizeId`),
  KEY `orderidFK_idx` (`orderId`),
  CONSTRAINT `crusttypeFK` FOREIGN KEY (`crustTypeId`) REFERENCES `crusttypes` (`crustTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderidFK` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sizeidFK` FOREIGN KEY (`sizeId`) REFERENCES `sizes` (`sizeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_toppings_map`
--

DROP TABLE IF EXISTS `pizza_toppings_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pizza_toppings_map` (
  `toppingId` int(11) NOT NULL,
  `pizzaId` int(11) NOT NULL,
  `pizza_toppings_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pizza_toppings_id`),
  KEY `pizzaidFK_idx` (`pizzaId`),
  KEY `toppingidFK` (`toppingId`),
  CONSTRAINT `pizzaidFK` FOREIGN KEY (`pizzaId`) REFERENCES `pizza` (`pizzaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `toppingidFK` FOREIGN KEY (`toppingId`) REFERENCES `toppings` (`toppingId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_toppings_map`
--

LOCK TABLES `pizza_toppings_map` WRITE;
/*!40000 ALTER TABLE `pizza_toppings_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `pizza_toppings_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes` (
  `sizeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`sizeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (1,'Small'),(2,'Medium'),(3,'Large');
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toppings`
--

DROP TABLE IF EXISTS `toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toppings` (
  `toppingId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL DEFAULT '0',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `empAddedBy` int(11) NOT NULL,
  `isActive` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`toppingId`),
  KEY `employeeidFK_idx` (`empAddedBy`),
  CONSTRAINT `employeeidFK` FOREIGN KEY (`empAddedBy`) REFERENCES `employee` (`employeeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toppings`
--

LOCK TABLES `toppings` WRITE;
/*!40000 ALTER TABLE `toppings` DISABLE KEYS */;
INSERT INTO `toppings` VALUES (5,'cheese',0,'2017-11-04 23:35:40',1,1),(6,'extra cheese',1.99,'2017-11-04 23:35:40',1,1),(7,'pepperoni',1.99,'2017-11-04 23:35:40',1,1),(8,'green peppers',1.99,'2017-11-04 23:35:40',1,1),(9,'Pinneapple',5,'2019-12-09 14:36:29',1,1),(25,'Pineapple',2,'2019-12-10 18:56:10',1,1),(26,'Bacon',1,'2019-12-10 18:57:43',1,1),(29,'Tomatoes',4,'2019-12-11 14:35:31',1,1);
/*!40000 ALTER TABLE `toppings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11 13:21:51
