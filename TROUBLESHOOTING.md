# 仓库管理系统故障排除指南

## 问题描述
显示"当前是第[1/0]页"，说明总页数为0，没有查询到数据库数据。

## 可能的原因和解决方案

### 1. 数据库连接问题
**症状**: 程序无法连接到数据库
**检查步骤**:
1. 确保MySQL服务正在运行
2. 检查数据库连接配置（DBHelper.java中的配置）
3. 运行DatabaseTest.java测试数据库连接

**解决方案**:
- 启动MySQL服务
- 检查数据库名称、用户名、密码是否正确
- 确保端口3306开放

### 2. 数据库中没有数据
**症状**: 数据库连接正常，但查询结果为0
**检查步骤**:
1. 使用MySQL客户端连接数据库
2. 执行SQL查询：`SELECT COUNT(*) FROM warehouse;`
3. 检查warehouse表是否存在数据

**解决方案**:
- 如果表为空，添加测试数据
- 检查表结构是否正确

### 3. 查询条件过于严格
**症状**: 有数据但查询条件不匹配
**检查步骤**:
1. 检查用户输入的查询条件
2. 查看SQL查询语句是否正确生成
3. 使用DatabaseTest.java测试不同查询条件

**解决方案**:
- 放宽查询条件
- 检查SQL语句生成逻辑

### 4. 分页逻辑问题
**症状**: 有数据但分页显示异常
**检查步骤**:
1. 检查PageHelper类的分页计算逻辑
2. 验证总记录数和每页显示数量的设置

**解决方案**:
- 已修复PageHelper.java中的分页逻辑
- 确保在没有数据时总页数至少为1

## 测试步骤

### 步骤1: 运行数据库测试
```bash
javac -cp "lib/*" src/cn/jiruan/Main/DatabaseTest.java
java -cp "lib/*:src" cn.jiruan.Main.DatabaseTest
```

### 步骤2: 检查输出
- 数据库连接状态
- 仓库表记录数
- 分页计算是否正确

### 步骤3: 运行主程序
```bash
javac -cp "lib/*" src/cn/jiruan/Main/Main.java
java -cp "lib/*:src" cn.jiruan.Main.Main
```

## 常见错误和修复

### 错误1: 数据库连接失败
```
数据库连接失败！错误信息：
java.sql.SQLException: Access denied for user 'root'@'localhost'
```
**修复**: 检查MySQL用户名和密码

### 错误2: 表不存在
```
java.sql.SQLException: Table 'jiruan.warehouse' doesn't exist
```
**修复**: 创建warehouse表或检查表名拼写

### 错误3: 字段不存在
```
java.sql.SQLException: Unknown column 'warehouseName' in 'field list'
```
**修复**: 检查表结构和字段名

## 数据库表结构参考

warehouse表应该包含以下字段：
- warehousePrimaryKey (主键)
- warehouseId (仓库编号)
- warehouseName (仓库名称)
- warehouseCapacity (仓库容量)
- warehouseAddress (仓库地址)

## 联系支持
如果问题仍然存在，请提供：
1. 错误信息截图
2. 数据库连接配置
3. 数据库表结构
4. 程序运行日志 