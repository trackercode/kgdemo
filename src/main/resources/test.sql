/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql8.0.18_root
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3366
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 25/06/2023 22:22:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `ID` int(11) NOT NULL COMMENT '编号',
  `UID` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `MONEY` double NULL DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `FK_Reference_8`(`UID`) USING BTREE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`UID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 41, 1000);
INSERT INTO `account` VALUES (2, 45, 1000);
INSERT INTO `account` VALUES (3, 41, 2000);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for jar_info
-- ----------------------------
DROP TABLE IF EXISTS `jar_info`;
CREATE TABLE `jar_info`  (
  `id` int(11) NOT NULL COMMENT '编号\r\n',
  `jar_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'jar包名称',
  `local_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '本地ip',
  `local_port` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '本体端口',
  `remote_ip` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '远程ip',
  `remote_port` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '远程端口',
  `protocol` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '协议',
  `args` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '运行参数',
  `md5_sgin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'jar包版本',
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jar_info
-- ----------------------------
INSERT INTO `jar_info` VALUES (1, 'ace-ticket-exec.jar', NULL, '9898', NULL, '8591', 'tcp', 'defult', 'eb49603a8a786fd7ad4ef3c1a45f2b14', NULL);
INSERT INTO `jar_info` VALUES (2, 'ace-admin-exec.jar', NULL, '8879', NULL, NULL, 'tcp', 'defult', 'f3f8842f2f2613564bb671c4465dcd24', NULL);
INSERT INTO `jar_info` VALUES (3, 'ace-dict.jar', NULL, '9999', NULL, NULL, 'tcp', 'defult', 'd8c9644255fda1bea4c2a8ddc7fa614f', NULL);
INSERT INTO `jar_info` VALUES (4, 'ace-logging-info.jar', NULL, '9001', NULL, NULL, 'tcp', 'defult', '78639da32c488de46e3e46fa64f22086', NULL);
INSERT INTO `jar_info` VALUES (5, 'ace-auth-exec.jar', NULL, '9777', NULL, NULL, 'tcp', 'defult', 'ec0bce1740d00fa399bc5518b21bc181', NULL);
INSERT INTO `jar_info` VALUES (6, 'ace-center.jar', NULL, '8761', NULL, NULL, 'tcp', 'defult', '8ec1f19a84137d8dfde78f871d902db6', NULL);
INSERT INTO `jar_info` VALUES (7, 'ace-auth-9778.jar', NULL, '9777', NULL, NULL, 'tcp', 'defult', '0050a9fb8cedc3496687818c84f7ac68', NULL);
INSERT INTO `jar_info` VALUES (8, 'ace-center.jar', NULL, '8761', NULL, NULL, 'tcp', 'defult', 'dbdde42a37e508eae0e62ec560d933e5', NULL);
INSERT INTO `jar_info` VALUES (9, 'ace-dict.jar', NULL, '8761', NULL, NULL, 'tcp', 'defult', '2d1265ad8089bb9f79e65e70c599c4d8', NULL);
INSERT INTO `jar_info` VALUES (10, 'ace-gate.jar', NULL, '8765', NULL, NULL, 'tcp', 'defult', 'f5e7a69c3ce74a442b1ea9bdfa3e1c42', NULL);
INSERT INTO `jar_info` VALUES (11, 'ace-config.jar', NULL, '8750', NULL, NULL, 'tcp', 'defult', 'd1e9ca147070f2a10c23630eba110310', NULL);
INSERT INTO `jar_info` VALUES (12, 'ace-admin-8762.jar', NULL, '8763', NULL, NULL, 'tcp', 'defult', 'a568fcc77febeadb9d83c1ef93e71e1c', NULL);
INSERT INTO `jar_info` VALUES (13, 'ace-app-exec.jar', NULL, '9555', NULL, NULL, 'tcp', 'defult', '6e43d156b845896977a9a9c0c5478ea0', NULL);
INSERT INTO `jar_info` VALUES (14, 'ace-intercity.jar', NULL, '9559', NULL, NULL, 'tcp', 'defult', 'f8d0d0a2bd442e92d70ac05cb9a0185e', NULL);
INSERT INTO `jar_info` VALUES (15, 'ace-rate.jar', NULL, '9001', NULL, NULL, 'tcp', 'defult', '436035ed9a8583f3787471a1fbd56be8', NULL);
INSERT INTO `jar_info` VALUES (16, 'ace-shiftinfo.jar', NULL, '8010', NULL, NULL, 'tcp', 'defult', 'dc30287f5f40a6637683c059c2867698', NULL);
INSERT INTO `jar_info` VALUES (17, 'ace-gate.jar', NULL, '8765', NULL, NULL, 'tcp', 'defult', '99de31e9b6027836a7f6df7cd6c96248', NULL);
INSERT INTO `jar_info` VALUES (18, 'ace-gate.jar', NULL, '8765', NULL, NULL, 'tcp', 'defult', '3f7989d1c0cbff5d7ee635250fb59aa1', NULL);
INSERT INTO `jar_info` VALUES (19, 'ace-ticket-exec.jar', NULL, '9898', NULL, NULL, 'tcp', 'defult', '0b1ed7917dec6c199ef0271775ddac73', NULL);
INSERT INTO `jar_info` VALUES (20, 'ace-shiftinfo.jar', NULL, '8010', NULL, NULL, NULL, NULL, '7a0efc825c85c08a5cb6bb3783013b0c', NULL);

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of persons
-- ----------------------------
INSERT INTO `persons` VALUES (1, '2017-06-29 05:37:14', 'zhq@hentop.cn', '861580000222', '男', '埃隆·马斯克', '美国加利福尼亚州洛杉矶');
INSERT INTO `persons` VALUES (2, '2017-06-29 05:37:14', 'tes@163.com', '8613000001112', '男', '马克·扎克伯格', '加利福尼亚州帕洛阿');
INSERT INTO `persons` VALUES (3, '2017-06-29 05:37:14', 'yoyo.wu@gmail.com', '86130000011135', '女', '杨惠妍', '中国佛山');
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

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ID` int(11) NOT NULL COMMENT '编号',
  `ROLE_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '院长', '管理整个学院');
