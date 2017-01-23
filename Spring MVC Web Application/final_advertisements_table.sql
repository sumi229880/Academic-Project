-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: final
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advertisements_table`
--

DROP TABLE IF EXISTS `advertisements_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertisements_table` (
  `ADVERT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CATEGORY` varchar(30) NOT NULL,
  `DESCRIPITION` text NOT NULL,
  `EMAIL` varchar(30) NOT NULL,
  `PHOTOS` text NOT NULL,
  `PRICE` double NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  `YEAR_OLD` varchar(255) NOT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ADVERT_ID`),
  UNIQUE KEY `ADVERT_ID` (`ADVERT_ID`),
  KEY `FK7548F73D6BE39614` (`USER_ID`),
  CONSTRAINT `FK7548F73D6BE39614` FOREIGN KEY (`USER_ID`) REFERENCES `user_table` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisements_table`
--

LOCK TABLES `advertisements_table` WRITE;
/*!40000 ALTER TABLE `advertisements_table` DISABLE KEYS */;
INSERT INTO `advertisements_table` VALUES (1,'Books','In very Good Condition','smith@gmail.com','/kraiglist/resources/images/1467306972812got.jpg',700,'Game Of Thrones','less than a year',5),(2,'ElectronicInstruments','Working condition Fixed Price','smith@gmail.com','/kraiglist/resources/images/14673070580146.JPG',1500,'Conductors','less than 4 years',5),(3,'LeaseRent','Fully furnished ready to move in','smith@gmail.com','/kraiglist/resources/images/146730712303311.jpg',1500,'Sublet for 1 month','for rent/lease',5),(4,'Books','Good sto','rony@yahoo.com','/kraiglist/resources/images/14673072017902.JPG',25,'Thriller','less than half a year',1),(5,'ElectronicInstruments','well maintained','rony@yahoo.com','/kraiglist/resources/images/14673072711027.jpg',700,'Electronic plugin board','less than 3 years',1),(6,'LeaseRent','for one person only','rony@yahoo.com','/kraiglist/resources/images/146730732224012.jpg',700,'Fully furnished room for rent','for rent/lease',1),(7,'Books','Must read','elisha@gmail.com','/kraiglist/resources/images/14673074076453.jpg',18,'Thriller book','less than half a year',2),(8,'ElectronicInstruments','Not Working Need to be repaired','elisha@gmail.com','/kraiglist/resources/images/14673075112988.jpg',789,'Harmonium','between 5 to 10 years',2),(9,'LeaseRent','1 year contract must','elisha@gmail.com','/kraiglist/resources/images/146730757131913.jpg',400,'room available for 2','for rent/lease',2),(11,'ElectronicInstruments','Unique mechanical alarm clock','chang@gmail.com','/kraiglist/resources/images/14673079278169.jpg',2000,'Antique Clock','less than a year',3),(12,'LeaseRent','for 3bhk 11 months contract Please contact at my mail id','chang@gmail.com','/kraiglist/resources/images/146730800167714.png',3500,'House for Lease in Mission main','for rent/lease',3),(13,'Books','Must read','jhon@outlook.com','/kraiglist/resources/images/14673081288045.jpg',8,'Romantic Story','less than a year',4),(14,'ElectronicInstruments','Very well maintained','jhon@outlook.com','/kraiglist/resources/images/146730816542910.jpg',550,'Electronic Guitar','less than a year',4),(15,'LeaseRent','2bhk no furniture Please contact at mail id','jhon@outlook.com','/kraiglist/resources/images/146730823087715.jpg',3200,'Lease Apartment at City View','less than half a year',4),(16,'Furniture','In very Good Condition','smith@gmail.com','/kraiglist/resources/images/1.jpg',700,'Sofa','less than a year',5),(17,'Mobiles','Working condition Fixed Price','smith@gmail.com','/kraiglist/resources/images/6.jpg',1500,'Samsung Mobile ','less than 4 years',5),(18,'Vehicles','Fully furnished ready to move in','smith@gmail.com','/kraiglist/resources/images/11.jpg',1500,'Super Bike','for rent/lease',5),(19,'TicketsPasses','Good story','smith@gmail.com','/kraiglist/resources/images/16.jpg',25,'Concert Passes','less than half a year',5),(20,'Freebie','well maintained','smith@gmail.com','/kraiglist/resources/images/3.jpg',700,'Free Item','less than 3 years',5),(21,'Others','for one person only','smith@gmail.com','/kraiglist/resources/images/13.jpg',700,'Phone','for rent/lease',5),(22,'Furniture','Must read','rony@yahoo.com','/kraiglist/resources/images/2.jpg',18,'Chair','less than half a year',1),(23,'Mobiles','Not Working Need to be repaired','rony@yahoo.com','/kraiglist/resources/images/7.jpg',789,'Samsung Galaxy','between 5 to 10 years',1),(24,'Vehicles','1 year contract must','rony@yahoo.com','/kraiglist/resources/images/12.jpg',400,'Super Bike','for rent/lease',1),(25,'TicketsPasses','Good book for starters','rony@yahoo.com','/kraiglist/resources/images/17.jpg',4,'Concert Passes','less than 2 years',1),(26,'Freebie','Unique mechanical alarm clock','rony@yahoo.com','/kraiglist/resources/images/7.jpg',2000,'Bike','less than a year',1),(27,'Others','for 3bhk 11 months contract Please contact at my mail id','rony@yahoo.com','/kraiglist/resources/images/4.jpg',3500,'Phone','for rent/lease',1),(28,'Furniture','Must read','elisha@gmail.com','/kraiglist/resources/images/3.jpg',8,'Sofa','less than a year',2),(29,'Mobiles','Very well maintained','elisha@gmail.com','/kraiglist/resources/images/8.jpg',550,'Iphone','less than a year',2),(30,'Vehicles','2bhk no furniture Please contact at mail id','elisha@gmail.com','/kraiglist/resources/images/13.jpg',320000,'Customised Car','less than half a year',2),(31,'TicketsPasses','goodworkingcondition','elisha@gmail.com','/kraiglist/resources/images/18.jpg',233,'Concert Passes','less than half a year',2),(32,'Freebie','Verygoodcondition.','elisha@gmail.com','/kraiglist/resources/images/1.jpg',700,'Free Item','less than half a year',2),(33,'Others','In very Good Condition','elisha@gmail.com','/kraiglist/resources/images/9.jpg',1500,'Furniture','less than a year',2),(34,'Furniture','Working condition Fixed Price','chang@gmail.com','/kraiglist/resources/images/4.jpg',1500,'Sofa','less than 4 years',3),(35,'Mobiles','Fully furnished ready to move in','chang@gmail.com','/kraiglist/resources/images/9.jpg',25,'Samsung Mobile ','for rent/lease',3),(36,'Vehicles','Good story','chang@gmail.com','/kraiglist/resources/images/14.jpg',700,'Super Bike','less than half a year',3),(37,'TicketsPasses','well maintained','chang@gmail.com','/kraiglist/resources/images/19.jpg',700,'Concert Passes','less than 3 years',3),(38,'Freebie','for one person only','chang@gmail.com','/kraiglist/resources/images/5.jpg',18,'Free Item','for rent/lease',3),(39,'Others','Must read','chang@gmail.com','/kraiglist/resources/images/5.jpg',789,'Phone','less than half a year',3),(40,'Furniture','Not Working Need to be repaired','jhon@outlook.com','/kraiglist/resources/images/5.jpg',400,'Sofa','between 5 to 10 years',4),(41,'Mobiles','1 year contract must','jhon@outlook.com','/kraiglist/resources/images/10.jpg',4,'Samsung Mobile ','for rent/lease',4),(42,'Vehicles','Good book for starters','jhon@outlook.com','/kraiglist/resources/images/15.jpg',2000,'Super Bike','less than 2 years',4),(43,'TicketsPasses','Unique mechanical alarm clock','jhon@outlook.com','/kraiglist/resources/images/20.jpg',3500,'Concert Passes','less than a year',4),(44,'Freebie','for 3bhk 11 months contract Please contact at my mail id','jhon@outlook.com','/kraiglist/resources/images/16.jpg',8,'Free Item','for rent/lease',4),(45,'Others','Must read','jhon@outlook.com','/kraiglist/resources/images/18.jpg',550,'Phone','less than a year',4),(46,'Others','hghf hhgf','brad@yahoo.in','/kraiglist/resources/images/1484779295765counts.JPG',3,'Game Of Thrones','less than half a year',6);
/*!40000 ALTER TABLE `advertisements_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-18 18:05:34
