### 一、存放目录

###### Application属性文件，按优先级排序，位置高的将覆盖位置

1. 当前项目目录下的一个/config子目录

2. 当前项目目录

3. 项目的resources即一个classpath下的/config包

4. 项目的resources即classpath根路径（root）

   

   如图：

   ![img](SpringBoot%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6-%E5%8A%A0%E8%BD%BD%E9%A1%BA%E5%BA%8F.assets/13184578-31bb8d4c59d678b6-1623395362703.png)

   目录

### 二、读取顺序

如果在不同的目录中存在多个配置文件，它的读取顺序是：
 1、config/application.properties（项目根目录中config目录下）
 2、config/application.yml
 3、application.properties（项目根目录下）
 4、application.yml
 5、resources/config/application.properties（项目resources目录中config目录下）
 6、resources/config/application.yml
 7、resources/application.properties（项目的resources目录下）
 8、resources/application.yml

###### 顺序可以通过实验验证：

1~8 个位置 分别定义不同的 server 端口号 9001~9008
 即可验证结果顺序
 注：
 1、如果同一个目录下，有application.yml也有application.properties，默认先读取application.properties。
 2、如果同一个配置属性，在多个配置文件都配置了，默认使用第1个读取到的，后面读取的不覆盖前面读取到的。
 3、创建SpringBoot项目时，一般的配置文件放置在项目的resources目录下，因为配置文件的修改，通过热部署不用重新启动项目，而热部署的作用范围是classpath下

### 三、配置文件的生效顺序，会对值进行覆盖

1. @TestPropertySource 注解
2. 命令行参数
3. Java系统属性（System.getProperties()）
4. 操作系统环境变量
5. 只有在random.*里包含的属性会产生一个RandomValuePropertySource
6. 在打包的jar外的应用程序配置文件（application.properties，包含YAML和profile变量）
7. 在打包的jar内的应用程序配置文件（application.properties，包含YAML和profile变量）
8. 在@Configuration类上的@PropertySource注解
9. 默认属性（使用SpringApplication.setDefaultProperties指定）

### 四、配置随机值

roncoo.secret={random.value} roncoo.number={random.int}
 roncoo.bignumber={random.long} roncoo.number.less.than.ten={random.int(10)}
 roncoo.number.in.range=${random.int[1024,65536]}

读取使用注解：@Value(value = "${roncoo.secret}")

注：出现黄点提示，是要提示配置元数据，可以不配置

### 五、属性占位符

当application.properties里的值被使用时，它们会被存在的Environment过滤，所以你能够引用先前定义的值（比如，系统属性）
 [roncoo.name](http://roncoo.name) = [www.roncoo.com](http://www.roncoo.com)
 roncoo.desc = ${roncoo.name} is a domain name

### 六、其他配置的介绍

- 端口配置
   server.port=8090
- 时间格式化
   spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
- 时区设置
   spring.jackson.time-zone=Asia/Chongqing