INSERT INTO `role` VALUES (2, '总裁', '管理整个公司');
INSERT INTO `role` VALUES (3, '校长', '管理整个学校');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_book
-- ----------------------------

-- ----------------------------
-- Table structure for t_classes
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes`  (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_classes
-- ----------------------------
INSERT INTO `t_classes` VALUES (1, '大一');
INSERT INTO `t_classes` VALUES (2, '大二');
INSERT INTO `t_classes` VALUES (3, '大三');

-- ----------------------------
-- Table structure for t_classessteacher
-- ----------------------------
DROP TABLE IF EXISTS `t_classessteacher`;
CREATE TABLE `t_classessteacher`  (
  `id` int(11) NOT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `tid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_classessteacher
-- ----------------------------
INSERT INTO `t_classessteacher` VALUES (1, 1, 1);
INSERT INTO `t_classessteacher` VALUES (2, 2, 1);
INSERT INTO `t_classessteacher` VALUES (3, 1, 3);
INSERT INTO `t_classessteacher` VALUES (4, 2, 3);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `tid` int(11) NOT NULL,
  `tname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, '王老师');
INSERT INTO `t_teacher` VALUES (2, '李老师');
INSERT INTO `t_teacher` VALUES (3, '张老师');

-- ----------------------------
-- Table structure for tedpi10_back
-- ----------------------------
DROP TABLE IF EXISTS `tedpi10_back`;
CREATE TABLE `tedpi10_back`  (
  `REC_CREATOR` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REC_CREATE_TIME` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `REC_REVISOR` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REC_REVISE_TIME` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `ARCHIVE_FLAG` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `TREE_ENAME` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `NODE_ENAME` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `NODE_CNAME` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `NODE_TYPE` decimal(1, 0) NULL DEFAULT NULL,
  `NODE_URL` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `NODE_SORT_ID` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `NODE_PARAM` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `NODE_IMAGE_PATH` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `TENANT_ID` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目菜单节点信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tedpi10_back
-- ----------------------------
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'DM', 'DM01', '示例菜单1', 2, '  ', '1', ' ', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'DM', 'DM02', '示例菜单2', 2, '  ', '2', ' ', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'DM', 'DMCM01', '入门示例', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20220713130601', ' ', ' ', ' ', 'DM01', 'ABCD00', '公司信息', 1, '/web/ABCD', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'DM01', 'DMCM01', '示例页面01', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EP03', '当前平台信息', 1, '  ', '0', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EP11', '会话缓存诊断', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EP14', '缓存诊断', 1, '  ', '2', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EPDA01', '模型仿真调用', 1, '  ', '6', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EUME03', '平台配置项', 1, '  ', '7', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EUME04', '系统当前进程', 1, '  ', '8', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EUME05', '容器对象信息', 1, '  ', '9', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EUSI01', '服务仿真调用', 1, '  ', '4', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EC', 'EUSI02', '事件仿真调用', 1, '  ', '5', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'BAPC', '图片管理', 2, '  ', '10', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EDCC', '配置管理', 2, '  ', '04', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EDCM', '代码管理', 2, '  ', '05', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EDDB', '数据字典', 2, '  ', '07', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EDFA', '页面按钮菜单', 2, '  ', '02', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EDMDM', '序列号管理', 2, '  ', '09', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EDNM', '发布管理', 2, '  ', '08', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EDProject', '项目模块管理', 2, '  ', '01', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'EUDM', '附件管理', 2, '  ', '06', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'ED', 'XM', '微服务管理', 2, '  ', '03', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDCC', 'EDCC02', '配置环境管理', 1, '  ', '2', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDCC', 'EDCC03', '配置信息管理', 1, '  ', '3', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDCM', 'EDCM00', '代码分类管理', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDCM', 'EDCM01', '代码明细管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDB', 'EDDBIG', '信息生成', 2, '  ', '3', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDB', 'EDDBIT', '信息项维护', 2, '  ', '1', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDB', 'EDDBTM', '表信息维护', 2, '  ', '2', ' ', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBIG', 'EDDBT5', '初始化数据生成', 1, '  ', '2', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBIG', 'EDIG01', '生成设计文档', 1, '  ', '5', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBIG', 'EDIG02', '程序生成', 1, '  ', '4', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBIG', 'EDIG03', 'SQL生成', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBIG', 'EU15', '数据库比较', 1, '  ', '3', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBIT', 'EIIT00', '信息项维护', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBIT', 'EIIT10', '字根维护', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBTM', 'EDDBI0', '表索引维护', 1, '  ', '3', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBTM', 'EDDBT0', '表头维护', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDDBTM', 'EDDBT1', '表体维护', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDFA', 'EDFA00', '页面信息管理', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDFA', 'EDFA01', '按钮信息管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDFA', 'EDPI10', '菜单信息管理', 1, '  ', '3', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDMDM', 'EDMDM2', '序列号定义', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDNM', 'EDNM01', '主机管理', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDNM', 'EDNM02', '节点管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDNM', 'EDNM03', '组件信息管理', 1, '  ', '3', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EDProject', 'EDPI01', '项目模块管理', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EJ', 'EJ00', '任务管理', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EJ', 'EJ08', '高级任务管理', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EM', 'EM01', '消息管理', 1, '  ', '17', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EP', 'EC', '系统管理控制台', 2, '  ', '22', '', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EP', 'ED', '配置管理', 2, '  ', '11', ' ', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EP', 'EJ', '任务管理', 2, '  ', '13', '', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EP', 'EM', '消息管理', 2, '  ', '15', '', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EP', 'XS', '安全管理', 2, '  ', '16', ' ', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EUDM', 'EUDM01', '附件目录管理', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EUDM', 'EUDM02', '附件信息管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EW', 'EWAD', '流程辅助', 2, '  ', '4', ' ', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EW', 'EWPC', '流程客户端', 2, '  ', '3', ' ', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EW', 'EWPM', '业务流程管理', 2, '  ', '2', ' ', 'fa fa-folder', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190530101346', ' ', ' ', ' ', 'EW', 'EWPR', '流程规则管理', 2, ' ', '5', ' ', 'fa fa-folder', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWAD', 'EWPC10', '流程授权管理', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWAD', 'EWPC11', '流程代理管理', 1, '  ', '0', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWAD', 'EWPD05', '流程扩展属性管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWPC', 'EWPC01', '待办事宜', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWPC', 'EWPC02', '已办事宜', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWPM', 'EWPD01', '流程定义管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWPM', 'EWPI00', '流程实例管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'EWPM', 'EWPT10', '流程任务管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190530101514', ' ', ' ', ' ', 'EWPR', 'EWPR01', '流程定义规则管理', 1, ' ', '1', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190530101540', ' ', ' ', ' ', 'EWPR', 'EWPR02', '分支条件规则管理', 1, ' ', '2', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190530101711', ' ', ' ', ' ', 'EWPR', 'EWPR03', '参与者规则管理', 1, ' ', '3', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XM', 'EDXM00', '微服务事件管理', 1, '  ', '3', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XM', 'EDXM01', '微服务信息管理', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XM', 'EDXM02', '微服务参数管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XM', 'EDXM05', '微服务事件参数管理', 1, '  ', '4', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XM', 'EDXM06', '事件路由管理', 1, '  ', '5', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XS', 'XSAD', '集中审计管理', 2, '  ', '13', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XS', 'XSAG', '分级授权', 2, '  ', '14', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XS', 'XSAM', '用户信息管理', 2, '  ', '11', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XS', 'XSAU', '资源权限管理', 2, '  ', '12', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('securityImport', '20200401164000', ' ', ' ', ' ', 'XS', 'XSLV', '分级授权管理', 2, ' ', '7', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190521165052', 'admin', '20190521165115', ' ', 'XS', 'XSOG', '组织机构管理', 2, ' ', '12', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAD', 'XS11', '操作行为审计', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAD', 'XS18', '用户权限审计', 1, '  ', '2', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAD', 'XS19', '页面资源审计', 1, '  ', '3', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAD', 'XS20', '按钮资源审计', 1, '  ', '4', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAD', 'XS21', '服务资源审计', 1, '  ', '5', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAD', 'XS22', '事件资源审计', 1, '  ', '6', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAD', 'XS23', '用户所属组审计', 1, '  ', '7', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAG', 'XS13', '分级成员管理', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAG', 'XS15', '分级资源管理', 1, '  ', '2', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAM', 'XS01', '用户信息管理', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAM', 'XS0103', '用户信息修改', 1, '  ', '3', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAM', 'XS0105', '密码重置', 1, '  ', '6', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAM', 'XS02', '用户群组信息管理', 1, '  ', '4', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAM', 'XS03', '群组成员信息管理', 1, '  ', '5', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAM', 'XS17', '系统管理员', 1, '  ', '7', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAU', 'XS04', '资源信息管理', 1, '  ', '1', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAU', 'XS05', '资源组信息管理', 1, '  ', '2', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAU', 'XS06', '资源组成员信息管理', 1, '  ', '3', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAU', 'XS08', '授权信息管理', 1, '  ', '4', ' ', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAU', 'XS16', '基础授权', 1, '  ', '5', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSAU', 'XSDATAS', '数据集权限管理', 2, '  ', '6', '', '', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSDATAS', 'XS09', '数据集条件定义', 1, '  ', '1', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'XSDATAS', 'XS10', '数据集授权', 1, '  ', '2', '', ' ', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('securityImport', '20200401164000', ' ', ' ', ' ', 'XSLV', 'XSLV01', '分级管理员管理', 1, ' ', '1', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('securityImport', '20200401164000', ' ', ' ', ' ', 'XSLV', 'XSLV02', '分级资源维护', 1, ' ', '2', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('securityImport', '20200401164000', ' ', ' ', ' ', 'XSLV', 'XSLV03', '分级用户组维护', 1, ' ', '3', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('securityImport', '20200401164000', ' ', ' ', ' ', 'XSLV', 'XSLV04', '分级授权管理', 1, ' ', '4', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('securityImport', '20200401164000', ' ', ' ', ' ', 'XSLV', 'XSLV05', '分级用户组成员管理', 1, ' ', '5', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('securityImport', '20200401164000', ' ', ' ', ' ', 'XSLV', 'XSLV06', '组织机构映射', 1, ' ', '5', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190521165404', ' ', ' ', ' ', 'XSOG', 'XSOG01', '组织机构维护', 1, ' ', '1', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190521165404', ' ', ' ', ' ', 'XSOG', 'XSOG02', '组织机构与用户的关系维护', 1, ' ', '2', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20190521165404', ' ', ' ', ' ', 'XSOG', 'XSOG03', '组织机构与用户组的关系维护', 1, ' ', '3', ' ', ' ', ' ');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'root', 'DM', '示例项目管理', 2, '  ', '0', ' ', 'css:fa-dashboard', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'root', 'EP', '系统平台', 2, '  ', '1', ' ', 'css:fa-cubes', 'BDAS');
INSERT INTO `tedpi10_back` VALUES ('admin', '20180206143142', 'admin', '20180206143142', '0', 'root', 'EW', '业务流程管理', 2, '  ', '4', ' ', 'css:fa-recycle', 'BDAS');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '版本',
  `t_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `t_date` date NULL DEFAULT NULL COMMENT '更新时间',
  `ins_version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '安装版本',
  `duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '运行时间',
  `t_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (10, 'v3', 'tname', '2022-12-29', 'in_version1', 'one_year', '张');

-- ----------------------------
-- Table structure for time_area
-- ----------------------------
DROP TABLE IF EXISTS `time_area`;
CREATE TABLE `time_area`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `starttime` timestamp(0) NULL DEFAULT NULL,
  `endtime` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_area
-- ----------------------------
INSERT INTO `time_area` VALUES (1, 'bg1', '2022-01-01 13:36:17', '2022-01-10 13:37:11');
INSERT INTO `time_area` VALUES (2, 'bg2', '2022-02-01 13:37:57', '2022-02-10 13:38:21');
INSERT INTO `time_area` VALUES (3, 'bg3', '2022-03-02 13:38:33', '2022-03-08 13:38:44');
INSERT INTO `time_area` VALUES (4, 'bg4', '2022-04-01 13:38:56', '2022-04-04 13:39:09');
INSERT INTO `time_area` VALUES (5, 'bg5', '2022-04-06 13:39:32', '2022-04-09 13:39:52');
INSERT INTO `time_area` VALUES (6, 'bg6', NULL, NULL);
INSERT INTO `time_area` VALUES (7, 'bg7', '2022-06-01 13:40:19', '2022-06-10 13:40:34');
INSERT INTO `time_area` VALUES (8, 'bg8', NULL, NULL);
INSERT INTO `time_area` VALUES (9, 'bg9', NULL, NULL);
INSERT INTO `time_area` VALUES (10, 'bg10', '2022-07-03 13:40:57', '2022-07-09 13:41:10');
INSERT INTO `time_area` VALUES (11, 'bg11', '2022-07-14 13:41:22', '2022-07-16 13:41:33');
INSERT INTO `time_area` VALUES (12, 'bg12', '2022-07-17 13:41:48', '2022-07-19 13:42:11');
INSERT INTO `time_area` VALUES (13, 'bg13', '2022-08-02 13:42:29', '2022-08-05 13:42:39');
INSERT INTO `time_area` VALUES (14, 'bg14', '2022-08-09 13:43:41', '2022-08-12 13:43:52');
INSERT INTO `time_area` VALUES (15, 'bg15', NULL, NULL);
INSERT INTO `time_area` VALUES (16, 'bg16', '2022-10-01 13:44:14', '2022-10-03 13:44:20');
INSERT INTO `time_area` VALUES (17, 'bg17', '2022-10-04 13:44:25', '2022-10-06 13:44:32');
INSERT INTO `time_area` VALUES (18, 'bg18', '2022-10-07 13:44:37', '2022-10-08 13:44:45');
INSERT INTO `time_area` VALUES (19, 'bg19', '2022-10-10 13:44:52', '2022-10-12 13:44:58');
INSERT INTO `time_area` VALUES (20, 'bg20', '2022-10-13 13:45:03', '2022-10-15 13:45:07');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (41, '马云', '2018-02-27 17:47:08', '男', '北京');
INSERT INTO `user` VALUES (42, '马化腾', '2018-03-02 15:09:37', '女', '安宁昆钢');
INSERT INTO `user` VALUES (43, '许家印', '2018-03-04 11:34:34', '女', '昆明盛唐城');
INSERT INTO `user` VALUES (45, '黄峥', '2018-03-04 12:04:06', '男', '北京马街');
INSERT INTO `user` VALUES (46, '丁磊', '2018-03-07 17:37:26', '男', '上海');
INSERT INTO `user` VALUES (48, '张一鸣', '2018-03-08 11:44:00', '女', '昆明金立');
INSERT INTO `user` VALUES (49, '孙正义', '2022-02-26 00:26:22', '男', '日本');
INSERT INTO `user` VALUES (50, '马斯克', '2022-02-26 00:29:04', '男', '美国');
INSERT INTO `user` VALUES (51, '扎克伯格', '2022-02-26 00:29:45', '男', '美国');
INSERT INTO `user` VALUES (52, '巴菲特', '2022-02-26 00:30:20', '男', '美国');
INSERT INTO `user` VALUES (53, '张小龙', '2022-02-26 00:31:03', '男', '中国');

-- ----------------------------
-- Table structure for user2
-- ----------------------------
DROP TABLE IF EXISTS `user2`;
CREATE TABLE `user2`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passWord` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `realName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user2
-- ----------------------------
INSERT INTO `user2` VALUES (1, 'admin', 'spjr4IH16QlvKCgo==', '管理员');
INSERT INTO `user2` VALUES (2, 'kgadmin', 'kg2022', '管理员');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `UID` int(11) NOT NULL COMMENT '用户编号',
  `RID` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`UID`, `RID`) USING BTREE,
  INDEX `FK_Reference_10`(`RID`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`RID`) REFERENCES `role` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`UID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (41, 1);
