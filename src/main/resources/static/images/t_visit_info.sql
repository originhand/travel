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

 Date: 14/06/2024 16:59:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_visit_info
-- ----------------------------
DROP TABLE IF EXISTS `t_visit_info`;
CREATE TABLE `t_visit_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `visit_time` datetime(0) NOT NULL COMMENT '到访时间',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '来访人姓名',
  `tel_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '来访人联系方式',
  `people_num` int(0) NOT NULL DEFAULT 1 COMMENT '来访人数',
  `reason_for_visiting` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '来访理由',
  `company` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '来访人单位',
  `visit_emp_id` int(0) NOT NULL COMMENT '被访人id',
  `emp_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被访人姓名',
  `emp_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被放人工号',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` int(0) NOT NULL DEFAULT 3 COMMENT '审核状态 1 审核通过  2审核未通过 3审核中',
  `deleted` int(0) NOT NULL DEFAULT 1 COMMENT '删除标识 1 未删除 0 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 234 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
