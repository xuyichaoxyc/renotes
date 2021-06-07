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



# Linux系统基本结构

## 系统与硬件

### Linux硬件资源管理

#### 查看系统PCI设备

**lspci：**列出所有的pci设备，比如主板、声卡、显卡和网卡等，也会把usb接口设备列出来

**lspci -v：**查看更详细的PCI设备信息

#### 查看CPU信息

**more /proc/cpuinfo**

processor：逻辑处理器的唯一标识符

vendor-id：处理器类型（GenuineIntel，英特尔处理器）

physical id：每个物理封装的唯一标识符，也就是一个物理CPU

siblings：位于相同物理封装中的逻辑处理器的数量

core id：每个内核的唯一标识符

cpu cores：位于相同物理封装中的内核数量

siblings 和 cpu cores值之间的对应关系：

如果 siblings 是 cpu cores的两倍，说明系统支持超线程，且超线程已打开；

如果 siblings 和 cpu cores一致，则说明系统不支持超线程，或超线程未打开

查看系统物理CPU的个数：

**cat /proc/cpuinfo | grep "physical id" | sort | uniq | wc -l**

查看每个物理CPU中内核的个数：

**cat /proc/cpuinfo | grep "cpu coreds"**

查看系统所有逻辑CPU个数

**cat /proc/cpuinfo | grep "processor" | wc -l**



#### 查看系统内存信息

**more /proc/meminfo**

#### 查看磁盘分区信息

**fdisk -l**



### Linux外在设备的使用

在Linux 下，如软盘、U盘、光驱和磁带等外在设备都需要通过挂载方式才能使用

#### 硬件与设备文件

设备文件：硬件与系统下相对应的文件

设备文件在外部设备与操作系统之间提供了一个接口，用户使用外在设备就相当于使用普通文件一样

设备文件在Linux系统下存放在 /dev 下面，设备文件的命名方式是主设备号加次设备号，主设备号说明设备类型，次设备号说明具体指哪一个设备。

软盘（floppydisk，fd）：/dev/fdx,主设备号fd，次设备号x是冉攀驱动器相应的编号。如 /dev/fd0

U盘（在 Linux 下被识别为 SCSI 设备）：/dev/sdax，主设备号 sd表示 SCSI disk，a表示第一块SCSI设备，如果有第二块SCSI设备，那么对应的设备文件是 /dev/sdb。x表示SCSI设备的相应分区编号。例如，/dev/sda1表示第一块SCSI设备的第一个分区，/dev/sdc5表示第三块SCSI设备的第一个逻辑分区。

光驱：/dev/had

SCSI光驱：/dev/srx

指向光驱的符号链接：/dev/cdrom

磁带：/dev/stx



#### 常见文件系统类型

文件系统类型就是分区的格式，对于不同的外设，Linux也提供了不同的文件类型

|  文件系统格式  |                             备注                             |
| :------------: | :----------------------------------------------------------: |
|     msdos      |                       DOS文件系统类型                        |
|      vfat      | 支持长文件名的DOS分区文件系统类型，也可理解为Windows文件系统类型 |
|    iso9660     |                     光盘格式文件系统类型                     |
| ext2/ext3/ext4 |                  Linux下的主流文件系统类型                   |
|      xfs       | Linux下的一种高性能的日志文件系统，在Centos7.x版本中称为默认文件系统 |

#### 设备的挂载使用

**mount -t 文件系统类型 设备名 挂载点**

##### 挂载软盘

```shell
mount -t msdos /dev/fd0 /mnt/floppy
```

##### 挂载U盘

```shell
mount -t vfat /dev/sda1 /mnt/usb
```

通过访问 /mnt/usb 目录来访问 U盘的内容

##### 挂载光盘

```shell
mount -t iso9660 /dev/hda /mnt/cdrom

或者

mount /dev/cdrom /mnt/cdrom
```

#### 设配的卸载

```shell
umount 挂载目录

umount /mnt/usb
umount /mnt/cdrom
```



## 文件系统结构介绍

### 目录结构

#### 经典树形目录结构

![image-20210607155644039](Linux%E5%AD%A6%E4%B9%A0.assets/image-20210607155644039-1623052606275.png)

#### 目录功能介绍

##### /etc 目录

存放系统管理相关的配置文件以及子目录

比较重要的有系统初始化文件 /etc/rc、用户信息文件/etc/passwd，相关网络配置文件和服务启动文件

