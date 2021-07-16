# MVC框架

+ HTTP URL 映射到 Controller 某个方法
+ HTTP 参数映射到 Controller 方法的参数上，比如参数映射到某个 Java 对象，或者上传附件映射到某个File 对象上
+ 参数的校验
+ MVC 错误处理
+ MVC 中如何调用视图
+ MVC 中如何序列化对象 成 JSON
+ 拦截器等高级定制

Spring MVC 具备上述所有技术实现



## 集成MVC框架

### 引入依赖

springboot 集成 SpringMVC框架并实现自动配置，只需要在 pom 中添加以下依赖：

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### Web 应用目录结构

Web **模板文件**处于：resources/template 目录

模板文件使用的**静态资源文件**，如：JS、CSS、图片，存放在 resources/static 目录下

在 MVC 中，视图名自动在 templates 目录下找到对应的模板名称，模板中使用的静态资源将在 static 目录下查找

```java
@RequestMapping("/userdetail.html")
public String foo(String id){
    ...;
    return "/admin/userInfo.btl";
}
```

渲染的视图名称为：/admin/userInfo.btl，会寻找 templates/admin/userInfo.btl 模板文件

如果这个 userInfo.btl 有以下引用

```html
<link href = "/css/ztree.css" rel="stylesheet" />
```

则 SpringBoot 将会从 static 下查找 css/ztree.css 文件

### Java 包结构

+ Controller —— MVC 的 Controller，如 UserController
+ Service —— 业务处理代码，如 UserService
+ entity —— 业务实体，如 User 类
+ conf —— 包含了一些配置类，配置数据源 DataSourceConfig，JSON序列化配置 JacksonConf

应用程序入口 建立在这些包名之上



api —— bean —— app —— core



## 使用 Controller

SpringMVC 无需像传统MVC框架那样必须继承某个基础类才能处理用户的HTTP请求，

添加 @Controller 注解即可

对于用户请求，使用 @RequestMapping 映射 HTTP 请求到特地的 方法处理类

```java
@Controller
@RequestMapping("/test")
public class HelloworldController{
    @RequestMapping("/index.html")
    public String say(Model model){
        model.addAttribute("name", "hello, world");
        return "/index.btl";
    }
}
```

+ @Controller 作用于类：MVC 中的 Controller

+ @RequestMapping：作用于类和方法

+ Model 参数：SpringMVC 可识别的一个类型，用来表示 MVC 中的 Model，可以为这个 Model 添加多个变量，这些变量随后可以用于视图渲染

+ 返回值类型字符串：默认视图名称，resources/templates

  + 有时候返回的是 JSON 字符串，如果想直接返回内容，而不是视图名，则需要在方法上使用 @ResponseBody

  + ```java
    @RequestMapping("/index.json")
    public @ResponseBody String say(){
        return "hello, world";
    }
    ```

    或者采用 @RestController 注解

  + @ResponseBody 注解直接将返回的对象输出到客户端，如果是字符串则直接返回；不是，则默认使用 Jackson 序列化成 JSON 字符串后输出

  + 

  ```java
  @RequestMapping("/all.json", method = RequestMethod.GET)
  public @ResponseBody List<User> allUser(){
      return userService.allUser();
  }
  ```



## URL 映射到方法

### @RequestMapping

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112230352.png" alt="image-20210709112230352" style="zoom:50%;" />

### URL路径匹配

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112332359-1625801015341.png" alt="image-20210709112332359" style="zoom:50%;" />

### HTTP method 匹配

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112441734-1625801084539.png" alt="image-20210709112441734" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112503685-1625801105653.png" alt="image-20210709112503685" style="zoom:50%;" />

### Consumers 和 Produces

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112623208-1625801187230.png" alt="image-20210709112623208" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112649850.png" alt="image-20210709112649850" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112823312-1625801305356.png" alt="image-20210709112823312" style="zoom:50%;" />

### params 和 header 匹配

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112906914-1625801348736.png" alt="image-20210709112906914" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709112937470-1625801379400.png" alt="image-20210709112937470" style="zoom:50%;" />

