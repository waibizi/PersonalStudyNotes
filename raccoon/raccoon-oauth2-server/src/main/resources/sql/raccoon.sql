/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : raccoon

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2020-06-04 20:50:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `oauth_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('web', null, '$2a$10$2.9QBRdDtsCgSHPZygURS.A0QbGmk72o3N8Rd9RsquEXo/ZmnCp1y', 'all', 'authorization_code,password,refresh_token', 'http://baidu.com', null, null, null, null, null);

-- ----------------------------
-- Table structure for `oauth_refresh_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_login`
-- ----------------------------
DROP TABLE IF EXISTS `sys_login`;
CREATE TABLE `sys_login` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` datetime DEFAULT NULL,
  `login_ip` varchar(120) DEFAULT NULL,
  `login_equipment` varchar(40) DEFAULT NULL,
  `login_user` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login
-- ----------------------------
INSERT INTO `sys_login` VALUES ('1', '2020-05-31 03:07:45', '127.0.0.1', 'Unknown', 'user');
INSERT INTO `sys_login` VALUES ('2', '2020-05-31 03:28:59', '127.0.0.1', 'Unknown', 'user');
INSERT INTO `sys_login` VALUES ('3', '2020-06-03 02:42:14', '127.0.0.1', 'Unknown', 'user');
INSERT INTO `sys_login` VALUES ('4', '2020-06-04 12:48:44', '127.0.0.1', 'Unknown', 'user');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `m_id` int(6) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(40) DEFAULT NULL,
  `menu_url` varchar(80) DEFAULT NULL,
  `direct_parent_menu_id` int(6) DEFAULT NULL,
  `all_parent_menu_id` int(6) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` int(6) DEFAULT NULL,
  `update_user` int(6) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_operation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation`;
CREATE TABLE `sys_operation` (
  `o_id` int(6) NOT NULL AUTO_INCREMENT,
  `operation_name` varchar(50) DEFAULT NULL,
  `operation_code` varchar(50) DEFAULT NULL,
  `operation_url` varchar(80) DEFAULT NULL,
  `operation_pid` int(6) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` int(6) DEFAULT NULL,
  `update_user` int(6) DEFAULT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_operation
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_permision_set`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permision_set`;
CREATE TABLE `sys_permision_set` (
  `ps_id` int(6) NOT NULL AUTO_INCREMENT,
  `ps_name` varchar(50) DEFAULT NULL,
  `parent_ps_id` int(6) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` int(6) DEFAULT NULL,
  `update_user` int(6) DEFAULT NULL,
  PRIMARY KEY (`ps_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permision_set
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `p_id` int(6) NOT NULL AUTO_INCREMENT,
  `permission_type` varchar(50) DEFAULT NULL,
  `permission_name` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` int(6) DEFAULT NULL,
  `update_user` int(6) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'system:user:query', '查询用户', '2020-05-25 00:00:00', '2020-05-25 00:00:00', '1', '1');
INSERT INTO `sys_permission` VALUES ('2', 'system:druid:query', '查看druid后台', '2020-05-27 20:51:58', '2020-05-27 20:52:02', '1', '1');
INSERT INTO `sys_permission` VALUES ('3', 'system:user:edit', '修改用户', '2020-06-04 20:46:40', '2020-06-04 20:46:43', '1', '1');

-- ----------------------------
-- Table structure for `sys_permissionset_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissionset_permission`;
CREATE TABLE `sys_permissionset_permission` (
  `permission_set_id` int(6) DEFAULT NULL,
  `permission_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissionset_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_permission_file`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_file`;
CREATE TABLE `sys_permission_file` (
  `permission_id` int(6) DEFAULT NULL,
  `file_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_file
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_permission_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_menu`;
CREATE TABLE `sys_permission_menu` (
  `permission_id` int(6) DEFAULT NULL,
  `menu_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `r_id` int(6) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  `create_user` int(6) DEFAULT NULL,
  `update_user` int(6) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '1', '1', '2020-05-25 22:54:57', '2020-05-25 22:55:00');
INSERT INTO `sys_role` VALUES ('2', 'user', '1', '1', '2020-05-27 20:53:58', '2020-05-27 20:54:03');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(6) DEFAULT NULL,
  `permission_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('2', '3');

-- ----------------------------
-- Table structure for `sys_role_permissionset`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permissionset`;
CREATE TABLE `sys_role_permissionset` (
  `permission_set_id` int(6) DEFAULT NULL,
  `role_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permissionset
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_url_resources`
-- ----------------------------
DROP TABLE IF EXISTS `sys_url_resources`;
CREATE TABLE `sys_url_resources` (
  `u_id` int(6) NOT NULL AUTO_INCREMENT,
  `url_address` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` int(6) DEFAULT NULL,
  `update_user` int(6) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_url_resources
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `u_id` int(6) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `user_password` varchar(300) DEFAULT NULL,
  `user_enable` int(2) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'xsx', '$2a$10$VzjrTNkmTtMKPr3Sgi4QROSkIPU36P/oyfIaOogzPHPhuHR49NOQC', '1');
INSERT INTO `sys_user` VALUES ('2', 'user', '$2a$10$hm01ebObK9LQtF9MPEYrHOjFaGdkm3Gn1wieJf1sA8ddlSHluAqeu', '1');
INSERT INTO `sys_user` VALUES ('3', 'admin', '$2a$10$nJaWrhvRr8bxt5cT4cvx/Onhf7CtsyxqN9KeMlKYNi8LwTipbwtM6', '0');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(6) DEFAULT NULL,
  `role_id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
