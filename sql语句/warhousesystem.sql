/*
 Navicat Premium Dump SQL

 Source Server         : 1806A
 Source Server Type    : MySQL
 Source Server Version : 80400 (8.4.0)
 Source Host           : localhost:3306
 Source Schema         : warhousesystem

 Target Server Type    : MySQL
 Target Server Version : 80400 (8.4.0)
 File Encoding         : 65001

 Date: 16/08/2025 13:17:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `inventoryPrimaryKey` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `wareHousePrimaryKey` int NULL DEFAULT NULL COMMENT '仓库主键',
  `inventoryAllCapacity` int NULL DEFAULT NULL COMMENT '库存容量',
  `inventoryUseCapacity` int NULL DEFAULT NULL COMMENT '库存已用容量',
  `inventoryWarnCapacity` int NULL DEFAULT NULL COMMENT '库存预警容量',
  `inventoryType` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '库存类型',
  PRIMARY KEY (`inventoryPrimaryKey` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 306 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES (305, 28, 1, 0, 1, '水产仓库');
INSERT INTO `inventory` VALUES (304, 28, 666, 0, 40, '水产仓库');
INSERT INTO `inventory` VALUES (76, 25, 4000, 2017, 300, '美味仓库');
INSERT INTO `inventory` VALUES (75, 25, 11500, 7182, 1150, '水产仓库');
INSERT INTO `inventory` VALUES (74, 25, 11000, 6826, 1100, '水产仓库');
INSERT INTO `inventory` VALUES (73, 25, 10500, 6200, 1050, '水产仓库');
INSERT INTO `inventory` VALUES (72, 24, 11000, 7000, 1100, '水产仓库');
INSERT INTO `inventory` VALUES (71, 24, 10500, 6500, 1050, '水产仓库');
INSERT INTO `inventory` VALUES (70, 24, 10000, 6001, 1000, '水产仓库');
INSERT INTO `inventory` VALUES (69, 23, 10500, 6800, 1050, '水产仓库');
INSERT INTO `inventory` VALUES (68, 23, 10000, 6200, 1000, '水产仓库');
INSERT INTO `inventory` VALUES (67, 23, 9500, 5800, 950, '水产仓库');
INSERT INTO `inventory` VALUES (66, 22, 10000, 6500, 1000, '水产仓库');
INSERT INTO `inventory` VALUES (65, 22, 9500, 6000, 950, '水产仓库');
INSERT INTO `inventory` VALUES (64, 22, 9000, 5500, 900, '水产仓库');
INSERT INTO `inventory` VALUES (63, 21, 9500, 6200, 950, '水产仓库');
INSERT INTO `inventory` VALUES (62, 21, 9000, 5800, 900, '水产仓库');
INSERT INTO `inventory` VALUES (61, 21, 8500, 5200, 850, '水产仓库');
INSERT INTO `inventory` VALUES (60, 20, 9000, 6000, 900, '水产仓库');
INSERT INTO `inventory` VALUES (59, 20, 8500, 5500, 850, '水产仓库');
INSERT INTO `inventory` VALUES (58, 20, 8000, 5000, 800, '水产仓库');
INSERT INTO `inventory` VALUES (57, 19, 8500, 5800, 850, '水产仓库');
INSERT INTO `inventory` VALUES (56, 19, 8000, 5200, 800, '水产仓库');
INSERT INTO `inventory` VALUES (55, 19, 7500, 4800, 750, '水产仓库');
INSERT INTO `inventory` VALUES (54, 18, 8000, 5500, 800, '水产仓库');
INSERT INTO `inventory` VALUES (53, 18, 7500, 5000, 750, '水产仓库');
INSERT INTO `inventory` VALUES (52, 18, 7000, 4500, 700, '水产仓库');
INSERT INTO `inventory` VALUES (51, 17, 13000, 8000, 1300, '常温仓库');
INSERT INTO `inventory` VALUES (50, 13, 12500, 7500, 1250, '常温仓库');
INSERT INTO `inventory` VALUES (49, 17, 12000, 7000, 1200, '常温仓库');
INSERT INTO `inventory` VALUES (48, 16, 12500, 7800, 1250, '常温仓库');
INSERT INTO `inventory` VALUES (47, 16, 12000, 7200, 1200, '常温仓库');
INSERT INTO `inventory` VALUES (46, 16, 11500, 6800, 1150, '常温仓库');
INSERT INTO `inventory` VALUES (45, 15, 12000, 7500, 1200, '常温仓库');
INSERT INTO `inventory` VALUES (44, 15, 11500, 7000, 1150, '常温仓库');
INSERT INTO `inventory` VALUES (43, 15, 11000, 6500, 1100, '常温仓库');
INSERT INTO `inventory` VALUES (42, 14, 11500, 7200, 1150, '常温仓库');
INSERT INTO `inventory` VALUES (41, 14, 11000, 6800, 1100, '常温仓库');
INSERT INTO `inventory` VALUES (40, 14, 10500, 6200, 1050, '常温仓库');
INSERT INTO `inventory` VALUES (39, 13, 11000, 7000, 1100, '常温仓库');
INSERT INTO `inventory` VALUES (38, 13, 10500, 6500, 1050, '常温仓库');
INSERT INTO `inventory` VALUES (37, 13, 10000, 6000, 1000, '常温仓库');
INSERT INTO `inventory` VALUES (36, 12, 10500, 6800, 1050, '常温仓库');
INSERT INTO `inventory` VALUES (35, 12, 10000, 6200, 1000, '常温仓库');
INSERT INTO `inventory` VALUES (34, 12, 9500, 5800, 950, '常温仓库');
INSERT INTO `inventory` VALUES (33, 11, 10000, 6500, 1000, '常温仓库');
INSERT INTO `inventory` VALUES (32, 11, 9500, 6000, 950, '常温仓库');
INSERT INTO `inventory` VALUES (31, 11, 9000, 5500, 900, '常温仓库');
INSERT INTO `inventory` VALUES (30, 10, 9500, 6200, 950, '常温仓库');
INSERT INTO `inventory` VALUES (29, 10, 9000, 5800, 900, '常温仓库');
INSERT INTO `inventory` VALUES (28, 10, 8500, 5200, 850, '常温仓库');
INSERT INTO `inventory` VALUES (27, 9, 9000, 6000, 900, '常温仓库');
INSERT INTO `inventory` VALUES (26, 9, 8500, 5500, 850, '常温仓库');
INSERT INTO `inventory` VALUES (25, 9, 8000, 5000, 800, '常温仓库');
INSERT INTO `inventory` VALUES (24, 8, 7500, 4800, 750, '冷冻仓库');
INSERT INTO `inventory` VALUES (23, 8, 7000, 4200, 700, '冷冻仓库');
INSERT INTO `inventory` VALUES (22, 8, 6500, 3800, 650, '冷冻仓库');
INSERT INTO `inventory` VALUES (21, 7, 7000, 4500, 700, '冷冻仓库');
INSERT INTO `inventory` VALUES (20, 7, 6500, 4000, 650, '冷冻仓库');
INSERT INTO `inventory` VALUES (19, 7, 6000, 3500, 600, '冷冻仓库');
INSERT INTO `inventory` VALUES (18, 6, 6500, 4200, 650, '冷冻仓库');
INSERT INTO `inventory` VALUES (17, 6, 6000, 3800, 600, '冷冻仓库');
INSERT INTO `inventory` VALUES (16, 6, 5500, 3200, 550, '冷冻仓库');
INSERT INTO `inventory` VALUES (15, 5, 6000, 4000, 600, '冷冻仓库');
INSERT INTO `inventory` VALUES (14, 5, 5500, 3500, 550, '冷冻仓库');
INSERT INTO `inventory` VALUES (13, 5, 5000, 3000, 500, '冷冻仓库');
INSERT INTO `inventory` VALUES (12, 4, 5500, 3800, 550, '冷冻仓库');
INSERT INTO `inventory` VALUES (11, 4, 5000, 3200, 500, '冷冻仓库');
INSERT INTO `inventory` VALUES (10, 4, 4500, 2825, 450, '冷冻仓库');
INSERT INTO `inventory` VALUES (9, 3, 5000, 3500, 500, '冷冻仓库');
INSERT INTO `inventory` VALUES (8, 3, 4500, 3000, 450, '冷冻仓库');
INSERT INTO `inventory` VALUES (7, 3, 4000, 2500, 400, '冷冻仓库');
INSERT INTO `inventory` VALUES (6, 2, 4500, 3200, 450, '冷冻仓库');
INSERT INTO `inventory` VALUES (5, 2, 4000, 2800, 400, '冷冻仓库');
INSERT INTO `inventory` VALUES (4, 2, 4000, 2212, 3000, '冷冻仓');
INSERT INTO `inventory` VALUES (3, 1, 4000, 3000, 400, '冷冻仓库');
INSERT INTO `inventory` VALUES (2, 1, 3500, 2500, 350, '冷冻仓库');
INSERT INTO `inventory` VALUES (1, 1, 3000, 2000, 300, '冷冻仓库');

-- ----------------------------
-- Table structure for plinki
-- ----------------------------
DROP TABLE IF EXISTS `plinki`;
CREATE TABLE `plinki`  (
  `primarykey` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `productprimarykey` int NULL DEFAULT NULL COMMENT '产品主键',
  `inventoryPrimaryKey` int NULL DEFAULT NULL COMMENT '库存主键',
  `storageTime` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`primarykey`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 301 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of plinki
-- ----------------------------
INSERT INTO `plinki` VALUES (1, 1, 1, '2025-01-01');
INSERT INTO `plinki` VALUES (2, 2, 1, '2025-01-02');
INSERT INTO `plinki` VALUES (3, 3, 1, '2025-01-03');
INSERT INTO `plinki` VALUES (4, 4, 2, '2025-01-04');
INSERT INTO `plinki` VALUES (5, 5, 2, '2025-01-05');
INSERT INTO `plinki` VALUES (6, 6, 2, '2025-01-06');
INSERT INTO `plinki` VALUES (7, 7, 3, '2025-01-07');
INSERT INTO `plinki` VALUES (8, 8, 3, '2025-01-08');
INSERT INTO `plinki` VALUES (9, 9, 3, '2025-01-09');
INSERT INTO `plinki` VALUES (10, 10, 4, '2025-01-10');
INSERT INTO `plinki` VALUES (11, 11, 4, '2025-01-11');
INSERT INTO `plinki` VALUES (12, 12, 4, '2025-01-12');
INSERT INTO `plinki` VALUES (13, 13, 5, '2025-01-13');
INSERT INTO `plinki` VALUES (14, 14, 5, '2025-01-14');
INSERT INTO `plinki` VALUES (15, 15, 5, '2025-01-15');
INSERT INTO `plinki` VALUES (16, 16, 6, '2025-01-16');
INSERT INTO `plinki` VALUES (17, 17, 6, '2025-01-17');
INSERT INTO `plinki` VALUES (18, 18, 6, '2025-01-18');
INSERT INTO `plinki` VALUES (19, 19, 7, '2025-01-19');
INSERT INTO `plinki` VALUES (20, 20, 7, '2025-01-20');
INSERT INTO `plinki` VALUES (21, 21, 7, '2025-01-21');
INSERT INTO `plinki` VALUES (22, 22, 8, '2025-01-22');
INSERT INTO `plinki` VALUES (23, 23, 8, '2025-01-23');
INSERT INTO `plinki` VALUES (24, 24, 8, '2025-01-24');
INSERT INTO `plinki` VALUES (25, 25, 9, '2025-01-25');
INSERT INTO `plinki` VALUES (26, 26, 9, '2025-01-26');
INSERT INTO `plinki` VALUES (27, 27, 9, '2025-01-27');
INSERT INTO `plinki` VALUES (28, 28, 10, '2025-01-28');
INSERT INTO `plinki` VALUES (29, 29, 10, '2025-01-29');
INSERT INTO `plinki` VALUES (30, 30, 10, '2025-01-30');
INSERT INTO `plinki` VALUES (31, 31, 11, '2025-01-31');
INSERT INTO `plinki` VALUES (32, 32, 11, '2025-02-01');
INSERT INTO `plinki` VALUES (33, 33, 11, '2025-02-02');
INSERT INTO `plinki` VALUES (34, 34, 12, '2025-02-03');
INSERT INTO `plinki` VALUES (35, 35, 12, '2025-02-04');
INSERT INTO `plinki` VALUES (36, 36, 12, '2025-02-05');
INSERT INTO `plinki` VALUES (37, 37, 13, '2025-02-06');
INSERT INTO `plinki` VALUES (38, 38, 13, '2025-02-07');
INSERT INTO `plinki` VALUES (39, 39, 13, '2025-02-08');
INSERT INTO `plinki` VALUES (40, 40, 14, '2025-02-09');
INSERT INTO `plinki` VALUES (41, 41, 14, '2025-02-10');
INSERT INTO `plinki` VALUES (42, 42, 14, '2025-02-11');
INSERT INTO `plinki` VALUES (43, 43, 15, '2025-02-12');
INSERT INTO `plinki` VALUES (44, 44, 15, '2025-02-13');
INSERT INTO `plinki` VALUES (45, 45, 15, '2025-02-14');
INSERT INTO `plinki` VALUES (46, 46, 16, '2025-02-15');
INSERT INTO `plinki` VALUES (47, 47, 16, '2025-02-16');
INSERT INTO `plinki` VALUES (48, 48, 16, '2025-02-17');
INSERT INTO `plinki` VALUES (49, 49, 17, '2025-02-18');
INSERT INTO `plinki` VALUES (50, 50, 17, '2025-02-19');
INSERT INTO `plinki` VALUES (51, 51, 17, '2025-02-20');
INSERT INTO `plinki` VALUES (52, 52, 18, '2025-02-21');
INSERT INTO `plinki` VALUES (53, 53, 18, '2025-02-22');
INSERT INTO `plinki` VALUES (54, 54, 18, '2025-02-23');
INSERT INTO `plinki` VALUES (55, 55, 19, '2025-02-24');
INSERT INTO `plinki` VALUES (56, 56, 19, '2025-02-25');
INSERT INTO `plinki` VALUES (57, 57, 19, '2025-02-26');
INSERT INTO `plinki` VALUES (58, 58, 20, '2025-02-27');
INSERT INTO `plinki` VALUES (59, 59, 20, '2025-02-28');
INSERT INTO `plinki` VALUES (60, 60, 20, '2025-03-01');
INSERT INTO `plinki` VALUES (61, 61, 21, '2025-03-02');
INSERT INTO `plinki` VALUES (62, 62, 21, '2025-03-03');
INSERT INTO `plinki` VALUES (63, 63, 21, '2025-03-04');
INSERT INTO `plinki` VALUES (64, 64, 22, '2025-03-05');
INSERT INTO `plinki` VALUES (65, 65, 22, '2025-03-06');
INSERT INTO `plinki` VALUES (66, 66, 22, '2025-03-07');
INSERT INTO `plinki` VALUES (67, 67, 23, '2025-03-08');
INSERT INTO `plinki` VALUES (68, 68, 23, '2025-03-09');
INSERT INTO `plinki` VALUES (69, 69, 23, '2025-03-10');
INSERT INTO `plinki` VALUES (70, 70, 24, '2025-03-11');
INSERT INTO `plinki` VALUES (71, 71, 24, '2025-03-12');
INSERT INTO `plinki` VALUES (72, 72, 24, '2025-03-13');
INSERT INTO `plinki` VALUES (73, 73, 25, '2025-03-14');
INSERT INTO `plinki` VALUES (74, 74, 25, '2025-03-15');
INSERT INTO `plinki` VALUES (75, 75, 25, '2025-03-16');
INSERT INTO `plinki` VALUES (76, 76, 26, '2025-03-17');
INSERT INTO `plinki` VALUES (77, 77, 26, '2025-03-18');
INSERT INTO `plinki` VALUES (78, 78, 26, '2025-03-19');
INSERT INTO `plinki` VALUES (79, 79, 27, '2025-03-20');
INSERT INTO `plinki` VALUES (80, 80, 27, '2025-03-21');
INSERT INTO `plinki` VALUES (81, 81, 27, '2025-03-22');
INSERT INTO `plinki` VALUES (82, 82, 28, '2025-03-23');
INSERT INTO `plinki` VALUES (83, 83, 28, '2025-03-24');
INSERT INTO `plinki` VALUES (84, 84, 28, '2025-03-25');
INSERT INTO `plinki` VALUES (85, 85, 29, '2025-03-26');
INSERT INTO `plinki` VALUES (86, 86, 29, '2025-03-27');
INSERT INTO `plinki` VALUES (87, 87, 29, '2025-03-28');
INSERT INTO `plinki` VALUES (88, 88, 30, '2025-03-29');
INSERT INTO `plinki` VALUES (89, 89, 30, '2025-03-30');
INSERT INTO `plinki` VALUES (90, 90, 30, '2025-03-31');
INSERT INTO `plinki` VALUES (91, 91, 31, '2025-04-01');
INSERT INTO `plinki` VALUES (92, 92, 31, '2025-04-02');
INSERT INTO `plinki` VALUES (93, 93, 31, '2025-04-03');
INSERT INTO `plinki` VALUES (94, 94, 32, '2025-04-04');
INSERT INTO `plinki` VALUES (95, 95, 32, '2025-04-05');
INSERT INTO `plinki` VALUES (96, 96, 32, '2025-04-06');
INSERT INTO `plinki` VALUES (97, 97, 33, '2025-04-07');
INSERT INTO `plinki` VALUES (98, 98, 33, '2025-04-08');
INSERT INTO `plinki` VALUES (99, 99, 33, '2025-04-09');
INSERT INTO `plinki` VALUES (100, 100, 34, '2025-04-10');
INSERT INTO `plinki` VALUES (101, 101, 34, '2025-04-11');
INSERT INTO `plinki` VALUES (102, 102, 34, '2025-04-12');
INSERT INTO `plinki` VALUES (103, 103, 35, '2025-04-13');
INSERT INTO `plinki` VALUES (104, 104, 35, '2025-04-14');
INSERT INTO `plinki` VALUES (105, 105, 35, '2025-04-15');
INSERT INTO `plinki` VALUES (106, 106, 36, '2025-04-16');
INSERT INTO `plinki` VALUES (107, 107, 36, '2025-04-17');
INSERT INTO `plinki` VALUES (108, 108, 36, '2025-04-18');
INSERT INTO `plinki` VALUES (109, 109, 37, '2025-04-19');
INSERT INTO `plinki` VALUES (110, 110, 37, '2025-04-20');
INSERT INTO `plinki` VALUES (111, 111, 37, '2025-04-21');
INSERT INTO `plinki` VALUES (112, 112, 38, '2025-04-22');
INSERT INTO `plinki` VALUES (113, 113, 38, '2025-04-23');
INSERT INTO `plinki` VALUES (114, 114, 38, '2025-04-24');
INSERT INTO `plinki` VALUES (115, 115, 39, '2025-04-25');
INSERT INTO `plinki` VALUES (116, 116, 39, '2025-04-26');
INSERT INTO `plinki` VALUES (117, 117, 39, '2025-04-27');
INSERT INTO `plinki` VALUES (118, 118, 40, '2025-04-28');
INSERT INTO `plinki` VALUES (119, 119, 40, '2025-04-29');
INSERT INTO `plinki` VALUES (120, 120, 40, '2025-04-30');
INSERT INTO `plinki` VALUES (121, 121, 41, '2025-05-01');
INSERT INTO `plinki` VALUES (122, 122, 41, '2025-05-02');
INSERT INTO `plinki` VALUES (123, 123, 41, '2025-05-03');
INSERT INTO `plinki` VALUES (124, 124, 42, '2025-05-04');
INSERT INTO `plinki` VALUES (125, 125, 42, '2025-05-05');
INSERT INTO `plinki` VALUES (126, 126, 42, '2025-05-06');
INSERT INTO `plinki` VALUES (127, 127, 43, '2025-05-07');
INSERT INTO `plinki` VALUES (128, 128, 43, '2025-05-08');
INSERT INTO `plinki` VALUES (129, 129, 43, '2025-05-09');
INSERT INTO `plinki` VALUES (130, 130, 44, '2025-05-10');
INSERT INTO `plinki` VALUES (131, 131, 44, '2025-05-11');
INSERT INTO `plinki` VALUES (132, 132, 44, '2025-05-12');
INSERT INTO `plinki` VALUES (133, 133, 45, '2025-05-13');
INSERT INTO `plinki` VALUES (134, 134, 45, '2025-05-14');
INSERT INTO `plinki` VALUES (135, 135, 45, '2025-05-15');
INSERT INTO `plinki` VALUES (136, 136, 46, '2025-05-16');
INSERT INTO `plinki` VALUES (137, 137, 46, '2025-05-17');
INSERT INTO `plinki` VALUES (138, 138, 46, '2025-05-18');
INSERT INTO `plinki` VALUES (139, 139, 47, '2025-05-19');
INSERT INTO `plinki` VALUES (140, 140, 47, '2025-05-20');
INSERT INTO `plinki` VALUES (141, 141, 47, '2025-05-21');
INSERT INTO `plinki` VALUES (142, 142, 48, '2025-05-22');
INSERT INTO `plinki` VALUES (143, 143, 48, '2025-05-23');
INSERT INTO `plinki` VALUES (144, 144, 48, '2025-05-24');
INSERT INTO `plinki` VALUES (145, 145, 49, '2025-05-25');
INSERT INTO `plinki` VALUES (146, 146, 49, '2025-05-26');
INSERT INTO `plinki` VALUES (147, 147, 49, '2025-05-27');
INSERT INTO `plinki` VALUES (148, 148, 50, '2025-05-28');
INSERT INTO `plinki` VALUES (149, 149, 50, '2025-05-29');
INSERT INTO `plinki` VALUES (150, 150, 50, '2025-05-30');
INSERT INTO `plinki` VALUES (151, 151, 51, '2025-05-31');
INSERT INTO `plinki` VALUES (152, 152, 51, '2025-06-01');
INSERT INTO `plinki` VALUES (153, 153, 51, '2025-06-02');
INSERT INTO `plinki` VALUES (154, 154, 52, '2025-06-03');
INSERT INTO `plinki` VALUES (155, 155, 52, '2025-06-04');
INSERT INTO `plinki` VALUES (156, 156, 52, '2025-06-05');
INSERT INTO `plinki` VALUES (157, 157, 53, '2025-06-06');
INSERT INTO `plinki` VALUES (158, 158, 53, '2025-06-07');
INSERT INTO `plinki` VALUES (159, 159, 53, '2025-06-08');
INSERT INTO `plinki` VALUES (160, 160, 54, '2025-06-09');
INSERT INTO `plinki` VALUES (161, 161, 54, '2025-06-10');
INSERT INTO `plinki` VALUES (162, 162, 54, '2025-06-11');
INSERT INTO `plinki` VALUES (163, 163, 55, '2025-06-12');
INSERT INTO `plinki` VALUES (164, 164, 55, '2025-06-13');
INSERT INTO `plinki` VALUES (165, 165, 55, '2025-06-14');
INSERT INTO `plinki` VALUES (166, 166, 56, '2025-06-15');
INSERT INTO `plinki` VALUES (167, 167, 56, '2025-06-16');
INSERT INTO `plinki` VALUES (168, 168, 56, '2025-06-17');
INSERT INTO `plinki` VALUES (169, 169, 57, '2025-06-18');
INSERT INTO `plinki` VALUES (170, 170, 57, '2025-06-19');
INSERT INTO `plinki` VALUES (171, 171, 57, '2025-06-20');
INSERT INTO `plinki` VALUES (172, 172, 58, '2025-06-21');
INSERT INTO `plinki` VALUES (173, 173, 58, '2025-06-22');
INSERT INTO `plinki` VALUES (174, 174, 58, '2025-06-23');
INSERT INTO `plinki` VALUES (175, 175, 59, '2025-06-24');
INSERT INTO `plinki` VALUES (176, 176, 59, '2025-06-25');
INSERT INTO `plinki` VALUES (177, 177, 59, '2025-06-26');
INSERT INTO `plinki` VALUES (178, 178, 60, '2025-06-27');
INSERT INTO `plinki` VALUES (179, 179, 60, '2025-06-28');
INSERT INTO `plinki` VALUES (180, 180, 60, '2025-06-29');
INSERT INTO `plinki` VALUES (181, 181, 61, '2025-06-30');
INSERT INTO `plinki` VALUES (182, 182, 61, '2025-07-01');
INSERT INTO `plinki` VALUES (183, 183, 61, '2025-07-02');
INSERT INTO `plinki` VALUES (184, 184, 62, '2025-07-03');
INSERT INTO `plinki` VALUES (185, 185, 62, '2025-07-04');
INSERT INTO `plinki` VALUES (186, 186, 62, '2025-07-05');
INSERT INTO `plinki` VALUES (187, 187, 63, '2025-07-06');
INSERT INTO `plinki` VALUES (188, 188, 63, '2025-07-07');
INSERT INTO `plinki` VALUES (189, 189, 63, '2025-07-08');
INSERT INTO `plinki` VALUES (190, 190, 64, '2025-07-09');
INSERT INTO `plinki` VALUES (191, 191, 64, '2025-07-10');
INSERT INTO `plinki` VALUES (192, 192, 64, '2025-07-11');
INSERT INTO `plinki` VALUES (193, 193, 65, '2025-07-12');
INSERT INTO `plinki` VALUES (194, 194, 65, '2025-07-13');
INSERT INTO `plinki` VALUES (195, 195, 65, '2025-07-14');
INSERT INTO `plinki` VALUES (196, 196, 66, '2025-07-15');
INSERT INTO `plinki` VALUES (197, 197, 66, '2025-07-16');
INSERT INTO `plinki` VALUES (198, 198, 66, '2025-07-17');
INSERT INTO `plinki` VALUES (199, 199, 67, '2025-07-18');
INSERT INTO `plinki` VALUES (200, 200, 67, '2025-07-19');
INSERT INTO `plinki` VALUES (201, 201, 67, '2025-07-20');
INSERT INTO `plinki` VALUES (202, 202, 68, '2025-07-21');
INSERT INTO `plinki` VALUES (203, 203, 68, '2025-07-22');
INSERT INTO `plinki` VALUES (204, 204, 68, '2025-07-23');
INSERT INTO `plinki` VALUES (205, 205, 69, '2025-07-24');
INSERT INTO `plinki` VALUES (206, 206, 69, '2025-07-25');
INSERT INTO `plinki` VALUES (207, 207, 69, '2025-07-26');
INSERT INTO `plinki` VALUES (208, 208, 70, '2025-07-27');
INSERT INTO `plinki` VALUES (209, 209, 70, '2025-07-28');
INSERT INTO `plinki` VALUES (210, 210, 70, '2025-07-29');
INSERT INTO `plinki` VALUES (211, 211, 71, '2025-07-30');
INSERT INTO `plinki` VALUES (212, 212, 71, '2025-07-31');
INSERT INTO `plinki` VALUES (213, 213, 71, '2025-08-01');
INSERT INTO `plinki` VALUES (214, 214, 72, '2025-08-02');
INSERT INTO `plinki` VALUES (215, 215, 72, '2025-08-03');
INSERT INTO `plinki` VALUES (216, 216, 72, '2025-08-04');
INSERT INTO `plinki` VALUES (217, 217, 73, '2025-08-05');
INSERT INTO `plinki` VALUES (218, 218, 73, '2025-08-06');
INSERT INTO `plinki` VALUES (219, 219, 73, '2025-08-07');
INSERT INTO `plinki` VALUES (220, 220, 74, '2025-08-08');
INSERT INTO `plinki` VALUES (221, 221, 74, '2025-08-09');
INSERT INTO `plinki` VALUES (222, 222, 74, '2025-08-10');
INSERT INTO `plinki` VALUES (223, 223, 75, '2025-08-11');
INSERT INTO `plinki` VALUES (224, 224, 75, '2025-08-12');
INSERT INTO `plinki` VALUES (225, 225, 75, '2025-08-13');
INSERT INTO `plinki` VALUES (226, 224, 76, '2211-01-02');

-- ----------------------------
-- Table structure for plinkw
-- ----------------------------
DROP TABLE IF EXISTS `plinkw`;
CREATE TABLE `plinkw`  (
  `primaryKey` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `productPrimaryKey` int NULL DEFAULT NULL COMMENT '产品主键',
  `wareHousePrimaryKey` int NULL DEFAULT NULL COMMENT '仓库主键',
  PRIMARY KEY (`primaryKey` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 301 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of plinkw
-- ----------------------------
INSERT INTO `plinkw` VALUES (300, 300, 25);
INSERT INTO `plinkw` VALUES (299, 299, 25);
INSERT INTO `plinkw` VALUES (298, 298, 25);
INSERT INTO `plinkw` VALUES (297, 297, 25);
INSERT INTO `plinkw` VALUES (296, 296, 25);
INSERT INTO `plinkw` VALUES (295, 295, 25);
INSERT INTO `plinkw` VALUES (294, 294, 25);
INSERT INTO `plinkw` VALUES (293, 293, 25);
INSERT INTO `plinkw` VALUES (292, 292, 25);
INSERT INTO `plinkw` VALUES (291, 291, 25);
INSERT INTO `plinkw` VALUES (290, 290, 25);
INSERT INTO `plinkw` VALUES (289, 289, 25);
INSERT INTO `plinkw` VALUES (288, 288, 24);
INSERT INTO `plinkw` VALUES (287, 287, 24);
INSERT INTO `plinkw` VALUES (286, 286, 24);
INSERT INTO `plinkw` VALUES (285, 285, 24);
INSERT INTO `plinkw` VALUES (284, 284, 24);
INSERT INTO `plinkw` VALUES (283, 283, 24);
INSERT INTO `plinkw` VALUES (282, 282, 24);
INSERT INTO `plinkw` VALUES (281, 281, 24);
INSERT INTO `plinkw` VALUES (280, 280, 24);
INSERT INTO `plinkw` VALUES (279, 279, 24);
INSERT INTO `plinkw` VALUES (278, 278, 24);
INSERT INTO `plinkw` VALUES (277, 277, 24);
INSERT INTO `plinkw` VALUES (276, 276, 23);
INSERT INTO `plinkw` VALUES (275, 275, 23);
INSERT INTO `plinkw` VALUES (274, 274, 23);
INSERT INTO `plinkw` VALUES (273, 273, 23);
INSERT INTO `plinkw` VALUES (272, 272, 23);
INSERT INTO `plinkw` VALUES (271, 271, 23);
INSERT INTO `plinkw` VALUES (270, 270, 23);
INSERT INTO `plinkw` VALUES (269, 269, 23);
INSERT INTO `plinkw` VALUES (268, 268, 23);
INSERT INTO `plinkw` VALUES (267, 267, 23);
INSERT INTO `plinkw` VALUES (266, 266, 23);
INSERT INTO `plinkw` VALUES (265, 265, 23);
INSERT INTO `plinkw` VALUES (264, 264, 22);
INSERT INTO `plinkw` VALUES (263, 263, 22);
INSERT INTO `plinkw` VALUES (262, 262, 22);
INSERT INTO `plinkw` VALUES (261, 261, 22);
INSERT INTO `plinkw` VALUES (260, 260, 22);
INSERT INTO `plinkw` VALUES (259, 259, 22);
INSERT INTO `plinkw` VALUES (258, 258, 22);
INSERT INTO `plinkw` VALUES (257, 257, 22);
INSERT INTO `plinkw` VALUES (256, 256, 22);
INSERT INTO `plinkw` VALUES (255, 255, 22);
INSERT INTO `plinkw` VALUES (254, 254, 22);
INSERT INTO `plinkw` VALUES (253, 253, 22);
INSERT INTO `plinkw` VALUES (252, 252, 21);
INSERT INTO `plinkw` VALUES (251, 251, 21);
INSERT INTO `plinkw` VALUES (250, 250, 21);
INSERT INTO `plinkw` VALUES (249, 249, 21);
INSERT INTO `plinkw` VALUES (248, 248, 21);
INSERT INTO `plinkw` VALUES (247, 247, 21);
INSERT INTO `plinkw` VALUES (246, 246, 21);
INSERT INTO `plinkw` VALUES (245, 245, 21);
INSERT INTO `plinkw` VALUES (244, 244, 21);
INSERT INTO `plinkw` VALUES (243, 243, 21);
INSERT INTO `plinkw` VALUES (242, 242, 21);
INSERT INTO `plinkw` VALUES (241, 241, 21);
INSERT INTO `plinkw` VALUES (240, 240, 20);
INSERT INTO `plinkw` VALUES (239, 239, 20);
INSERT INTO `plinkw` VALUES (238, 238, 20);
INSERT INTO `plinkw` VALUES (237, 237, 20);
INSERT INTO `plinkw` VALUES (236, 236, 20);
INSERT INTO `plinkw` VALUES (235, 235, 20);
INSERT INTO `plinkw` VALUES (234, 234, 20);
INSERT INTO `plinkw` VALUES (233, 233, 20);
INSERT INTO `plinkw` VALUES (232, 232, 20);
INSERT INTO `plinkw` VALUES (231, 231, 20);
INSERT INTO `plinkw` VALUES (230, 230, 20);
INSERT INTO `plinkw` VALUES (229, 229, 20);
INSERT INTO `plinkw` VALUES (228, 228, 19);
INSERT INTO `plinkw` VALUES (227, 227, 19);
INSERT INTO `plinkw` VALUES (226, 226, 19);
INSERT INTO `plinkw` VALUES (225, 225, 19);
INSERT INTO `plinkw` VALUES (224, 224, 19);
INSERT INTO `plinkw` VALUES (223, 223, 19);
INSERT INTO `plinkw` VALUES (222, 222, 19);
INSERT INTO `plinkw` VALUES (221, 221, 19);
INSERT INTO `plinkw` VALUES (220, 220, 19);
INSERT INTO `plinkw` VALUES (219, 219, 19);
INSERT INTO `plinkw` VALUES (218, 218, 19);
INSERT INTO `plinkw` VALUES (217, 217, 19);
INSERT INTO `plinkw` VALUES (216, 216, 18);
INSERT INTO `plinkw` VALUES (215, 215, 18);
INSERT INTO `plinkw` VALUES (214, 214, 18);
INSERT INTO `plinkw` VALUES (213, 213, 18);
INSERT INTO `plinkw` VALUES (212, 212, 18);
INSERT INTO `plinkw` VALUES (211, 211, 18);
INSERT INTO `plinkw` VALUES (210, 210, 18);
INSERT INTO `plinkw` VALUES (209, 209, 18);
INSERT INTO `plinkw` VALUES (208, 208, 18);
INSERT INTO `plinkw` VALUES (207, 207, 18);
INSERT INTO `plinkw` VALUES (206, 206, 18);
INSERT INTO `plinkw` VALUES (205, 205, 18);
INSERT INTO `plinkw` VALUES (204, 204, 17);
INSERT INTO `plinkw` VALUES (203, 203, 17);
INSERT INTO `plinkw` VALUES (202, 202, 17);
INSERT INTO `plinkw` VALUES (201, 201, 17);
INSERT INTO `plinkw` VALUES (200, 200, 17);
INSERT INTO `plinkw` VALUES (199, 199, 17);
INSERT INTO `plinkw` VALUES (198, 198, 17);
INSERT INTO `plinkw` VALUES (197, 197, 17);
INSERT INTO `plinkw` VALUES (196, 196, 17);
INSERT INTO `plinkw` VALUES (195, 195, 17);
INSERT INTO `plinkw` VALUES (194, 194, 17);
INSERT INTO `plinkw` VALUES (193, 193, 17);
INSERT INTO `plinkw` VALUES (192, 192, 16);
INSERT INTO `plinkw` VALUES (191, 191, 16);
INSERT INTO `plinkw` VALUES (190, 190, 16);
INSERT INTO `plinkw` VALUES (189, 189, 16);
INSERT INTO `plinkw` VALUES (188, 188, 16);
INSERT INTO `plinkw` VALUES (187, 187, 16);
INSERT INTO `plinkw` VALUES (186, 186, 16);
INSERT INTO `plinkw` VALUES (185, 185, 16);
INSERT INTO `plinkw` VALUES (184, 184, 16);
INSERT INTO `plinkw` VALUES (183, 183, 16);
INSERT INTO `plinkw` VALUES (182, 182, 16);
INSERT INTO `plinkw` VALUES (181, 181, 16);
INSERT INTO `plinkw` VALUES (180, 180, 15);
INSERT INTO `plinkw` VALUES (179, 179, 15);
INSERT INTO `plinkw` VALUES (178, 178, 15);
INSERT INTO `plinkw` VALUES (177, 177, 15);
INSERT INTO `plinkw` VALUES (176, 176, 15);
INSERT INTO `plinkw` VALUES (175, 175, 15);
INSERT INTO `plinkw` VALUES (174, 174, 15);
INSERT INTO `plinkw` VALUES (173, 173, 15);
INSERT INTO `plinkw` VALUES (172, 172, 15);
INSERT INTO `plinkw` VALUES (171, 171, 15);
INSERT INTO `plinkw` VALUES (170, 170, 15);
INSERT INTO `plinkw` VALUES (169, 169, 15);
INSERT INTO `plinkw` VALUES (168, 168, 14);
INSERT INTO `plinkw` VALUES (167, 167, 14);
INSERT INTO `plinkw` VALUES (166, 166, 14);
INSERT INTO `plinkw` VALUES (165, 165, 14);
INSERT INTO `plinkw` VALUES (164, 164, 14);
INSERT INTO `plinkw` VALUES (163, 163, 14);
INSERT INTO `plinkw` VALUES (162, 162, 14);
INSERT INTO `plinkw` VALUES (161, 161, 14);
INSERT INTO `plinkw` VALUES (160, 160, 14);
INSERT INTO `plinkw` VALUES (159, 159, 14);
INSERT INTO `plinkw` VALUES (158, 158, 14);
INSERT INTO `plinkw` VALUES (157, 157, 14);
INSERT INTO `plinkw` VALUES (156, 156, 13);
INSERT INTO `plinkw` VALUES (155, 155, 13);
INSERT INTO `plinkw` VALUES (154, 154, 13);
INSERT INTO `plinkw` VALUES (153, 153, 13);
INSERT INTO `plinkw` VALUES (152, 152, 13);
INSERT INTO `plinkw` VALUES (151, 151, 13);
INSERT INTO `plinkw` VALUES (150, 150, 13);
INSERT INTO `plinkw` VALUES (149, 149, 13);
INSERT INTO `plinkw` VALUES (148, 148, 13);
INSERT INTO `plinkw` VALUES (147, 147, 13);
INSERT INTO `plinkw` VALUES (146, 146, 13);
INSERT INTO `plinkw` VALUES (145, 145, 13);
INSERT INTO `plinkw` VALUES (144, 144, 12);
INSERT INTO `plinkw` VALUES (143, 143, 12);
INSERT INTO `plinkw` VALUES (142, 142, 12);
INSERT INTO `plinkw` VALUES (141, 141, 12);
INSERT INTO `plinkw` VALUES (140, 140, 12);
INSERT INTO `plinkw` VALUES (139, 139, 12);
INSERT INTO `plinkw` VALUES (138, 138, 12);
INSERT INTO `plinkw` VALUES (137, 137, 12);
INSERT INTO `plinkw` VALUES (136, 136, 12);
INSERT INTO `plinkw` VALUES (135, 135, 12);
INSERT INTO `plinkw` VALUES (134, 134, 12);
INSERT INTO `plinkw` VALUES (133, 133, 12);
INSERT INTO `plinkw` VALUES (132, 132, 11);
INSERT INTO `plinkw` VALUES (131, 131, 11);
INSERT INTO `plinkw` VALUES (130, 130, 11);
INSERT INTO `plinkw` VALUES (129, 129, 11);
INSERT INTO `plinkw` VALUES (128, 128, 11);
INSERT INTO `plinkw` VALUES (127, 127, 11);
INSERT INTO `plinkw` VALUES (126, 126, 11);
INSERT INTO `plinkw` VALUES (125, 125, 11);
INSERT INTO `plinkw` VALUES (124, 124, 11);
INSERT INTO `plinkw` VALUES (123, 123, 11);
INSERT INTO `plinkw` VALUES (122, 122, 11);
INSERT INTO `plinkw` VALUES (121, 121, 11);
INSERT INTO `plinkw` VALUES (120, 120, 10);
INSERT INTO `plinkw` VALUES (119, 119, 10);
INSERT INTO `plinkw` VALUES (118, 118, 10);
INSERT INTO `plinkw` VALUES (117, 117, 10);
INSERT INTO `plinkw` VALUES (116, 116, 10);
INSERT INTO `plinkw` VALUES (115, 115, 10);
INSERT INTO `plinkw` VALUES (114, 114, 10);
INSERT INTO `plinkw` VALUES (113, 113, 10);
INSERT INTO `plinkw` VALUES (112, 112, 10);
INSERT INTO `plinkw` VALUES (111, 111, 10);
INSERT INTO `plinkw` VALUES (110, 110, 10);
INSERT INTO `plinkw` VALUES (109, 109, 10);
INSERT INTO `plinkw` VALUES (108, 108, 9);
INSERT INTO `plinkw` VALUES (107, 107, 9);
INSERT INTO `plinkw` VALUES (106, 106, 9);
INSERT INTO `plinkw` VALUES (105, 105, 9);
INSERT INTO `plinkw` VALUES (104, 104, 9);
INSERT INTO `plinkw` VALUES (103, 103, 9);
INSERT INTO `plinkw` VALUES (102, 102, 9);
INSERT INTO `plinkw` VALUES (101, 101, 9);
INSERT INTO `plinkw` VALUES (100, 100, 9);
INSERT INTO `plinkw` VALUES (99, 99, 9);
INSERT INTO `plinkw` VALUES (98, 98, 9);
INSERT INTO `plinkw` VALUES (97, 97, 9);
INSERT INTO `plinkw` VALUES (96, 96, 8);
INSERT INTO `plinkw` VALUES (95, 95, 8);
INSERT INTO `plinkw` VALUES (94, 94, 8);
INSERT INTO `plinkw` VALUES (93, 93, 8);
INSERT INTO `plinkw` VALUES (92, 92, 8);
INSERT INTO `plinkw` VALUES (91, 91, 8);
INSERT INTO `plinkw` VALUES (90, 90, 8);
INSERT INTO `plinkw` VALUES (89, 89, 8);
INSERT INTO `plinkw` VALUES (88, 88, 8);
INSERT INTO `plinkw` VALUES (87, 87, 8);
INSERT INTO `plinkw` VALUES (86, 86, 8);
INSERT INTO `plinkw` VALUES (85, 85, 8);
INSERT INTO `plinkw` VALUES (84, 84, 7);
INSERT INTO `plinkw` VALUES (83, 83, 7);
INSERT INTO `plinkw` VALUES (82, 82, 7);
INSERT INTO `plinkw` VALUES (81, 81, 7);
INSERT INTO `plinkw` VALUES (80, 80, 7);
INSERT INTO `plinkw` VALUES (79, 79, 7);
INSERT INTO `plinkw` VALUES (78, 78, 7);
INSERT INTO `plinkw` VALUES (77, 77, 7);
INSERT INTO `plinkw` VALUES (76, 76, 7);
INSERT INTO `plinkw` VALUES (75, 75, 7);
INSERT INTO `plinkw` VALUES (74, 74, 7);
INSERT INTO `plinkw` VALUES (73, 73, 7);
INSERT INTO `plinkw` VALUES (72, 72, 6);
INSERT INTO `plinkw` VALUES (71, 71, 6);
INSERT INTO `plinkw` VALUES (70, 70, 6);
INSERT INTO `plinkw` VALUES (69, 69, 6);
INSERT INTO `plinkw` VALUES (68, 68, 6);
INSERT INTO `plinkw` VALUES (67, 67, 6);
INSERT INTO `plinkw` VALUES (66, 66, 6);
INSERT INTO `plinkw` VALUES (65, 65, 6);
INSERT INTO `plinkw` VALUES (64, 64, 6);
INSERT INTO `plinkw` VALUES (63, 63, 6);
INSERT INTO `plinkw` VALUES (62, 62, 6);
INSERT INTO `plinkw` VALUES (61, 61, 6);
INSERT INTO `plinkw` VALUES (60, 60, 5);
INSERT INTO `plinkw` VALUES (59, 59, 5);
INSERT INTO `plinkw` VALUES (58, 58, 5);
INSERT INTO `plinkw` VALUES (57, 57, 5);
INSERT INTO `plinkw` VALUES (56, 56, 5);
INSERT INTO `plinkw` VALUES (55, 55, 5);
INSERT INTO `plinkw` VALUES (54, 54, 5);
INSERT INTO `plinkw` VALUES (53, 53, 5);
INSERT INTO `plinkw` VALUES (52, 52, 5);
INSERT INTO `plinkw` VALUES (51, 51, 5);
INSERT INTO `plinkw` VALUES (50, 50, 5);
INSERT INTO `plinkw` VALUES (49, 49, 5);
INSERT INTO `plinkw` VALUES (48, 48, 4);
INSERT INTO `plinkw` VALUES (47, 47, 4);
INSERT INTO `plinkw` VALUES (46, 46, 4);
INSERT INTO `plinkw` VALUES (45, 45, 4);
INSERT INTO `plinkw` VALUES (44, 44, 4);
INSERT INTO `plinkw` VALUES (43, 43, 4);
INSERT INTO `plinkw` VALUES (42, 42, 4);
INSERT INTO `plinkw` VALUES (41, 41, 4);
INSERT INTO `plinkw` VALUES (40, 40, 4);
INSERT INTO `plinkw` VALUES (39, 39, 4);
INSERT INTO `plinkw` VALUES (38, 38, 4);
INSERT INTO `plinkw` VALUES (37, 37, 4);
INSERT INTO `plinkw` VALUES (36, 36, 3);
INSERT INTO `plinkw` VALUES (35, 35, 3);
INSERT INTO `plinkw` VALUES (34, 34, 3);
INSERT INTO `plinkw` VALUES (33, 33, 3);
INSERT INTO `plinkw` VALUES (32, 32, 3);
INSERT INTO `plinkw` VALUES (31, 31, 3);
INSERT INTO `plinkw` VALUES (30, 30, 3);
INSERT INTO `plinkw` VALUES (29, 29, 3);
INSERT INTO `plinkw` VALUES (28, 28, 3);
INSERT INTO `plinkw` VALUES (27, 27, 3);
INSERT INTO `plinkw` VALUES (26, 26, 3);
INSERT INTO `plinkw` VALUES (25, 25, 3);
INSERT INTO `plinkw` VALUES (24, 24, 2);
INSERT INTO `plinkw` VALUES (23, 23, 2);
INSERT INTO `plinkw` VALUES (22, 22, 2);
INSERT INTO `plinkw` VALUES (21, 21, 2);
INSERT INTO `plinkw` VALUES (20, 20, 2);
INSERT INTO `plinkw` VALUES (19, 19, 2);
INSERT INTO `plinkw` VALUES (18, 18, 2);
INSERT INTO `plinkw` VALUES (17, 17, 2);
INSERT INTO `plinkw` VALUES (16, 16, 2);
INSERT INTO `plinkw` VALUES (15, 15, 2);
INSERT INTO `plinkw` VALUES (14, 14, 2);
INSERT INTO `plinkw` VALUES (13, 13, 2);
INSERT INTO `plinkw` VALUES (12, 12, 1);
INSERT INTO `plinkw` VALUES (11, 11, 1);
INSERT INTO `plinkw` VALUES (10, 10, 1);
INSERT INTO `plinkw` VALUES (9, 9, 1);
INSERT INTO `plinkw` VALUES (8, 8, 1);
INSERT INTO `plinkw` VALUES (7, 7, 1);
INSERT INTO `plinkw` VALUES (6, 6, 1);
INSERT INTO `plinkw` VALUES (5, 5, 1);
INSERT INTO `plinkw` VALUES (4, 4, 1);
INSERT INTO `plinkw` VALUES (3, 3, 1);
INSERT INTO `plinkw` VALUES (2, 2, 1);
INSERT INTO `plinkw` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productPrimaryKey` int NOT NULL AUTO_INCREMENT COMMENT '产品主键（自增ID）',
  `productId` int NULL DEFAULT NULL COMMENT '产品编号（业务唯一标识）',
  `productName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品名称',
  `productType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品类型',
  `productDate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生产日期',
  `qualityDate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`productPrimaryKey` DESC) USING BTREE,
  UNIQUE INDEX `productId`(`productId` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '产品信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (225, 3021, '活三文鱼', '水产仓库', '2025-08-13', '365');
INSERT INTO `product` VALUES (224, 3020, '活面包蟹', '水产仓库', '2025-08-12', '365');
INSERT INTO `product` VALUES (223, 3019, '活石蟹', '水产仓库', '2025-08-11', '365');
INSERT INTO `product` VALUES (222, 3018, '活花蟹', '水产仓库', '2025-08-10', '365');
INSERT INTO `product` VALUES (221, 3017, '活梭子蟹', '水产仓库', '2025-08-09', '365');
INSERT INTO `product` VALUES (220, 3016, '活青蟹', '水产仓库', '2025-08-08', '365');
INSERT INTO `product` VALUES (219, 3015, '活大闸蟹', '水产仓库', '2025-08-07', '1');
INSERT INTO `product` VALUES (218, 3014, '活毛蟹', '水产仓库', '2025-08-06', '2');
INSERT INTO `product` VALUES (217, 3013, '活松叶蟹', '水产仓库', '2025-08-05', '3');
INSERT INTO `product` VALUES (216, 3012, '活雪蟹', '水产仓库', '2025-08-04', '365');
INSERT INTO `product` VALUES (215, 3011, '活帝王蟹', '水产仓库', '2025-08-03', '365');
INSERT INTO `product` VALUES (214, 3010, '活象拔蚌', '水产仓库', '2025-08-02', '365');
INSERT INTO `product` VALUES (213, 3009, '活海螺', '水产仓库', '2025-08-01', '365');
INSERT INTO `product` VALUES (212, 3008, '活蛏子', '水产仓库', '2025-07-31', '365');
INSERT INTO `product` VALUES (211, 3007, '活蛤蜊', '水产仓库', '2025-07-30', '365');
INSERT INTO `product` VALUES (210, 3006, '活牡蛎', '水产仓库', '2025-07-29', '365');
INSERT INTO `product` VALUES (209, 3005, '活扇贝', '水产仓库', '2025-07-28', '365');
INSERT INTO `product` VALUES (208, 3004, '活海参', '水产仓库', '2025-07-27', '365');
INSERT INTO `product` VALUES (207, 3003, '活鲍鱼', '水产仓库', '2025-07-26', '365');
INSERT INTO `product` VALUES (206, 3002, '活螃蟹', '水产仓库', '2025-07-25', '365');
INSERT INTO `product` VALUES (205, 3001, '活龙虾', '水产仓库', '2025-07-24', '365');
INSERT INTO `product` VALUES (204, 2108, '苏打水', '常温仓库', '2025-07-23', '365');
INSERT INTO `product` VALUES (203, 2107, '纯净水', '常温仓库', '2025-07-22', '365');
INSERT INTO `product` VALUES (202, 2106, '矿泉水', '常温仓库', '2025-07-21', '365');
INSERT INTO `product` VALUES (201, 2105, '山泉水', '常温仓库', '2025-07-20', '365');
INSERT INTO `product` VALUES (200, 2104, '矿物质水', '常温仓库', '2025-07-19', '365');
INSERT INTO `product` VALUES (199, 2103, '蒸馏水', '常温仓库', '2025-07-18', '365');
INSERT INTO `product` VALUES (198, 2102, '气泡水', '常温仓库', '2025-07-17', '365');
INSERT INTO `product` VALUES (197, 2101, '苏打水', '常温仓库', '2025-07-16', '365');
INSERT INTO `product` VALUES (196, 2100, '纯净水', '常温仓库', '2025-07-15', '365');
INSERT INTO `product` VALUES (195, 2099, '矿泉水', '常温仓库', '2025-07-14', '365');
INSERT INTO `product` VALUES (194, 2098, '山泉水', '常温仓库', '2025-07-13', '365');
INSERT INTO `product` VALUES (193, 2097, '矿物质水', '常温仓库', '2025-07-12', '365');
INSERT INTO `product` VALUES (192, 2096, '蒸馏水', '常温仓库', '2025-07-11', '365');
INSERT INTO `product` VALUES (191, 2095, '气泡水', '常温仓库', '2025-07-10', '365');
INSERT INTO `product` VALUES (190, 2094, '苏打水', '常温仓库', '2025-07-09', '365');
INSERT INTO `product` VALUES (189, 2093, '纯净水', '常温仓库', '2025-07-08', '365');
INSERT INTO `product` VALUES (188, 2092, '矿泉水', '常温仓库', '2025-07-07', '365');
INSERT INTO `product` VALUES (187, 2091, '山泉水', '常温仓库', '2025-07-06', '365');
INSERT INTO `product` VALUES (186, 2090, '矿物质水', '常温仓库', '2025-07-05', '365');
INSERT INTO `product` VALUES (185, 2089, '蒸馏水', '常温仓库', '2025-07-04', '365');
INSERT INTO `product` VALUES (184, 2088, '气泡水', '常温仓库', '2025-07-03', '365');
INSERT INTO `product` VALUES (183, 2087, '苏打水', '常温仓库', '2025-07-02', '365');
INSERT INTO `product` VALUES (182, 2086, '纯净水', '常温仓库', '2025-07-01', '365');
INSERT INTO `product` VALUES (181, 2085, '矿泉水', '常温仓库', '2025-06-30', '365');
INSERT INTO `product` VALUES (180, 2084, '山泉水', '常温仓库', '2025-06-29', '365');
INSERT INTO `product` VALUES (179, 2083, '矿物质水', '常温仓库', '2025-06-28', '365');
INSERT INTO `product` VALUES (178, 2082, '蒸馏水', '常温仓库', '2025-06-27', '365');
INSERT INTO `product` VALUES (177, 2081, '气泡水', '常温仓库', '2025-06-26', '365');
INSERT INTO `product` VALUES (176, 2080, '苏打水', '常温仓库', '2025-06-25', '365');
INSERT INTO `product` VALUES (175, 2079, '纯净水', '常温仓库', '2025-06-24', '365');
INSERT INTO `product` VALUES (174, 2078, '矿泉水', '常温仓库', '2025-06-23', '365');
INSERT INTO `product` VALUES (173, 2077, '山泉水', '常温仓库', '2025-06-22', '365');
INSERT INTO `product` VALUES (172, 2076, '矿物质水', '常温仓库', '2025-06-21', '365');
INSERT INTO `product` VALUES (171, 2075, '蒸馏水', '常温仓库', '2025-06-20', '365');
INSERT INTO `product` VALUES (170, 2074, '气泡水', '常温仓库', '2025-06-19', '365');
INSERT INTO `product` VALUES (169, 2073, '苏打水', '常温仓库', '2025-06-18', '365');
INSERT INTO `product` VALUES (168, 2072, '纯净水', '常温仓库', '2025-06-17', '365');
INSERT INTO `product` VALUES (167, 2071, '矿泉水', '常温仓库', '2025-06-16', '365');
INSERT INTO `product` VALUES (166, 2070, '山泉水', '常温仓库', '2025-06-15', '365');
INSERT INTO `product` VALUES (165, 2069, '矿物质水', '常温仓库', '2025-06-14', '365');
INSERT INTO `product` VALUES (164, 2068, '蒸馏水', '常温仓库', '2025-06-13', '365');
INSERT INTO `product` VALUES (163, 2067, '气泡水', '常温仓库', '2025-06-12', '365');
INSERT INTO `product` VALUES (162, 2066, '苏打水', '常温仓库', '2025-06-11', '365');
INSERT INTO `product` VALUES (161, 2065, '纯净水', '常温仓库', '2025-06-10', '365');
INSERT INTO `product` VALUES (160, 2064, '矿泉水', '常温仓库', '2025-06-09', '365');
INSERT INTO `product` VALUES (159, 2063, '山泉水', '常温仓库', '2025-06-08', '365');
INSERT INTO `product` VALUES (158, 2062, '矿物质水', '常温仓库', '2025-06-07', '365');
INSERT INTO `product` VALUES (157, 2061, '蒸馏水', '常温仓库', '2025-06-06', '365');
INSERT INTO `product` VALUES (156, 2060, '气泡水', '常温仓库', '2025-06-05', '365');
INSERT INTO `product` VALUES (155, 2059, '苏打水', '常温仓库', '2025-06-04', '365');
INSERT INTO `product` VALUES (154, 2058, '纯净水', '常温仓库', '2025-06-03', '365');
INSERT INTO `product` VALUES (153, 2057, '矿泉水', '常温仓库', '2025-06-02', '365');
INSERT INTO `product` VALUES (152, 2056, '山泉水', '常温仓库', '2025-06-01', '365');
INSERT INTO `product` VALUES (151, 2055, '矿物质水', '常温仓库', '2025-05-31', '365');
INSERT INTO `product` VALUES (150, 2054, '蒸馏水', '常温仓库', '2025-05-30', '365');
INSERT INTO `product` VALUES (149, 2053, '气泡水', '常温仓库', '2025-05-29', '365');
INSERT INTO `product` VALUES (148, 2052, '苏打水', '常温仓库', '2025-05-28', '365');
INSERT INTO `product` VALUES (147, 2051, '纯净水', '常温仓库', '2025-05-27', '365');
INSERT INTO `product` VALUES (146, 2050, '矿泉水', '常温仓库', '2025-05-26', '365');
INSERT INTO `product` VALUES (145, 2049, '山泉水', '常温仓库', '2025-05-25', '365');
INSERT INTO `product` VALUES (144, 2048, '矿物质水', '常温仓库', '2025-05-24', '365');
INSERT INTO `product` VALUES (143, 2047, '蒸馏水', '常温仓库', '2025-05-23', '365');
INSERT INTO `product` VALUES (142, 2046, '气泡水', '常温仓库', '2025-05-22', '365');
INSERT INTO `product` VALUES (141, 2045, '苏打水', '常温仓库', '2025-05-21', '365');
INSERT INTO `product` VALUES (140, 2044, '纯净水', '常温仓库', '2025-05-20', '365');
INSERT INTO `product` VALUES (139, 2043, '矿泉水', '常温仓库', '2025-05-19', '365');
INSERT INTO `product` VALUES (138, 2042, '山泉水', '常温仓库', '2025-05-18', '365');
INSERT INTO `product` VALUES (137, 2041, '矿物质水', '常温仓库', '2025-05-17', '365');
INSERT INTO `product` VALUES (136, 2040, '蒸馏水', '常温仓库', '2025-05-16', '365');
INSERT INTO `product` VALUES (135, 2039, '气泡水', '常温仓库', '2025-05-15', '365');
INSERT INTO `product` VALUES (134, 2038, '苏打水', '常温仓库', '2025-05-14', '365');
INSERT INTO `product` VALUES (133, 2037, '纯净水', '常温仓库', '2025-05-13', '365');
INSERT INTO `product` VALUES (132, 2036, '矿泉水', '常温仓库', '2025-05-12', '365');
INSERT INTO `product` VALUES (131, 2035, '山泉水', '常温仓库', '2025-05-11', '365');
INSERT INTO `product` VALUES (130, 2034, '矿物质水', '常温仓库', '2025-05-10', '365');
INSERT INTO `product` VALUES (129, 2033, '蒸馏水', '常温仓库', '2025-05-09', '365');
INSERT INTO `product` VALUES (128, 2032, '气泡水', '常温仓库', '2025-05-08', '365');
INSERT INTO `product` VALUES (127, 2031, '苏打水', '常温仓库', '2025-05-07', '365');
INSERT INTO `product` VALUES (126, 2030, '纯净水', '常温仓库', '2025-05-06', '365');
INSERT INTO `product` VALUES (125, 2029, '矿泉水', '常温仓库', '2025-05-05', '365');
INSERT INTO `product` VALUES (124, 2028, '山泉水', '常温仓库', '2025-05-04', '365');
INSERT INTO `product` VALUES (123, 2027, '矿物质水', '常温仓库', '2025-05-03', '365');
INSERT INTO `product` VALUES (122, 2026, '蒸馏水', '常温仓库', '2025-05-02', '365');
INSERT INTO `product` VALUES (121, 2025, '气泡水', '常温仓库', '2025-05-01', '365');
INSERT INTO `product` VALUES (120, 2024, '苏打水', '常温仓库', '2025-04-30', '365');
INSERT INTO `product` VALUES (119, 2023, '纯净水', '常温仓库', '2025-04-29', '365');
INSERT INTO `product` VALUES (118, 2022, '矿泉水', '常温仓库', '2025-04-28', '365');
INSERT INTO `product` VALUES (117, 2021, '山泉水', '常温仓库', '2025-04-27', '365');
INSERT INTO `product` VALUES (116, 2020, '矿物质水', '常温仓库', '2025-04-26', '365');
INSERT INTO `product` VALUES (115, 2019, '蒸馏水', '常温仓库', '2025-04-25', '365');
INSERT INTO `product` VALUES (114, 2018, '气泡水', '常温仓库', '2025-04-24', '365');
INSERT INTO `product` VALUES (113, 2017, '苏打水', '常温仓库', '2025-04-23', '365');
INSERT INTO `product` VALUES (112, 2016, '纯净水', '常温仓库', '2025-04-22', '365');
INSERT INTO `product` VALUES (111, 2015, '矿泉水', '常温仓库', '2025-04-21', '365');
INSERT INTO `product` VALUES (110, 2014, '山泉水', '常温仓库', '2025-04-20', '365');
INSERT INTO `product` VALUES (109, 2013, '矿物质水', '常温仓库', '2025-04-19', '365');
INSERT INTO `product` VALUES (108, 2012, '蒸馏水', '常温仓库', '2025-04-18', '365');
INSERT INTO `product` VALUES (107, 2011, '气泡水', '常温仓库', '2025-04-17', '365');
INSERT INTO `product` VALUES (106, 2010, '苏打水', '常温仓库', '2025-04-16', '365');
INSERT INTO `product` VALUES (105, 2009, '纯净水', '常温仓库', '2025-04-15', '365');
INSERT INTO `product` VALUES (104, 2008, '矿泉水', '常温仓库', '2025-04-14', '365');
INSERT INTO `product` VALUES (103, 2007, '山泉水', '常温仓库', '2025-04-13', '365');
INSERT INTO `product` VALUES (102, 2006, '矿物质水', '常温仓库', '2025-04-12', '365');
INSERT INTO `product` VALUES (101, 2005, '蒸馏水', '常温仓库', '2025-04-11', '365');
INSERT INTO `product` VALUES (100, 2004, '气泡水', '常温仓库', '2025-04-10', '365');
INSERT INTO `product` VALUES (99, 2003, '苏打水', '常温仓库', '2025-04-09', '365');
INSERT INTO `product` VALUES (98, 2002, '纯净水', '常温仓库', '2025-04-08', '365');
INSERT INTO `product` VALUES (97, 2001, '矿泉水', '常温仓库', '2025-04-07', '365');
INSERT INTO `product` VALUES (96, 1096, '冷冻鸡胸条', '冷冻仓库', '2025-04-06', '365');
INSERT INTO `product` VALUES (95, 1095, '冷冻鸡胸块', '冷冻仓库', '2025-04-05', '365');
INSERT INTO `product` VALUES (94, 1094, '冷冻鸡胸串', '冷冻仓库', '2025-04-04', '365');
INSERT INTO `product` VALUES (93, 1093, '冷冻鸡胸棒', '冷冻仓库', '2025-04-03', '365');
INSERT INTO `product` VALUES (92, 1092, '冷冻鸡胸卷', '冷冻仓库', '2025-04-02', '365');
INSERT INTO `product` VALUES (91, 1091, '冷冻鸡胸肠', '冷冻仓库', '2025-04-01', '365');
INSERT INTO `product` VALUES (90, 1090, '冷冻鸡胸饼', '冷冻仓库', '2025-03-31', '365');
INSERT INTO `product` VALUES (89, 1089, '冷冻鸡胸丸', '冷冻仓库', '2025-03-30', '365');
INSERT INTO `product` VALUES (88, 1088, '冷冻鸡胸馅', '冷冻仓库', '2025-03-29', '365');
INSERT INTO `product` VALUES (87, 1087, '冷冻鸡胸糜', '冷冻仓库', '2025-03-28', '365');
INSERT INTO `product` VALUES (86, 1086, '冷冻鸡胸丁', '冷冻仓库', '2025-03-27', '365');
INSERT INTO `product` VALUES (85, 1085, '冷冻鸡胸丝', '冷冻仓库', '2025-03-26', '365');
INSERT INTO `product` VALUES (84, 1084, '冷冻鸡胸片', '冷冻仓库', '2025-03-25', '365');
INSERT INTO `product` VALUES (83, 1083, '冷冻鸡胸条', '冷冻仓库', '2025-03-24', '365');
INSERT INTO `product` VALUES (82, 1082, '冷冻鸡胸块', '冷冻仓库', '2025-03-23', '365');
INSERT INTO `product` VALUES (81, 1081, '冷冻鸡胸串', '冷冻仓库', '2025-03-22', '365');
INSERT INTO `product` VALUES (80, 1080, '冷冻鸡胸棒', '冷冻仓库', '2025-03-21', '365');
INSERT INTO `product` VALUES (79, 1079, '冷冻鸡胸卷', '冷冻仓库', '2025-03-20', '365');
INSERT INTO `product` VALUES (78, 1078, '冷冻鸡胸肠', '冷冻仓库', '2025-03-19', '365');
INSERT INTO `product` VALUES (77, 1077, '冷冻鸡胸饼', '冷冻仓库', '2025-03-18', '365');
INSERT INTO `product` VALUES (76, 1076, '冷冻鸡胸丸', '冷冻仓库', '2025-03-17', '365');
INSERT INTO `product` VALUES (75, 1075, '冷冻鸡胸馅', '冷冻仓库', '2025-03-16', '365');
INSERT INTO `product` VALUES (74, 1074, '冷冻鸡胸糜', '冷冻仓库', '2025-03-15', '365');
INSERT INTO `product` VALUES (73, 1073, '冷冻鸡胸丁', '冷冻仓库', '2025-03-14', '365');
INSERT INTO `product` VALUES (72, 1072, '冷冻鸡胸丝', '冷冻仓库', '2025-03-13', '365');
INSERT INTO `product` VALUES (71, 1071, '冷冻鸡胸片', '冷冻仓库', '2025-03-12', '365');
INSERT INTO `product` VALUES (70, 1070, '冷冻鸡胸条', '冷冻仓库', '2025-03-11', '365');
INSERT INTO `product` VALUES (69, 1069, '冷冻鸡胸块', '冷冻仓库', '2025-03-10', '365');
INSERT INTO `product` VALUES (68, 1068, '冷冻鸡胸串', '冷冻仓库', '2025-03-09', '365');
INSERT INTO `product` VALUES (67, 1067, '冷冻鸡胸棒', '冷冻仓库', '2025-03-08', '365');
INSERT INTO `product` VALUES (66, 1066, '冷冻鸡胸卷', '冷冻仓库', '2025-03-07', '365');
INSERT INTO `product` VALUES (65, 1065, '冷冻鸡胸肠', '冷冻仓库', '2025-03-06', '365');
INSERT INTO `product` VALUES (64, 1064, '冷冻鸡胸饼', '冷冻仓库', '2025-03-05', '365');
INSERT INTO `product` VALUES (63, 1063, '冷冻鸡胸丸', '冷冻仓库', '2025-03-04', '365');
INSERT INTO `product` VALUES (62, 1062, '冷冻鸡胸馅', '冷冻仓库', '2025-03-03', '365');
INSERT INTO `product` VALUES (61, 1061, '冷冻鸡胸糜', '冷冻仓库', '2025-03-02', '365');
INSERT INTO `product` VALUES (60, 1060, '冷冻鸡胸丁', '冷冻仓库', '2025-03-01', '365');
INSERT INTO `product` VALUES (59, 1059, '冷冻鸡胸丝', '冷冻仓库', '2025-02-28', '365');
INSERT INTO `product` VALUES (58, 1058, '冷冻鸡胸片', '冷冻仓库', '2025-02-27', '365');
INSERT INTO `product` VALUES (57, 1057, '冷冻鸡胸条', '冷冻仓库', '2025-02-26', '365');
INSERT INTO `product` VALUES (56, 1056, '冷冻鸡胸块', '冷冻仓库', '2025-02-25', '365');
INSERT INTO `product` VALUES (55, 1055, '冷冻鸡胸串', '冷冻仓库', '2025-02-24', '365');
INSERT INTO `product` VALUES (54, 1054, '冷冻鸡胸棒', '冷冻仓库', '2025-02-23', '365');
INSERT INTO `product` VALUES (53, 1053, '冷冻鸡胸卷', '冷冻仓库', '2025-02-22', '365');
INSERT INTO `product` VALUES (52, 1052, '冷冻鸡胸肠', '冷冻仓库', '2025-02-21', '365');
INSERT INTO `product` VALUES (51, 1051, '冷冻鸡胸饼', '冷冻仓库', '2025-02-20', '365');
INSERT INTO `product` VALUES (50, 1050, '冷冻鸡胸丸', '冷冻仓库', '2025-02-19', '365');
INSERT INTO `product` VALUES (49, 1049, '冷冻鸡胸馅', '冷冻仓库', '2025-02-18', '365');
INSERT INTO `product` VALUES (48, 1048, '冷冻鸡胸糜', '冷冻仓库', '2025-02-17', '365');
INSERT INTO `product` VALUES (47, 1047, '冷冻鸡胸丁', '冷冻仓库', '2025-02-16', '365');
INSERT INTO `product` VALUES (46, 1046, '冷冻鸡胸丝', '冷冻仓库', '2025-02-15', '365');
INSERT INTO `product` VALUES (45, 1045, '冷冻鸡胸片', '冷冻仓库', '2025-02-14', '365');
INSERT INTO `product` VALUES (44, 1044, '冷冻鸡胸条', '冷冻仓库', '2025-02-13', '365');
INSERT INTO `product` VALUES (43, 1043, '冷冻鸡胸块', '冷冻仓库', '2025-02-12', '365');
INSERT INTO `product` VALUES (42, 1042, '冷冻鸡胸串', '冷冻仓库', '2025-02-11', '365');
INSERT INTO `product` VALUES (41, 1041, '冷冻鸡胸棒', '冷冻仓库', '2025-02-10', '365');
INSERT INTO `product` VALUES (40, 1040, '冷冻鸡胸卷', '冷冻仓库', '2025-02-09', '365');
INSERT INTO `product` VALUES (39, 1039, '冷冻鸡胸肠', '冷冻仓库', '2025-02-08', '365');
INSERT INTO `product` VALUES (38, 1038, '冷冻鸡胸饼', '冷冻仓库', '2025-02-07', '365');
INSERT INTO `product` VALUES (37, 1037, '冷冻鸡胸丸', '冷冻仓库', '2025-02-06', '365');
INSERT INTO `product` VALUES (36, 1036, '冷冻鸡胸馅', '冷冻仓库', '2025-02-05', '365');
INSERT INTO `product` VALUES (35, 1035, '冷冻鸡胸糜', '冷冻仓库', '2025-02-04', '365');
INSERT INTO `product` VALUES (34, 1034, '冷冻鸡胸片', '冷冻仓库', '2025-02-03', '365');
INSERT INTO `product` VALUES (33, 1033, '冷冻鸡胸丁', '冷冻仓库', '2025-02-02', '365');
INSERT INTO `product` VALUES (32, 1032, '冷冻鸡胸丝', '冷冻仓库', '2025-02-01', '365');
INSERT INTO `product` VALUES (31, 1031, '冷冻鸡胸块', '冷冻仓库', '2025-01-31', '365');
INSERT INTO `product` VALUES (30, 1030, '冷冻鸡胸条', '冷冻仓库', '2025-01-30', '365');
INSERT INTO `product` VALUES (29, 1029, '冷冻鸡胸排', '冷冻仓库', '2025-01-29', '365');
INSERT INTO `product` VALUES (28, 1028, '冷冻鸡全翅', '冷冻仓库', '2025-01-28', '365');
INSERT INTO `product` VALUES (27, 1027, '冷冻鸡全腿', '冷冻仓库', '2025-01-27', '365');
INSERT INTO `product` VALUES (26, 1026, '冷冻鸡小腿', '冷冻仓库', '2025-01-26', '365');
INSERT INTO `product` VALUES (25, 1025, '冷冻鸡大腿', '冷冻仓库', '2025-01-25', '365');
INSERT INTO `product` VALUES (24, 1024, '冷冻鸡翅中', '冷冻仓库', '2025-01-24', '365');
INSERT INTO `product` VALUES (23, 1023, '冷冻鸡翅根', '冷冻仓库', '2025-01-23', '365');
INSERT INTO `product` VALUES (22, 1022, '冷冻鸡架', '冷冻仓库', '2025-01-22', '365');
INSERT INTO `product` VALUES (21, 1021, '冷冻鸡脖', '冷冻仓库', '2025-01-21', '365');
INSERT INTO `product` VALUES (20, 1020, '冷冻鸡爪', '冷冻仓库', '2025-01-20', '365');
INSERT INTO `product` VALUES (19, 1019, '冷冻鸡胗', '冷冻仓库', '2025-01-19', '365');
INSERT INTO `product` VALUES (18, 1018, '冷冻鸡心', '冷冻仓库', '2025-01-18', '365');
INSERT INTO `product` VALUES (17, 1017, '冷冻鸭肝', '冷冻仓库', '2025-01-17', '365');
INSERT INTO `product` VALUES (16, 1016, '冷冻鹅肝', '冷冻仓库', '2025-01-16', '365');
INSERT INTO `product` VALUES (15, 1015, '冷冻火鸡', '冷冻仓库', '2025-01-15', '365');
INSERT INTO `product` VALUES (14, 1014, '冷冻鹌鹑', '冷冻仓库', '2025-01-14', '365');
INSERT INTO `product` VALUES (13, 1013, '冷冻鸽子', '冷冻仓库', '2025-01-13', '365');
INSERT INTO `product` VALUES (12, 1012, '冷冻鹿肉', '冷冻仓库', '2025-01-12', '365');
INSERT INTO `product` VALUES (11, 1011, '冷冻兔肉', '冷冻仓库', '2025-01-11', '365');
INSERT INTO `product` VALUES (10, 1010, '冷冻鹅肉', '冷冻仓库', '2024-08-21', '365');
INSERT INTO `product` VALUES (9, 1009, '冷冻鸭肉', '冷冻仓库', '2024-08-20', '365');
INSERT INTO `product` VALUES (8, 1008, '冷冻羊肉', '冷冻仓库', '2024-08-19', '365');
INSERT INTO `product` VALUES (7, 1007, '冷冻牛肉', '冷冻仓库', '2025-01-07', '365');
INSERT INTO `product` VALUES (6, 1006, '冷冻猪肉', '冷冻仓库', '2025-01-06', '365');
INSERT INTO `product` VALUES (5, 1005, '冷冻鸡胸肉', '冷冻仓库', '2025-01-05', '365');
INSERT INTO `product` VALUES (4, 1004, '冷冻鸡腿', '冷冻仓库', '2025-01-04', '365');
INSERT INTO `product` VALUES (3, 1003, '冷冻鸡翅', '冷冻仓库', '2025-01-03', '365');
INSERT INTO `product` VALUES (2, 1002, '冷冻羊排', '冷冻仓库', '2025-08-16', '365');
INSERT INTO `product` VALUES (1, 1001, '冷冻牛排', '冷冻仓库', '2024-01-01', '365');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userPrimaryKey` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`userPrimaryKey` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10, 'u', 'u');
INSERT INTO `user` VALUES (9, '9', 'Y');
INSERT INTO `user` VALUES (8, '2', '0');
INSERT INTO `user` VALUES (7, '1', '1');
INSERT INTO `user` VALUES (5, '崔振宇', '5555');
INSERT INTO `user` VALUES (4, '黎子瑶', '4444');
INSERT INTO `user` VALUES (3, '周华南', '3333');
INSERT INTO `user` VALUES (2, '韩成準', '2222');
INSERT INTO `user` VALUES (1, '翟祖一', '1111');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `wareHousePrimaryKey` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `wareHouseId` int NULL DEFAULT NULL COMMENT '仓库编号',
  `wareHouseName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库名称',
  `wareHouseCapacity` int NULL DEFAULT NULL COMMENT '仓库容量',
  `wareHouseAddress` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库地址',
  PRIMARY KEY (`wareHousePrimaryKey` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (33, 202, '仙丹仓库', 10000, '海南');
INSERT INTO `warehouse` VALUES (32, 202, '喵咪仓库', 7000, '海南');
INSERT INTO `warehouse` VALUES (31, 202, '这是仓库', 100000, '海南');
INSERT INTO `warehouse` VALUES (30, 202, 'good', 10000, '海南');
INSERT INTO `warehouse` VALUES (28, 404, '是仓库啊', 90000, '海南');
INSERT INTO `warehouse` VALUES (27, 202, '狗狗仓库', 90000, '伊黎');
INSERT INTO `warehouse` VALUES (26, 404, '崔振宇仓库', 20000, '18期');
INSERT INTO `warehouse` VALUES (25, 308, '大葱仓库', 100000, '某地');
INSERT INTO `warehouse` VALUES (24, 307, '蟠桃仓库', 88888, '天庭');
INSERT INTO `warehouse` VALUES (23, 306, '水产仓库6', 38000, '广东省深圳市');
INSERT INTO `warehouse` VALUES (22, 305, '水产仓库5', 35000, '广东省广州市');
INSERT INTO `warehouse` VALUES (21, 304, '水产仓库4', 32000, '福建省福州市');
INSERT INTO `warehouse` VALUES (20, 303, '水产仓库3', 30000, '福建省厦门市');
INSERT INTO `warehouse` VALUES (19, 302, '水产仓库2', 28000, '山东省烟台市');
INSERT INTO `warehouse` VALUES (18, 301, '水产仓库1', 25000, '山东省青岛市');
INSERT INTO `warehouse` VALUES (17, 209, '常温仓库9', 50000, '浙江省杭州市');
INSERT INTO `warehouse` VALUES (16, 208, '常温仓库8', 48000, '江苏省苏州市');
INSERT INTO `warehouse` VALUES (15, 207, '常温仓库7', 45000, '江苏省南京市');
INSERT INTO `warehouse` VALUES (14, 206, '常温仓库6', 42000, '上海市闵行区');
INSERT INTO `warehouse` VALUES (13, 205, '常温仓库5', 40000, '上海市浦东新区');
INSERT INTO `warehouse` VALUES (12, 204, '常温仓库4', 38000, '天津市河西区');
INSERT INTO `warehouse` VALUES (11, 203, '常温仓库3', 35000, '天津市南开区');
INSERT INTO `warehouse` VALUES (10, 202, '常温仓库2', 32000, '北京市海淀区');
INSERT INTO `warehouse` VALUES (9, 201, '常温仓库1', 30000, '北京市朝阳区');
INSERT INTO `warehouse` VALUES (8, 108, '冷冻仓库8', 28000, '河北省唐山市');
INSERT INTO `warehouse` VALUES (7, 107, '冷冻仓库7', 25000, '河北省石家庄市');
INSERT INTO `warehouse` VALUES (6, 106, '冷冻仓库6', 22000, '黑龙江省齐齐哈尔市');
INSERT INTO `warehouse` VALUES (5, 105, '冷冻仓库5', 20000, '黑龙江省哈尔滨市');
INSERT INTO `warehouse` VALUES (4, 104, '冷冻仓库4', 18000, '辽宁省大连市');
INSERT INTO `warehouse` VALUES (3, 103, '冷冻仓库3', 15000, '辽宁省沈阳市');
INSERT INTO `warehouse` VALUES (2, 102, '冷冻仓库2', 12000, '吉林省吉林市');
INSERT INTO `warehouse` VALUES (1, 101, '冷冻仓库1', 10000, '吉林省长春市');

SET FOREIGN_KEY_CHECKS = 1;
