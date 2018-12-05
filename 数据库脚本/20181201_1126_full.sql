/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : dang

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2018-12-01 11:26:41
*/

drop database IF EXISTS dang;-- 删除数据库
create database dang default character set utf8;-- 创建指定字符集的数据库
use dang;-- 进入dang数据库

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for d_book
-- ----------------------------
DROP TABLE IF EXISTS `d_book`;
CREATE TABLE `d_book` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `fixed_price` double NOT NULL,
  `dang_price` double NOT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `author` varchar(200) NOT NULL,
  `publishing` varchar(200) NOT NULL,
  `pub_time` date NOT NULL,
  `author_summary` varchar(100) NOT NULL,
  `descr` varchar(100) DEFAULT NULL,
  `score` int(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_book
-- ----------------------------
INSERT INTO `d_book` VALUES ('1', '疯狂Java讲义第三版', '200', '180', '16.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('2', '疯狂Java讲义第四版', '200', '180', '17.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('3', 'JAVA核心技术', '200', '180', '18.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('4', '深度学习', '200', '180', '19.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('5', '大话设计模式', '200', '180', '20.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('6', 'Python核心编程', '200', '180', '21.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('7', 'JavaScript学习指南', '200', '180', '22.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('8', '高等数学', '200', '180', '23.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('9', '离散数学', '200', '180', '24.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('10', '三体·黑暗森林', '200', '180', '2.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');
INSERT INTO `d_book` VALUES ('11', '数据挖掘原理与算法', '200', '180', '3.jpg', '作者1', '出版社1', '2018-12-01', '作者简介1', '这真是一本好书啊', '90');

-- ----------------------------
-- Table structure for d_order
-- ----------------------------
DROP TABLE IF EXISTS `d_order`;
CREATE TABLE `d_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `order_time` mediumtext NOT NULL,
  `total_price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_order
-- ----------------------------

-- ----------------------------
-- Table structure for d_receive_address
-- ----------------------------
DROP TABLE IF EXISTS `d_receive_address`;
CREATE TABLE `d_receive_address` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(12) NOT NULL,
  `receive_name` varchar(50) NOT NULL,
  `full_address` varchar(50) NOT NULL,
  `postal_code` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_receive_address
-- ----------------------------

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_user
-- ----------------------------
INSERT INTO `d_user` VALUES ('1', 'shao@123.com', 'shao', '666666');
INSERT INTO `d_user` VALUES ('2', 'long@123.com', 'long', '666666');
INSERT INTO `d_user` VALUES ('3', 'admin@123.com', 'admin', '666666');
