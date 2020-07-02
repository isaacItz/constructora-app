-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: mysql
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tables_priv`
--

DROP TABLE IF EXISTS `tables_priv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tables_priv` (
  `Host` char(255) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '',
  `Db` char(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `User` char(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `Table_name` char(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `Grantor` varchar(288) COLLATE utf8_bin NOT NULL DEFAULT '',
  `Timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Table_priv` set('Select','Insert','Update','Delete','Create','Drop','Grant','References','Index','Alter','Create View','Show view','Trigger') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Column_priv` set('Select','Insert','Update','References') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`Host`,`Db`,`User`,`Table_name`),
  KEY `Grantor` (`Grantor`)
) /*!50100 TABLESPACE `mysql` */ ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin STATS_PERSISTENT=0 ROW_FORMAT=DYNAMIC COMMENT='Table privileges';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tables_priv`
--

LOCK TABLES `tables_priv` WRITE;
/*!40000 ALTER TABLE `tables_priv` DISABLE KEYS */;
INSERT INTO `tables_priv` VALUES ('%','consC','Chalan','actrealizar','root@localhost','0000-00-00 00:00:00','Select',''),('%','consC','Chalan','checador','root@localhost','0000-00-00 00:00:00','Select,Insert',''),('%','consC','Chalan','diahora','root@localhost','0000-00-00 00:00:00','Select,Insert',''),('%','consC','Chalan','direccion','root@localhost','0000-00-00 00:00:00','Select',''),('%','consC','Chalan','horario','root@localhost','0000-00-00 00:00:00','Select,Insert',''),('%','consC','Chalan','persona','root@localhost','0000-00-00 00:00:00','Select',''),('%','consC','Chalan','puedohacer','root@localhost','0000-00-00 00:00:00','Select',''),('%','consC','Chalan','trabajadorcon','root@localhost','0000-00-00 00:00:00','Select',''),('%','consC','Recursos Humanos','cita','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','ciudad','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','clausula','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','clausulaobra','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','cliente','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','codigopostal','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','colonia','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','diahora','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','horario','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','obra','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','pago','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','permiso','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','permisoobra','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','persona','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','producto','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','renglonresurtir','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','resurtir','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','statuscita','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('%','consC','Recursos Humanos','trabajadorcon','root@localhost','0000-00-00 00:00:00','Select,Insert,Update',''),('localhost','mysql','mysql.session','user','boot@','0000-00-00 00:00:00','Select',''),('localhost','sys','mysql.sys','sys_config','root@localhost','2020-07-01 22:06:10','Select','');
/*!40000 ALTER TABLE `tables_priv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-02  1:33:27
