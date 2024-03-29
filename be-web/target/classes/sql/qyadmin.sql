-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: qyadmin
-- ------------------------------------------------------
-- Server version	5.7.9

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
-- Table structure for table `sys_dep`
--

DROP TABLE IF EXISTS `sys_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dep` (
  `ID` varchar(255) NOT NULL COMMENT '部门主键',
  `ACTIVE_FLAG` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(60) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(60) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `DEP_LEADER` varchar(32) DEFAULT NULL COMMENT '部门领导',
  `DEP_NAME` varchar(30) NOT NULL,
  `DEP_TYPE` varchar(32) DEFAULT NULL,
  `DESCRIPTION` varchar(120) DEFAULT NULL,
  `ORDER_NUMBER` int(11) DEFAULT NULL,
  `PARENT_ID` varchar(32) NOT NULL,
  `DEP_CODE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_9vkihetjjfmeh2ij19mlox75i` (`DEP_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dep`
--

LOCK TABLES `sys_dep` WRITE;
/*!40000 ALTER TABLE `sys_dep` DISABLE KEYS */;
INSERT INTO `sys_dep` VALUES ('02D64427F5EB471EB2354A09CF6D46D9',-1,'admin','2017-04-05 20:43:35','admin','2017-04-06 20:48:22','123','审计部门','','123',NULL,'123','sjbu'),('123',1,'123','2017-04-04 19:00:01','admin','2017-04-08 15:21:22','32342333333','山竹之七语','','123',123,'123','1231123321123123777'),('1234',1,'123','2017-04-04 19:14:59',NULL,NULL,'3','财务部','1','123',123,'123',NULL),('1C6A4F504FCE49F98D3CE3A2DD6789BC',1,'admin','2017-04-06 21:03:28','admin','2017-04-06 21:19:32','123','ceshi1','','123',NULL,'123','ceshi'),('2863EFFFE7644CE2A9DD1386F4B78D88',-1,'admin','2017-04-05 20:41:07','admin','2017-04-06 20:55:17','123','测试2','','123',NULL,'123','123123'),('288AB3250C834B38AF4C25FFB490E0F5',1,'admin','2017-04-04 23:01:52',NULL,NULL,'123','运维部门','','123',NULL,'123','yunwei'),('3097C476B4E34C3E9499FD8C49220776',1,'admin','2017-04-05 20:40:50',NULL,NULL,'123','测试1','','123',NULL,'123','ceshi123'),('5A8C578641A54FD4995DB36464750E86',1,'admin','2017-04-06 21:03:45',NULL,NULL,'234','234432234','','234',NULL,'123','234'),('6C0B67EB6CAE439192CE19F2005F98C2',1,'admin','2017-04-05 20:43:52',NULL,NULL,'1','测试部门1','','1',NULL,'123','1'),('6E2FC0C8A5B94F6F9E206B4FE9B14D42',1,'admin','2017-04-15 08:06:02',NULL,NULL,'4','4','','4',NULL,'123','4'),('73A900BF8B884C359BBA897F4DE2E1A2',1,'admin','2017-04-04 23:01:23',NULL,NULL,'123','总经理办公室','','123',NULL,'123','zongjingli'),('8F50EC90530042EFAC2AB097603697FE',1,'admin','2017-04-05 20:43:43',NULL,NULL,'123','设计部门','','123',NULL,'123','123'),('98BB762900F742829F9FF12FE10CA9B0',1,'admin','2017-04-04 23:01:40',NULL,NULL,'123','实施部门','','123',NULL,'123','shishi'),('9E965FF6C762482B884F1D9B1426D71D',-1,'admin','2017-04-06 17:10:26','admin','2017-04-15 08:06:15','11','11','','11',NULL,'123','11'),('A5B42778B12D4BC3AC22DB14FFA6D254',-1,'admin','2017-04-06 21:12:04','admin','2017-04-06 21:12:27','123','karring','','123',NULL,'123','123'),('ACA3A7E91A72495AA03DA46890E76F3B',1,'admin','2017-04-05 20:41:15',NULL,NULL,'123','测试3333','','123',NULL,'123','123'),('C048C4D8FBF743F6940A0CD1A451E929',1,'admin','2017-04-05 20:41:24',NULL,NULL,'55','测试5555','','55',NULL,'123','555'),('CF089E269C5741C7809D66A6E0B9AFF2',1,'admin','2017-04-04 23:01:02',NULL,NULL,'','测试部门','','',NULL,'123','ceshi110'),('CF1AF5F32D8D4A2097FC0037314550F9',1,'admin','2017-04-05 19:43:28',NULL,NULL,'213','123','','',NULL,'288AB3250C834B38AF4C25FFB490E0F5','123'),('DCCB863C939448AF89AE93AC30D57CDD',1,'admin','2017-04-06 21:08:43',NULL,NULL,'1','ceshi321','','1',NULL,'123','1'),('E25C0AEF6209419799F3DF18DFE02B56',1,'admin','2017-04-04 23:32:42',NULL,NULL,'234','财务部门1','','234',NULL,'123','caiwubu002'),('EAEB94FA97A049AFA3EB611A40E87BAA',1,'admin','2017-04-06 23:08:13',NULL,NULL,'123','测试123321','','123',NULL,'123','ceshi123321123'),('F120E26903C543F0AE7421C1695CFEED',1,'admin','2017-04-04 22:58:56',NULL,NULL,'123','研发部','','123',NULL,'123','123');
/*!40000 ALTER TABLE `sys_dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_file`
--

DROP TABLE IF EXISTS `sys_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_file` (
  `PARENT_ID` varchar(32) NOT NULL COMMENT '文件相关联的对象的主键',
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `SIZE` decimal(11,0) DEFAULT NULL COMMENT '文件大小',
  `EXT` varchar(100) DEFAULT NULL COMMENT '文件扩展名',
  `FILE_PATH` varchar(100) NOT NULL COMMENT '文件在服务器上的地址',
  `CREATE_BY` varchar(32) NOT NULL COMMENT '创建人',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '修改时间',
  `ACTIVE_FLAG` char(1) NOT NULL COMMENT '逻辑删除状态,0：删除；1：未删除',
  `TYPE` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_file`
--

LOCK TABLES `sys_file` WRITE;
/*!40000 ALTER TABLE `sys_file` DISABLE KEYS */;
INSERT INTO `sys_file` VALUES ('45473EC8D9FD43B38C1DED24D69398FA','E394D47F9FF84624884EF69757A0A032','boduoyejieyi.png',142949,'png','group1/M00/00/00/eSqmIFjfsxGAS37CAAIuZSMt_Wc782.png','admin','2017-04-01 22:02:57','admin','2017-04-01 22:02:57','1','image/png');
/*!40000 ALTER TABLE `sys_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_function`
--

DROP TABLE IF EXISTS `sys_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_function` (
  `ID` varchar(255) NOT NULL,
  `ACTIVE_FLAG` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(60) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(60) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `FUN_CODE` varchar(32) NOT NULL,
  `FUN_NAME` varchar(60) NOT NULL,
  `ORDER_NUMBER` int(11) DEFAULT NULL,
  `PARENT_ID` varchar(32) DEFAULT NULL,
  `URL` varchar(60) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ICON` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `TYPE` int(11) NOT NULL COMMENT '-1代表菜单、1代表按钮',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_function`
--

LOCK TABLES `sys_function` WRITE;
/*!40000 ALTER TABLE `sys_function` DISABLE KEYS */;
INSERT INTO `sys_function` VALUES ('0F8BABE1837E40CFB70F33544ECDB5B4',1,'admin','2017-04-08 16:51:57','admin','2017-04-08 16:55:35','ceshiCode','测试菜单（改成测试21）',NULL,'123','test/main',NULL,'no',1),('123',1,'123','2017-04-08 10:18:13',NULL,NULL,'123','首页',1,'-1','/index','首页',NULL,1),('130E1DE051984242B5A8CD67884D527E',1,'admin','2017-04-08 15:04:22','admin','2017-04-08 16:33:49','updateCode','修改',NULL,'321','no',NULL,'no',0),('2AABC7B44ACA475A8DA7F6F5E6D4A945',1,'admin','2017-04-08 15:04:00','admin','2017-04-08 16:33:55','addCode','增加',NULL,'321','no',NULL,'no',0),('3006A9A161C34F8EB1824D7D72602CE7',1,'admin','2017-04-08 15:04:42','admin','2017-04-08 16:34:02','deleteCode','删除',NULL,'321','no',NULL,'no',0),('321',1,'321','2017-04-08 10:39:21',NULL,NULL,'321','用户管理',2,'123','/user/main','用户管理',NULL,1),('4A03A55B921840379C94E7462C2B7CC4',1,'admin','2017-04-08 15:01:09','admin','2017-04-08 16:16:02','timeCode','定时器',NULL,'123','timer/main',NULL,'no',1),('56AADD866BBC45FDA15048B49FB90972',1,'admin','2017-04-08 15:01:39','admin','2017-04-08 16:16:15','dicCode','数据字典',NULL,'123','dic/main',NULL,'no',1),('6C14CE79E8464ECB86971E1F1075E06D',1,'admin','2017-04-08 14:52:38','admin','2017-04-08 16:16:24','orgCode','部门管理',NULL,'123','/dep/main',NULL,'1',1),('848A25BA06E9461E9EE05EBC2938D5AA',1,'admin','2017-04-08 14:59:36',NULL,NULL,'funCode','菜单管理',NULL,'123','function/main',NULL,'no',1),('A49E036CE4674A15AA88FF8A43A119EE',-1,'admin','2017-04-08 15:08:01','admin','2017-04-08 16:45:33','updatesCode','变更',NULL,'848A25BA06E9461E9EE05EBC2938D5AA','no',NULL,'no',0),('A623EDC6C25D4FBBA2F0C979EF1C1AF8',1,'admin','2017-04-08 15:00:45',NULL,NULL,'logCode','日志管理',NULL,'123','log/main',NULL,'no',1),('AE3E36A33427424F82EA97A6E439049E',1,'admin','2017-04-08 15:03:19',NULL,NULL,'sessionCode','会话管理',NULL,'123','session/main',NULL,'no',1),('BCE1CC8F3BF54CCCBB0B0BE2BE3F7E26',-1,'admin','2017-04-08 15:08:22','admin','2017-04-08 15:44:31','delete1','delete1',NULL,'848A25BA06E9461E9EE05EBC2938D5AA','1231',NULL,'1231',1),('C2BCE661E60A4CBC9D5550FC13631ABC',-1,'admin','2017-04-08 15:10:30','admin','2017-04-08 16:35:17','indexCode1','HOME',NULL,'123','index',NULL,'no',1),('C2BDF69866254ECE9019A48C1E8E43D7',1,'admin','2017-04-08 16:07:23','admin','2017-04-08 16:33:20','addCode1','增加',NULL,'848A25BA06E9461E9EE05EBC2938D5AA','123',NULL,'123',0),('CA0C6408BADB4B8997F0D67EE357649F',-1,'admin','2017-04-08 16:15:31','admin','2017-04-08 17:00:16','bpm','工作流',NULL,'123','123',NULL,'123',1),('D7E68611F5004E6B8CABA7165F49F8CB',1,'admin','2017-04-08 15:00:07',NULL,NULL,'roleCode','角色管理',NULL,'123','role/main',NULL,'no',1),('E657B21AB3FA412FA9A059454A3C26EE',1,'admin','2017-04-08 15:07:01','admin','2017-04-08 16:33:37','saveCode','添加',NULL,'848A25BA06E9461E9EE05EBC2938D5AA','no',NULL,'no',0),('F9FEBAF425134D6E946FC9A9A6BAEB5A',1,'admin','2017-04-08 16:35:00',NULL,NULL,'indexCode','首页',NULL,'123','index',NULL,'123',1);
/*!40000 ALTER TABLE `sys_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_scheduler`
--

DROP TABLE IF EXISTS `sys_scheduler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_scheduler` (
  `ID` varchar(32) NOT NULL,
  `ACTIVE_FLAG` int(11) NOT NULL,
  `CREATE_BY` varchar(32) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `JOB_NAME` varchar(100) DEFAULT NULL,
  `JOB_CLASS` varchar(100) DEFAULT NULL,
  `CRON` varchar(100) DEFAULT NULL,
  `IS_START` char(1) DEFAULT NULL,
  `NOTES` varchar(100) DEFAULT NULL,
  `JOB_PARAMS` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_scheduler`
--

LOCK TABLES `sys_scheduler` WRITE;
/*!40000 ALTER TABLE `sys_scheduler` DISABLE KEYS */;
INSERT INTO `sys_scheduler` VALUES ('1',1,'admin','2017-02-24 10:23:27',NULL,NULL,'定时任务===','com.qiyu.admin.system.quartz.jobs.SchedulerTest','0/10 * * * * ?','0','第三方规定',NULL);
/*!40000 ALTER TABLE `sys_scheduler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_session`
--

DROP TABLE IF EXISTS `sys_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_session` (
  `ID` varchar(64) NOT NULL,
  `ACTIVE_FLAG` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(255) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(255) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `IP` varchar(20) DEFAULT NULL,
  `LAST_ACCESS_TIME` datetime DEFAULT NULL,
  `SESSION_ID` varchar(64) DEFAULT NULL,
  `SESSION_VALUE` text,
  `LOGIN_NAME` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_session`
--

LOCK TABLES `sys_session` WRITE;
/*!40000 ALTER TABLE `sys_session` DISABLE KEYS */;
INSERT INTO `sys_session` VALUES ('5379044a-4d42-4130-b0ff-0e2d48d20f48',1,'sessionManager','2017-05-15 15:23:14',NULL,'2017-05-15 16:10:34','0:0:0:0:0:0:0:1','2017-05-15 16:10:34','5379044a-4d42-4130-b0ff-0e2d48d20f48','rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDUzNzkwNDRhLTRkNDItNDEzMC1iMGZmLTBlMmQ0OGQyMGY0OHNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAVwK/VTreHNxAH4AA3cIAAABXAsorKt4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAV0AAh1c2VySW5mb3NyACBjb20ucWl5dS5hZG1pbi5zeXN0ZW0ubW9kZWwuVXNlcpGUs63nFHNEAgAKTAAFZGVwSWR0ABJMamF2YS9sYW5nL1N0cmluZztMAAVlbWFpbHEAfgAKTAAGZ2VuZGVydAATTGphdmEvbGFuZy9JbnRlZ2VyO0wACWxvZ2luTmFtZXEAfgAKTAAIbG9naW5Qd2RxAH4ACkwABXBob25lcQB+AApMAAVwaG90b3EAfgAKTAAEc2FsdHEAfgAKTAAIdXNlckNvZGVxAH4ACkwACHVzZXJOYW1lcQB+AAp4cgAhY29tLnFpeXUuZnJhbWV3b3JrLmJhc2UuQmFzZU1vZGVsYwa0rqvZEg4CAAZMAAphY3RpdmVGbGFncQB+AAtMAAhjcmVhdGVCeXEAfgAKTAAKY3JlYXRlRGF0ZXQAEExqYXZhL3V0aWwvRGF0ZTtMAAJpZHEAfgAKTAAIdXBkYXRlQnlxAH4ACkwACnVwZGF0ZURhdGVxAH4ADXhwc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAFwcHQAIDQ1NDczRUM4RDlGRDQzQjM4QzFERUQyNEQ2OTM5OEZBdAAFYWRtaW5zcQB+AAN3CAAAAVtu7QXYeHQAAzEyM3QADzEyMTIzMTIzQHFxLmNvbXEAfgARdAAFYWRtaW50ACBkZjIzZmFhYTVkOWM4OGQ0NDZiNWRmMjdmZDUzYjE1N3QABjEyMzI0M3B0ACBjMjI1OWY2NDNhZDBiY2JmYjE4MjlmNDQ1ZjRkMmU3OHQACGFkbWluMTIzdAAJ566h55CG5ZGYdAARc2hpcm9TYXZlZFJlcXVlc3RzcgAmb3JnLmFwYWNoZS5zaGlyby53ZWIudXRpbC5TYXZlZFJlcXVlc3SvzjyteYLKugIAA0wABm1ldGhvZHEAfgAKTAALcXVlcnlTdHJpbmdxAH4ACkwACnJlcXVlc3RVUklxAH4ACnhwdAADR0VUcHQAFS9RaVl1QWRtaW4vaW5kZXguaHRtbHQACWxvZ2luTmFtZXEAfgAXdABQb3JnLmFwYWNoZS5zaGlyby5zdWJqZWN0LnN1cHBvcnQuRGVmYXVsdFN1YmplY3RDb250ZXh0X0FVVEhFTlRJQ0FURURfU0VTU0lPTl9LRVlzcgARamF2YS5sYW5nLkJvb2xlYW7NIHKA1Zz67gIAAVoABXZhbHVleHABdABNb3JnLmFwYWNoZS5zaGlyby5zdWJqZWN0LnN1cHBvcnQuRGVmYXVsdFN1YmplY3RDb250ZXh0X1BSSU5DSVBBTFNfU0VTU0lPTl9LRVlzcgAyb3JnLmFwYWNoZS5zaGlyby5zdWJqZWN0LlNpbXBsZVByaW5jaXBhbENvbGxlY3Rpb26of1glxqMISgMAAUwAD3JlYWxtUHJpbmNpcGFsc3QAD0xqYXZhL3V0aWwvTWFwO3hwc3IAF2phdmEudXRpbC5MaW5rZWRIYXNoTWFwNMBOXBBswPsCAAFaAAthY2Nlc3NPcmRlcnhxAH4ABj9AAAAAAAAMdwgAAAAQAAAAAXQALWNvbS5xaXl1LmFkbWluLnN5c3RlbS5zaGlyby5BdXRoQ3VzdG9tUmVhbG1fMHNyABdqYXZhLnV0aWwuTGlua2VkSGFzaFNldNhs11qV3SoeAgAAeHIAEWphdmEudXRpbC5IYXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9AAAAAAAABcQB+AA54eAB3AQFxAH4AK3h4eA==','admin'),('5b720990-d810-4cd4-a97d-cb84cb48a4e2',1,'sessionManager','2017-05-31 23:02:58',NULL,'2017-05-31 23:08:40','0:0:0:0:0:0:0:1','2017-05-31 23:08:40','5b720990-d810-4cd4-a97d-cb84cb48a4e2','rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDViNzIwOTkwLWQ4MTAtNGNkNC1hOTdkLWNiODRjYjQ4YTRlMnNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAVxfB/xkeHNxAH4AA3cIAAABXF8NM3F4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAV0AAh1c2VySW5mb3NyACBjb20ucWl5dS5hZG1pbi5zeXN0ZW0ubW9kZWwuVXNlcpGUs63nFHNEAgAKTAAFZGVwSWR0ABJMamF2YS9sYW5nL1N0cmluZztMAAVlbWFpbHEAfgAKTAAGZ2VuZGVydAATTGphdmEvbGFuZy9JbnRlZ2VyO0wACWxvZ2luTmFtZXEAfgAKTAAIbG9naW5Qd2RxAH4ACkwABXBob25lcQB+AApMAAVwaG90b3EAfgAKTAAEc2FsdHEAfgAKTAAIdXNlckNvZGVxAH4ACkwACHVzZXJOYW1lcQB+AAp4cgAhY29tLnFpeXUuZnJhbWV3b3JrLmJhc2UuQmFzZU1vZGVsYwa0rqvZEg4CAAZMAAphY3RpdmVGbGFncQB+AAtMAAhjcmVhdGVCeXEAfgAKTAAKY3JlYXRlRGF0ZXQAEExqYXZhL3V0aWwvRGF0ZTtMAAJpZHEAfgAKTAAIdXBkYXRlQnlxAH4ACkwACnVwZGF0ZURhdGVxAH4ADXhwc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAFwcHQAIDQ1NDczRUM4RDlGRDQzQjM4QzFERUQyNEQ2OTM5OEZBdAAFYWRtaW5zcQB+AAN3CAAAAVtu7QXYeHQAAzEyM3QADzEyMTIzMTIzQHFxLmNvbXEAfgARdAAFYWRtaW50ACBkZjIzZmFhYTVkOWM4OGQ0NDZiNWRmMjdmZDUzYjE1N3QABjEyMzI0M3B0ACBjMjI1OWY2NDNhZDBiY2JmYjE4MjlmNDQ1ZjRkMmU3OHQACGFkbWluMTIzdAAJ566h55CG5ZGYdAARc2hpcm9TYXZlZFJlcXVlc3RzcgAmb3JnLmFwYWNoZS5zaGlyby53ZWIudXRpbC5TYXZlZFJlcXVlc3SvzjyteYLKugIAA0wABm1ldGhvZHEAfgAKTAALcXVlcnlTdHJpbmdxAH4ACkwACnJlcXVlc3RVUklxAH4ACnhwdAADR0VUcHQAFi9RaVl1QWRtaW4vZmF2aWNvbi5pY290AAlsb2dpbk5hbWVxAH4AF3QAUG9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9BVVRIRU5USUNBVEVEX1NFU1NJT05fS0VZc3IAEWphdmEubGFuZy5Cb29sZWFuzSBygNWc+u4CAAFaAAV2YWx1ZXhwAXQATW9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9QUklOQ0lQQUxTX1NFU1NJT05fS0VZc3IAMm9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5TaW1wbGVQcmluY2lwYWxDb2xsZWN0aW9uqH9YJcajCEoDAAFMAA9yZWFsbVByaW5jaXBhbHN0AA9MamF2YS91dGlsL01hcDt4cHNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cQB+AAY/QAAAAAAADHcIAAAAEAAAAAF0AC1jb20ucWl5dS5hZG1pbi5zeXN0ZW0uc2hpcm8uQXV0aEN1c3RvbVJlYWxtXzBzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hTZXTYbNdald0qHgIAAHhyABFqYXZhLnV0aWwuSGFzaFNldLpEhZWWuLc0AwAAeHB3DAAAAAI/QAAAAAAAAXNxAH4ACXNxAH4ADwAAAAFwcHQAIDQ1NDczRUM4RDlGRDQzQjM4QzFERUQyNEQ2OTM5OEZBdAAFYWRtaW5zcQB+AAN3CAAAAVtu7QXYeHQAAzEyM3QADzEyMTIzMTIzQHFxLmNvbXEAfgAxdAAFYWRtaW50ACBkZjIzZmFhYTVkOWM4OGQ0NDZiNWRmMjdmZDUzYjE1N3QABjEyMzI0M3B0ACBjMjI1OWY2NDNhZDBiY2JmYjE4MjlmNDQ1ZjRkMmU3OHQACGFkbWluMTIzdAAJ566h55CG5ZGYeHgAdwEBcQB+ACt4eHg=','admin'),('783e29cc-99f5-4500-883a-b7ea65d6a8c5',1,'sessionManager','2017-05-15 16:12:28',NULL,'2017-05-15 16:30:48','login','2017-05-15 16:30:48','783e29cc-99f5-4500-883a-b7ea65d6a8c5','rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDc4M2UyOWNjLTk5ZjUtNDUwMC04ODNhLWI3ZWE2NWQ2YThjNXNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAVwLKmmIeHNxAH4AA3cIAAABXAs7Ml54dw8AAAAAABt3QAAFbG9naW5zcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAABHQACHVzZXJJbmZvc3IAIGNvbS5xaXl1LmFkbWluLnN5c3RlbS5tb2RlbC5Vc2VykZSzrecUc0QCAApMAAVkZXBJZHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABWVtYWlscQB+AApMAAZnZW5kZXJ0ABNMamF2YS9sYW5nL0ludGVnZXI7TAAJbG9naW5OYW1lcQB+AApMAAhsb2dpblB3ZHEAfgAKTAAFcGhvbmVxAH4ACkwABXBob3RvcQB+AApMAARzYWx0cQB+AApMAAh1c2VyQ29kZXEAfgAKTAAIdXNlck5hbWVxAH4ACnhyACFjb20ucWl5dS5mcmFtZXdvcmsuYmFzZS5CYXNlTW9kZWxjBrSuq9kSDgIABkwACmFjdGl2ZUZsYWdxAH4AC0wACGNyZWF0ZUJ5cQB+AApMAApjcmVhdGVEYXRldAAQTGphdmEvdXRpbC9EYXRlO0wAAmlkcQB+AApMAAh1cGRhdGVCeXEAfgAKTAAKdXBkYXRlRGF0ZXEAfgANeHBzcgARamF2YS5sYW5nLkludGVnZXIS4qCk94GHOAIAAUkABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAAAAXBwdAAgNDU0NzNFQzhEOUZENDNCMzhDMURFRDI0RDY5Mzk4RkF0AAVhZG1pbnNxAH4AA3cIAAABW27tBdh4dAADMTIzdAAPMTIxMjMxMjNAcXEuY29tcQB+ABF0AAVhZG1pbnQAIGRmMjNmYWFhNWQ5Yzg4ZDQ0NmI1ZGYyN2ZkNTNiMTU3dAAGMTIzMjQzcHQAIGMyMjU5ZjY0M2FkMGJjYmZiMTgyOWY0NDVmNGQyZTc4dAAIYWRtaW4xMjN0AAnnrqHnkIblkZh0AAlsb2dpbk5hbWVxAH4AF3QAUG9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9BVVRIRU5USUNBVEVEX1NFU1NJT05fS0VZc3IAEWphdmEubGFuZy5Cb29sZWFuzSBygNWc+u4CAAFaAAV2YWx1ZXhwAXQATW9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9QUklOQ0lQQUxTX1NFU1NJT05fS0VZc3IAMm9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5TaW1wbGVQcmluY2lwYWxDb2xsZWN0aW9uqH9YJcajCEoDAAFMAA9yZWFsbVByaW5jaXBhbHN0AA9MamF2YS91dGlsL01hcDt4cHNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cQB+AAY/QAAAAAAADHcIAAAAEAAAAAF0AC1jb20ucWl5dS5hZG1pbi5zeXN0ZW0uc2hpcm8uQXV0aEN1c3RvbVJlYWxtXzBzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hTZXTYbNdald0qHgIAAHhyABFqYXZhLnV0aWwuSGFzaFNldLpEhZWWuLc0AwAAeHB3DAAAABA/QAAAAAAAAXEAfgAOeHgAdwEBcQB+ACZ4eHg=','admin'),('787116f7-175e-4127-a1bb-b645db46dee2',1,'sessionManager','2017-05-26 21:28:46',NULL,'2017-05-26 21:31:35','0:0:0:0:0:0:0:1','2017-05-26 21:31:35','787116f7-175e-4127-a1bb-b645db46dee2','rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDc4NzExNmY3LTE3NWUtNDEyNy1hMWJiLWI2NDVkYjQ2ZGVlMnNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAVxE8fJKeHNxAH4AA3cIAAABXET0hrx4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAV0AAh1c2VySW5mb3NyACBjb20ucWl5dS5hZG1pbi5zeXN0ZW0ubW9kZWwuVXNlcpGUs63nFHNEAgAKTAAFZGVwSWR0ABJMamF2YS9sYW5nL1N0cmluZztMAAVlbWFpbHEAfgAKTAAGZ2VuZGVydAATTGphdmEvbGFuZy9JbnRlZ2VyO0wACWxvZ2luTmFtZXEAfgAKTAAIbG9naW5Qd2RxAH4ACkwABXBob25lcQB+AApMAAVwaG90b3EAfgAKTAAEc2FsdHEAfgAKTAAIdXNlckNvZGVxAH4ACkwACHVzZXJOYW1lcQB+AAp4cgAhY29tLnFpeXUuZnJhbWV3b3JrLmJhc2UuQmFzZU1vZGVsYwa0rqvZEg4CAAZMAAphY3RpdmVGbGFncQB+AAtMAAhjcmVhdGVCeXEAfgAKTAAKY3JlYXRlRGF0ZXQAEExqYXZhL3V0aWwvRGF0ZTtMAAJpZHEAfgAKTAAIdXBkYXRlQnlxAH4ACkwACnVwZGF0ZURhdGVxAH4ADXhwc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAFwcHQAIDQ1NDczRUM4RDlGRDQzQjM4QzFERUQyNEQ2OTM5OEZBdAAFYWRtaW5zcQB+AAN3CAAAAVtu7QXYeHQAAzEyM3QADzEyMTIzMTIzQHFxLmNvbXEAfgARdAAFYWRtaW50ACBkZjIzZmFhYTVkOWM4OGQ0NDZiNWRmMjdmZDUzYjE1N3QABjEyMzI0M3B0ACBjMjI1OWY2NDNhZDBiY2JmYjE4MjlmNDQ1ZjRkMmU3OHQACGFkbWluMTIzdAAJ566h55CG5ZGYdAARc2hpcm9TYXZlZFJlcXVlc3RzcgAmb3JnLmFwYWNoZS5zaGlyby53ZWIudXRpbC5TYXZlZFJlcXVlc3SvzjyteYLKugIAA0wABm1ldGhvZHEAfgAKTAALcXVlcnlTdHJpbmdxAH4ACkwACnJlcXVlc3RVUklxAH4ACnhwdAADR0VUcHQAFi9RaVl1QWRtaW4vZmF2aWNvbi5pY290AAlsb2dpbk5hbWVxAH4AF3QAUG9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9BVVRIRU5USUNBVEVEX1NFU1NJT05fS0VZc3IAEWphdmEubGFuZy5Cb29sZWFuzSBygNWc+u4CAAFaAAV2YWx1ZXhwAXQATW9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9QUklOQ0lQQUxTX1NFU1NJT05fS0VZc3IAMm9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5TaW1wbGVQcmluY2lwYWxDb2xsZWN0aW9uqH9YJcajCEoDAAFMAA9yZWFsbVByaW5jaXBhbHN0AA9MamF2YS91dGlsL01hcDt4cHNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cQB+AAY/QAAAAAAADHcIAAAAEAAAAAF0AC1jb20ucWl5dS5hZG1pbi5zeXN0ZW0uc2hpcm8uQXV0aEN1c3RvbVJlYWxtXzBzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hTZXTYbNdald0qHgIAAHhyABFqYXZhLnV0aWwuSGFzaFNldLpEhZWWuLc0AwAAeHB3DAAAABA/QAAAAAAAAXEAfgAOeHgAdwEBcQB+ACt4eHg=','admin'),('7a878966-7a39-4caf-8c14-0ff9921ba533',1,'sessionManager','2017-05-27 12:38:21',NULL,'2017-05-27 12:39:39','0:0:0:0:0:0:0:1','2017-05-27 12:39:39','7a878966-7a39-4caf-8c14-0ff9921ba533','rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDdhODc4OTY2LTdhMzktNGNhZi04YzE0LTBmZjk5MjFiYTUzM3NyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAVxIMrPUeHNxAH4AA3cIAAABXEgz49l4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAV0AAh1c2VySW5mb3NyACBjb20ucWl5dS5hZG1pbi5zeXN0ZW0ubW9kZWwuVXNlcpGUs63nFHNEAgAKTAAFZGVwSWR0ABJMamF2YS9sYW5nL1N0cmluZztMAAVlbWFpbHEAfgAKTAAGZ2VuZGVydAATTGphdmEvbGFuZy9JbnRlZ2VyO0wACWxvZ2luTmFtZXEAfgAKTAAIbG9naW5Qd2RxAH4ACkwABXBob25lcQB+AApMAAVwaG90b3EAfgAKTAAEc2FsdHEAfgAKTAAIdXNlckNvZGVxAH4ACkwACHVzZXJOYW1lcQB+AAp4cgAhY29tLnFpeXUuZnJhbWV3b3JrLmJhc2UuQmFzZU1vZGVsYwa0rqvZEg4CAAZMAAphY3RpdmVGbGFncQB+AAtMAAhjcmVhdGVCeXEAfgAKTAAKY3JlYXRlRGF0ZXQAEExqYXZhL3V0aWwvRGF0ZTtMAAJpZHEAfgAKTAAIdXBkYXRlQnlxAH4ACkwACnVwZGF0ZURhdGVxAH4ADXhwc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAFwcHQAIDQ1NDczRUM4RDlGRDQzQjM4QzFERUQyNEQ2OTM5OEZBdAAFYWRtaW5zcQB+AAN3CAAAAVtu7QXYeHQAAzEyM3QADzEyMTIzMTIzQHFxLmNvbXEAfgARdAAFYWRtaW50ACBkZjIzZmFhYTVkOWM4OGQ0NDZiNWRmMjdmZDUzYjE1N3QABjEyMzI0M3B0ACBjMjI1OWY2NDNhZDBiY2JmYjE4MjlmNDQ1ZjRkMmU3OHQACGFkbWluMTIzdAAJ566h55CG5ZGYdAARc2hpcm9TYXZlZFJlcXVlc3RzcgAmb3JnLmFwYWNoZS5zaGlyby53ZWIudXRpbC5TYXZlZFJlcXVlc3SvzjyteYLKugIAA0wABm1ldGhvZHEAfgAKTAALcXVlcnlTdHJpbmdxAH4ACkwACnJlcXVlc3RVUklxAH4ACnhwdAADR0VUcHQAFi9RaVl1QWRtaW4vZmF2aWNvbi5pY290AAlsb2dpbk5hbWVxAH4AF3QAUG9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9BVVRIRU5USUNBVEVEX1NFU1NJT05fS0VZc3IAEWphdmEubGFuZy5Cb29sZWFuzSBygNWc+u4CAAFaAAV2YWx1ZXhwAXQATW9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9QUklOQ0lQQUxTX1NFU1NJT05fS0VZc3IAMm9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5TaW1wbGVQcmluY2lwYWxDb2xsZWN0aW9uqH9YJcajCEoDAAFMAA9yZWFsbVByaW5jaXBhbHN0AA9MamF2YS91dGlsL01hcDt4cHNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cQB+AAY/QAAAAAAADHcIAAAAEAAAAAF0AC1jb20ucWl5dS5hZG1pbi5zeXN0ZW0uc2hpcm8uQXV0aEN1c3RvbVJlYWxtXzBzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hTZXTYbNdald0qHgIAAHhyABFqYXZhLnV0aWwuSGFzaFNldLpEhZWWuLc0AwAAeHB3DAAAABA/QAAAAAAAAXEAfgAOeHgAdwEBcQB+ACt4eHg=','admin'),('7cbdc31e-8569-4770-9518-8d70e9fee86d',1,'sessionManager','2017-05-15 16:12:09',NULL,'2017-05-15 16:33:21','192.168.10.111','2017-05-15 16:33:21','7cbdc31e-8569-4770-9518-8d70e9fee86d','rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDdjYmRjMzFlLTg1NjktNDc3MC05NTE4LThkNzBlOWZlZTg2ZHNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAVwLKh3jeHNxAH4AA3cIAAABXAs9ikZ4dxgAAAAAABt3QAAOMTkyLjE2OC4xMC4xMTFzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAABXQACHVzZXJJbmZvc3IAIGNvbS5xaXl1LmFkbWluLnN5c3RlbS5tb2RlbC5Vc2VykZSzrecUc0QCAApMAAVkZXBJZHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABWVtYWlscQB+AApMAAZnZW5kZXJ0ABNMamF2YS9sYW5nL0ludGVnZXI7TAAJbG9naW5OYW1lcQB+AApMAAhsb2dpblB3ZHEAfgAKTAAFcGhvbmVxAH4ACkwABXBob3RvcQB+AApMAARzYWx0cQB+AApMAAh1c2VyQ29kZXEAfgAKTAAIdXNlck5hbWVxAH4ACnhyACFjb20ucWl5dS5mcmFtZXdvcmsuYmFzZS5CYXNlTW9kZWxjBrSuq9kSDgIABkwACmFjdGl2ZUZsYWdxAH4AC0wACGNyZWF0ZUJ5cQB+AApMAApjcmVhdGVEYXRldAAQTGphdmEvdXRpbC9EYXRlO0wAAmlkcQB+AApMAAh1cGRhdGVCeXEAfgAKTAAKdXBkYXRlRGF0ZXEAfgANeHBzcgARamF2YS5sYW5nLkludGVnZXIS4qCk94GHOAIAAUkABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAAAAXBwdAAgNDU0NzNFQzhEOUZENDNCMzhDMURFRDI0RDY5Mzk4RkF0AAVhZG1pbnNxAH4AA3cIAAABW27tBdh4dAADMTIzdAAPMTIxMjMxMjNAcXEuY29tcQB+ABF0AAVhZG1pbnQAIGRmMjNmYWFhNWQ5Yzg4ZDQ0NmI1ZGYyN2ZkNTNiMTU3dAAGMTIzMjQzcHQAIGMyMjU5ZjY0M2FkMGJjYmZiMTgyOWY0NDVmNGQyZTc4dAAIYWRtaW4xMjN0AAnnrqHnkIblkZh0ABFzaGlyb1NhdmVkUmVxdWVzdHNyACZvcmcuYXBhY2hlLnNoaXJvLndlYi51dGlsLlNhdmVkUmVxdWVzdK/OPK15gsq6AgADTAAGbWV0aG9kcQB+AApMAAtxdWVyeVN0cmluZ3EAfgAKTAAKcmVxdWVzdFVSSXEAfgAKeHB0AANHRVRwdAAWL1FpWXVBZG1pbi9mYXZpY29uLmljb3QACWxvZ2luTmFtZXEAfgAXdABQb3JnLmFwYWNoZS5zaGlyby5zdWJqZWN0LnN1cHBvcnQuRGVmYXVsdFN1YmplY3RDb250ZXh0X0FVVEhFTlRJQ0FURURfU0VTU0lPTl9LRVlzcgARamF2YS5sYW5nLkJvb2xlYW7NIHKA1Zz67gIAAVoABXZhbHVleHABdABNb3JnLmFwYWNoZS5zaGlyby5zdWJqZWN0LnN1cHBvcnQuRGVmYXVsdFN1YmplY3RDb250ZXh0X1BSSU5DSVBBTFNfU0VTU0lPTl9LRVlzcgAyb3JnLmFwYWNoZS5zaGlyby5zdWJqZWN0LlNpbXBsZVByaW5jaXBhbENvbGxlY3Rpb26of1glxqMISgMAAUwAD3JlYWxtUHJpbmNpcGFsc3QAD0xqYXZhL3V0aWwvTWFwO3hwc3IAF2phdmEudXRpbC5MaW5rZWRIYXNoTWFwNMBOXBBswPsCAAFaAAthY2Nlc3NPcmRlcnhxAH4ABj9AAAAAAAAMdwgAAAAQAAAAAXQALWNvbS5xaXl1LmFkbWluLnN5c3RlbS5zaGlyby5BdXRoQ3VzdG9tUmVhbG1fMHNyABdqYXZhLnV0aWwuTGlua2VkSGFzaFNldNhs11qV3SoeAgAAeHIAEWphdmEudXRpbC5IYXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9AAAAAAAABcQB+AA54eAB3AQFxAH4AK3h4eA==','admin'),('f63a5a40-6357-4256-872b-65f73f13f3cb',1,'sessionManager','2017-05-27 12:39:45',NULL,'2017-05-27 12:51:19','0:0:0:0:0:0:0:1','2017-05-27 12:51:19','f63a5a40-6357-4256-872b-65f73f13f3cb','rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJGY2M2E1YTQwLTYzNTctNDI1Ni04NzJiLTY1ZjczZjEzZjNjYnNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAVxIM/lXeHNxAH4AA3cIAAABXEg+kOF4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAV0AAh1c2VySW5mb3NyACBjb20ucWl5dS5hZG1pbi5zeXN0ZW0ubW9kZWwuVXNlcpGUs63nFHNEAgAKTAAFZGVwSWR0ABJMamF2YS9sYW5nL1N0cmluZztMAAVlbWFpbHEAfgAKTAAGZ2VuZGVydAATTGphdmEvbGFuZy9JbnRlZ2VyO0wACWxvZ2luTmFtZXEAfgAKTAAIbG9naW5Qd2RxAH4ACkwABXBob25lcQB+AApMAAVwaG90b3EAfgAKTAAEc2FsdHEAfgAKTAAIdXNlckNvZGVxAH4ACkwACHVzZXJOYW1lcQB+AAp4cgAhY29tLnFpeXUuZnJhbWV3b3JrLmJhc2UuQmFzZU1vZGVsYwa0rqvZEg4CAAZMAAphY3RpdmVGbGFncQB+AAtMAAhjcmVhdGVCeXEAfgAKTAAKY3JlYXRlRGF0ZXQAEExqYXZhL3V0aWwvRGF0ZTtMAAJpZHEAfgAKTAAIdXBkYXRlQnlxAH4ACkwACnVwZGF0ZURhdGVxAH4ADXhwc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAFwcHQAIDQ1NDczRUM4RDlGRDQzQjM4QzFERUQyNEQ2OTM5OEZBdAAFYWRtaW5zcQB+AAN3CAAAAVtu7QXYeHQAAzEyM3QADzEyMTIzMTIzQHFxLmNvbXEAfgARdAAFYWRtaW50ACBkZjIzZmFhYTVkOWM4OGQ0NDZiNWRmMjdmZDUzYjE1N3QABjEyMzI0M3B0ACBjMjI1OWY2NDNhZDBiY2JmYjE4MjlmNDQ1ZjRkMmU3OHQACGFkbWluMTIzdAAJ566h55CG5ZGYdAARc2hpcm9TYXZlZFJlcXVlc3RzcgAmb3JnLmFwYWNoZS5zaGlyby53ZWIudXRpbC5TYXZlZFJlcXVlc3SvzjyteYLKugIAA0wABm1ldGhvZHEAfgAKTAALcXVlcnlTdHJpbmdxAH4ACkwACnJlcXVlc3RVUklxAH4ACnhwdAADR0VUcHQAFi9RaVl1QWRtaW4vZmF2aWNvbi5pY290AAlsb2dpbk5hbWVxAH4AF3QAUG9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9BVVRIRU5USUNBVEVEX1NFU1NJT05fS0VZc3IAEWphdmEubGFuZy5Cb29sZWFuzSBygNWc+u4CAAFaAAV2YWx1ZXhwAXQATW9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5zdXBwb3J0LkRlZmF1bHRTdWJqZWN0Q29udGV4dF9QUklOQ0lQQUxTX1NFU1NJT05fS0VZc3IAMm9yZy5hcGFjaGUuc2hpcm8uc3ViamVjdC5TaW1wbGVQcmluY2lwYWxDb2xsZWN0aW9uqH9YJcajCEoDAAFMAA9yZWFsbVByaW5jaXBhbHN0AA9MamF2YS91dGlsL01hcDt4cHNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cQB+AAY/QAAAAAAADHcIAAAAEAAAAAF0AC1jb20ucWl5dS5hZG1pbi5zeXN0ZW0uc2hpcm8uQXV0aEN1c3RvbVJlYWxtXzBzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hTZXTYbNdald0qHgIAAHhyABFqYXZhLnV0aWwuSGFzaFNldLpEhZWWuLc0AwAAeHB3DAAAAAI/QAAAAAAAAXNxAH4ACXNxAH4ADwAAAAFwcHQAIDQ1NDczRUM4RDlGRDQzQjM4QzFERUQyNEQ2OTM5OEZBdAAFYWRtaW5zcQB+AAN3CAAAAVtu7QXYeHQAAzEyM3QADzEyMTIzMTIzQHFxLmNvbXEAfgAxdAAFYWRtaW50ACBkZjIzZmFhYTVkOWM4OGQ0NDZiNWRmMjdmZDUzYjE1N3QABjEyMzI0M3B0ACBjMjI1OWY2NDNhZDBiY2JmYjE4MjlmNDQ1ZjRkMmU3OHQACGFkbWluMTIzdAAJ566h55CG5ZGYeHgAdwEBcQB+ACt4eHg=','admin');
/*!40000 ALTER TABLE `sys_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `ID` varchar(32) NOT NULL,
  `ACTIVE_FLAG` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `DEP_ID` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(40) DEFAULT NULL,
  `GENDER` int(11) DEFAULT NULL,
  `LOGIN_NAME` varchar(40) NOT NULL,
  `LOGIN_PWD` varchar(100) NOT NULL,
  `PHONE` varchar(40) NOT NULL,
  `PHOTO` varchar(40) DEFAULT NULL,
  `USER_CODE` varchar(40) NOT NULL,
  `USER_NAME` varchar(40) NOT NULL,
  `SALT` varchar(64) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_nkgq3ktmqmqtj2eaxwb7q89f7` (`LOGIN_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('0B475A1350DF4059A38450231C02D2A7',1,'admin','2017-03-20 20:42:54','admin','2017-04-15 08:05:46','123','444',NULL,'admin123123','9e50ffb16b53ca416b2bb255401e82f7','444',NULL,'123123444','123123','b7de73ba3c7b8bad8124174fdacbaa77'),('3C45D8133D7441D4BB638DA32BA9FDD9',1,'admin','2017-03-17 12:50:09','admin','2017-03-20 13:11:53','123','231123',1,'admin1','4655480e5cce4b4f5511fd1f87fcc17b','11231231',NULL,'管理员1111','admin','0965573470308b6858fed9e9df80567b'),('45473EC8D9FD43B38C1DED24D69398FA',1,NULL,NULL,'admin','2017-04-15 08:04:39','123','12123123@qq.com',1,'admin','df23faaa5d9c88d446b5df27fd53b157','123243',NULL,'admin123','管理员','c2259f643ad0bcbfb1829f445f4d2e78'),('7A6BC246FD71421298241BB0212E6FB3',1,'admin','2017-03-10 13:23:14',NULL,NULL,'123','123',1,'ceshi','36b27b967e7f569909b64f7fe21a01b7','123123123',NULL,'ceshi','ceshi','03953747031df334405d56645efa72bd'),('A0CA01B245494657B4827FB4359EA5B7',1,'admin','2017-03-10 16:39:46',NULL,NULL,'123','',NULL,'080','c6969b870df9e8d638228aed82fb7c5c','123',NULL,'123321','123','06a1fd47b9e32b1c9e62154870c943c9'),('AFAB3680396A49E9AFD83637FAEF7DD6',1,'admin','2017-03-10 13:41:08',NULL,NULL,'123','',NULL,'qwe123','9f5d1fc35590f273571b497385692a3b','',NULL,'1231231qwe','123','9d03c2b4369c769a3e88c50503364642'),('B052A5978AF14AB190E205EDD9EBA4C0',1,'admin','2017-03-10 13:40:15',NULL,NULL,'123','',NULL,'sdfsdfsfd','01bfbaae84303fa24aebe04babb7dd3b','',NULL,'sdfsdfsdfsdf','sdfsdfsdfsdf','ab40d466fc6653f164447ccd17143ec9'),('C56EF2DCAFFA47549EBC895F24146590',1,'admin','2017-03-10 16:41:28',NULL,NULL,'123','234',2,'2099','9488cca48bf532e76aa7386b67e39d97','234',NULL,'23423','234','92297376e5ce4164c95040d758b5e199'),('D29DDB968F0944279518FD8D390F939C',1,'admin','2017-03-28 19:56:48',NULL,NULL,'123','af',1,'admin1123','16c1ba58506f11145018c8ac35a82ea4','asfd',NULL,'123','asf','df4b4019cd75c15a0611d4103b731ad2'),('DF1CDBEFE6E444F894DEA6D15F80507C',1,'admin','2017-04-15 08:05:10',NULL,NULL,NULL,'234',1,'234','3719ff8238e8128ba1f05ab76dec94a2','234',NULL,'234','234','d6682e56638835a6673692c495a01805'),('DF6BCA1863E9494E89799AE15399AF90',1,'admin','2017-03-10 13:44:54',NULL,NULL,'123','',NULL,'sdf234234','0ad87e046039e0a325884bc72f523242','123',NULL,'asdfasdf','123','6debf36a48d61963e026a715ee0d6c91'),('EF994030DF1C45589C589FC0803CB5F1',1,'admin','2017-03-10 16:43:57',NULL,NULL,'123','34',2,'788','7474cd5bcb931eae1f7f6936570f7bac','2342',NULL,'123','234','539597953d0c9782e55b09c97e407fc3'),('F382069E269046FF885D2C380B49F4D5',1,'admin','2017-03-10 13:39:01',NULL,NULL,'123','123',NULL,'133333222','c589c3f6ef019d3ebdc659144e9fd6a6','123',NULL,'12313123123','123','d74ddc61d7a3732bcd0318ab3de5ae8d'),('FB6DAEC2596D46F0835F419C660A632A',1,'admin','2017-03-10 13:25:22',NULL,NULL,'123','123',1,'ceshi1','ece03f858e82e05089ff7a8b4eb98b92','123',NULL,'ceshi1','ceshi','2da3d6d10d2b2bd543b8d764849de288');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-31 23:09:33
