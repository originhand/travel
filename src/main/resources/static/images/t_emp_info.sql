/*
 Navicat Premium Data Transfer

 Source Server         : 浩科
 Source Server Type    : MySQL
 Source Server Version : 80037
 Source Host           : 47.113.111.51:3306
 Source Schema         : hlink_db

 Target Server Type    : MySQL
 Target Server Version : 80037
 File Encoding         : 65001

 Date: 14/06/2024 16:59:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_emp_info
-- ----------------------------
DROP TABLE IF EXISTS `t_emp_info`;
CREATE TABLE `t_emp_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工姓名',
  `emp_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工编号（工号）',
  `tel_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系方式',
  `dept_id` int(0) NULL DEFAULT NULL COMMENT '部门编号',
  `gender` int(0) NOT NULL DEFAULT 1 COMMENT '性别 1 男 0 女',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NOT NULL COMMENT '最后修改时间',
  `update_by` int(0) NULL DEFAULT NULL COMMENT '最后修改人',
  `status` int(0) NOT NULL DEFAULT 1 COMMENT '状态 1正常 0离职',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uq_name`(`name`) USING BTREE COMMENT '姓名唯一',
  UNIQUE INDEX `uq_tel_number`(`tel_number`) USING BTREE COMMENT '手机号唯一',
  UNIQUE INDEX `uq_emp_no`(`emp_no`) USING BTREE COMMENT '工号唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 305 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
