/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : localhost
 Source Database       : db_bee

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 04/16/2015 13:58:29 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `TB_AREA`
-- ----------------------------
DROP TABLE IF EXISTS `TB_AREA`;
CREATE TABLE `TB_AREA` (
  `AID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  `PARENTID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`AID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地区表';

-- ----------------------------
--  Table structure for `TB_IMAGE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_IMAGE`;
CREATE TABLE `TB_IMAGE` (
  `IID` bigint(20) NOT NULL AUTO_INCREMENT,
  `URL` varchar(255) NOT NULL DEFAULT '',
  `PATH` varchar(255) NOT NULL DEFAULT '',
  `TYPE` int(11) NOT NULL DEFAULT 0,
  `REMARK` varchar(255) NOT NULL DEFAULT '',
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `SORT` int(11) NOT NULL DEFAULT 100,
  `WIDTH` int(11) NOT NULL DEFAULT 0,
  `HEIGHT` int(11) NOT NULL DEFAULT 0,
  `SHOP_USER` bigint(20) NOT NULL DEFAULT 0,
  `FIND` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`IID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='图片表';


-- ----------------------------
--  Table structure for `TB_APPLYER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_APPLYER`;
CREATE TABLE `TB_APPLYER` (
  `AID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LINKNAME` varchar(50) NOT NULL DEFAULT '',
  `PHONE` varchar(20) NOT NULL DEFAULT '',
  `EXTRAINFO` varchar(255) NOT NULL DEFAULT '',
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`AID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家申请表';

-- ----------------------------
--  Table structure for `TB_USER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER`;
CREATE TABLE `TB_USER` (
  `UID` bigint(20) NOT NULL AUTO_INCREMENT,
  `URL` varchar(255) NOT NULL DEFAULT '',
  `PATH` varchar(255) NOT NULL DEFAULT '',
  `DEVICE` varchar(50) NOT NULL DEFAULT '',
  `TYPE` int(11) NOT NULL DEFAULT 1,
  `NAME` varchar(20) NOT NULL DEFAULT '',
  `PHONE` varchar(25) NOT NULL DEFAULT '',
  `PASSWORD` varchar(100) NOT NULL DEFAULT '',
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `ALIPAY` varchar(100) NOT NULL DEFAULT '',
  `LEVEL` int(11) NOT NULL DEFAULT 0,
  `EXP` int(11) NOT NULL DEFAULT 0,
  `INTEGRAL` int(11) NOT NULL DEFAULT 0,
  `CASH` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
--  Table structure for `TB_USER_AUTH`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_AUTH`;
CREATE TABLE `TB_USER_AUTH` (
  `UAID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AUTHNAME` VARCHAR(255) NOT NULL DEFAULT '',
  `USER` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`UAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户权限表';

-- ----------------------------
--  Table structure for `TB_USER_FRIEND`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_FRIEND`;
CREATE TABLE `TB_USER_FRIEND` (
  `UFID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER` bigint(20) DEFAULT NULL,
  `FRIEND` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`UFID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='好友表';

-- ----------------------------
--  Table structure for `TB_ADVICE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ADVICE`;
CREATE TABLE `TB_ADVICE` (
  `AID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `MSG` varchar(255) NOT NULL DEFAULT '',
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `PHONE` varchar(20) NOT NULL DEFAULT '',
  `DEVICE` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`AID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='意见表';

-- ----------------------------
--  Table structure for `TB_SHOP`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP`;
CREATE TABLE `TB_SHOP` (
  `SID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IDENTITY` varchar(20) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `AREA` bigint(20) DEFAULT NULL,
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `LINKNAME` varchar(20) DEFAULT NULL,
  `PHONE` varchar(11) DEFAULT NULL,
  `ADDR` varchar(255) DEFAULT NULL,
  `LON` bigint(20) DEFAULT NULL,
  `LAT` bigint(20) DEFAULT NULL,
  `CREATETIME` bigint(20) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  `SORTTIME` bigint(20) DEFAULT NULL,
  `REMARK` text DEFAULT NULL,
  `RECOMMEND` int(11) DEFAULT NULL,
  `ISBACK` int(11) NOT NULL DEFAULT 0,
  `UPDATETIME` BIGINT(20) NOT NULL DEFAULT 0,
  `SERVICETIME` VARCHAR(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户表';

-- ----------------------------
--  Table structure for `TB_SHOP_USER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_USER`;
CREATE TABLE `TB_SHOP_USER` (
  `SUID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `NAME` VARCHAR(50) NOT NULL DEFAULT '',
  `PHONE` VARCHAR(11) NOT NULL DEFAULT '',
  `INTRODUCE` text NOT NULL DEFAULT '',
  `CREATETIME` BIGINT(20) NOT NULL DEFAULT 0,
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`SUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户管理员表';

-- ----------------------------
--  Table structure for `TB_SHOP_PRICE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_PRICE`;
CREATE TABLE `TB_SHOP_PRICE` (
  `SPID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRICE` double NOT NULL DEFAULT 0,
  `DISCOUNT` varchar(255) NOT NULL DEFAULT '',
  `MARK` varchar(255) NOT NULL DEFAULT '',
  `SORT` int(11) NOT NULL DEFAULT 100,
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  `TITLE` VARCHAR(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`SPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户价格表';

-- ----------------------------
--  Table structure for `TB_SHOP_IMAGE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_IMAGE`;
CREATE TABLE `TB_SHOP_IMAGE` (
  `SIID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PATH` varchar(255) NOT NULL DEFAULT '',
  `URL` varchar(255) NOT NULL DEFAULT '',
  `REMARK` varchar(255) NOT NULL DEFAULT '',
  `TYPE` int(11) NOT NULL DEFAULT 0,
  `SORT` int(11) NOT NULL DEFAULT 100,
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  `WIDTH` int(11) NOT NULL DEFAULT 0,
  `HEIGHT` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`SIID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户图片表';

-- ----------------------------
--  Table structure for `TB_SHOP_COMMENT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_COMMENT`;
CREATE TABLE `TB_SHOP_COMMENT` (
  `SCID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONTENT` text NOT NULL DEFAULT '',
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `ORDER` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`SCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户评论表';

-- ----------------------------
--  Table structure for `TB_SHOP_REPLY`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_REPLY`;
CREATE TABLE `TB_SHOP_REPLY` (
  `SRID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(255) NOT NULL,
  `USER` bigint(20) NOT NULL,
  `SHOPCOMMENT` bigint(20) NOT NULL,
  `CREATETIME` bigint(20) NOT NULL,
  PRIMARY KEY (`SRID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户回复表';

-- ----------------------------
--  Table structure for `TB_SHOP_FOCUS`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_FOCUS`;
CREATE TABLE `TB_SHOP_FOCUS` (
  `SFID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `CREATETIME` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`SFID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户关注表';

-- ----------------------------
--  Table structure for `TB_SHOP_PRICE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_ERROR`;
CREATE TABLE `TB_SHOP_ERROR` (
  `SEID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ERRORMSG` varchar(255) NOT NULL DEFAULT '',
  `TYPE` int(11) NOT NULL DEFAULT 0,
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `STATUS` int(11) NOT NULL DEFAULT 0,
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  `PHONE` varchar(20) NOT NULL DEFAULT '',
  `USER` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`SEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户纠错表';

-- ----------------------------
--  Table structure for `TB_SHOP_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_GROUP`;
CREATE TABLE `TB_SHOP_GROUP` (
  `SGID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUPNAME` varchar(255) NOT NULL DEFAULT '',
  `SHOP` BIGINT(20) NOT NULL DEFAULT 0,
  `PRICE` DOUBLE NOT NULL DEFAULT 0,
  `REMARK` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`SGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户技师组表';

-- ----------------------------
--  Table structure for `TB_SHOP_TECHEE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_TECHEE`;
CREATE TABLE `TB_SHOP_TECHEE` (
  `STID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `NUMBER` VARCHAR(30) NOT NULL DEFAULT '',
  `SHOPGROUP` BIGINT(20) NOT NULL DEFAULT 0,
  `SHOP` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`STID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户技师表';

-- ----------------------------
--  Table structure for `TB_SHOP_ATTEND`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SHOP_ATTEND`;
CREATE TABLE `TB_SHOP_ATTEND` (
  `SAID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `SHOPTECHEE` BIGINT(20) NOT NULL DEFAULT 0,
  `ATTENDTIME` BIGINT(20) NOT NULL DEFAULT 0,
  `SHOP` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`SAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商户技师出勤表';

-- ----------------------------
--  Table structure for `TB_ORDER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ORDER`;
CREATE TABLE `TB_ORDER` (
  `OID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NO` varchar(20) NOT NULL DEFAULT '',
  `TYPE` int(11) NOT NULL DEFAULT 0,
  `STATUS` int(11) NOT NULL DEFAULT 0,
  `NUM` int(11) NOT NULL DEFAULT 1,
  `EXECTIME` bigint(20) NOT NULL DEFAULT 0,
  `REMARK` varchar(255) NOT NULL DEFAULT '',
  `ORDERNAME` varchar(50) NOT NULL DEFAULT '',
  `ORDERPHONE` varchar(11) NOT NULL DEFAULT '',
  `DEVICE` varchar(100) NOT NULL DEFAULT '',
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `SHOPUSER` bigint(20) NOT NULL DEFAULT 0,
  `ISCOMMENT` int(11) NOT NULL DEFAULT 0,
  `FINISHTIME` BIGINT(20) NOT NULL DEFAULT 0,
  `OPERATE` TEXT NOT NULL DEFAULT '',
  PRIMARY KEY(`OID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表';

-- ----------------------------
--  Table structure for `TB_AD`
-- ----------------------------
DROP TABLE IF EXISTS `TB_AD`;
CREATE TABLE `TB_AD` (
  `ADID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PATH` varchar(255) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `TYPE` int(11) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  `SHOP` bigint(20) DEFAULT NULL,
  `AREA` bigint(20) DEFAULT NULL,
  `CREATETIME` bigint(20) DEFAULT NULL,
  `STARTTIME` bigint(20) NOT NULL DEFAULT 0,
  `STOPTIME` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ADID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='广告表';

-- ----------------------------
--  Table structure for `TB_APP_VER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_APP_VER`;
CREATE TABLE `TB_APP_VER` (
  `AVID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` int(11) NOT NULL DEFAULT 0,
  `VER` int(11) NOT NULL DEFAULT 0,
  `VERSTR` varchar(50) NOT NULL DEFAULT '',
  `PATH` varchar(255) NOT NULL DEFAULT '',
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `REMARK` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`AVID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='APP发布表';

-- ----------------------------
--  Table structure for `TB_USER_LOGIN_STAT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_LOGIN_STAT`;
CREATE TABLE `TB_USER_LOGIN_STAT` (
  `ULSID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER` bigint(20) DEFAULT NULL,
  `DEVICE` varchar(50) DEFAULT NULL,
  `CREATETIME` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ULSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户登录统计表';

-- ----------------------------
--  Table structure for `TB_FIND`
-- ----------------------------
DROP TABLE IF EXISTS `TB_FIND`;
CREATE TABLE `TB_FIND` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` int(11) NOT NULL DEFAULT 0,
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  `CONTENT` text NOT NULL DEFAULT '',
  `SHOP` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='发现表';

-- ----------------------------
--  Table structure for `TB_FIND_REPLY`
-- ----------------------------
DROP TABLE IF EXISTS `TB_FIND_REPLY`;
CREATE TABLE `TB_FIND_REPLY` (
  `FRID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER` bigint(20) NOT NULL,
  `CREATETIME` bigint(20) NOT NULL,
  `CONTENT` text NOT NULL,
  `FIND` bigint(20) NOT NULL,
  PRIMARY KEY (`FRID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='发现回复表';

-- ----------------------------
--  Table structure for `TB_PARTY`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PARTY`;
CREATE TABLE `TB_PARTY` (
  `PID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` int(11) NOT NULL DEFAULT 0,
  `CHILDID` bigint(20) NOT NULL DEFAULT 0,
  `PATH` varchar(255) NOT NULL DEFAULT '',
  `URL` varchar(255) NOT NULL DEFAULT '',
  `TITLE` varchar(255) NOT NULL DEFAULT '',
  `LOOKNUM` int(11) NOT NULL DEFAULT 0,
  `PARTYTIME` varchar(255) NOT NULL DEFAULT '',
  `STARTTIME` bigint(20) NOT NULL DEFAULT 0,
  `STOPTIME` bigint(20) NOT NULL DEFAULT 0,
  `SORT` int(11) NOT NULL DEFAULT 100,
  `ISBEE` int(11) NOT NULL DEFAULT 0,
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='活动主表';

-- ----------------------------
--  Table structure for `TB_PARTY_USER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PARTY_USER`;
CREATE TABLE `TB_PARTY_USER` (
  `PUID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `PARTY` bigint(20) NOT NULL DEFAULT 0,
  `CREATETIME` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`PUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='活动报名表';

-- ----------------------------
--  Table structure for `TB_PARTY_MEET`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PARTY_MEET`;
CREATE TABLE `TB_PARTY_MEET` (
  `PMID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRICE` double NOT NULL DEFAULT 0,
  `REMARK` text NOT NULL DEFAULT '',
  `ADDR` varchar(255) NOT NULL DEFAULT '',
  `LON` bigint(20) NOT NULL DEFAULT 0,
  `LAT` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`PMID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='活动聚会表';

-- ----------------------------
--  Table structure for `TB_USER_REG_STAT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_REG_STAT`;
CREATE TABLE `TB_USER_REG_STAT` (
  `URSID` bigint(20) NOT NULL AUTO_INCREMENT,
  `YEAR` int(11) NOT NULL DEFAULT 0,
  `MONTH` int(11) NOT NULL DEFAULT 0,
  `DAY` int(11) NOT NULL DEFAULT 0,
  `NUM` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`URSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户注册统计表';


-- ----------------------------
--  Table structure for `TB_GOODS`
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS`;
CREATE TABLE `TB_GOODS` (
  `GID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` INT(11) NOT NULL DEFAULT 0,
  `NAME` VARCHAR(255) NOT NULL DEFAULT '',
  `NUMBER` INT(11) NOT NULL DEFAULT 0,
  `INTEGRAL` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='积分商城商品表';

-- ----------------------------
--  Table structure for `TB_USER_CONVERT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_CONVERT`;
CREATE TABLE `TB_USER_CONVERT` (
  `UCID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GOODS` BIGINT(20) NOT NULL DEFAULT 0,
  `USER` BIGINT(20) NOT NULL DEFAULT 0,
  `CARDNUMBER` VARCHAR(255) NOT NULL DEFAULT '',
  `CREATETIME` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`UCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='积分商城兑换记录表';

-- ----------------------------
--  Table structure for `TB_PHONE_CARD`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PHONE_CARD`;
CREATE TABLE `TB_PHONE_CARD` (
  `PCID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CARDNUMBER` VARCHAR(255) NOT NULL DEFAULT '',
  `OPERATOR` INT(11) NOT NULL DEFAULT 0,
  `STATUS` INT(11) NOT NULL DEFAULT 0,
  `CREATETIME` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`PCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='手机充值卡表';

-- ----------------------------
--  Table structure for `TB_MESSAGE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MESSAGE`;
CREATE TABLE `TB_MESSAGE` (
  `MID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MSG` VARCHAR(255) NOT NULL DEFAULT '',
  `TYPE` INT(11) NOT NULL DEFAULT 0,
  `USER` bigint(20) NOT NULL DEFAULT 0,
  `CREATETIME` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统消息表';

SET FOREIGN_KEY_CHECKS = 1;
