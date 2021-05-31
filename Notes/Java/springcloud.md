# SpringCloud - SpringBoot版本对应
---

表头 |  表头* 
:----: | :----:
dany | dad 
dany | dad 
dany | dad 
dany | dad 
dany | dad 


# FeignClient 远程调用服务注解
  ### 在使用Spring Cloud开发微服务应用时中，各个微服务服务提供者都是以HTTP接口的形式对外提供服务，因此服务消费者在调用服务提供者时，通过HTTP Client的方式访问。当然我们可以使用JDK原生的`URLConnection`、`Apache的Http Client`、`Netty的异步HTTP Client`, Spring的`RestTemplate`去实现服务间的调用。Spring Cloud对Fegin进行了增强，使Fegin支持了Spring MVC的注解，并整合了Ribbon和Eureka，从而让Fegin的使用更加方便（在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验）。
+ ### 首先通过@EnableFeignCleints注解开启FeignCleint
+ ### 根据Feign的规则实现接口，并加@FeignCleint注解
+ ### 程序启动后，会进行包扫描，扫描所有的@ FeignCleint的注解的类，并将这些信息注入到ioc容器中。
+ ### 当接口的方法被调用，通过jdk的代理，来生成具体的RequesTemplate
+ ### RequesTemplate在生成Request
+ ### Request交给Client去处理，其中Client可以是HttpUrlConnection、HttpClient也可以是Okhttp
+ ### 最后Client被封装到LoadBalanceClient类，这个类结合类Ribbon做到了负载均衡  