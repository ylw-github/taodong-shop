/*
 Navicat Premium Data Transfer

 Source Server         : Local-MySQL(5.7)
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : taodong-goods

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 09/04/2021 15:26:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attribute_key
-- ----------------------------
DROP TABLE IF EXISTS `attribute_key`;
CREATE TABLE `attribute_key` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CATEGORY_ID` int(11) DEFAULT NULL COMMENT '分类ID',
  `ATTRIBUTE_NAME` varchar(32) DEFAULT NULL COMMENT '属性名称',
  `NAME_SORT` varchar(32) DEFAULT NULL COMMENT '名称排序',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品规格Key表 ';

-- ----------------------------
-- Records of attribute_key
-- ----------------------------
BEGIN;
INSERT INTO `attribute_key` VALUES (1, 6, '重量', '0', 1, NULL, '2020-03-02 15:34:35', '2020-03-02 15:34:35', '2020-03-02 15:34:35');
INSERT INTO `attribute_key` VALUES (2, 6, '类别', '0', 1, NULL, '2020-03-02 15:34:35', '2020-03-02 15:34:35', '2020-03-02 15:34:35');
INSERT INTO `attribute_key` VALUES (3, 6, '原产地', '0', 1, NULL, '2020-03-02 15:34:35', '2020-03-02 15:34:35', '2020-03-02 15:34:35');
INSERT INTO `attribute_key` VALUES (4, 6, '售卖方式', '0', 1, NULL, '2020-03-02 15:34:35', '2020-03-02 15:34:35', '2020-03-02 15:34:35');
COMMIT;

-- ----------------------------
-- Table structure for attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `attribute_value`;
CREATE TABLE `attribute_value` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ATTRIBUTE_ID` varchar(32) DEFAULT NULL COMMENT '属性ID',
  `ATTRIBUTE_VALUE` varchar(32) DEFAULT NULL COMMENT '属性值',
  `VALUE_SORT` varchar(32) DEFAULT NULL COMMENT '值排序',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='商品规格值表 ';

-- ----------------------------
-- Records of attribute_value
-- ----------------------------
BEGIN;
INSERT INTO `attribute_value` VALUES (1, '1', '3kg-4kg', '0', 1, NULL, '2020-03-02 15:36:27', '2020-03-02 15:36:27', '2020-03-02 15:36:27');
INSERT INTO `attribute_value` VALUES (2, '1', '1000g以下', '0', 1, NULL, '2020-03-02 15:36:42', '2020-03-02 15:36:42', '2020-03-02 15:36:42');
INSERT INTO `attribute_value` VALUES (3, '1', '1000-1999g', '0', 1, NULL, '2020-03-02 15:36:43', '2020-03-02 15:36:43', '2020-03-02 15:36:43');
INSERT INTO `attribute_value` VALUES (4, '1', '2000-3999g', '0', 1, NULL, '2020-03-02 15:36:43', '2020-03-02 15:36:43', '2020-03-02 15:36:43');
INSERT INTO `attribute_value` VALUES (5, '2', '红富士', '0', 1, NULL, '2020-03-02 15:38:55', '2020-03-02 15:38:55', '2020-03-02 15:38:55');
INSERT INTO `attribute_value` VALUES (6, '2', '雪莲果', '0', 1, NULL, '2020-03-02 15:38:55', '2020-03-02 15:38:55', '2020-03-02 15:38:55');
INSERT INTO `attribute_value` VALUES (7, '2', '徐香', '0', 1, NULL, '2020-03-02 15:38:55', '2020-03-02 15:38:55', '2020-03-02 15:38:55');
INSERT INTO `attribute_value` VALUES (8, '3', '陕西', '0', 1, NULL, '2020-03-02 15:38:57', '2020-03-02 15:38:57', '2020-03-02 15:38:57');
INSERT INTO `attribute_value` VALUES (9, '3', '四川', '0', 1, NULL, '2020-03-02 15:38:57', '2020-03-02 15:38:57', '2020-03-02 15:38:57');
INSERT INTO `attribute_value` VALUES (10, '3', '泰国', '0', 1, NULL, '2020-03-02 15:38:57', '2020-03-02 15:38:57', '2020-03-02 15:38:57');
INSERT INTO `attribute_value` VALUES (11, '3', '海南', '0', 1, NULL, '2020-03-02 15:38:59', '2020-03-02 15:38:59', '2020-03-02 15:38:59');
INSERT INTO `attribute_value` VALUES (12, '3', '山东', '0', 1, NULL, '2020-03-02 15:38:59', '2020-03-02 15:38:59', '2020-03-02 15:38:59');
INSERT INTO `attribute_value` VALUES (13, '3', '广西', '0', 1, NULL, '2020-03-02 15:38:59', '2020-03-02 15:38:59', '2020-03-02 15:38:59');
INSERT INTO `attribute_value` VALUES (14, '3', '越南', '0', 1, NULL, '2020-03-02 15:38:59', '2020-03-02 15:38:59', '2020-03-02 15:38:59');
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父ID',
  `NAME` varchar(128) DEFAULT NULL COMMENT '名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `SORT_ORDER` int(11) DEFAULT NULL COMMENT '分类顺序',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='商品分类 商品分类信息表';

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, 0, '新鲜水果', 0, 0, NULL, NULL, '2020-03-02 15:00:57', '2020-03-02 15:00:57', '2020-03-02 15:00:57');
INSERT INTO `category` VALUES (2, 1, '热销水果', 0, 0, NULL, NULL, '2020-03-02 15:02:08', '2020-03-02 15:02:08', '2020-03-02 15:02:08');
INSERT INTO `category` VALUES (3, 1, '时令水果', 0, 0, NULL, NULL, '2020-03-02 15:02:08', '2020-03-02 15:02:08', '2020-03-02 15:02:08');
INSERT INTO `category` VALUES (4, 1, '热带水果', 0, 0, NULL, NULL, '2020-03-02 15:02:08', '2020-03-02 15:02:08', '2020-03-02 15:02:08');
INSERT INTO `category` VALUES (5, 1, '地标水果', 0, 0, NULL, NULL, '2020-03-02 15:02:08', '2020-03-02 15:02:08', '2020-03-02 15:02:08');
INSERT INTO `category` VALUES (6, 2, '苹果', 0, 0, NULL, NULL, '2020-03-02 15:03:19', '2020-03-02 15:03:19', '2020-03-02 15:03:19');
INSERT INTO `category` VALUES (7, 2, '橙子', 0, 0, NULL, NULL, '2020-03-02 15:03:19', '2020-03-02 15:03:19', '2020-03-02 15:03:19');
INSERT INTO `category` VALUES (8, 0, '海鲜水产', 0, 0, NULL, NULL, '2020-03-02 15:28:39', '2020-03-02 15:28:39', '2020-03-02 15:28:39');
INSERT INTO `category` VALUES (9, 8, '鱼类', 0, 0, NULL, NULL, '2020-03-02 15:28:49', '2020-03-02 15:28:49', '2020-03-02 15:28:49');
INSERT INTO `category` VALUES (10, 8, '虾类', 0, 0, NULL, NULL, '2020-03-02 15:28:49', '2020-03-02 15:28:49', '2020-03-02 15:28:49');
INSERT INTO `category` VALUES (11, 9, '三文鱼', 0, 0, NULL, NULL, '2020-03-02 15:30:10', '2020-03-02 15:30:10', '2020-03-02 15:30:10');
INSERT INTO `category` VALUES (12, 9, '鳕鱼', 0, 0, NULL, NULL, '2020-03-02 15:30:10', '2020-03-02 15:30:10', '2020-03-02 15:30:10');
INSERT INTO `category` VALUES (13, 9, '金枪鱼', 0, 0, NULL, NULL, '2020-04-01 15:30:10', '2020-04-01 15:30:10', '2020-04-01 15:30:10');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CATEGORY_ID` int(11) DEFAULT NULL COMMENT '类型ID',
  `NAME` varchar(128) DEFAULT NULL COMMENT '名称',
  `SUBTITLE` varchar(128) DEFAULT NULL COMMENT '小标题',
  `MAIN_IMAGE` varchar(128) DEFAULT NULL COMMENT '主图像',
  `SUB_IMAGES` text COMMENT '小标题图像',
  `DETAIL` text COMMENT '描述',
  `ATTRIBUTE_LIST` varchar(128) DEFAULT NULL COMMENT '商品规格',
  `PRICE` decimal(32,8) DEFAULT NULL COMMENT '价格',
  `STOCK` int(11) DEFAULT NULL COMMENT '库存',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (1, 6, '烟台红富士苹果', '红富士苹果', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1296845473,2218916964&fm=26&gp=0.jpg', '{\"imgages\":[{\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3443692772,1819655971&fm=26&gp=0.jpg\"},{\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1435166030,2305236542&fm=26&gp=0.jpg\"}]}', '烟台红富士苹果 12个 净重2.6kg以上', '1,2,3,4', NULL, NULL, 0, 1, NULL, '2020-03-30 17:00:40', NULL, '2020-04-01 18:00:40');
INSERT INTO `product` VALUES (2, 6, '赣州脐橙', '甜橙子', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1296845473,2218916964&fm=26&gp=0.jpg', '{\"imgages\":[{\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3443692772,1819655971&fm=26&gp=0.jpg\"},{\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1435166030,2305236542&fm=26&gp=0.jpg\"}]}', '赣南脐橙 鲜甜橙子 2.5kg装 单果160g-200g 生鲜自营新鲜水果', '1,2,3,4', NULL, NULL, 0, 1, NULL, '2020-03-30 17:53:40', NULL, '2020-04-01 18:53:40');
COMMIT;

-- ----------------------------
-- Table structure for product_specs
-- ----------------------------
DROP TABLE IF EXISTS `product_specs`;
CREATE TABLE `product_specs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '商品ID',
  `PRODUCT_SPECS` text COMMENT '商品规格',
  `SPECS_SEQ` int(11) DEFAULT NULL COMMENT '规格顺序',
  `PRODUCT_STOCK` int(11) DEFAULT NULL COMMENT '商品库存',
  `PRODUCT_PRICE` decimal(32,8) DEFAULT NULL COMMENT '商品价格',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品规格表 ';

-- ----------------------------
-- Records of product_specs
-- ----------------------------
BEGIN;
INSERT INTO `product_specs` VALUES (1, 1, '{\"内存\":\"4G\",\"颜色\":\"红色\",\"年份\":\"2019\",\"尺寸\":\"16寸\"}', 0, 30, 3699.00000000, 1, NULL, '2019-03-02 15:50:04', '2019-03-02 15:50:04', '2019-03-02 15:50:04');
INSERT INTO `product_specs` VALUES (2, 1, '{\"内存\":\"8G\",\"颜色\":\"白色\",\"年份\":\"2019\",\"尺寸\":\"16寸\"}', 0, 30, 3899.00000000, 1, NULL, '2019-03-02 15:50:04', '2019-03-02 15:50:04', '2019-03-02 15:50:04');
INSERT INTO `product_specs` VALUES (3, 1, '{\"内存\":\"16G\",\"颜色\":\"白色\",\"年份\":\"2019\",\"尺寸\":\"16寸\"}', 0, 30, 4199.00000000, 1, NULL, '2019-03-02 15:50:04', '2019-03-02 15:50:04', '2019-03-02 15:50:04');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