|      文件名和目录      |                           主要作用                           |
| :--------------------: | :----------------------------------------------------------: |
|         passwd         | 用户库文件、每个用户的用户名、UID、GID和工作目录等都存放在此文件中 |
|         shadow         |     存放用户密码的文件，每个用户的密码加密后都放入此文件     |
|         group          |                      主要存储用户组信息                      |
|         fstab          | 系统开机启动自动挂载分区列表，需要设置开机自动挂载的分区，都可以在此文件加入 |
|        systemd         | systemd的配置文件目录，是Centos7.x版本之后新增目录，此目录是Linux启动的重要部分，用来完成对整个系统的基本初始化配置 |
|         hosts          | 设定用户自己的IP与名字的对应表，类似于 Windows下的hosts文件  |
|      resolve.conf      |                      客户端DNS配置文件                       |
| systemd/system/*.wants | 此目录包含所有服务启动脚本，开机时系统将自动启动这些服务，是Centos7.x版本之后新增目录 |
|          X11           |                     X-Window 的配置文件                      |
|      rsyslog.conf      | 系统日志输出配置文件，在Centos5.x版本以及之前版本中对应的文件是syslog.conf，centos6.x版本以及以后版本中是rsyslog.conf文件 |
|        crontab         |                  系统级别的守护进程配置文件                  |
|      sysctl.conf       | 系统内核参数配置文件，在Centos7.x版本之后，内核参数配置文件转移到了/usr/lib/sysctl.d目录下，但sysctl.conf文件仍有效，并且可覆盖/usr/lib/sysctl.d的配置 |
|        services        |                 定义系统服务与端口的对应关系                 |
|        profile         |                   系统全局环境变量配置文件                   |

##### /usr目录

此目录主要用于存放**应用程序和文件**。如果在系统安装的时候选择了很多软件包，那么这些软件包默认会安装到此目录下，平时安装的一些软件默认情况下也会安装到此目录内。

|      文件或目录      |                         主要作用                          |
| :------------------: | :-------------------------------------------------------: |
| lib64以及local/lib64 |                64位操作系统中的函数库目录                 |
|         src          | 该目录包含所有程序的源代码，其中主要是Linux核心程序源代码 |
|        local         |       存放本地安装的软件和其他文件，与Linux系统无关       |
|   bin以及local/bin   |               使用者可执行的二进制文件目录                |
|   lib以及local/lib   |               32位操作系统使用的函数库目录                |
|  sbin以及local/sbin  |               存放系统管理员才能执行的命令                |
|       include        |           包含C语言的头文件，文件扩展名大多是.h           |
|        share         |               该目录存放共享的文件和数据库                |

##### /var目录

此目录主要用于存放系统运行以及软件运行的日志信息。

| 文件或目录 | 主要作用                                                     |
| ---------- | ------------------------------------------------------------ |
| log        | 存放各种应用程序的日志文件，这里的文件是经常变动的，因此需要定期清理 |
| lib        | 存放系统正常运行时需要改变的库文件                           |
| spool      | mail、new、打印机队列和其他队列输入、输出的缓冲目录          |
| tmp        | 允许比/tmp存放更大的文件                                     |
| lock       | 存放被锁定的文件，很多程序都会在/var/lock下产生一个锁文件，以保证其他程序不能同时使用这个设备或文件 |
| local      | 存放/usr/local中所安装程序的可变数据                         |
| account    | 存放已经格式化的man页                                        |
| run        | 包含到下次系统启动前的系统信息                               |

##### /dev目录

![image-20210607163315996](Linux%E5%AD%A6%E4%B9%A0.assets/image-20210607163315996-1623054801190.png)

##### /proc目录

虚拟目录，目录中所有信息都是内存的映射，通过这个虚拟的内存映射目录，可以和内核内部数据结构进行交互，获取有关进程的有用信息，同时亦可以修改内核参数，与其他目录不同，/proc存于内存中，而不是硬盘上

![image-20210607163558839](Linux%E5%AD%A6%E4%B9%A0.assets/image-20210607163558839-1623054961467.png)

##### 其他目录

/boot：启动Linux时的一些核心文件，具体包含一些镜像文件和链接文件

/bin和/sbin：存放的都是可执行的二进制文件，/bin下存放的就是经常使用的Linux命令

/sbin：只有超级用户才能使用的命令

/home：系统中每个用户的工作目录

/lib：存放的是共享程序库和映像文件

/root：超级用户root的默认主目录

/run：外在设备的自动挂载点目录

/media：与/run作用基本类似

/lost+found：用于保存丢失的文件

/tmp：临时文件目录



### 系统核心组成

一个完整的Linux内核，一般由5个部分组成，分别是 **内存管理**、**进程管理**、**进程间通信**、**虚拟文件系统**和**网络接口**

#### 内存管理

#### 进程管理

#### 进程间通信

#### 虚拟文件系统

#### 网络接口

## 运行机制介绍

### Linux初始化init系统

从 BIOS 开始，Linux引导程序将内核映像加载进内存，进行内核初始化。内核初始化的最后一步就是启动PID为1的init进程，这个进程是系统的第一个进程，负责产生其他所有用户进程。

sysvinit

​	upstart

​	systemd

### runlevel到target的改变

### 系统关机过程

## 系统服务管理工具 systemd

### 启动、停止、重启服务

### 查看、禁止、启用服务

### systemd和sysvinit命令对比

## Linux 与 SecureCRT

### SecureCRT概述

### SecureCRT的安装与使用

### 与SecureCRT相关的Linux命令

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

## CPU性能评估

### vmstat

### sar

### iostat

### uptime

## 内存性能评估

### free

### 通过 watch 和 free 相结合动态监控内存状况

### vmstat 监控内存

### "sar -r" 命令组合

## 磁盘 I/O 性能评估

### "sar -d"

### "iostat -d"

### "vmstat -d"

## 网络性能评估

### ping——检测网络联通性

### "netstat -r"——检测系统的路由表信息

### "sar -n"——组合显示系统的网络运行状态

## 基于Web应用的性能分析及优化案例

### 基于动态内容的网站优化案例

### 基于动态、静态内容结合的网站优化案例



# 虚拟化云计算平台 Proxmox VE

## OpenVZ

## KVM

## Proxmox VE





# 高性能集群软件 Keepalived

## 集群的定义

## 集群的特点与功能

### 高可用性与可扩展性

### 负载均衡与错误恢复

### 心跳监测与漂移IP地址

## 集群的分类

### 高可用集群

### 负载均衡集群

### 分布式计算集群

## HA集群中的相关属于

## Keepalived简介

### 用途

### VRRP 与 工作原理

### Keepalived 工作原理

### 体系结构

## Keepalived 安装与配置

### 安装过程

### 全局配置

### VRRPD配置

### LVS配置

## Keepalived 基础功能应用实例

### 基础HA功能演示

### 通过vrrp_script实现对集群资源的监控

### keepalived 集群中 Master 和 Backup 角色选举策略



# 负载均衡集群LVS 与 HAProxy