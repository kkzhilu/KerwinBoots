/*
 Navicat Premium Data Transfer

 Source Server         : Mine-阿里云
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 120.79.88.17:3306
 Source Schema         : code_show

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 21/11/2019 18:23:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code_file
-- ----------------------------
DROP TABLE IF EXISTS `code_file`;
CREATE TABLE `code_file`  (
  `uuid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fileName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fileType` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for root_file
-- ----------------------------
DROP TABLE IF EXISTS `root_file`;
CREATE TABLE `root_file`  (
  `uuid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fileName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
