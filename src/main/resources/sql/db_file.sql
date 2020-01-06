/*
 Navicat Premium Data Transfer

 Source Server         : Mine
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : localhost:3306
 Source Schema         : db_file

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : 65001

 Date: 06/01/2020 16:22:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for script_dir
-- ----------------------------
DROP TABLE IF EXISTS `script_dir`;
CREATE TABLE `script_dir`  (
  `script_dir_id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL,
  `projectid` int(11) NULL DEFAULT NULL,
  `parent_dir_id` int(11) NULL DEFAULT NULL,
  `script_dir_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `script_dir_creator_userid` int(11) NULL DEFAULT NULL,
  `script_dir_updater_userid` int(11) NULL DEFAULT NULL,
  `script_dir_status` tinyint(4) NULL DEFAULT 1,
  `script_dir_version` int(11) NULL DEFAULT 1,
  `createtime` bigint(20) NULL DEFAULT NULL,
  `updatetime` bigint(20) NULL DEFAULT NULL,
  `is_delete` tinyint(4) NULL DEFAULT 0,
  `dir_type` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`script_dir_id`) USING BTREE,
  INDEX `parent_dir_id`(`parent_dir_id`) USING BTREE,
  INDEX `eid`(`eid`) USING BTREE,
  INDEX `projectid`(`projectid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of script_dir
-- ----------------------------
INSERT INTO `script_dir` VALUES (1, 1, 1890, NULL, '项目组--浩东', 1, NULL, 1, 1, 1554801576619, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (2, 1, 1890, 1, 'test1', 6380, NULL, 1, 1, 1554801584707, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (3, 1, 387, NULL, '自动化测试', 1, NULL, 1, 1, 1554801608012, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (4, 1, 1890, 2, 'test2', 6380, NULL, 1, 1, 1554801620475, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (5, 1, 387, 3, '新建目录1', 1937, NULL, 1, 1, 1554801650958, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (6, 1, 1890, 4, 'test3', 6380, NULL, 1, 1, 1554801653525, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (7, 1, 387, 3, '新建目录2', 1937, 1937, 1, 5, 1554801764329, 1554802059303, 0, NULL);
INSERT INTO `script_dir` VALUES (8, 1, 1890, 1, '子节点1', 6380, 1, 1, 3, 1554801814108, 1559641533212, 1, NULL);
INSERT INTO `script_dir` VALUES (9, 1, 387, 7, '新建目录3', 1937, NULL, 1, 1, 1554801913629, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (10, 1, 387, 7, '新建目录4', 1937, 1937, 1, 2, 1554801931325, 1554802053677, 0, NULL);
INSERT INTO `script_dir` VALUES (11, 1, 351, NULL, '测试专用', 1, NULL, 1, 1, 1554865962164, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (12, 1, 351, 11, '新建目录1', 1012, NULL, 1, 1, 1554866248912, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (13, 1, 351, NULL, '新建目录2', 1012, NULL, 1, 1, 1554866249145, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (14, 1, 351, 11, '新建目录3', 1012, NULL, 1, 1, 1554866249339, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (15, 1, 351, 11, '新建目录9', 1012, NULL, 1, 1, 1554866255458, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (16, 1, 351, 15, '新建目录11', 1012, NULL, 1, 1, 1554866264122, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (17, 1, 351, 16, '新建目录12', 1012, NULL, 1, 1, 1554866269040, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (18, 1, 351, 17, '新建目录13', 1012, NULL, 1, 1, 1554866272621, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (19, 1, 351, 18, '新建目录14', 1012, NULL, 1, 1, 1554866279903, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (20, 1, 2563, NULL, '交行验证专用', 1, NULL, 1, 1, 1554887894148, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (21, 1, 8, NULL, '真机调试用户群组', 1, NULL, 1, 1, 1557109303307, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (22, 1, 23, NULL, '私有云测试项目组', 1, NULL, 1, 1, 1557109320265, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (23, 1, 1708, NULL, '华泰证券验证专用', 1, NULL, 1, 1, 1557109357058, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (24, 1, 64, NULL, '私有云验证测试', 1, NULL, 1, 1, 1557109368605, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (25, 1, 2581, NULL, '专门测试上位机的项目组', 1, NULL, 1, 1, 1557727971833, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (26, 1, 1, NULL, '根目录', 1, NULL, 1, 1, 1557821025944, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (27, 1, 981, NULL, '脚本检测', 1, NULL, 1, 1, 1558955487296, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (28, 1, 758, NULL, '陈浩东拨测监控测试项目组', 1, NULL, 1, 1, 1559116794105, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (29, 1, 6, NULL, '质保团队APP组', 1, NULL, 1, 1, 1559610934699, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (30, 1, 2727, NULL, '脚本检测/删除测试', 1, NULL, 1, 1, 1559731602645, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (31, 1, 2727, 30, 'test1', 1012, NULL, 1, 1, 1562655219444, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (32, 1, 2727, 31, 'test2', 1012, 1012, 1, 3, 1562655824758, 1562664643606, 1, NULL);
INSERT INTO `script_dir` VALUES (33, 1, 1890, 1, '脚本导入', 6380, NULL, 1, 1, 1564734852751, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (34, 1, 6, 29, 'ss', 1012, 1012, 1, 7, 1566641022030, 1571392284447, 0, NULL);
INSERT INTO `script_dir` VALUES (35, 1, 6, 34, 'afa', 1012, 1012, 1, 2, 1566641067663, 1566641072136, 0, NULL);
INSERT INTO `script_dir` VALUES (36, 1, 201, NULL, 'iTestinPro', 1, NULL, 1, 1, 1566974738050, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (37, 1, 6, 35, '123456', 6547, NULL, 1, 1, 1567050838839, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (38, 1, 6, 37, '4567', 6547, 1012, 1, 2, 1567050843196, 1571380700894, 1, NULL);
INSERT INTO `script_dir` VALUES (39, 1, 6, 38, '67890-', 6547, 1012, 1, 2, 1567050848131, 1571380650810, 1, NULL);
INSERT INTO `script_dir` VALUES (40, 1, 6, 39, '12345', 6547, 1012, 1, 2, 1567050852308, 1571380566842, 1, NULL);
INSERT INTO `script_dir` VALUES (41, 1, 6, 40, '1qaz2wsx3edc4rfv5tgb', 6547, 1012, 1, 2, 1567050884121, 1571380399647, 1, NULL);
INSERT INTO `script_dir` VALUES (42, 1, 23, 22, '新建目录1', 3982, NULL, 1, 1, 1568008315629, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (43, 1, 23, 42, '新建目录1', 3982, NULL, 1, 1, 1568008636773, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (44, 1, 10, NULL, '质保团队理财组', 1, NULL, 1, 1, 1568269010661, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (45, 1, 2766, NULL, '测试test1', 1, NULL, 1, 1, 1568269186797, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (46, 1, 713, NULL, 'POC_DEMO', 1, NULL, 1, 1, 1568269204521, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (47, 1, 786, NULL, '宵嘉的项目组', 1, NULL, 1, 1, 1568269261712, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (48, 1, 9, NULL, '质保团队开户组', 1, NULL, 1, 1, 1568269591568, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (49, 1, 7, NULL, '质保团队投顾组', 1, NULL, 1, 1, 1568269609329, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (50, 1, 2551, NULL, '新新新项目组', 1, NULL, 1, 1, 1569376533506, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (51, 1, 5, NULL, 'testqwdQW', 1, NULL, 1, 1, 1571280061828, NULL, 0, NULL);
INSERT INTO `script_dir` VALUES (52, 1, 6, 37, 'aad', 1012, 1012, 1, 2, 1571380965024, 1571380980609, 1, NULL);
INSERT INTO `script_dir` VALUES (53, 1, 6, 37, 'a', 1012, 1012, 1, 2, 1571381085027, 1571382266475, 1, NULL);
INSERT INTO `script_dir` VALUES (54, 1, 6, 37, '1', 1012, 1012, 1, 2, 1571382333973, 1571382353114, 1, NULL);
INSERT INTO `script_dir` VALUES (55, 1, 6, 37, '1', 1012, 1012, 1, 2, 1571382395439, 1571383079468, 1, NULL);
INSERT INTO `script_dir` VALUES (56, 1, 6, 37, '1', 1012, 1012, 1, 2, 1571388167209, 1571388506974, 0, NULL);
INSERT INTO `script_dir` VALUES (57, 1, 1, 26, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (58, 1, 5, 51, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (59, 1, 6, 29, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (60, 1, 7, 49, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (61, 1, 9, 48, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (62, 1, 10, 44, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (63, 1, 23, 22, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (64, 1, 64, 24, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (65, 1, 201, 36, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (66, 1, 351, 11, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (67, 1, 387, 3, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (68, 1, 713, 46, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (69, 1, 758, 28, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (70, 1, 786, 47, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (71, 1, 982, NULL, '上位机专用', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (72, 1, 982, 71, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (73, 1, 991, NULL, '回归测试', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (74, 1, 991, 73, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (75, 1, 1234, NULL, '华泰', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (76, 1, 1234, 75, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (77, 1, 1367, NULL, '交付培训项目组', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (78, 1, 1367, 77, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (79, 1, 1414, NULL, '咪咕专用', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (80, 1, 1414, 79, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (81, 1, 1708, 23, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (82, 1, 1890, 1, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (83, 1, 2563, 20, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (84, 1, 2581, 25, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);
INSERT INTO `script_dir` VALUES (85, 1, 2727, 30, '默认目录', 1, NULL, 1, 1, 1553662901107, NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
