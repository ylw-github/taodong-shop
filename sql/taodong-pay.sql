/*
 Navicat Premium Data Transfer

 Source Server         : Local-MySQL(5.7)
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : taodong-pay

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 09/04/2021 15:26:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment_channel
-- ----------------------------
DROP TABLE IF EXISTS `payment_channel`;
CREATE TABLE `payment_channel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CHANNEL_NAME` varchar(32) NOT NULL COMMENT '渠道名称',
  `CHANNEL_ID` varchar(32) NOT NULL COMMENT '渠道ID',
  `MERCHANT_ID` varchar(32) NOT NULL COMMENT '商户id',
  `SYNC_URL` text NOT NULL COMMENT '同步回调URL',
  `ASYN_URL` text NOT NULL COMMENT '异步回调URL',
  `PUBLIC_KEY` text COMMENT '公钥',
  `PRIVATE_KEY` text COMMENT '私钥',
  `CHANNEL_STATE` int(11) DEFAULT '0' COMMENT '渠道状态 0开启1关闭',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `CLASS_ADDRES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`,`CHANNEL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='支付渠道 ';

-- ----------------------------
-- Records of payment_channel
-- ----------------------------
BEGIN;
INSERT INTO `payment_channel` VALUES (1, '银联支付', 'yinlian_pay', '777290058110097', 'http://localhost:8600/unionPaySynCallback', 'http://zgs9gb.natappfree.cc/unionPayAsynCallback', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 'com.ylw.service.pay.strategy.impl.UnionPayStrategy');
INSERT INTO `payment_channel` VALUES (2, '支付宝', 'ali_pay', '777666655522521', 'http://localhost:8600/aliPaySynCallback', 'http://zgs9gb.natappfree.cc/aliPayAsynCallback', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 'com.ylw.service.pay.strategy.impl.AliPayStrategy');
INSERT INTO `payment_channel` VALUES (3, '微信支付', 'weixin_pay', '777290058110048', 'test', 'test', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 'com.ylw.service.pay.strategy.impl.WeixinPayStrategy');
COMMIT;

-- ----------------------------
-- Table structure for payment_transaction
-- ----------------------------
DROP TABLE IF EXISTS `payment_transaction`;
CREATE TABLE `payment_transaction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `PAY_AMOUNT` int(11) NOT NULL COMMENT '支付金额',
  `PAYMENT_STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '支付状态 0待支付1已经支付2支付超时3支付失败',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `ORDER_ID` varchar(32) NOT NULL COMMENT '订单号码',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PARTYPAY_ID` varchar(32) DEFAULT NULL,
  `PAYMENT_ID` varchar(32) DEFAULT NULL COMMENT '订单号',
  `PRODUCT_NAME` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `PAYMENT_CHANNEL` varchar(32) DEFAULT NULL COMMENT '渠道',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8 COMMENT='支付交易 ';

-- ----------------------------
-- Records of payment_transaction
-- ----------------------------
BEGIN;
INSERT INTO `payment_transaction` VALUES (132, 999, 1, 27, '20200513141452', NULL, NULL, '2020-05-19 08:08:44', NULL, '2020-05-19 08:08:44', NULL, '422635326348070912', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (133, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:33:38', NULL, '2020-05-20 01:33:38', NULL, '422898285175508992', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (134, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:40:42', NULL, '2020-05-20 01:40:42', NULL, '422900064449597440', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (135, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:40:46', NULL, '2020-05-20 01:40:46', NULL, '422900078508904448', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (136, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:40:47', NULL, '2020-05-20 01:40:47', NULL, '422900085362397184', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (137, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:40:50', NULL, '2020-05-20 01:40:50', NULL, '422900095923654656', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (138, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:40:52', NULL, '2020-05-20 01:40:52', NULL, '422900105088208896', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (139, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:41:18', NULL, '2020-05-20 01:41:18', NULL, '422900214605680640', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (140, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:42:06', NULL, '2020-05-20 01:42:06', NULL, '422900417366724608', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (141, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:42:19', NULL, '2020-05-20 01:42:19', NULL, '422900468822446080', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (142, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 01:43:24', NULL, '2020-05-20 01:43:24', NULL, '422900741062135808', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (143, 8882, 0, 27, '20200513141452', NULL, NULL, '2020-05-20 02:30:09', NULL, '2020-05-20 02:30:09', NULL, '422912506164547584', '玉米香肠', NULL);
INSERT INTO `payment_transaction` VALUES (144, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 01:47:01', NULL, '2020-05-21 01:47:01', NULL, '423264040769425408', '广东米酒', NULL);
INSERT INTO `payment_transaction` VALUES (145, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 01:48:35', NULL, '2020-05-21 01:48:35', NULL, '423264436787220480', '&#24191;&#19996;&#31859;&#37202;', NULL);
INSERT INTO `payment_transaction` VALUES (146, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 01:51:08', NULL, '2020-05-21 01:51:08', NULL, '423265078150828032', '&#24191;&#19996;&#31859;&#37202;', NULL);
INSERT INTO `payment_transaction` VALUES (147, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 01:57:41', NULL, '2020-05-21 01:57:41', NULL, '423266724503228416', '&#24191;&#19996;&#31859;&#37202;', NULL);
INSERT INTO `payment_transaction` VALUES (148, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 06:40:48', NULL, '2020-05-21 06:40:48', NULL, '423337973434683392', '&#24191;&#19996;&#31859;&#37202;', NULL);
INSERT INTO `payment_transaction` VALUES (149, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 06:46:03', NULL, '2020-05-21 06:46:03', NULL, '423339294485254144', 'apple', NULL);
INSERT INTO `payment_transaction` VALUES (150, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 08:19:20', NULL, '2020-05-21 08:19:20', NULL, '423362770046685184', 'apple', NULL);
INSERT INTO `payment_transaction` VALUES (151, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 08:19:37', NULL, '2020-05-21 08:19:37', NULL, '423362840058007552', 'apple', NULL);
INSERT INTO `payment_transaction` VALUES (152, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 08:20:36', NULL, '2020-05-21 08:20:36', NULL, '423363087727464448', 'apple', NULL);
INSERT INTO `payment_transaction` VALUES (153, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 08:20:58', NULL, '2020-05-21 08:20:58', NULL, '423363181344329728', 'apple', NULL);
INSERT INTO `payment_transaction` VALUES (154, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 08:54:22', NULL, '2020-05-21 08:54:22', NULL, '423371586997981184', 'apple', NULL);
INSERT INTO `payment_transaction` VALUES (155, 9999, 0, 27, '20200513141452', NULL, NULL, '2020-05-21 08:55:51', NULL, '2020-05-21 08:55:51', NULL, '423371961951981568', 'apple', NULL);
COMMIT;

-- ----------------------------
-- Table structure for payment_transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `payment_transaction_log`;
CREATE TABLE `payment_transaction_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `SYNCH_LOG` text COMMENT '同步回调日志',
  `ASYNC_LOG` text COMMENT '异步回调日志',
  `CHANNEL_ID` int(11) DEFAULT NULL COMMENT '支付渠道ID',
  `TRANSACTION_ID` bigint(20) DEFAULT NULL COMMENT '支付交易ID',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='支付交易日志表 ';

-- ----------------------------
-- Records of payment_transaction_log
-- ----------------------------
BEGIN;
INSERT INTO `payment_transaction_log` VALUES (59, NULL, '{bizType=000201, orderId=422635326348070912, signature=HgSEc9ZOlfKlRxg24y+bamTlUefIM4z/pKwpmZ5qHLdO8M58Ec3avpVh9bjNwrQABnkQtHaxv4EOHzVTS0GR/w1xaqFyaRqQRJOXTv5HU1KPA/FTpAOf91GIl0i95+ozhbnhhGwCoyMJxhNOGXZrmXVYApFqw7JVUrlC3yjrvajTEoBI2+l+HoF6qfbIKpIGT/bL9BGHKch3q8FSlgsUpcQoXd7q/M/pJhnrkD9oKIHXXawJ4hd/S/GKypn21AT1Vdb+q+YQJqzhQpnMMGzSIyv6+Bp5ICS1vZ6f3XEquztYitjj3wkLkCis+UlEBHokevJywhuqXLUFf0iMNIVn8Q==, traceNo=729024, settleAmt=999, settleCurrencyCode=156, settleDate=0519, txnType=01, queryId=222005190808447290248, accessType=0, result=200, paymentId=422635326348070912, traceTime=0519080844, txnTime=20200519080844, signPubKeyCert=-----BEGIN CERTIFICATE-----\r\nMIIEQzCCAyugAwIBAgIFEBJJZVgwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMC\r\nQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhv\r\ncml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMTAxMDcyNDA4WhcN\r\nMjAxMTAxMDcyNDA4WjB3MQswCQYDVQQGEwJjbjESMBAGA1UEChMJQ0ZDQSBPQ0Ex\r\nMQ4wDAYDVQQLEwVDVVBSQTEUMBIGA1UECxMLRW50ZXJwcmlzZXMxLjAsBgNVBAMU\r\nJTA0MUBaMjAxNy0xMS0xQDAwMDQwMDAwOlNJR05AMDAwMDAwMDEwggEiMA0GCSqG\r\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDIWO6AESrg+34HgbU9mSpgef0sl6avr1d\r\nbD/IjjZYM63SoQi3CZHZUyoyzBKodRzowJrwXmd+hCmdcIfavdvfwi6x+ptJNp9d\r\nEtpfEAnJk+4quriQFj1dNiv6uP8ARgn07UMhgdYB7D8aA1j77Yk1ROx7+LFeo7rZ\r\nDdde2U1opPxjIqOPqiPno78JMXpFn7LiGPXu75bwY2rYIGEEImnypgiYuW1vo9UO\r\nG47NMWTnsIdy68FquPSw5FKp5foL825GNX3oJSZui8d2UDkMLBasf06Jz0JKz5AV\r\nblaI+s24/iCfo8r+6WaCs8e6BDkaijJkR/bvRCQeQpbX3V8WoTLVAgMBAAGjgfQw\r\ngfEwHwYDVR0jBBgwFoAUz3CdYeudfC6498sCQPcJnf4zdIAwSAYDVR0gBEEwPzA9\r\nBghggRyG7yoBATAxMC8GCCsGAQUFBwIBFiNodHRwOi8vd3d3LmNmY2EuY29tLmNu\r\nL3VzL3VzLTE0Lmh0bTA5BgNVHR8EMjAwMC6gLKAqhihodHRwOi8vdWNybC5jZmNh\r\nLmNvbS5jbi9SU0EvY3JsMjQ4NzIuY3JsMAsGA1UdDwQEAwID6DAdBgNVHQ4EFgQU\r\nmQQLyuqYjES7qKO+zOkzEbvdFwgwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUF\r\nBwMEMA0GCSqGSIb3DQEBBQUAA4IBAQAujhBuOcuxA+VzoUH84uoFt5aaBM3vGlpW\r\nKVMz6BUsLbIpp1ho5h+LaMnxMs6jdXXDh/du8X5SKMaIddiLw7ujZy1LibKy2jYi\r\nYYfs3tbZ0ffCKQtv78vCgC+IxUUurALY4w58fRLLdu8u8p9jyRFHsQEwSq+W5+bP\r\nMTh2w7cDd9h+6KoCN6AMI1Ly7MxRIhCbNBL9bzaxF9B5GK86ARY7ixkuDCEl4XCF\r\nJGxeoye9R46NqZ6AA/k97mJun//gmUjStmb9PUXA59fR5suAB5o/5lBySZ8UXkrI\r\npp/iLT8vIl1hNgLh0Ghs7DBSx99I+S3VuUzjHNxL6fGRhlix7Rb8\r\n-----END CERTIFICATE-----, payCardType=01, txnSubType=01, accNo=eMTQqNSylmMEEJ7p3Y4xUvCsg8B2eT9QPI873aQ4JDL+TQSsQ/XmB0SbXdRDYj4DB1CkQcsG6ccptZQlh4DaS1udpOWea6IRcSefh1H8pgO7UBkaOy3ZDuiAzhJJKccdJ6D44o/zezop321r1GBcl02iDXgUrSuVBKIIVLu8+L+tjldBOw2K9ODiYWexGAXRIs3O0SiPgwvTDqecOr7jrHKpcbE0Y1a/Q2MmwjEcvMTBInKlCkWBLtUFkIdElddlSaYia6QU7nU0Cb4W78E1AnFrk+PwJLDlt6IaaDYoCGiXrQ2c1WFEF+y265q7Lo7ky3UN9+Ti9IuYvMMZ3qfR5g==, encoding=UTF-8, version=5.1.0, respMsg=成功[0000000], merId=777290058110097, currencyCode=156, respCode=00, signMethod=01, txnAmt=999}', NULL, 422635326348070912, NULL, NULL, '2020-05-19 08:12:32', NULL, '2020-05-19 08:12:32');
INSERT INTO `payment_transaction_log` VALUES (60, NULL, '{bizType=000201, orderId=422635326348070912, signature=HgSEc9ZOlfKlRxg24y+bamTlUefIM4z/pKwpmZ5qHLdO8M58Ec3avpVh9bjNwrQABnkQtHaxv4EOHzVTS0GR/w1xaqFyaRqQRJOXTv5HU1KPA/FTpAOf91GIl0i95+ozhbnhhGwCoyMJxhNOGXZrmXVYApFqw7JVUrlC3yjrvajTEoBI2+l+HoF6qfbIKpIGT/bL9BGHKch3q8FSlgsUpcQoXd7q/M/pJhnrkD9oKIHXXawJ4hd/S/GKypn21AT1Vdb+q+YQJqzhQpnMMGzSIyv6+Bp5ICS1vZ6f3XEquztYitjj3wkLkCis+UlEBHokevJywhuqXLUFf0iMNIVn8Q==, traceNo=729024, settleAmt=999, settleCurrencyCode=156, settleDate=0519, txnType=01, queryId=222005190808447290248, accessType=0, result=200, paymentId=422635326348070912, traceTime=0519080844, txnTime=20200519080844, signPubKeyCert=-----BEGIN CERTIFICATE-----\r\nMIIEQzCCAyugAwIBAgIFEBJJZVgwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMC\r\nQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhv\r\ncml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMTAxMDcyNDA4WhcN\r\nMjAxMTAxMDcyNDA4WjB3MQswCQYDVQQGEwJjbjESMBAGA1UEChMJQ0ZDQSBPQ0Ex\r\nMQ4wDAYDVQQLEwVDVVBSQTEUMBIGA1UECxMLRW50ZXJwcmlzZXMxLjAsBgNVBAMU\r\nJTA0MUBaMjAxNy0xMS0xQDAwMDQwMDAwOlNJR05AMDAwMDAwMDEwggEiMA0GCSqG\r\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDIWO6AESrg+34HgbU9mSpgef0sl6avr1d\r\nbD/IjjZYM63SoQi3CZHZUyoyzBKodRzowJrwXmd+hCmdcIfavdvfwi6x+ptJNp9d\r\nEtpfEAnJk+4quriQFj1dNiv6uP8ARgn07UMhgdYB7D8aA1j77Yk1ROx7+LFeo7rZ\r\nDdde2U1opPxjIqOPqiPno78JMXpFn7LiGPXu75bwY2rYIGEEImnypgiYuW1vo9UO\r\nG47NMWTnsIdy68FquPSw5FKp5foL825GNX3oJSZui8d2UDkMLBasf06Jz0JKz5AV\r\nblaI+s24/iCfo8r+6WaCs8e6BDkaijJkR/bvRCQeQpbX3V8WoTLVAgMBAAGjgfQw\r\ngfEwHwYDVR0jBBgwFoAUz3CdYeudfC6498sCQPcJnf4zdIAwSAYDVR0gBEEwPzA9\r\nBghggRyG7yoBATAxMC8GCCsGAQUFBwIBFiNodHRwOi8vd3d3LmNmY2EuY29tLmNu\r\nL3VzL3VzLTE0Lmh0bTA5BgNVHR8EMjAwMC6gLKAqhihodHRwOi8vdWNybC5jZmNh\r\nLmNvbS5jbi9SU0EvY3JsMjQ4NzIuY3JsMAsGA1UdDwQEAwID6DAdBgNVHQ4EFgQU\r\nmQQLyuqYjES7qKO+zOkzEbvdFwgwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUF\r\nBwMEMA0GCSqGSIb3DQEBBQUAA4IBAQAujhBuOcuxA+VzoUH84uoFt5aaBM3vGlpW\r\nKVMz6BUsLbIpp1ho5h+LaMnxMs6jdXXDh/du8X5SKMaIddiLw7ujZy1LibKy2jYi\r\nYYfs3tbZ0ffCKQtv78vCgC+IxUUurALY4w58fRLLdu8u8p9jyRFHsQEwSq+W5+bP\r\nMTh2w7cDd9h+6KoCN6AMI1Ly7MxRIhCbNBL9bzaxF9B5GK86ARY7ixkuDCEl4XCF\r\nJGxeoye9R46NqZ6AA/k97mJun//gmUjStmb9PUXA59fR5suAB5o/5lBySZ8UXkrI\r\npp/iLT8vIl1hNgLh0Ghs7DBSx99I+S3VuUzjHNxL6fGRhlix7Rb8\r\n-----END CERTIFICATE-----, payCardType=01, txnSubType=01, accNo=eMTQqNSylmMEEJ7p3Y4xUvCsg8B2eT9QPI873aQ4JDL+TQSsQ/XmB0SbXdRDYj4DB1CkQcsG6ccptZQlh4DaS1udpOWea6IRcSefh1H8pgO7UBkaOy3ZDuiAzhJJKccdJ6D44o/zezop321r1GBcl02iDXgUrSuVBKIIVLu8+L+tjldBOw2K9ODiYWexGAXRIs3O0SiPgwvTDqecOr7jrHKpcbE0Y1a/Q2MmwjEcvMTBInKlCkWBLtUFkIdElddlSaYia6QU7nU0Cb4W78E1AnFrk+PwJLDlt6IaaDYoCGiXrQ2c1WFEF+y265q7Lo7ky3UN9+Ti9IuYvMMZ3qfR5g==, encoding=UTF-8, version=5.1.0, respMsg=成功[0000000], merId=777290058110097, currencyCode=156, respCode=00, signMethod=01, txnAmt=999}', NULL, 422635326348070912, NULL, NULL, '2020-05-19 08:13:43', NULL, '2020-05-19 08:13:43');
INSERT INTO `payment_transaction_log` VALUES (61, NULL, '{bizType=000201, orderId=422635326348070912, signature=HgSEc9ZOlfKlRxg24y+bamTlUefIM4z/pKwpmZ5qHLdO8M58Ec3avpVh9bjNwrQABnkQtHaxv4EOHzVTS0GR/w1xaqFyaRqQRJOXTv5HU1KPA/FTpAOf91GIl0i95+ozhbnhhGwCoyMJxhNOGXZrmXVYApFqw7JVUrlC3yjrvajTEoBI2+l+HoF6qfbIKpIGT/bL9BGHKch3q8FSlgsUpcQoXd7q/M/pJhnrkD9oKIHXXawJ4hd/S/GKypn21AT1Vdb+q+YQJqzhQpnMMGzSIyv6+Bp5ICS1vZ6f3XEquztYitjj3wkLkCis+UlEBHokevJywhuqXLUFf0iMNIVn8Q==, traceNo=729024, settleAmt=999, settleCurrencyCode=156, settleDate=0519, txnType=01, queryId=222005190808447290248, accessType=0, result=200, paymentId=422635326348070912, traceTime=0519080844, txnTime=20200519080844, signPubKeyCert=-----BEGIN CERTIFICATE-----\r\nMIIEQzCCAyugAwIBAgIFEBJJZVgwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMC\r\nQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhv\r\ncml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMTAxMDcyNDA4WhcN\r\nMjAxMTAxMDcyNDA4WjB3MQswCQYDVQQGEwJjbjESMBAGA1UEChMJQ0ZDQSBPQ0Ex\r\nMQ4wDAYDVQQLEwVDVVBSQTEUMBIGA1UECxMLRW50ZXJwcmlzZXMxLjAsBgNVBAMU\r\nJTA0MUBaMjAxNy0xMS0xQDAwMDQwMDAwOlNJR05AMDAwMDAwMDEwggEiMA0GCSqG\r\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDIWO6AESrg+34HgbU9mSpgef0sl6avr1d\r\nbD/IjjZYM63SoQi3CZHZUyoyzBKodRzowJrwXmd+hCmdcIfavdvfwi6x+ptJNp9d\r\nEtpfEAnJk+4quriQFj1dNiv6uP8ARgn07UMhgdYB7D8aA1j77Yk1ROx7+LFeo7rZ\r\nDdde2U1opPxjIqOPqiPno78JMXpFn7LiGPXu75bwY2rYIGEEImnypgiYuW1vo9UO\r\nG47NMWTnsIdy68FquPSw5FKp5foL825GNX3oJSZui8d2UDkMLBasf06Jz0JKz5AV\r\nblaI+s24/iCfo8r+6WaCs8e6BDkaijJkR/bvRCQeQpbX3V8WoTLVAgMBAAGjgfQw\r\ngfEwHwYDVR0jBBgwFoAUz3CdYeudfC6498sCQPcJnf4zdIAwSAYDVR0gBEEwPzA9\r\nBghggRyG7yoBATAxMC8GCCsGAQUFBwIBFiNodHRwOi8vd3d3LmNmY2EuY29tLmNu\r\nL3VzL3VzLTE0Lmh0bTA5BgNVHR8EMjAwMC6gLKAqhihodHRwOi8vdWNybC5jZmNh\r\nLmNvbS5jbi9SU0EvY3JsMjQ4NzIuY3JsMAsGA1UdDwQEAwID6DAdBgNVHQ4EFgQU\r\nmQQLyuqYjES7qKO+zOkzEbvdFwgwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUF\r\nBwMEMA0GCSqGSIb3DQEBBQUAA4IBAQAujhBuOcuxA+VzoUH84uoFt5aaBM3vGlpW\r\nKVMz6BUsLbIpp1ho5h+LaMnxMs6jdXXDh/du8X5SKMaIddiLw7ujZy1LibKy2jYi\r\nYYfs3tbZ0ffCKQtv78vCgC+IxUUurALY4w58fRLLdu8u8p9jyRFHsQEwSq+W5+bP\r\nMTh2w7cDd9h+6KoCN6AMI1Ly7MxRIhCbNBL9bzaxF9B5GK86ARY7ixkuDCEl4XCF\r\nJGxeoye9R46NqZ6AA/k97mJun//gmUjStmb9PUXA59fR5suAB5o/5lBySZ8UXkrI\r\npp/iLT8vIl1hNgLh0Ghs7DBSx99I+S3VuUzjHNxL6fGRhlix7Rb8\r\n-----END CERTIFICATE-----, payCardType=01, txnSubType=01, accNo=eMTQqNSylmMEEJ7p3Y4xUvCsg8B2eT9QPI873aQ4JDL+TQSsQ/XmB0SbXdRDYj4DB1CkQcsG6ccptZQlh4DaS1udpOWea6IRcSefh1H8pgO7UBkaOy3ZDuiAzhJJKccdJ6D44o/zezop321r1GBcl02iDXgUrSuVBKIIVLu8+L+tjldBOw2K9ODiYWexGAXRIs3O0SiPgwvTDqecOr7jrHKpcbE0Y1a/Q2MmwjEcvMTBInKlCkWBLtUFkIdElddlSaYia6QU7nU0Cb4W78E1AnFrk+PwJLDlt6IaaDYoCGiXrQ2c1WFEF+y265q7Lo7ky3UN9+Ti9IuYvMMZ3qfR5g==, encoding=UTF-8, version=5.1.0, respMsg=成功[0000000], merId=777290058110097, currencyCode=156, respCode=00, signMethod=01, txnAmt=999}', NULL, 422635326348070912, NULL, NULL, '2020-05-19 08:15:54', NULL, '2020-05-19 08:15:54');
INSERT INTO `payment_transaction_log` VALUES (62, NULL, '{bizType=000201, orderId=422635326348070912, signature=HgSEc9ZOlfKlRxg24y+bamTlUefIM4z/pKwpmZ5qHLdO8M58Ec3avpVh9bjNwrQABnkQtHaxv4EOHzVTS0GR/w1xaqFyaRqQRJOXTv5HU1KPA/FTpAOf91GIl0i95+ozhbnhhGwCoyMJxhNOGXZrmXVYApFqw7JVUrlC3yjrvajTEoBI2+l+HoF6qfbIKpIGT/bL9BGHKch3q8FSlgsUpcQoXd7q/M/pJhnrkD9oKIHXXawJ4hd/S/GKypn21AT1Vdb+q+YQJqzhQpnMMGzSIyv6+Bp5ICS1vZ6f3XEquztYitjj3wkLkCis+UlEBHokevJywhuqXLUFf0iMNIVn8Q==, traceNo=729024, settleAmt=999, settleCurrencyCode=156, settleDate=0519, txnType=01, queryId=222005190808447290248, accessType=0, result=200, paymentId=422635326348070912, traceTime=0519080844, txnTime=20200519080844, signPubKeyCert=-----BEGIN CERTIFICATE-----\r\nMIIEQzCCAyugAwIBAgIFEBJJZVgwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMC\r\nQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhv\r\ncml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMTAxMDcyNDA4WhcN\r\nMjAxMTAxMDcyNDA4WjB3MQswCQYDVQQGEwJjbjESMBAGA1UEChMJQ0ZDQSBPQ0Ex\r\nMQ4wDAYDVQQLEwVDVVBSQTEUMBIGA1UECxMLRW50ZXJwcmlzZXMxLjAsBgNVBAMU\r\nJTA0MUBaMjAxNy0xMS0xQDAwMDQwMDAwOlNJR05AMDAwMDAwMDEwggEiMA0GCSqG\r\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDIWO6AESrg+34HgbU9mSpgef0sl6avr1d\r\nbD/IjjZYM63SoQi3CZHZUyoyzBKodRzowJrwXmd+hCmdcIfavdvfwi6x+ptJNp9d\r\nEtpfEAnJk+4quriQFj1dNiv6uP8ARgn07UMhgdYB7D8aA1j77Yk1ROx7+LFeo7rZ\r\nDdde2U1opPxjIqOPqiPno78JMXpFn7LiGPXu75bwY2rYIGEEImnypgiYuW1vo9UO\r\nG47NMWTnsIdy68FquPSw5FKp5foL825GNX3oJSZui8d2UDkMLBasf06Jz0JKz5AV\r\nblaI+s24/iCfo8r+6WaCs8e6BDkaijJkR/bvRCQeQpbX3V8WoTLVAgMBAAGjgfQw\r\ngfEwHwYDVR0jBBgwFoAUz3CdYeudfC6498sCQPcJnf4zdIAwSAYDVR0gBEEwPzA9\r\nBghggRyG7yoBATAxMC8GCCsGAQUFBwIBFiNodHRwOi8vd3d3LmNmY2EuY29tLmNu\r\nL3VzL3VzLTE0Lmh0bTA5BgNVHR8EMjAwMC6gLKAqhihodHRwOi8vdWNybC5jZmNh\r\nLmNvbS5jbi9SU0EvY3JsMjQ4NzIuY3JsMAsGA1UdDwQEAwID6DAdBgNVHQ4EFgQU\r\nmQQLyuqYjES7qKO+zOkzEbvdFwgwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUF\r\nBwMEMA0GCSqGSIb3DQEBBQUAA4IBAQAujhBuOcuxA+VzoUH84uoFt5aaBM3vGlpW\r\nKVMz6BUsLbIpp1ho5h+LaMnxMs6jdXXDh/du8X5SKMaIddiLw7ujZy1LibKy2jYi\r\nYYfs3tbZ0ffCKQtv78vCgC+IxUUurALY4w58fRLLdu8u8p9jyRFHsQEwSq+W5+bP\r\nMTh2w7cDd9h+6KoCN6AMI1Ly7MxRIhCbNBL9bzaxF9B5GK86ARY7ixkuDCEl4XCF\r\nJGxeoye9R46NqZ6AA/k97mJun//gmUjStmb9PUXA59fR5suAB5o/5lBySZ8UXkrI\r\npp/iLT8vIl1hNgLh0Ghs7DBSx99I+S3VuUzjHNxL6fGRhlix7Rb8\r\n-----END CERTIFICATE-----, payCardType=01, txnSubType=01, accNo=eMTQqNSylmMEEJ7p3Y4xUvCsg8B2eT9QPI873aQ4JDL+TQSsQ/XmB0SbXdRDYj4DB1CkQcsG6ccptZQlh4DaS1udpOWea6IRcSefh1H8pgO7UBkaOy3ZDuiAzhJJKccdJ6D44o/zezop321r1GBcl02iDXgUrSuVBKIIVLu8+L+tjldBOw2K9ODiYWexGAXRIs3O0SiPgwvTDqecOr7jrHKpcbE0Y1a/Q2MmwjEcvMTBInKlCkWBLtUFkIdElddlSaYia6QU7nU0Cb4W78E1AnFrk+PwJLDlt6IaaDYoCGiXrQ2c1WFEF+y265q7Lo7ky3UN9+Ti9IuYvMMZ3qfR5g==, encoding=UTF-8, version=5.1.0, respMsg=成功[0000000], merId=777290058110097, currencyCode=156, respCode=00, signMethod=01, txnAmt=999}', NULL, 422635326348070912, NULL, NULL, '2020-05-19 08:20:05', NULL, '2020-05-19 08:20:05');
INSERT INTO `payment_transaction_log` VALUES (63, NULL, '{bizType=000201, orderId=422635326348070912, signature=HgSEc9ZOlfKlRxg24y+bamTlUefIM4z/pKwpmZ5qHLdO8M58Ec3avpVh9bjNwrQABnkQtHaxv4EOHzVTS0GR/w1xaqFyaRqQRJOXTv5HU1KPA/FTpAOf91GIl0i95+ozhbnhhGwCoyMJxhNOGXZrmXVYApFqw7JVUrlC3yjrvajTEoBI2+l+HoF6qfbIKpIGT/bL9BGHKch3q8FSlgsUpcQoXd7q/M/pJhnrkD9oKIHXXawJ4hd/S/GKypn21AT1Vdb+q+YQJqzhQpnMMGzSIyv6+Bp5ICS1vZ6f3XEquztYitjj3wkLkCis+UlEBHokevJywhuqXLUFf0iMNIVn8Q==, traceNo=729024, settleAmt=999, settleCurrencyCode=156, settleDate=0519, txnType=01, queryId=222005190808447290248, accessType=0, result=200, paymentId=422635326348070912, traceTime=0519080844, txnTime=20200519080844, signPubKeyCert=-----BEGIN CERTIFICATE-----\r\nMIIEQzCCAyugAwIBAgIFEBJJZVgwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMC\r\nQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhv\r\ncml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMTAxMDcyNDA4WhcN\r\nMjAxMTAxMDcyNDA4WjB3MQswCQYDVQQGEwJjbjESMBAGA1UEChMJQ0ZDQSBPQ0Ex\r\nMQ4wDAYDVQQLEwVDVVBSQTEUMBIGA1UECxMLRW50ZXJwcmlzZXMxLjAsBgNVBAMU\r\nJTA0MUBaMjAxNy0xMS0xQDAwMDQwMDAwOlNJR05AMDAwMDAwMDEwggEiMA0GCSqG\r\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDIWO6AESrg+34HgbU9mSpgef0sl6avr1d\r\nbD/IjjZYM63SoQi3CZHZUyoyzBKodRzowJrwXmd+hCmdcIfavdvfwi6x+ptJNp9d\r\nEtpfEAnJk+4quriQFj1dNiv6uP8ARgn07UMhgdYB7D8aA1j77Yk1ROx7+LFeo7rZ\r\nDdde2U1opPxjIqOPqiPno78JMXpFn7LiGPXu75bwY2rYIGEEImnypgiYuW1vo9UO\r\nG47NMWTnsIdy68FquPSw5FKp5foL825GNX3oJSZui8d2UDkMLBasf06Jz0JKz5AV\r\nblaI+s24/iCfo8r+6WaCs8e6BDkaijJkR/bvRCQeQpbX3V8WoTLVAgMBAAGjgfQw\r\ngfEwHwYDVR0jBBgwFoAUz3CdYeudfC6498sCQPcJnf4zdIAwSAYDVR0gBEEwPzA9\r\nBghggRyG7yoBATAxMC8GCCsGAQUFBwIBFiNodHRwOi8vd3d3LmNmY2EuY29tLmNu\r\nL3VzL3VzLTE0Lmh0bTA5BgNVHR8EMjAwMC6gLKAqhihodHRwOi8vdWNybC5jZmNh\r\nLmNvbS5jbi9SU0EvY3JsMjQ4NzIuY3JsMAsGA1UdDwQEAwID6DAdBgNVHQ4EFgQU\r\nmQQLyuqYjES7qKO+zOkzEbvdFwgwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUF\r\nBwMEMA0GCSqGSIb3DQEBBQUAA4IBAQAujhBuOcuxA+VzoUH84uoFt5aaBM3vGlpW\r\nKVMz6BUsLbIpp1ho5h+LaMnxMs6jdXXDh/du8X5SKMaIddiLw7ujZy1LibKy2jYi\r\nYYfs3tbZ0ffCKQtv78vCgC+IxUUurALY4w58fRLLdu8u8p9jyRFHsQEwSq+W5+bP\r\nMTh2w7cDd9h+6KoCN6AMI1Ly7MxRIhCbNBL9bzaxF9B5GK86ARY7ixkuDCEl4XCF\r\nJGxeoye9R46NqZ6AA/k97mJun//gmUjStmb9PUXA59fR5suAB5o/5lBySZ8UXkrI\r\npp/iLT8vIl1hNgLh0Ghs7DBSx99I+S3VuUzjHNxL6fGRhlix7Rb8\r\n-----END CERTIFICATE-----, payCardType=01, txnSubType=01, accNo=eMTQqNSylmMEEJ7p3Y4xUvCsg8B2eT9QPI873aQ4JDL+TQSsQ/XmB0SbXdRDYj4DB1CkQcsG6ccptZQlh4DaS1udpOWea6IRcSefh1H8pgO7UBkaOy3ZDuiAzhJJKccdJ6D44o/zezop321r1GBcl02iDXgUrSuVBKIIVLu8+L+tjldBOw2K9ODiYWexGAXRIs3O0SiPgwvTDqecOr7jrHKpcbE0Y1a/Q2MmwjEcvMTBInKlCkWBLtUFkIdElddlSaYia6QU7nU0Cb4W78E1AnFrk+PwJLDlt6IaaDYoCGiXrQ2c1WFEF+y265q7Lo7ky3UN9+Ti9IuYvMMZ3qfR5g==, encoding=UTF-8, version=5.1.0, respMsg=成功[0000000], merId=777290058110097, currencyCode=156, respCode=00, signMethod=01, txnAmt=999}', NULL, 422635326348070912, NULL, NULL, '2020-05-19 08:25:16', NULL, '2020-05-19 08:25:16');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
