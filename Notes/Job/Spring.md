# Spring

## IOC 和 DI



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

