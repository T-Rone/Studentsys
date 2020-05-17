# Host: localhost  (Version: 5.5.53)
# Date: 2020-04-27 15:20:36
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "cj"
#

CREATE TABLE `cj` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `usid` varchar(255) NOT NULL DEFAULT '',
  `cid` varchar(255) NOT NULL DEFAULT '',
  `score` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "cj"
#

INSERT INTO `cj` VALUES (1,'1601301113','206','76'),(2,'1601302234','302','80'),(3,'1402307539','102','78'),(4,'1601307562','102','78'),(5,'1901306649','208','78'),(6,'1402307539','101','62'),(7,'1501303264','301','70'),(8,'1601305913','209','81'),(9,'1601302239','101','90'),(10,'666','302','77'),(11,'1601301113','101','77');

#
# Structure for table "department"
#

CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `depart_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "department"
#

INSERT INTO `department` VALUES (1,'软件技术'),(2,'网络技术');

#
# Structure for table "kc"
#

CREATE TABLE `kc` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `cid` varchar(6) NOT NULL DEFAULT '',
  `cname` varchar(15) NOT NULL DEFAULT '',
  `term` varchar(11) DEFAULT '1',
  `period` varchar(11) NOT NULL DEFAULT '0',
  `credit` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "kc"
#

INSERT INTO `kc` VALUES (1,'101','计算机基础','1','80','5'),(2,'102','C程序设计','2','68','4'),(3,'206','高等数学','4','68','4'),(4,'208','数据结构','2','68','4'),(5,'209','操作系统','3','68','4'),(6,'210','计算机组装','5','80','5'),(7,'212','ORACLE数据库','6','68','4'),(8,'301','计算机网络','7','52','3'),(9,'302','软件工程','7','52','3');

#
# Structure for table "student"
#

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usid` varchar(255) DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `college` varchar(11) DEFAULT NULL,
  `major` varchar(11) DEFAULT NULL,
  `classes` varchar(11) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `home` varchar(255) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `schoolday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,'1601301113','王金华','计算机','软件技术','1',1,'湖北襄阳','1997-09-11 00:00:00','2016-09-01 00:00:00'),(2,'1601302234','程周杰','计算机','网络技术','2',1,'河北石家庄','1997-09-11 00:00:00','2016-09-01 00:00:00'),(3,'1601306499','李明','计算机','信息管理','4',1,'湖南长沙','1997-09-11 00:00:00','2016-09-01 00:00:00'),(4,'1601302239','刘敏','计算机','软件技术','1',1,'湖北武汉','1997-09-11 00:00:00','2016-09-01 00:00:00'),(5,'1601307562','赵云','计算机','网络技术','3',1,'浙江温州','1997-09-11 00:00:00','2016-09-01 00:00:00'),(6,'1901306649','马克','计算机','信息管理','3',1,'浙江杭州','2000-10-15 09:55:18','2019-09-01 09:55:18'),(7,'1601305913','杨帆','计算机','计算机应用基础','5',1,'陕西西安','1997-09-11 00:00:00','2016-09-01 00:00:00'),(8,'1402307539','唐慧婷','机电','机械制造','7',0,'广东广州','1997-09-11 00:00:00','2014-09-01 00:00:00'),(9,'1501303264','孙祥','建筑','土木工程','7',1,'山东济南','1994-10-15 09:45:45','2015-10-15 09:45:45'),(10,'666','test',NULL,NULL,'2',NULL,NULL,NULL,NULL);

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'long','123'),(6,'test','123'),(13,'666','777');
