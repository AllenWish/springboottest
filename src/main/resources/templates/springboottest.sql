/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50170
Source Host           : localhost:3306
Source Database       : springboottest

Target Server Type    : MYSQL
Target Server Version : 50170
File Encoding         : 65001

Date: 2017-08-01 16:43:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tsuser
-- ----------------------------
DROP TABLE IF EXISTS `tsuser`;
CREATE TABLE `tsuser` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tsuser
-- ----------------------------
INSERT INTO `tsuser` VALUES ('1', 'aa', '1', '北京');
INSERT INTO `tsuser` VALUES ('2', 'ab', '5', '北京');
INSERT INTO `tsuser` VALUES ('3', 'cq1', '50', '重庆');
INSERT INTO `tsuser` VALUES ('4', 'cq2', '51', '重庆');
INSERT INTO `tsuser` VALUES ('5', 'aw', '18', '罗山');
