[TOC]

# Linux学习路线图

## 初级阶段

	+ 了解Linux多种安装方式（光驱安装、U盘安装、硬盘安装）
	+ 熟练掌握Linux常见命令（常见命令约80个）
	+ 熟练掌握Linux软件包安装方法（源码安装、rpm方式安装、yum安装）
	+ 熟练掌握Linux系统结构及运行原理
	+ 掌握 vi、shell 别名、管道、I/O、重定向、输入和输出以及 shell 简单脚本编程
	+ Linux环境下的网络基本组建

## 中级阶段

+ 能够熟练搭建各种常见服务器（Web Apache/Nginx/DNS/MySQL）
+ 熟悉网络安全并能配置服务器安全策略（iptables/Selinux）
+ 熟悉并掌握Linux下磁盘存储管理器、用户权限管理、内存管理、文件系统管理、进程管理等机制
+ 熟练掌握系统故障排查方法并熟悉系统调优策略

## 高级阶段

+ 能够熟练搭建各种常见服务器（Web Apache/Nginx/DNS/MySQL）
+ 掌握一门Linux编程语言（Shell、Python、PHP）
+ 熟悉并能够熟练应用Linux下多种集群架构（LVS/HAProxy/keepalived/Heartbeat）
+ 熟悉并能够阅读内核源码及定制Linux内核



# Linux命令

## shell

### shell命令格式——命令行

```shell
command [options] [arguments]
# command：命令的名称
# options：命令的选项
# arguments：命令的参数
```

+ 选项是包含一个或多个字母的代码，主要用于改变命令的执行方式。一般在选项前面有一个**"-"**符号
+ 多个选项可以在**"-"**后面 一起列出来（ls -a -l    ls -al）
+ 在一行中输入多个命令，每个命令用分号分隔**(;)**
+ 在多行中输入一个命令，用**"\\"**将命令持续到下一行

### shell的通配符

+ **"*"** ——匹配任意一个或多个字符
+ **"?"** ——匹配任意单一字符
+ **"[]"** ——匹配任意包含在方括号中的单字符

### shell的重定向

Linux系统下打开的3个文件：标准输入、标准输出和标准错误输出

标准输入——用户键盘、标准输出和标准错误输出——屏幕

重定向：不使用系统默认的标准输入/输出，而是重新指定

输入重定向、输出重定向和错误输出重定向

输入重定向操作符——（<、<<）

输出重定向操作符——（>、>>）

错误重定向操作符——（>、>>）



### shell的管道

管道可以将很多命令连接起来，可以把第一个命令的输出当作第二个命令的输入，第二个命令的输出当作第三个命令的输入，以此类推。

管道作用：把一个命令的输出当作下一个命令的输入



管道符：**"|"**

### shell的引用

引用的作用就是忽略特殊字符的特殊含义，将特殊字符当成普通字符处理

+ **"\\"**
+ **" \' "**
+ **" \" "**

### shell的自动补全（Tab键）

## shell命令

### 系统管理与维护

#### ls

#### pwd

#### cd

#### date

#### passwd

#### su

#### clear

#### man

#### who

#### w

#### uname

#### uptime

#### last

#### dmesg

#### free

#### ps

#### top

### 文件管理与编辑

#### mkdir

#### more

#### cat

#### diff

#### grep

#### rm

#### touch

#### ln

#### file

#### cp

#### find

#### split

#### mv

### 压缩与解压

#### zip/uzip

#### gzip/gunzip

#### bzip2/bunzip2

#### tar

#### dd

#### cpio

### 磁盘管理与维护

#### df

#### du

#### fsck

#### sync

#### eject

#### mount/umount



### 网络设置与维护

#### ifconfig

#### scp

#### netstat

#### traceroute

#### telnet

#### wget



### 文本编辑工具vi

# Linux 下软件的安装与管理

## 源码安装方式

## RPM包方式安装

## yum安装方式

## 二进制安装方式



# Linux服务器网络配置

## 网卡驱动的安装

### 网卡驱动安装的一般思路

### 编译安装网卡

## 配置Linux网络

### 不同Linux发行版的网络配置文件

### 网络配置文件详解

## Linux网络应用

### Linux下的IP别名功能

### 开启Linux代理转发功能

### 路由的概念与配置

### Linux路由器的架设



# 架设Linux服务器

## 使用OpenSSH远程管理Linux服务器

## Web服务器的搭建

### Apache与Tomcat整合的必要性

### Apache和Tomcat连接器

### Apache与Tomcat以及JK模块的安装

### Apache与Tomcat整合配置

## LAMP服务器的搭建

### LAMP与WordPress概述

### LAMP服务环境的搭建

