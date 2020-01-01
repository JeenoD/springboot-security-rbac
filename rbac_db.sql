/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : rbac_db

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 31/12/2019 10:26:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission_info
-- ----------------------------
DROP TABLE IF EXISTS `permission_info`;
CREATE TABLE `permission_info`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述信息',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授权链接',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父节点id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission_info
-- ----------------------------
INSERT INTO `permission_info` VALUES (1, '超管专属接口', '超管专属接口', '/admin', -1);
INSERT INTO `permission_info` VALUES (2, '省级专用接口', '省级及以上专用接口', '/prov', -1);
INSERT INTO `permission_info` VALUES (3, '用户个人中心', '用户个人中心', '/user', -1);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户角色名称',
  `level` int(255) NULL DEFAULT NULL COMMENT '层级',
  `pid` bigint(50) NULL DEFAULT NULL COMMENT '父节点id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'ADMIN', '超管', 0, -1);
INSERT INTO `role_info` VALUES (2, 'PROV', '浙江省', 1, 1);
INSERT INTO `role_info` VALUES (3, 'CITY', '杭州市', 2, 33);
INSERT INTO `role_info` VALUES (4, 'CITY', '金华市', 2, 33);
INSERT INTO `role_info` VALUES (5, 'COUNTY', '西湖区', 3, 3301);
INSERT INTO `role_info` VALUES (6, 'SCHOOL', '浙江工业大学', 4, 330101);

-- ----------------------------
-- Table structure for role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_relation`;
CREATE TABLE `role_permission_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission_relation
-- ----------------------------
INSERT INTO `role_permission_relation` VALUES (1, 1, 1);
INSERT INTO `role_permission_relation` VALUES (2, 2, 2);
INSERT INTO `role_permission_relation` VALUES (3, 1, 2);
INSERT INTO `role_permission_relation` VALUES (5, 3, 3);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'zhejiang', '{bcrypt}$2a$10$OU1cn/ZmXAyAbn6umKlXi.SbOfVEqhQgI3F7XdNfrDyCzc3nUuVWu', NULL, '188zhejiang');
INSERT INTO `user_info` VALUES (2, 'hangzhou', '{bcrypt}$2a$10$OU1cn/ZmXAyAbn6umKlXi.SbOfVEqhQgI3F7XdNfrDyCzc3nUuVWu', NULL, '188hangzhou');
INSERT INTO `user_info` VALUES (3, 'jinhua', '{bcrypt}$2a$10$OU1cn/ZmXAyAbn6umKlXi.SbOfVEqhQgI3F7XdNfrDyCzc3nUuVWu', NULL, '188jinhua');
INSERT INTO `user_info` VALUES (4, 'zjut', '{bcrypt}$2a$10$OU1cn/ZmXAyAbn6umKlXi.SbOfVEqhQgI3F7XdNfrDyCzc3nUuVWu', NULL, '188zjut');
INSERT INTO `user_info` VALUES (5, 'admin', '{bcrypt}$2a$10$OU1cn/ZmXAyAbn6umKlXi.SbOfVEqhQgI3F7XdNfrDyCzc3nUuVWu', NULL, '188admin');
INSERT INTO `user_info` VALUES (6, 'xihu', '{bcrypt}$2a$10$OU1cn/ZmXAyAbn6umKlXi.SbOfVEqhQgI3F7XdNfrDyCzc3nUuVWu', NULL, '188xihu');

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_relation
-- ----------------------------
INSERT INTO `user_role_relation` VALUES (1, 1, 2);
INSERT INTO `user_role_relation` VALUES (2, 2, 3);
INSERT INTO `user_role_relation` VALUES (3, 3, 4);
INSERT INTO `user_role_relation` VALUES (4, 5, 1);
INSERT INTO `user_role_relation` VALUES (5, 6, 5);
INSERT INTO `user_role_relation` VALUES (6, 4, 6);
INSERT INTO `user_role_relation` VALUES (7, 5, 2);

SET FOREIGN_KEY_CHECKS = 1;
