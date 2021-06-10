# Annotation（注解/注释）

元数据（MetaData)

注解/注释（Annotation）

代码里的特殊标记，这些标记可以在**编译**、**类加载**、**运行时**被读取，并执行相应的处理。

通过使用注解，程序开发人员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。

**代码分析工具**、**开发工具**、**部署工具**可以通过这些补充信息进行验证或者进行部署。



Annotation 是一个接口，程序可以通过反射来获取指定程序元素的 Annotation 对象。然后通过 Annotation 对象来取得注解里的元数据。



## 基本注释

### @Override —— 限定重写父类方法

方法注解

保证父类要包含一个被该方法重写的方法，否则就会编译出错

### @Deprecated ——  标识已过时

类、方法等注解

表示这些程序元素已过时

### @SuppressWarnings —— 抑制编译器警告

指示被该注解注释的程序元素（以及该程序元素的所有子元素）取消显示指定的编译器警告

### @SafeVarargs

—— 堆污染警告

+ @SafeVarargs 修饰引发该警告的方法或构造器
+ @SuppressWarnings("unchecked")
+ 编译时使用 -Xlint:varargs 选项

### @FunctionalInterface —— 标识函数式接口

可以有多个默认方法或多个 static 方法

只能有一个抽象方法



## 元注释 —— 只能用于修饰 Annotation 定义

### @Retention

用于指定被修饰的 Annotation 可以保留多长时间

+ RetentionPolicy.CLASS：默认值，编译器将 Annotation 记录在class 文件中。运行时不可获取 Annotation 信息。
+ RetentionPolicy.RUNTIME：编译器将 Annotation 记录在 class 文件中，运行时，JVM 也可获取 Annotation 信息，程序可以通过反射获取该Annotation 信息。
+ RetentionPolicy.SOURCE：Annotation 只保留在源代码中，编译器直接丢弃这种Annotation。

@Retention(value = RetentionPolicy.RUNTIME)

@Retention(RetentionPolicy.SOURCE)

### @Target

用于指定被修饰的 Annotation 能用于修饰哪些程序单元。

![image-20210609210858442](Annotation%EF%BC%88%E6%B3%A8%E9%87%8A%EF%BC%89.assets/image-20210609210858442-1623244140765.png)

### @Documented

javadoc 工具提取成文档

### @Inherited

指定被它修饰的 Annotation 将具有继承性



## 自定义 Annotation

```java
public @interface Test
{
    
}

public @interface MyTag
{
    String name();
    int age();
}
public @interface MyTag{
    String name() default 'yeeku';
    int age() default 32;
}
```



## 提取 Annotation 信息



## 可重复注释