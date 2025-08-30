-- 仓库管理系统数据库设置脚本
-- 请确保MySQL服务已启动，并使用root用户执行

-- 1. 创建数据库
CREATE DATABASE IF NOT EXISTS jiruan CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 2. 使用数据库
USE jiruan;

-- 3. 创建仓库表
CREATE TABLE IF NOT EXISTS warehouse (
    warehousePrimaryKey INT AUTO_INCREMENT PRIMARY KEY,
    warehouseId INT NOT NULL UNIQUE,
    warehouseName VARCHAR(100) NOT NULL,
    warehouseCapacity INT NOT NULL,
    warehouseAddress VARCHAR(200) NOT NULL
);

-- 4. 创建产品表
CREATE TABLE IF NOT EXISTS product (
    productPrimaryKey INT AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL UNIQUE,
    productName VARCHAR(100) NOT NULL,
    productType VARCHAR(50) NOT NULL,
    productPrice DECIMAL(10,2) NOT NULL
);

-- 5. 创建库存表
CREATE TABLE IF NOT EXISTS inventory (
    inventoryPrimaryKey INT AUTO_INCREMENT PRIMARY KEY,
    inventoryId INT NOT NULL UNIQUE,
    inventoryType VARCHAR(50) NOT NULL,
    inventoryAllCapacity INT NOT NULL,
    inventoryUseCapacity INT NOT NULL,
    inventoryWarnCapacity INT NOT NULL,
    warehousePrimaryKey INT NOT NULL,
    FOREIGN KEY (warehousePrimaryKey) REFERENCES warehouse(warehousePrimaryKey)
);

-- 6. 创建用户表
CREATE TABLE IF NOT EXISTS user (
    userPrimaryKey INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL UNIQUE,
    userName VARCHAR(50) NOT NULL,
    userPassword VARCHAR(100) NOT NULL,
    userType VARCHAR(20) NOT NULL
);

-- 7. 创建产品库存关联表
CREATE TABLE IF NOT EXISTS plinki (
    plinkIPrimaryKey INT AUTO_INCREMENT PRIMARY KEY,
    productPrimaryKey INT NOT NULL,
    inventoryPrimaryKey INT NOT NULL,
    FOREIGN KEY (productPrimaryKey) REFERENCES product(productPrimaryKey),
    FOREIGN KEY (inventoryPrimaryKey) REFERENCES inventory(inventoryPrimaryKey)
);

-- 8. 创建产品仓库关联表
CREATE TABLE IF NOT EXISTS plinkw (
    plinkWPrimaryKey INT AUTO_INCREMENT PRIMARY KEY,
    productPrimaryKey INT NOT NULL,
    warehousePrimaryKey INT NOT NULL,
    FOREIGN KEY (productPrimaryKey) REFERENCES product(productPrimaryKey),
    FOREIGN KEY (warehousePrimaryKey) REFERENCES warehouse(warehousePrimaryKey)
);

-- 9. 插入测试数据

-- 插入仓库数据
INSERT INTO warehouse (warehouseId, warehouseName, warehouseCapacity, warehouseAddress) VALUES
(1001, '主仓库A', 1000, '北京市朝阳区仓库路1号'),
(1002, '冷冻仓库B', 800, '上海市浦东新区冷冻路2号'),
(1003, '水产仓库C', 600, '广州市天河区水产路3号'),
(1004, '常温仓库D', 1200, '深圳市南山区常温路4号');

-- 插入产品数据
INSERT INTO product (productId, productName, productType, productPrice) VALUES
(2001, '苹果', '水果', 5.50),
(2002, '牛奶', '乳制品', 8.00),
(2003, '三文鱼', '海鲜', 45.00),
(2004, '面包', '烘焙', 3.50);

-- 插入库存数据
INSERT INTO inventory (inventoryId, inventoryType, inventoryAllCapacity, inventoryUseCapacity, inventoryWarnCapacity, warehousePrimaryKey) VALUES
(3001, '常温仓库', 500, 200, 100, 1),
(3002, '冷冻仓库', 400, 150, 80, 2),
(3003, '水产仓库', 300, 120, 60, 3),
(3004, '常温仓库', 600, 300, 150, 4);

-- 插入用户数据
INSERT INTO user (userId, userName, userPassword, userType) VALUES
(1, 'admin', 'admin123', '管理员'),
(2, 'user1', 'user123', '普通用户');

-- 10. 验证数据
SELECT '=== 仓库数据 ===' as info;
SELECT * FROM warehouse;

SELECT '=== 产品数据 ===' as info;
SELECT * FROM product;

SELECT '=== 库存数据 ===' as info;
SELECT * FROM inventory;

SELECT '=== 用户数据 ===' as info;
SELECT * FROM user;

-- 11. 检查表结构
SELECT '=== 表结构信息 ===' as info;
SHOW TABLES;

-- 12. 检查数据统计
SELECT '=== 数据统计 ===' as info;
SELECT 
    'warehouse' as table_name,
    COUNT(*) as record_count
FROM warehouse
UNION ALL
SELECT 
    'product' as table_name,
    COUNT(*) as record_count
FROM product
UNION ALL
SELECT 
    'inventory' as table_name,
    COUNT(*) as record_count
FROM inventory
UNION ALL
SELECT 
    'user' as table_name,
    COUNT(*) as record_count
FROM user; 