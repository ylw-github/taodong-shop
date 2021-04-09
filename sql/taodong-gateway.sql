/*
 Navicat Premium Data Transfer

 Source Server         : Local-MySQL(5.7)
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : taodong-gateway

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 09/04/2021 15:25:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `APP_NAME` varchar(100) DEFAULT NULL COMMENT '应用名称',
  `APP_ID` varchar(200) DEFAULT NULL COMMENT '应用id',
  `APP_SECRET` varchar(255) DEFAULT NULL COMMENT '应用秘钥',
  `AVAILABILITY` varchar(255) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_info
-- ----------------------------
BEGIN;
INSERT INTO `app_info` VALUES (1, '淘东合作伙伴', '0d30448a-78d0-417d-806d-05c1b384403e', 'F1DEE10360FBF787B10D4DEC7A3A208E', '0');
INSERT INTO `app_info` VALUES (2, '淘东合作伙伴', '8497ebbd-4c9e-4656-b92b-e64366b195e1', 'B547C32C1B88BFD3FEA3713BAB25ACE3', '0');
INSERT INTO `app_info` VALUES (3, '腾讯小马', '7f38d645-032a-43e7-9f08-b7740288836d', 'BF81CD9C70B597F88CF7794A7961F7FD', '0');
COMMIT;

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `ID` int(11) NOT NULL COMMENT '主键id',
  `IP_ADDRES` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `RESTRICTION_TYPE` varchar(255) DEFAULT NULL COMMENT '限制类型',
  `AVAILABILITY` varchar(255) DEFAULT NULL COMMENT '是否可用',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blacklist
-- ----------------------------
BEGIN;
INSERT INTO `blacklist` VALUES (1, '127.0.0.1', '0', '', NULL, '2020-05-19 08:08:44', '2020-05-19 08:08:44', NULL, '2020-05-19 08:08:44');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
