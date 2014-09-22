--create schema
CREATE DATABASE `manong` /*!40100 DEFAULT CHARACTER SET latin1 */;

--用户表
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `username` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'INACTIVE',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `sys_user` (`id`,`version`,`username`,`password`,`name`,`status`) VALUES (1,0,'test','098f6bcd4621d373cade4e832627b4f6','test','ACTIVE');

--20140920
--资源表
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `hierarchy` int(11) DEFAULT NULL,
  `sub_hierarchy` int(11) DEFAULT NULL,
  `show` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (1,'HOME','首页','/home',1,NULL,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (2,'IT_INFO','互联网资讯','/itInfo',1,NULL,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (3,'IT_INFO_LIST','互联网资讯列表','/itInfo/list',2,1,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (4,'IT_INFO_ACCEPT','互联网资讯录用','/itInfo/accept',2,2,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (5,'CELEBRITY','名人堂','/celebrity',1,NULL,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (6,'CELEBRITY_LIST','名人堂列表','/celebrity/list',2,1,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (7,'CELEBRITY_RECRUIT','名人堂录用','/celebrity/recruit',2,2,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (8,'SUPPORT','帮助与支持','/support',1,NULL,1,0);

CREATE TABLE `auth_res_oper_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority_code` varchar(45) DEFAULT NULL,
  `resource_code` varchar(45) DEFAULT NULL,
  `operation_code` varchar(45) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_po4b5orh82i9dcumn49moff2r` (`authority_code`),
  KEY `FK_my4xbn9gw8r6ypvvlpyx7618x` (`operation_code`),
  KEY `FK_mnmu6qibul7t1qccb3290fjou` (`resource_code`),
  CONSTRAINT `FK_mnmu6qibul7t1qccb3290fjou` FOREIGN KEY (`resource_code`) REFERENCES `sys_resource` (`code`),
  CONSTRAINT `FK_my4xbn9gw8r6ypvvlpyx7618x` FOREIGN KEY (`operation_code`) REFERENCES `sys_resource_operation` (`code`),
  CONSTRAINT `FK_po4b5orh82i9dcumn49moff2r` FOREIGN KEY (`authority_code`) REFERENCES `sys_authority` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (1,'USER','HOME','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (2,'USER','IT_INFO','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (3,'USER','IT_INFO_LIST','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (4,'USER','CELEBRITY','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (5,'USER','CELEBRITY_LIST','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (6,'USER','SUPPORT','VIEW',0);


CREATE TABLE `role_auth_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(45) DEFAULT NULL,
  `auth_code` varchar(45) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_mnnlgcfcpia07qsapq65wl5dq` (`auth_code`),
  KEY `FK_bkewchh9wugmlkge38qkpv7gr` (`role_code`),
  CONSTRAINT `FK_bkewchh9wugmlkge38qkpv7gr` FOREIGN KEY (`role_code`) REFERENCES `sys_role` (`code`),
  CONSTRAINT `FK_mnnlgcfcpia07qsapq65wl5dq` FOREIGN KEY (`auth_code`) REFERENCES `sys_authority` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `role_auth_mapping` (`id`,`role_code`,`auth_code`,`version`) VALUES (1,'USER','USER',0);

CREATE TABLE `sys_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `outdated` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pl0vno2ej03gici6ld4w66loe` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `sys_authority` (`id`,`code`,`name`,`outdated`,`version`) VALUES (1,'USER','一般用户权限',0,0);


CREATE TABLE `sys_resource_operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `version` varchar(45) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mm0sergnoq88rbixt01yen7am` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `sys_resource_operation` (`id`,`code`,`name`,`version`) VALUES (1,'VIEW','查看','0');


CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `is_system` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_plpigyqwsqfn7mn66npgf9ftp` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `sys_role` (`id`,`code`,`name`,`is_system`,`version`) VALUES (1,'USER','一般用户',0,0);

CREATE TABLE `user_role_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `role_code` varchar(45) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_ehjw3ngtsl0oaouvkiropp4vn` (`role_code`),
  KEY `FK_kf7xobjpn8kvkpmfcrxmdqmjc` (`username`),
  CONSTRAINT `FK_ehjw3ngtsl0oaouvkiropp4vn` FOREIGN KEY (`role_code`) REFERENCES `sys_role` (`code`),
  CONSTRAINT `FK_kf7xobjpn8kvkpmfcrxmdqmjc` FOREIGN KEY (`username`) REFERENCES `sys_user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `user_role_mapping` (`id`,`username`,`role_code`,`version`) VALUES (1,'test','USER',0);

--20140922
CREATE TABLE `info_tougao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `category` bigint(20) DEFAULT NULL,
  `type` bigint(20) DEFAULT NULL,
  `source_url` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `create_user` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `info_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tougao_id` bigint(20) DEFAULT NULL,
  `hits` bigint(20) DEFAULT '0',
  `top` tinyint(1) DEFAULT NULL,
  `accept_user` bigint(20) DEFAULT NULL,
  `accept_date` datetime DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