INSERT INTO `user_role` VALUES (45, 1);
INSERT INTO `user_role` VALUES (41, 2);

-- ----------------------------
-- Procedure structure for reg_sql
-- ----------------------------
DROP PROCEDURE IF EXISTS `reg_sql`;
delimiter ;;
CREATE PROCEDURE `reg_sql`(in the_table_name varchar(80),
    in the_sql_script_version varchar(80),
    in the_sql_script_name varchar(80),
    in the_install_version  varchar(80),
    in the_execution_duration varchar(80),
    in the_sql_script_description varchar(200))
begin
    declare column_exist int default 0;
    declare the_query varchar(500);

    select '[info] 检查条件 column_exist 是否成立';
    set column_exist = 1;
    if column_exist = 0
    then
        select '[info] 条件 column_exist 成立';
        select * from test;
    else
        select '[info] 条件 column_exist不成立';
        select concat('insert into ', the_table_name, '(version, t_name, t_date, ins_version, duration, t_description) values (?, ?, ?, ?, ?, ?)') into the_query;
        select concat('stmt_sql: ',the_query);
        set @stmt=the_query;
        prepare stmt from @stmt;
        select concat('[info] the_query1=', the_query );
        set @v_the_sql_script_version=the_sql_script_version;
        set @v_the_sql_script_name=the_sql_script_name;
        set @v_date=now();
        set @v_the_install_version=the_install_version;
        set @v_the_execution_duration=the_execution_duration;
        set @v_the_sql_script_description=the_sql_script_description;
        select concat('[info] the_query2=', the_query);
        execute stmt using @v_the_sql_script_version , @v_the_sql_script_name, @v_date, @v_the_install_version, @v_the_execution_duration, @v_the_sql_script_description;

    end if;
#     释放预处理语句
    deallocate prepare stmt;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
