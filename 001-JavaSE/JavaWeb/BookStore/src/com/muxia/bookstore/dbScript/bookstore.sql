SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `bookName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `price` double(5, 2) NULL DEFAULT NULL,
  `saleCount` int NULL DEFAULT NULL,
  `bookCount` int NULL DEFAULT NULL,
  `bookImg` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `bookName`(`bookName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'C语言入门经典', '亚历山大', 99.00, 8, 197, 'cyuyanrumenjingdian.jpg', NULL);
INSERT INTO `t_book` VALUES (2, '三体', '周杰伦', 48.95, 18, 892, 'santi.jpg', NULL);
INSERT INTO `t_book` VALUES (3, '艾伦图灵传', '刘若英', 50.00, 12, 143, 'ailuntulingzhuan.jpg', NULL);
INSERT INTO `t_book` VALUES (4, '百年孤独', '王力宏', 40.00, 3, 98, 'bainiangudu.jpg', NULL);
INSERT INTO `t_book` VALUES (5, '边城', '刘德华', 30.00, 2, 99, 'biancheng.jpg', NULL);
INSERT INTO `t_book` VALUES (6, '解忧杂货店', '东野圭吾', 27.00, 5, 100, 'jieyouzahuodian.jpg', NULL);
INSERT INTO `t_book` VALUES (7, '中国哲学史', '冯友兰', 45.00, 3, 100, 'zhongguozhexueshi.jpg', NULL);
INSERT INTO `t_book` VALUES (8, '忽然七日', '劳伦', 19.00, 50, 200, 'huranqiri.jpg', NULL);
INSERT INTO `t_book` VALUES (9, '苏东坡传', '林语堂', 20.00, 50, 300, 'sudongpozhuan.jpg', NULL);
INSERT INTO `t_book` VALUES (10, '扶桑', '严歌岑', 20.00, 10, 89, 'fusang.jpg', NULL);
INSERT INTO `t_book` VALUES (11, '给孩子的诗', '北岛', 23.00, 5, 99, 'geihaizideshi.jpg', NULL);

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `book` int NOT NULL,
                           `bookName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `price` double NOT NULL,
                           `buyCount` int NULL DEFAULT NULL,
                           `user` int NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `PK_cart_book`(`book`) USING BTREE,
                           INDEX `PK_cart_user`(`user`) USING BTREE,
                           CONSTRAINT `PK_cart_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                           CONSTRAINT `PK_cart_user` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cart
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `orderNo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `orderDate` datetime NOT NULL,
                            `orderMoney` double NULL DEFAULT NULL,
                            `orderCount` int NULL DEFAULT NULL,
                            `orderStatus` tinyint NULL DEFAULT NULL,
                            `user` int NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE INDEX `orderNo`(`orderNo`) USING BTREE,
                            INDEX `PK_order_user`(`user`) USING BTREE,
                            CONSTRAINT `PK_order_user` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail`  (
                                   `id` int NOT NULL AUTO_INCREMENT,
                                   `book` int NULL DEFAULT NULL,
                                   `bookName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                   `price` double NOT NULL,
                                   `buyCount` int NULL DEFAULT NULL,
                                   `orderBean` int NULL DEFAULT NULL,
                                   PRIMARY KEY (`id`) USING BTREE,
                                   INDEX `PK_order_detail_book`(`book`) USING BTREE,
                                   INDEX `PK_order_detail_order`(`orderBean`) USING BTREE,
                                   CONSTRAINT `PK_order_detail_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                   CONSTRAINT `PK_order_detail_order` FOREIGN KEY (`orderBean`) REFERENCES `t_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           `role` tinyint NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'lina', 'ok', 'lina@126.com', 0);
INSERT INTO `t_user` VALUES (2, 'rose', 'ok', 'rose@sina.com.cn', 1);

SET FOREIGN_KEY_CHECKS = 1;