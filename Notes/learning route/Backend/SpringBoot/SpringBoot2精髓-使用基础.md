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

Java EE 是企业应用需求的体现

Spring 则基于企业应用并非全是分布式

Spring 框架

+ Spring Framework
+ Spring Boot
+ Spring Data系列
+ Spring Cloud系列

等

## Spring 容器介绍

### Spring IOC / DI

传统企业应用代码：

​	类中直接创建对象，如果对象构造器比较复杂，是个单例对象，那么会使用工厂类来完成创建。

Spring 框架中：

​	容器帮你注入所需要的依赖对象

Spring 容器管理Bean，需要声明 Bean

​	类上注解：@Service、@Controller、@Configuration

​	方法上注解：@Bean

​	实现 Spring 的某些接口类，Spring 会在容器的生命周期里调用这些接口类。BeanPostProcessor接口，在所有容器管理Bean初始化后，会调用此接口实现，对 Bean 进行进一步的配置。

AutowiredAnnotationBeanPostProcessor 会 寻找 Bean 里的 @Autowired 注解来注入依赖





### Spring常用注解

Spring 提供了多个注解声明 Bean 为 Spring 管理的 Bean，注解不同代表的含义不一样，但是对于 Spring 容器来说，都是 Spring 管理的Bean。

+ Controller：声明此类是一个 MVC 类，通常 与 @RequestMapping 一起使用，方法返回的一般是视图名称

  + ```java
    @Controller
    @RequestMapping("/user")
    public class UserController{
        @RequestMapping("/get/{id}")
        public String getUser(@PathVariable String id){
            ...
        }
    }
    ```

    + 如 用户访问地址为 /user/get/1，将调用getUser() 方法，并把参数 1 传给 id。

+ Service：声明此类是一个业务处理类，通常与 @Transactional 一起使用

  + ```java
    @Service
    @Transactional
    public class userServiceImpl implements UserService{
        public void order(..){
            ..
        }
    }
    ```

+ Repository：声明此类是一个数据库或者其他 NoSQL 访问类

  + ```java
    @Repository
    public class UserDao implements CrudDao<User, String>{
        ..
    }
    ```

+ RestController：同 Controller，用于 REST 服务，相当于 @ResponseBody 和 @Controller 的结合

  + @ResponseBody，返回文本而不是视图名称

+ Component：声明此类是一个 Spring 管理的类，通常用于无法用上述注解描述的 Spring 管理类

+ Configuration：声明此类是一个配置类，通常与注解 @Bean 联合使用

  + ```java
    @Configuration
    public class DataSourceConfig{
        @Bean(name = "dataSource")
        public DataSource datasource(Environment env){
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
            ds.setUsername(env.getProperty("spring.datasource.username"));
            ds.setPassword(env.getProperty("spring.datasource.password"));
            ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        	
            return ds;
        }
    }
    ```

  + @Bean：作用在方法上，声明该方法执行的返回结果是一个 Spring 容器管理的Bean

### 进一步配置Bean

Spring 负责实例化Bean，开发者可以提供一系列回调函数，用于**进一步配置 Bean**，包括@PostConstruct注解和@PreDestroy注解



当 Bean 被容器初始化后，会调用 @PostConstruct 注解的方法

在 Bean 被容器销毁之前，会调用 @PreDestroy 注解的方法

```java
@Component
public class Example{
    @PostConstruct
    public void init(){
        ...
    }
}

@Service
public class ExampleBean{
    @PreDestory
    public void cleanup(){
        ..
    }
}
```

其他 Bean 声明周期的回调方式：指定初始化和销毁的方法

用 实现 InitializingBean 接口的 afterPropertiesSet() 来初始化Bean

实现 DisposableBean 的 destroy() 方法来销毁 Bean



### 引用容器管理的Bean

+ 根据名字

  + ```java
    @Service
    @Qualifier("exampleBean")
    public class ExampleBean{
        
    }
    ```

    

  + ```java
    @Service
    public AnotherExampleBean{
        @Qualifier("exampleBean") ExampleBean bean;
    }
    ```

