/*
Navicat MySQL Data Transfer

Source Server         : 2001JavaA
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : day0406

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2021-04-06 11:39:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_dept`
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deptname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES ('1', '保卫科');
INSERT INTO `tb_dept` VALUES ('2', '医患科');
INSERT INTO `tb_dept` VALUES ('3', '产科');
INSERT INTO `tb_dept` VALUES ('4', '妇科');
INSERT INTO `tb_dept` VALUES ('5', '儿科');
INSERT INTO `tb_dept` VALUES ('6', '眼科');
INSERT INTO `tb_dept` VALUES ('7', '内科');
INSERT INTO `tb_dept` VALUES ('8', '普外科');
INSERT INTO `tb_dept` VALUES ('9', '皮肤科');
INSERT INTO `tb_dept` VALUES ('10', '肛肠科');
INSERT INTO `tb_dept` VALUES ('11', '口腔科');
INSERT INTO `tb_dept` VALUES ('12', '骨科');
INSERT INTO `tb_dept` VALUES ('13', '办公室');
INSERT INTO `tb_dept` VALUES ('14', '神经外科');
INSERT INTO `tb_dept` VALUES ('15', '神经内科');

-- ----------------------------
-- Table structure for `tb_meun`
-- ----------------------------
DROP TABLE IF EXISTS `tb_meun`;
CREATE TABLE `tb_meun` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_meun
-- ----------------------------
INSERT INTO `tb_meun` VALUES ('1', '0', '北大国际医院内部管理系统', null, null, null);
INSERT INTO `tb_meun` VALUES ('2', '1', '系统管理', null, null, null);
INSERT INTO `tb_meun` VALUES ('3', '1', '药品管理', null, null, null);
INSERT INTO `tb_meun` VALUES ('4', '1', '个人信息关系', null, null, null);
INSERT INTO `tb_meun` VALUES ('5', '2', '人员管理', null, null, null);
INSERT INTO `tb_meun` VALUES ('6', '2', '科室管理', null, null, null);
INSERT INTO `tb_meun` VALUES ('7', '2', '职位管理', null, null, null);
INSERT INTO `tb_meun` VALUES ('8', '2', '菜单管理', null, null, null);

-- ----------------------------
-- Table structure for `tb_post`
-- ----------------------------
DROP TABLE IF EXISTS `tb_post`;
CREATE TABLE `tb_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `postname` varchar(255) DEFAULT NULL,
  `postdesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_post
-- ----------------------------
INSERT INTO `tb_post` VALUES ('1', '护士', null);
INSERT INTO `tb_post` VALUES ('2', '护士长', null);
INSERT INTO `tb_post` VALUES ('3', '普通医生', null);
INSERT INTO `tb_post` VALUES ('4', '副主任医师', null);
INSERT INTO `tb_post` VALUES ('5', '主任医师', null);
INSERT INTO `tb_post` VALUES ('6', '副院长', null);
INSERT INTO `tb_post` VALUES ('7', '院长', null);
INSERT INTO `tb_post` VALUES ('8', '主任', null);
INSERT INTO `tb_post` VALUES ('9', '卫门', null);
INSERT INTO `tb_post` VALUES ('10', '保安', null);

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `telphone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `pwdsalt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '张无忌', null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('2', '赵敏', null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('3', '周芷若', null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('4', '灭绝师太', null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('5', '张三张翠山丰', null, null, null, null, null, null, null);
