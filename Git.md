[TOC]

# Git

## 一、git fetch 和 git pull 的区别

### 1. 远程跟踪分支不同

+ git fetch：能够直接更改远端跟踪分支
+ git pull：无法直接对远程跟踪分支进行操作，必须先切回本地分支，然后创建一个新的commit提交

### 2. 拉取不同

+ git fetch：将数据拉取到本地仓库-并不会自动修改和合并当前的工作
+ git pull：从远程获取最新版本并merge到本地-会自动修改和合并当前的工作

### 3. commitID不同

+ git fetch：commitID不变
+ git pull：commitID发生改变

### 4. 语法

```bash
git pull 远程主机(origin) 远程分支(master)
git pull 远程主机(origin) 远程分支(master): 本地分支
取回远程主机版本库某个分支的更新，再与当前本地分支（指定本地分支）进行合并



```



### 5. 演示

```shell
git fetch origin master
git log -p master origin/master
git merge origin/master
/*
	从远程origin master主分支下载最新版本
	比较本地 master 分支和origin/master分支差别
	合并
*/

git fetch origin master:tmp
git diff tmp
git merge tmp


git pull origin master
相当
git fetch
+
git merge

```



## 二、git clone 和 git pull

### 1. git clone 从远程拉取整个版本库

### 2. git pull 从远程拉取版本库的某个分支，并与本地分支合并

有些时候，git 会自动在本地和远程之间，建立一种追踪。

git clone，所有本地分支默认与远程主机的同名分支建立追踪关系

### 3. git branch --set-upstream master origin/next 建立分支追踪关系

指定 master 分支追踪到 origin/next 分支