+ 根据类型

  + ```java
    @Service
    public class ExampleBean{
        
    }
    ```

    

  + ```java
    @Service
    public class AnotherExampleBean{
        @Autowired
        ExampleBean bean;
    }
    ```

  + @Autowired 声明对其他Bean的引用，作用于属性或者构造函数参数，甚至是方法调用参数上



## Spring AOP

面向切面编程，实现应用系统的公共服务

+ 每个业务方法调用的权限管理
+ 每个方法调用的审计
+ 数据库事务的管理
+ 缓存

不使用 AOP，上述需求都需要在每个方法中去实现完成

使用 AOP，可以在运行时刻动态地在方法调用前后“织入”一些公共代码，从而提供系统的公共服务

### AOP 术语

#### Aspect 切面

Aspect 声明类似于 Java 中的类声明，在Aspect中会包含一些 Point及相应的 Advice

横切关注点的模块化，比如上边提到的日志组件。可以认为是增强、引入和切入点的组合；在Spring中可以使用Schema和@AspectJ方式进行组织实现；在AOP中表示为“在哪干和干什么集合”；

#### Joint Point 连接点

在程序中明确定义的点，插入横切关注点的扩展点

典型的包括方法调用、对类成员的访问，异常处理程序块的执行

类初始化、方法执行、方法调用、字段调用或处理异常等

Spring 中的 Joint Point 只支持方法调用

AOP中表示为“在哪里干”

允许作为切入点的资源，所有类的所有方法均可以作为连接点

#### PointCut 切入点

选择一组相关连接点的模式，即可以认为连接点的集合，Spring支持perl5正则表达式和AspectJ切入点模式，Spring默认使用AspectJ语法，在AOP中表示为“在哪里干的集合”；

表示一组 Joint Point，如方法名、参数类型、返回类型等，这些 Joint Point 通过逻辑关系组合起来，它定义了相应的 Advice 将要发生的地方。

简单理解 PointCut（一种表达式）——用来判断Joint Point（方法调用）中执行 Advice（操作）

就是选定某些连接点，可以是一个或多个，比如类A存在request()、request2() 两个方法，可以选定所有调用A类request()的全部地方作为切点

#### Advice 通知/增强

表示在连接点上执行的行为，增强提供了在AOP中需要在切入点所选择的连接点处进行扩展现有行为的手段；包括前置增强（before advice）、后置增强(after advice)、环绕增强（around advice），在Spring中通过代理模式实现AOP，并通过拦截器模式以环绕连接点的拦截器链织入增强；在AOP中表示为“干什么”；

一个是选择时机，选择前置、后置、环绕任一即可；一个是干什么：以前置为例，在before方法内，会实现用户增强的逻辑。



定义了在Pointcut里面定义的程序点要做的操作

+ before
+ around
+ after
+ finally

#### AOP Proxy

Java 对象，JDK动态代理，CGLib代理

#### Waving

实现上述切面编程的代码织入，可以在编译时刻（AspectJ compiler），也可以在运行时刻，

Spring和其他大多数框架都是在运行时刻生成代理





- 目标对象（Target Object）：需要被织入横切关注点的对象，即该对象是切入点选择的对象，需要被增强的对象，从而也可称为“被增强对象”；由于Spring AOP 通过代理模式实现，从而这个对象永远是被代理对象，在AOP中表示为“对谁干”；
- AOP代理（AOP Proxy）：AOP框架使用代理模式创建的对象，从而实现在连接点处插入增强（即应用切面），就是通过代理来对目标对象应用切面。在Spring中，AOP代理可以用JDK动态代理或CGLIB代理实现，而通过拦截器模型应用切面。
- 织入（Weaving）：织入是一个过程，是将切面应用到目标对象从而创建出AOP代理对象的过程，织入可以在编译期、类装载期、运行期进行。



