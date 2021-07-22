# MyBatis

## 0. xml配置

### 添加依赖

### xml配置文件

#### <settings>

#### <typeAliases>

#### <environments>

#### <mappers>

### 实体类和Mapper.xml文件（这里无需接口）

## 1. MyBatis xml 方式基本用法

### 实体类
接口
Mapper.xml

### <select>
<insert>
<update>
<delete>

### mapper映射
resultType
resultMap

## 2. MyBatis 注解方式基本用法

### @Select
@Insert
@Update
@Delete

### @Results
@Result
@ResultMap

## 3. MyBatis 动态sql

### if
choose

### where
set
trim

### foreach
bind

## 4. MyBatis 代码生成器

### 依赖

### xml 配置

#### generatorConfiguration

##### properties

##### classPathEntry

##### context

###### property

###### plugin

###### commentGenerator

###### jdbcConnection

###### javaTypeResolver

###### javaModelGenerator

###### SqlMapGenerator

###### javaClientGenerator

###### table

### 编写代码运行
命令行提示符运行
Maven Plugin 运行
Eclipse插件运行

### Example 对象

#### 单表复杂批量操作

#### 条件和判断很多的情况下不建议使用

## 5. MyBatis 高级查询

### 高级结果映射

#### 一对一映射

##### 关联的嵌套结果映射
一次查询将结果映射到不同对象的方式

##### resultMap 将两个对象进行映射

##### resultMap 继承映射

##### 使用 resultMap 的 association 标签配置一对一映射

###### 子主题1

##### association 标签的嵌套查询

#### 一对多映射

##### collection集合的嵌套结果映射

##### collection集合的嵌套查询

#### 鉴别器映射

##### discriminator

###### column javaType

###### class value resultMap

### 存储过程

### 使用枚举类或其他对象

## 6. MyBatis 缓存配置

### 一级缓存
本地缓存
默认启用

#### 只存在于sqlSession的生命周期中
insert、delete、update 刷新一级缓存

### 二级缓存
存在于SqlSessionFactory的生命周期中

#### 配置二级缓存

##### <setting> cacheEnabled

##### 二级缓存和命名空间绑定，需要在Mapper.xml文件中配置，
或者Mapper接口中配置
<cache />
@CacheNameSpace

#### 使用二级缓存

##### 可读写缓存：序列化和反序列化对象
可读缓存：map 映射

### 集成EhCache缓存

#### 依赖：mybatis-ehcache

#### 配置 ehcache

#### 修改Mapper.xml 中缓存配置

### 集成redis缓存

#### 依赖：mybatis-redis

#### 配置redis

#### 修改Mapper.xml 中缓存配置

### 脏数据的产生和避免

### 二级缓存适用场景

#### 以查询为主的应用场景，只有尽可能少的增删改操作

#### 绝大多数以单表操作存在时，因为很少存在互相关联的情况，不会出现脏数据

#### 等等

## 7. MyBatis 插件开发

### 拦截器接口

#### Interceptor

##### intercept

##### plugin

##### setProperties

### 拦截器签名

#### @Intercepts
@Signature

#### Executor接口

#### ParameterHandler接口

#### ResultSetHandler

#### StatementHandler

### 下划线键值转小写驼峰形式插件

### 分页插件

#### PageInterceptor拦截器类

## 8. Spring 集成 MyBatis

### Maven Web 项目

### 集成Spring 和 SpringMVC

### 集成MyBatis

### Mapper(DAO)层，持久层，数据访问层
Service层，业务层
Controller层，控制层
View层，视图层

### 部署和运行

## 9. SpringBoot 集成 MyBatis

### SpringBoot 项目

### 集成MyBatis

#### 添加依赖
完成配置

### 开发

## 类型处理器（TypeHandler）