### 方法参数

Spring 的 Controller 方法可以接受多种类型参数

+ path 变量 @PathVariable——将 URL 中的值映射到方法参数中
+ MVC Model——Spring 中通用的MVC 模型，也可以使用 Map 和 ModelMap 作为渲染视图的模型
+ ModelAndView —— 包含了模板和视图路径 的对象
+ JavaBean —— 将 HTTP 参数映射到 JavaBean 对象
+ MultiPartFile —— 用于处理文件上传
+ @ModelAttribute —— 使用该注解的变量将作为 Model 的一个属性
+ WebRequest 或者 NativeWebRequest，类似 Servlet Request，但做了一定的封装
+ <img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709122051344-1625804453018.png" alt="image-20210709122051344" style="zoom:50%;" />
+ <img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709122119725-1625804481681.png" alt="image-20210709122119725" style="zoom:50%;" />

#### PathVariable

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709122514636.png" alt="image-20210709122514636" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709122233971.png" alt="image-20210709122233971" style="zoom:50%;" />



#### Model & ModelAndView

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709122806280.png" alt="image-20210709122806280" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709122928370-1625804970127.png" alt="image-20210709122928370" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123036052-1625805038743.png" alt="image-20210709123036052" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123309328-1625805192043.png" alt="image-20210709123309328" style="zoom:50%;" />

#### JavaBean 接受 HTTP 参数

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123456951-1625805299594.png" alt="image-20210709123456951" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123543944-1625805347701.png" alt="image-20210709123543944" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123605517-1625805369238.png" alt="image-20210709123605517" style="zoom:50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123629877-1625805392932.png" alt="image-20210709123629877" style="zoom: 50%;" />

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123806169.png" alt="image-20210709123806169" style="zoom:50%;" />

#### @RequestBody 接受 JSON 参数

<img src="SpringBoot2%E7%B2%BE%E9%AB%93-MVC.assets/image-20210709123953626-1625805595396.png" alt="image-20210709123953626" style="zoom:50%;" />

#### MultiPartFile

#### @ModelAttribute

#### @InitBinder

### 验证框架

#### JSR-303

#### MVC中使用 @Validated

#### 自定义校验

### WebMVCConfigurer

#### 拦截器

#### 跨域访问

#### 格式化

#### 注册Controller

### 视图技术

#### Freemarker

#### Beetl

#### 使用 Jackson

#### Redirect 和 Forward

redirect：重定向

forward：转发

+ 请求方式不同
  + redirect：客户端发起的请求
  + forward：服务端发起的请求
+ 浏览器地址表现不同
  + redirect：浏览器地址显示被请求的url
  + forward：浏览器地址不显示被请求的url
+ 参数传递不同
  + redirect：重新开始一个 request，原页面的 request 生命周期结束
  + forward：forward另一个连接的时候，request变量是在其生命周期内的，另一个页面也可使用，其实质是把目标地址 include
+ 底层运作不同
  + redirect：发送的请求信息又回送给客户机，让客户机再转发到另一个资源上，需要在服务器和客户机之间增加一次通信。
  + forward：服务器端直接找到目标，并include过来。
+ 定义不同
  + 直接转发方式（Forward）：客户端和浏览器只发出一次请求，Servlet、HTML、JSP或其它信息资源，由第二个信息资源响应该请求，在请求对象request中，保存的对象对于每个信息资源是共享的。
  + 间接转发方式（Redirect）实际是两次HTTP请求，服务器端在响应第一次请求的时候，让浏览器再向另外一个URL发出请求，从而达到转发的目的。

### 通用错误处理

SpringBoot中，Controller中抛出的异常默认交给了 /error 来处理，应用程序可以将 /error 映射到一个特定的 Controller 中处理来代替 Spring Boot 的默认实现，应用可以继承 **AbstractErrorController**来统一处理系统的各种异常

### @Service 和 @Transactional

SpringBoot 中，Controller 调用业务逻辑处理交给了 @Service 注解的类，这也是个普通的 JavaBean，Controller 中可以自动注入这种Bean，并调用其方法完成主要的业务逻辑。

