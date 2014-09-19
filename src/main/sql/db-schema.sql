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
