DROP TABLE IF EXISTS sys_user;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `username` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'INACTIVE',
  PRIMARY KEY (`id`,`username`),
  UNIQUE KEY `UK_51bvuyvihefoh4kp5syh2jpi4` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `sys_user` (`id`,`version`,`username`,`password`,`name`,`status`) VALUES (1,0,'test','098f6bcd4621d373cade4e832627b4f6','test','ACTIVE');

DROP TABLE IF EXISTS sys_role;
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

DROP TABLE IF EXISTS user_role_mapping;
CREATE TABLE `user_role_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `role_code` varchar(45) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_ehjw3ngtsl0oaouvkiropp4vn` (`role_code`),
  KEY `FK_kf7xobjpn8kvkpmfcrxmdqmjc` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `user_role_mapping` (`id`,`username`,`role_code`,`version`) VALUES (1,'test','USER',0);

DROP TABLE IF EXISTS sys_authority;
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

DROP TABLE IF EXISTS role_auth_mapping;
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

DROP TABLE IF EXISTS sys_resource;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `parent_code` varchar(45) DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `hierarchy` int(11) DEFAULT NULL,
  `sub_hierarchy` int(11) DEFAULT NULL,
  `show` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1unub6a3h9s0afpq1ijdwh69b` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (1,'HOME','HOME','首页','/home',1,1,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (2,'IT_INFO','IT_INFO','互联网资讯','/itInfo',1,2,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (3,'IT_INFO_LIST','IT_INFO','互联网资讯列表','/itInfo/list',2,1,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (4,'IT_INFO_ACCEPT','IT_INFO','互联网资讯录用','/itInfo/accept',2,2,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (5,'CELEBRITY','CELEBRITY','名人堂','/celebrity',1,3,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (6,'CELEBRITY_LIST','CELEBRITY','名人堂列表','/celebrity/list',2,1,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (7,'CELEBRITY_RECRUIT','CELEBRITY','名人堂录用','/celebrity/recruit',2,2,1,0);
INSERT INTO `sys_resource` (`id`,`code`,`parent_code`,`name`,`url`,`hierarchy`,`sub_hierarchy`,`show`,`version`) VALUES (8,'SUPPORT','SUPPORT','帮助与支持','/support',1,4,1,0);

DROP TABLE IF EXISTS sys_resource_operation;
CREATE TABLE `sys_resource_operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `version` varchar(45) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mm0sergnoq88rbixt01yen7am` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `sys_resource_operation` (`id`,`code`,`name`,`version`) VALUES (1,'VIEW','查看','0');

DROP TABLE IF EXISTS auth_res_oper_mapping;
CREATE TABLE `auth_res_oper_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority_code` varchar(45) DEFAULT NULL,
  `resource_code` varchar(45) DEFAULT NULL,
  `operation_code` varchar(45) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_po4b5orh82i9dcumn49moff2r` (`authority_code`),
  KEY `FK_my4xbn9gw8r6ypvvlpyx7618x` (`operation_code`),
  KEY `FK_mnmu6qibul7t1qccb3290fjou` (`resource_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (1,'USER','HOME','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (2,'USER','IT_INFO','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (3,'USER','IT_INFO_LIST','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (4,'USER','CELEBRITY','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (5,'USER','CELEBRITY_LIST','VIEW',0);
INSERT INTO `auth_res_oper_mapping` (`id`,`authority_code`,`resource_code`,`operation_code`,`version`) VALUES (6,'USER','SUPPORT','VIEW',0);

DROP TABLE IF EXISTS info_tougao;
CREATE TABLE `info_tougao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `category` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `source_url` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `create_user` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `accepted` tinyint(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_83njfy6m4wqwq3bvtjjp07tsx` (`create_user`),
  CONSTRAINT `FK_83njfy6m4wqwq3bvtjjp07tsx` FOREIGN KEY (`create_user`) REFERENCES `sys_user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
INSERT INTO `info_tougao` (`id`,`title`,`content`,`category`,`type`,`source_url`,`create_user`,`create_time`,`accepted`,`version`) VALUES (1,'测试文件编号','地方法','INFO','ORIGIN',NULL,'test','2014-09-23 13:14:42',0,2);
INSERT INTO `info_tougao` (`id`,`title`,`content`,`category`,`type`,`source_url`,`create_user`,`create_time`,`accepted`,`version`) VALUES (2,'测试文件编号2','地方法2','INFO','ORIGIN',NULL,'test','2014-09-23 13:15:11',1,1);
INSERT INTO `info_tougao` (`id`,`title`,`content`,`category`,`type`,`source_url`,`create_user`,`create_time`,`accepted`,`version`) VALUES (3,'测试文件编号3','地方法3','INFO','ORIGIN',NULL,'test','2014-09-23 13:15:20',0,0);
INSERT INTO `info_tougao` (`id`,`title`,`content`,`category`,`type`,`source_url`,`create_user`,`create_time`,`accepted`,`version`) VALUES (4,'fda','fda','INFO','ORIGIN','fda','test','2014-09-25 09:47:54',1,1);

DROP TABLE IF EXISTS info_list;

delete FROM manong.sys_resource where code = 'CELEBRITY_LIST';
delete from manong.auth_res_oper_mapping where resource_code = 'CELEBRITY_LIST';

DROP TABLE IF EXISTS celebrity_tougao;
CREATE TABLE `celebrity_tougao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `honor_title` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `profile` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `zhuanji` text CHARACTER SET utf8,
  `resource_url` text CHARACTER SET utf8,
  `accepted` tinyint(1) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `celebrity_tougao` (`id`,`honor_title`,`name`,`profile`,`zhuanji`,`resource_url`,`accepted`,`create_date`,`version`) VALUES (1,'传奇','传奇传奇','传奇传奇传奇传奇传奇传奇','传奇传奇传奇传奇传奇传奇传奇传奇','www.baidu.com',0,'2014-09-25 16:29:47',0);
