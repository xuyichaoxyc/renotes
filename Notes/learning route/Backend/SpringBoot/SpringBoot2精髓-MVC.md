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

