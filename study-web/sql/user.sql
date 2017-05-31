/*
 Navicat Premium Data Transfer

 Source Server         : mystudy
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : study

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 04/07/2017 13:51:39 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别 1 男, 2 女',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户姓名',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `sex` SMALLINT(2) DEFAULT NULL COMMENT '性别 1 男, 2 女',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `user_ext`
-- ----------------------------
DROP TABLE IF EXISTS `user_ext`;
CREATE TABLE `user_ext` (
  `ext_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL COMMENT '用户id',
  `coordinate` VARCHAR(50) DEFAULT NULL COMMENT '坐标',
  `company` VARCHAR(200) DEFAULT NULL COMMENT '用户单位',
  PRIMARY KEY (`ext_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `skill_shop`;
CREATE TABLE `skill_shop` (
  `shop_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `shop_name` VARCHAR(120) NOT NULL  COMMENT '商品名称',
  `shop_price` DOUBLE NOT NULL COMMENT '商品价格',
  `shop_number` INT NOT NULL COMMENT '商品库存',

  PRIMARY KEY (`shop_id`)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8;
