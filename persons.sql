/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql_root
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3366
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 27/02/2022 19:04:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for persons
-- ----------------------------
DROP TABLE IF EXISTS `persons`;
CREATE TABLE `persons`  (
  `id` int(11) NOT NULL,
  `create_datetime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persons
-- ----------------------------
INSERT INTO `persons` VALUES (1, '2017-06-29 05:37:14', 'zhq@hentop.cn', '861580000111222', '男', '埃隆·马斯克', '美国加利福尼亚州洛杉矶');
INSERT INTO `persons` VALUES (2, '2017-06-29 05:37:14', 'tes@163.com', '8613000001112', '男', '马克·扎克伯格', '加利福尼亚州帕洛阿');
INSERT INTO `persons` VALUES (3, '2017-06-29 05:37:14', 'yoyo.wu@gmail.com', '8613000001113', '女', '杨惠妍', '中国佛山');
INSERT INTO `persons` VALUES (4, '2017-06-29 05:37:14', 'stacy.gao@126.com', '8613000001114', '女', '吴亚军', '重庆合川');
INSERT INTO `persons` VALUES (5, '2017-06-29 05:37:14', 'hen@qq.com', '8613000001115', '女', '钟慧娟', '江苏连云港');
INSERT INTO `persons` VALUES (6, '2017-06-29 05:37:14', 'hong.zhu@163.com', '8613000001116', '男', '许家印', '中国深圳');
INSERT INTO `persons` VALUES (7, '2017-06-29 05:37:14', 'leon.lai@qq.com', '8613000001117', '男', '马化腾', '中国深圳');
INSERT INTO `persons` VALUES (8, '2017-06-29 05:38:12', 'mark.lei@sohu.com', '8613000001118', '男', '李嘉诚', '中国香港');
INSERT INTO `persons` VALUES (9, '2017-06-29 05:38:12', 'wen.liu@360.com', '8613000001119', '男', '张志东', '腾讯集团的创始人');
INSERT INTO `persons` VALUES (10, '2017-06-29 05:38:12', 'cai.lu@baidu.com', '8613000001120', '女', '范红卫', '江苏省苏州市吴江区');
INSERT INTO `persons` VALUES (11, '2017-06-29 05:38:12', 'alex.li@icee.com', '8613000001121', '男', '马云', '浙江省杭州市');
INSERT INTO `persons` VALUES (12, '2017-06-29 05:38:12', 'sofia.xu@qq.com', '8613000001122', '女', '曾芳勤', '广东');
INSERT INTO `persons` VALUES (13, '2017-06-29 05:38:12', 'cora.zhang@qq.com', '8613000001123', '女', '周群飞', '湖南湘乡');
INSERT INTO `persons` VALUES (14, '2017-06-29 05:38:13', 'tom.gao@hotmail.com', '8613000001124', '女', '鲁忠芳', '中公教育');

SET FOREIGN_KEY_CHECKS = 1;
