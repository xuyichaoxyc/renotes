[TOC]

# MySQL

## SQL

### 数据库

### 表

### 列和数据类型

### 行

### 主键



## MySQL

### 客户机-服务器软件

### 相关命令



## 数据查询

### select 语句

```sql
select

from

where

group by

having

order by

limit
```

### 限制结果

#### Limit

```sql
# MySQL 返回不多于 5 行
limit 5;

# 返回从行 5 开始的 5 行；开始位置，欲检索行数
limit 5, 5;

# 行0 检索出来的第一行为行0而不是行1。
# 在行数不够时 LIMIT中指定要检索的行数为检索的最大行数。如果没有足够的行，MySQL将只返回它能返回的那么多行。

# 从行 3 开始取 4 行
LIMIT 4 OFFSET 3；
```

#### Distinct

```mysql
# Distinct
# 只返回不同（唯一）的 xxx 行，必须直接放到列名前面
select DISTINCT xxx

```



### 排序结果

```sql
# 默认 ASC-升序，DESC-降序必须显示说明
# 可以多个字段排序，按生命顺序，一个管一个
order by column1 ASC, column2 DESC
```

### 过滤数据——where

#### 条件操作符

+ =：等于
+ <>：不等于
+ !=：不等于
+ <：小于
+ <=：小于等于
+ \> ：大于
+ \>=：大于等于
+ BETWEEN：在指定的两个值之间

```mysql
between 8 and 10
```



#### 空值检查

+ is NULL
+ is not NULL

```mysql
is null
is not null
```



#### IN

```mysql
a IN (1002, 1003)
a = 1002 or a = 1003
```

#### NOT

```mysql
in
between
exists
```



#### LIKE

通配符：

+ %：任意字符出现任意字数
+ _：任意字符出现单次
+ 

```mysql

```



#### 正则表达式

REGEXP '^[0-9\\\\.]'



### 计算字段、数据处理函数

### 聚合函数

### 分组

### 子查询

### 连结

#### 内部连结 inner join

+ 自联结
+ 自然联结

#### 外部联结 outer join

+ left outer join
+ right outer join

### 组合查询 UNION

### 全文本搜索



## 数据插入

```mysql
insert into tablename
values(val1, val2, val3);

insert into tablename(column1, column2, column3)
values(val1, val2, val3);

insert into tablename(column1, column2, column3)
values(val1, val2, val3),
values(val1, val2, val3);

insert into tablename(column1, column2, column3)
select column1, column2, column3
from tablename2;
```





## 数据更新

```mysql
update tablename
set column1 = value1
where column2 = value2;


update tablename
set column1 = value1,
	column3 = value3
where column2 = value2;
```



## 数据删除

```mysql
delete from tablename
where 
```

# 面试



## 知识图谱

![avatar](MySQL.assets/FlqFD5y4TdeIkkprs1ZefqfmzUKZ-1622814291868)

## 通用模块

MySQL 整体概念、执行流程、数据库引擎、查询缓存、表空间、回表查询、数据类型间的区别、内存表、临时表、删除表的n种方式、枚举、视图、数据恢复

## 索引模块



## 事务模块

## 锁

全局锁

表锁

行锁

死锁

乐观锁

悲观锁

## 日志

MySQL主备同步和容灾恢复以及问题排除的关键



## MySQL操作命令和内置函数

用户和权限的创建

数据库相关信息的查询

内置函数

## 性能优化和分布式

性能优化包括了慢查询的分析和处理



## 开放式问题

