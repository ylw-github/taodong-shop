/*
 Navicat Premium Data Transfer

 Source Server         : Local-MySQL(5.7)
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : taodong-member

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 09/04/2021 15:26:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PDMAN_DB_VERSION
-- ----------------------------
DROP TABLE IF EXISTS `PDMAN_DB_VERSION`;
CREATE TABLE `PDMAN_DB_VERSION` (
  `DB_VERSION` varchar(256) DEFAULT NULL,
  `VERSION_DESC` varchar(1024) DEFAULT NULL,
  `CREATED_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of PDMAN_DB_VERSION
-- ----------------------------
BEGIN;
INSERT INTO `PDMAN_DB_VERSION` VALUES ('v0.0.0', '默认版本，新增的版本不能低于此版本', '2020-03-20 15:12:19');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` int(12) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `MOBILE` varchar(11) NOT NULL COMMENT '手机号',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱号',
  `PASSWORD` varchar(64) NOT NULL COMMENT '密码',
  `USER_NAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `SEX` tinyint(1) DEFAULT '0' COMMENT '性别  1男  2女',
  `AGE` tinyint(3) DEFAULT '0' COMMENT '年龄',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `IS_AVALIBLE` tinyint(1) DEFAULT '1' COMMENT '是否可用 1正常  2冻结',
  `PIC_IMG` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `QQ_OPENID` varchar(50) DEFAULT NULL COMMENT 'QQ联合登陆id',
  `WX_OPENID` varchar(50) DEFAULT NULL COMMENT '微信公众号关注id',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `MOBILE_UNIQUE` (`MOBILE`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='用户会员表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (27, '13800000001', NULL, 'E10ADC3949BA59ABBE56E057F20F883E', '张三', NULL, NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (29, '13800000002', NULL, 'E10ADC3949BA59ABBE56E057F20F883E', '李四', NULL, NULL, NULL, 1, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `login_type` varchar(255) DEFAULT NULL,
  `device_infor` varchar(255) DEFAULT NULL,
  `is_availability` int(2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_token
-- ----------------------------
BEGIN;
INSERT INTO `user_token` VALUES (80, 'taodong.member.loginPC3e64cf5509674dcf81fb801ddfc75eef', 'PC', 'Chrome 8/80.0.3987.87', 1, 27, '2020-05-25', '2020-05-25');
INSERT INTO `user_token` VALUES (81, 'taodong.member.loginPC0f71be0ce9294bba9d4fa3dec61af1f3', 'PC', 'Chrome 8/80.0.3987.87', 0, 27, '2020-05-25', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