### 测试LAMP环境安装的正确性

## DNS服务器的搭建

### DNS服务器概述

### DNS服务器的搭建

## Samba服务器的搭建

### Samba的概念与功能

### Samba的安装与配置



# 构建高性能的MySQL数据库系统

## MySQL与MariaDB

## 常见的高可用MySQL解决方案

### 主从复制解决方案

### MMM高可用解决方案

### Heartbeat/SAN高可用解决方案

### Heartbeat/DRBD高可用解决方案

### MySQL Cluster高可用解决方案

## 通过Keepalived搭建MySQL双主模式的高可用集群系统

### MySQL复制

### MySQL复制的实现原理

### MySQL复制的常用架构

### MySQL主主互备模式配置

### 配置keepalived实现MySQL双主高可用

### 测试MySQL主从同步功能

### 测试Keepalived实现MySQL故障切换

## 通过MMM构建MySQL高可用集群系统

### MMM高可用MySQL方案简介

### MMM典型应用方案

### MMM高可用MySQL方案架构图

### MMM的安装与配置

### MMM的管理

### 测试MMM实现MySQL高可用功能

## MySQL读、写分离解决方案

### 常见的MySQL读、写分离方案

### 通过Amoeba实现MySQL读、写分离

# Linux服务器安全策略

## 网络安全概述

### 常见攻击类型

### 防范攻击策略

## 操作系统常用安全策略

### 软件的升级

### 端口与服务

### 密码登录安全

### 其他安全设置

## Linux软件防火墙iptables

### iptables的使用环境

### iptables的使用规则与语法

### 防火墙规则的查看与清除

### 制定防火墙规则

## Linux系统的备份

### Linux系统备份

### Linux系统需要备份的数据

### 备份的介质与方式

### 制定备份策略

### 备份工具的选择

# Linux故障排查思路与案例

## Linux下常见系统过账的处理

### 处理Linux系统故障的思路

### 忘记Linux root密码

### Linux系统无法启动的解决办法

## Linux下常见网络故障处理

## “Read-only file system”错误与解决案例

## 通过su命令切换用户带来的困惑

## 因NAS存储故障引起的Linux系统恢复案例

### 故障现象描述

### 问题判断思路

### 问题处理过程

### 解决问题

# Linux用户权限管理

## 用户与用户组管理概述

### 用户与组的概念

### 用户配置文件概述

## 用户管理工具介绍

### groupadd/newgrp/groupdel命令

### useradd/usermod/userdel命令

## 文件与权限的设定

### 查看文件的权限属性

### 利用chown改变属主和属组

### 利用chmod改变访问权限

# Linux磁盘存储管理

## 磁盘管理的基本概念

### 磁盘设备在Linux下的表示方法

### 设备的挂载与使用

### 磁盘分区的划分标准

## 利用fdisk工具划分磁盘分区

### fdisk参数含义介绍

### fdisk实例讲解

## 利用parted工具规划磁盘分区

### parted简介

### parted使用方法

### parted应用实例

## LVM

### LVM的基本概念

### LVM中的术语

### 安装LVM工具

### LVM的创建与管理



# Linux文件系统管理

## Linux文件系统概述

### 什么是文件系统

### 为什么要使用文件系统

### 文件系统的使用流程

## Linux下常用文件系统介绍

### ext3和ext4文件系统

### ReiserFS

### XFS

## 选择文件系统的标准

## NFS的使用

### NFS简介

### NFS的实现原理

### NFS的安装与配置

## Linux下常用的数据恢复工具

### 如何使用"rm -rf"命令

### extundelete与ext3grep的异同

### extundelete的恢复原理

### 安装extundelete

### extundelete用法详解

### 通过extundelete恢复数据的过程

# Linux内存管理

## 物理内存和虚拟内存

## 内存的监控

## 交换空间的使用

## 查看进程占用内存



# Linux系统进程管理

## 进程的概念与分类

## 进程的监控与管理

### 利用ps命令监控系统进程

### 利用pstree监控系统进程

### 利用top监控系统进程

### 利用lsof监控系统进程与程序

### 利用pgrep查询进程ID

## 任务调度进程crond的使用

### crond简介

### crontab工具的使用

### 使用crontab工具的注意事项

## 用kill和killall终止进程

### 用kill终止进程

### 用killall终止进程



# Linux系统优化思路

## 性能问题综述

## 影响Linux性能的因素

### 系统硬件资源

### 操作系统相关资源

### 应用程序软件资源

## 分析系统性能涉及的人员

### Linux运维人员

### 系统架构设计人员

### 软件开发人员

## 系统性能分析工具

## 系统性能分析标准

## 总结

# Linux系统性能与优化案例