/*
MySQL Backup
Database: db-mq
Backup Time: 2019-10-17 15:39:20
*/

CREATE DATABASE db-mq;
USE db-mq;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `db-mq`.`db_mq_demo`;
CREATE TABLE `db-mq`.`Untitled`  (
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `execnums` int(11) NULL DEFAULT NULL,
  `description` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publishtime` bigint(20) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE,
  INDEX `publishtime`(`publishtime`) USING BTREE COMMENT '时间索引',
  INDEX `status`(`status`) USING BTREE COMMENT '状态索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
BEGIN;
LOCK TABLES `db-mq`.`db_mq_demo` WRITE;
DELETE FROM `db-mq`.`db_mq_demo`;
UNLOCK TABLES;
COMMIT;
