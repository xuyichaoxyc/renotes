# Java 

## JDK 的安装与配置

# Maven

项目构建工具，能把项目抽象成 POM （Project object model），Maven 使用 POM 对项目进行构建、打包、文档化等操作。

最重要：依赖管理，简化开发环境搭建过程

## Maven 介绍

最初代替 Apache Ant，用来简化项目构建

Ant 构建项目：指令方式

​	源码编译：Javac 指令，以及一系列属性，包括源代码路径、依赖库的路径等

​	打包项目（war包）：war 指令和附带的一系列属性，如编译好的 class 的目录等



Maven 采用了不同方式对项目构建进行抽象：

​	源码位置：src/main/java

​	配置文件：src/main/resources

​	编译好的类：项目 target 目录



+ 项目构建变得容易，屏蔽了构建的复杂过程，**maven package** 构建整个 Java 项目 
+ 统一构建项目的方式，pom.xml 来描述项目，并提供一系列插件来构建项目
+ 类库依赖



仓库：

+ Apache 中心仓库，jar 发布存放的地方，http://search.maven.org
+ 国内外大量镜像库，与中心仓库同步，阿里云等
+ 私服，发布和存放库
+ 本地仓库，默认位置-用户目录下的 .m2 隐藏文件夹中



pom.xml

+ groupId：项目所属组，通常是一个公司或组织的名称：org.springframework

+ artifactId：项目唯一标识，spring-boot-starter-web

  + groupId，artifactId，能唯一标识一个项目或一个库，称之为项目坐标

+ packaging：项目类型，jar、war，

+ version：项目版本号，主版本号.次版本号.修订版本号，SNAPSHOT，开发中，RELEASE，正式发布，M1，M2，里程碑即将发布，RC（Release Candidate，发布候选）、GA（generally availability，基本可用版本）

  SNAPSHOT<m1<m2<...<RC<GA<Release

+ modelVersion：pom 文件的 Maven 的版本

+ dependencies：dependency，用来声明项目的依赖

+ dependency



+ scope：此类库与项目的关系
  + compile：默认，编译和打包都需要此类库
  + test：仅仅在单元测试时需要
  + provide：编译阶段需要，打包不需要，项目目标环境已经提供了
  + runtime：编译和打包都不需要，运行时候需要，如某个指定的数据库驱动
+ build：包含了多个插件 plugin，用来辅助项目构建



## Maven 的安装与配置

+ 下载
+ 解压
+ 设置环境变量

mvn --version



setting.xml

```xml
<mirror>
	<id>alimaven</id>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    <mirrorOf>central</mirrorOf>
</mirror>
```



## Maven 常用命令

### 创建 Maven 工程

```shell
mvn -B archetype:generate \ 
	-DarchetypeGroupId = org.apache.maven.archetype \ 
	-DgroupId = com.mycompany.app \ 
	-DartifactId = my-app
```

archetypeGroupId : Maven 项目的模板，生成不同应用的 Maven 项目

groupId：com.mycompany.app

artifactId：my-app

### 编译 Maven 工程

```shell
mvn compile
```

### 编译并打包 Maven 工程

根据 pom.xml 中元素 packaging 是 jar 还是 war 进行打包

```shell
mvn package
```

### 打包并安装到本地仓库

```shell
mvn install
```



### 其他

```shell
# 同 install，但打包并安装到远程仓库
mvn deploy
# 删除 target 目录
mvn clean
```





# Spring 核心技术



