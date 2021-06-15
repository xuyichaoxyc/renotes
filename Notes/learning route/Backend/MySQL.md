[TOC]

# MySQL 登录

```mys
mysql -u 用户名 -p -h 主机名 -P 端口号
```

# 选择数据库，了解数据库和表

```mysql
USE databasename;

# 返回可用数据库的一个列表
SHOW DATABASES;

# 返回当前选择的数据库内可用表的列表
SHOW TABLES;


# 显示表列
SHOW COLUMNS FROM tablename;

# SHOW COLUMNS FROM tablename;的快捷方式
DESCRIBE tablename;

# 显示广泛的服务器状态信息
SHOW STATUS;

# 显示创建特定数据库或表的MySQL语句
SHOW CREATE DATABASE;
SHOW CREATE TABLE;

# 显示授予用户（所有用户或特定用户）的安全权限
SHOW GRANTS;

# 显示服务器错误或警告消息
SHOW ERRORS;
SHOW WARNINGS;
```



# 检索数据

```mysql
# 检索单个列
select column_name from tablename;

# 检索多个列
select column_name1, column_name2, column_name3 from tablename;

# 检索所有列
select * from tablename;

# 检索不同的行，应用于所有行
select distinct column_name from tablename;

# 限制结果
select column_name from tablename limit 5;
select column_name from tablename limit 5, 5;

# 全限定表名
select tablename.column_name from tablename;


```



# 排序检索数据

```mysql
# order by 子句
select column_name
from tablename
order by column_name;

# 多个列排序
select column_name1, column_name2, column_name3
from tablename
order by column_name2, column_name3;

# 指定排序方向，默认升序 ASC，降序 DESC 需指定，z
select column_name
from tablename
order by column_name DESC;


```

