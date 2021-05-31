# SpringCloud - SpringBoot版本对应

         Spring Cloud          |                  Spring Boot                   
:----: | :----:
           Angel版本           |             兼容Spring Boot 1.2.x              
          Brixton版本          | 兼容Spring Boot 1.3.x，也兼容Spring Boot 1.4.x 
          Camden版本           | 兼容Spring Boot 1.4.x，也兼容Spring Boot 1.5.x 
   Dalston版本、Edgware版本    | 兼容Spring Boot 1.5.x，不兼容Spring Boot 2.0.x 
         Finchley版本          | 兼容Spring Boot 2.0.x，不兼容Spring Boot 1.5.x 
 **Greenwich版本**    **常用** |           **兼容Spring Boot 2.1.x**            
          Hoxtonl版本          |             兼容Spring Boot 2.2.x              

​    实际开发中更详细的对应  

|              Spring Boot               |      Spring Cloud       |
| :------------------------------------: | :---------------------: |
|             1.5.2.RELEASE              |       Dalston.RC1       |
|             1.5.9.RELEASE              |     Edgware.RELEASE     |
|             2.0.2.RELEASE              | Finchley.BUILD-SNAPSHOT |
|             2.0.3.RELEASE              |    Finchley.RELEASE     |
| **2.1.0.RELEASE   —   2.1.14.RELEASE** |    **Greenwich.SR5**    |
|                2.2.0.M4                |       Hoxton.SR4        |





# SpringCloud项目创建

+ ### 只需要一个maven父项目

​    空的父项目，的初始结构：

```xml
                	<modelVersion>4.0.0</modelVersion>

                    <groupId>org.example</groupId>
                    <artifactId>springcloud2</artifactId>
                    <version>1.0-SNAPSHOT</version>
                    <packaging>pom</packaging>
                    <properties>
                        <maven.compiler.source>8</maven.compiler.source>
                        <maven.compiler.target>8</maven.compiler.target>
                	</properties>
```

   需要注意的是```packaging```的打包方式是```pom```。

   接下来在父项目中增加```<dependencyManagement>```，来进行依赖**版本控制**。

```xml
<!-- springboot依赖 > 2.1.0 -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.4.5</version>
            </dependency>
            <!-- springcloud 使用Greenwich.SR5 -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.SR5</version>
            </dependency>
            <!-- lombok -->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.20</version>
            </dependency>
            <!-- springweb -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
                <version>2.4.5</version>
            </dependency>
```



FeignClient 远程调用服务注解

  ### 在使用Spring Cloud开发微服务应用时中，各个微服务服务提供者都是以HTTP接口的形式对外提供服务，因此服务消费者在调用服务提供者时，通过HTTP Client的方式访问。当然我们可以使用JDK原生的`URLConnection`、`Apache的Http Client`、`Netty的异步HTTP Client`, Spring的`RestTemplate`去实现服务间的调用。Spring Cloud对Fegin进行了增强，使Fegin支持了Spring MVC的注解，并整合了Ribbon和Eureka，从而让Fegin的使用更加方便（在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验）。
+ ### 首先通过@EnableFeignCleints注解开启FeignCleint
+ ### 根据Feign的规则实现接口，并加@FeignCleint注解
+ ### 程序启动后，会进行包扫描，扫描所有的@ FeignCleint的注解的类，并将这些信息注入到ioc容器中。
+ ### 当接口的方法被调用，通过jdk的代理，来生成具体的RequesTemplate
+ ### RequesTemplate在生成Request
+ ### Request交给Client去处理，其中Client可以是HttpUrlConnection、HttpClient也可以是Okhttp
+ ### 最后Client被封装到LoadBalanceClient类，这个类结合类Ribbon做到了负载均衡  