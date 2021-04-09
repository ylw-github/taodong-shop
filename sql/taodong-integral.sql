/*
 Navicat Premium Data Transfer

 Source Server         : Local-MySQL(5.7)
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : taodong-integral

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 09/04/2021 15:26:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for integral
-- ----------------------------
DROP TABLE IF EXISTS `integral`;
CREATE TABLE `integral` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户ID',
  `PAYMENT_ID` varchar(1024) DEFAULT NULL COMMENT '支付ID',
  `INTEGRAL` varchar(32) DEFAULT NULL COMMENT '积分',
  `AVAILABILITY` int(11) DEFAULT NULL COMMENT '是否可用',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT=' ';

-- ----------------------------
-- Records of integral
-- ----------------------------
BEGIN;
INSERT INTO `integral` VALUES (47, 27, '422635326348070912', '100', 1, 0, NULL, '2020-05-19 08:12:32', NULL, '2020-05-19 08:12:32');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
