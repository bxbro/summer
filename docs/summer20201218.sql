/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : summer

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2020-12-18 22:09:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `file_name` varchar(100) DEFAULT NULL COMMENT '文件名',
  `file_url` varchar(255) DEFAULT NULL COMMENT '文件存储的相对路径',
  `file_type` tinyint(1) DEFAULT NULL COMMENT '文件类型：0图片 1音频 2视频',
  `ctime` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `mtime` bigint(13) DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '是否删除标志位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(50) DEFAULT NULL COMMENT '菜单路径',
  `menu_level` tinyint(1) DEFAULT NULL COMMENT '菜单等级',
  `sort_no` tinyint(1) DEFAULT NULL COMMENT '菜单的排序编号',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '菜单是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_type` tinyint(1) NOT NULL COMMENT '角色类型',
  `role_permission` varchar(500) NOT NULL COMMENT '角色的菜单权限',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `ctime` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `mtime` bigint(13) DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL COMMENT '是否删除标志位（0 未删除 1 已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别（0 女 1 男 2 未知）',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `online` tinyint(1) DEFAULT NULL COMMENT '是否在线（0 离线 1 在线）',
  `last_time_online` datetime DEFAULT NULL COMMENT '上次在线时间',
  `ctime` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `mtime` bigint(13) DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除标志位 (0 未删除, 1 已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_lock
-- ----------------------------
DROP TABLE IF EXISTS `t_user_lock`;
CREATE TABLE `t_user_lock` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `fail_count` int(11) DEFAULT NULL COMMENT '失败次数',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
