# Spring

## IOC 和 DI

### IOC

控制反转

**Ioc意味着将你设计好的对象交给容器控制，而不是传统的在你的对象内部直接控制**

**IoC 容器控制了对象**，**主要控制了外部资源获取（不只是对象包括比如文件等）**

传统应用程序是由我们自己在对象中主动控制去直接获取依赖对象，也就是正转；而反转则是由容器来帮忙创建及注入依赖对象；

**容器帮我们查找及注入依赖对象，对象只是被动的接受依赖对象，所以是反转**，**依赖对象的获取被反转了**



### DI

依赖注入

**由容器动态的将某个依赖关系注入到组件之中**。**依赖注入的目的并非为软件系统带来更多功能，而是为了提升组件重用的频率，并为系统搭建一个灵活、可扩展的平台。**通过依赖注入机制，我们只需要通过简单的配置，而无需任何代码就可指定目标需要的资源，完成自身的业务逻辑，而不需要关心具体的资源来自何处，由谁实现。

**应用程序依赖于IoC容器**

**应用程序需要IoC容器来提供对象需要的外部资源**

**IoC容器注入应用程序某个对象，应用程序依赖的对象**

**注入某个对象所需要的外部资源（包括对象、资源、常量数据）**



## Spring 框架有哪些不同的功能

+ 轻量级——代码量和透明度方面
+ IOC——控制反转
+ AOP——将应用业务逻辑和系统服务分离，实现高内聚
+ 容器——Spring负责创建和管理对象（Bean）生命周期和配置
+ MVC——对 Web 提供了高度可配置性，其他框架的集成也十分方便
+ 事务管理——提供了用于事务管理的通用抽象层
+ JDBC异常——JDBC抽象层提供了一个异常层次结构，简化了错误处理策略

## Spring bean 容器的生命周期流程

1. Spring 容器根据配置中的bean定义，实例化bean
2. Spring 使用依赖注入填充所有属性，如 Bean 中所定义的配置
3. bean 实现 BeanNameAware 接口，工厂通过传递 bean 的 ID来调用 setBeanName
4. bean 实现 BeanFactoryAware 接口，工厂通过传递自身的实例来调用 setBeanFactory
5. 存在与 Bean 关联的任何 BeanPostProcessors，则调用 preProcessBeforeInitialization() 方法
6. 如果为 bean 指定了 init 方法（init-method属性），那么将调用它
7. 如果存在与 Bean 关联的任何 BeanPostProcessors，则调用 preProcessAfterInitialization() 方法
8. 如果bean实现 DisposableBean 接口，当 Spring 容器关闭时，会调用 destroy() 方法
9. 如果为 bean 指定了 destroy 方法（desroy-method）那么将调用它