@Service 和 @Transactional 搭配使用

#### 声明一个 Service 类

```java
public interface UserService{
    public User getUserById(Long id);
    public void updateUser(Long id, Integer type);
}

@Service
@Transactional
public class UserServiceImpl implements UserService{
    public User getUserById(Long id){
        return user;
    }
    public void updateUser(Long id, Integer type){
        
    }
}
```

#### 事务管理

Spring简单地实现了事务管理，通过在 Service 类中使用 @Transactional 来让参与事务管理。

为了使用事务，需添加以下依赖：

```xml
<dependence>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependence>
```

@Transactional

+ 可以作用在类上，这样所有的接口方法都会参与事务管理。
+ 可以作用在方法上，使用 @Transactional 来声明调用该方法会处于事务上下文中

```java
@Transactional
public void updateUser(Long id, Integer type){
    
}
```

当 Controller 调用这个 Service 方法的时候，会开启一个事务上下文，随后的调用都将处于这个事务上下文中。

如果调用这个 Service 方法抛出 RuntimeException，事务会自动回滚，否则，事务将提交。

### curl 命令

curl 是利用 URL 语法在命令行方式下的开源文件传输工具。

广泛运用在UNIX、多种Linux 发行版中，并且有 DOS 和 Win32、Win64下的移植版本。

Mac 和 Linux 自带 curl，Windows 系统，需要从 https://curl.haxx.se/ 下载window版本；

git shell 也自带了 curl

curl 命令可以在开发 Web 应用的时候，模拟前端发起的HTTP请求



```shell
# cur URL，返回请求地址的内容：如下，返回百度页面的html
curl baidu.com

<!DOCTYPE html>
<!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><link rel=stylesheet type=text/css href=http://s1.bdstatic.com/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class="bg s_ipt_wr"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus></span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn"></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=http://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录</a> </noscript> <script>document.write('<a href="http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === "" ? "?" : "&")+ "bdorz_come=1")+ '" name="tj_login" class="lb">登录</a>');</script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>

# -i 参数，还返回 HTTP 头：
curl -i baidu.com

HTTP/1.1 200 OK
Date: Sat, 10 Jul 2021 04:03:01 GMT
Server: Apache
Last-Modified: Tue, 12 Jan 2010 13:48:00 GMT
ETag: "51-47cf7e6ee8400"
Accept-Ranges: bytes
Content-Length: 81
Cache-Control: max-age=86400
Expires: Sun, 11 Jul 2021 04:03:01 GMT
Connection: Keep-Alive
Content-Type: text/html

<html>
<meta http-equiv="refresh" content="0;url=http://www.baidu.com/">
</html>


# -H 设置请求的 HTTP 头
curl URL -H 'Content-Type: application/json'

# URL 通常用双引号防止转义，&表示在命令行中表示后台运行
curl "baidu.com?q=txt&c=1"

# -d 参数发起 POST 请求，-d 后面是 POST 的内容
curl URL -d "param1=value1&param2=value2"

# 如果 POST 内容需要转义，中文字符、空格等，可以使用 --data-urllencode
curl URL --data-urlencode "param1=value1&param2=中文"

# -G 参数发起 GET 请求，可以联合--data-urlencode 来转义参数里中文特殊符号，data-urlencode 默认是 POST 请求，如果没有 -G 参数，则会发起一个 POST 请求：
curl -G "baidu.com" --data-urlencode "param1=value1&param2=中文"

# 发起一个json亲求， 通过-X指定PUT协议，JSON内容可以用引号括起来 
curl -XPUT 'localhost:9200/product/book/1?pretty' -H 'content-type: application/json' -d '{
"name": "北京xxx",
"type": "food",
"postData" : "2009-11-15",
"message" : "xxxx"
}'

# -F 上传文件
curl URL -F "file=@xxx.doc" -F "name=xiandufu"
```

 Chrome 插件 Postman 能可视化完成像 curl 这样的工作
