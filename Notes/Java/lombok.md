# 注解整理  



## ApiModel 和 ApiModelProperty

  ApiModel 注解是作用在接口相关**实体类上**的注解，用来对该接口相关实体类添加额外的描述信息，常常和 @ApiModelProperty 注解配合使用。

+ ### 注解主要属性汇总  

  | 属性名称          | 属性类型 | 默认值 |
  | ----------------- | -------- | ------ |
  | value()           | String   | 空     |
  | name()            | String   | 空     |
  | required()        | boolean  | false  |
  | hidden()          | boolean  | false  |
  | allowEmptyValue() | boolean  | false  |
- ApiModel的属性  
  -  ### value()  
  ```java
  @ApiModel(value = "用户实体，存储用户相关字段")
    public class User{
        // do something...
    }  
- ApiModelProperty的属性  
  - ### value()
  ```java
  @ApiModelProperty(value = "用户Id")
   private Integer id;
---



## lombok相关注解
| 案例
```java
    public class Car {
    private String make;
    private String model;
    private String bodyType;
    private int yearOfManufacture;
    private int cubicCapacity;

} 
``` 
- ### @AllArgsConstructor  
  等价于
  ```java
    public class Car {
        @Getter
        @Setter
        private String make;
        @Getter
        @Setter
        private String model;
        @Getter
        @Setter
        private String bodyType;
        @Getter
        @Setter
        private int yearOfManufacture;
        @Getter
        @Setter
        private int cubicCapacity;
        public Car(String make, String model, String bodyType, int yearOfManufacture, int cubicCapacity) {
            super();
            this.make = make;
            this.model = model;
            this.bodyType = bodyType;
            this.yearOfManufacture = yearOfManufacture;
            this.cubicCapacity = cubicCapacity;
        }
    }
    ```
    生成所有的参数的构造器
+ ### NoArgsConstructor
  生成无参构造器
+ ### @ToString
  生成toString方法
+ ### @Data
  自动写入setter和getter
+ ### @Builder
  ```java
    public class User {
    private Integer id;
    private String name;
    private String address;

    private User() {
    }

    private User(User origin) {
        this.id = origin.id;
        this.name = origin.name;
        this.address = origin.address;
    }

    public static class Builder {
        private User target;

        public Builder() {
            this.target = new User();
        }

        public Builder id(Integer id) {
            target.id = id;
            return this;
        }

        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder address(String address) {
            target.address = address;
            return this;
        }

        public User build() {
            return new User(target);
        }
    }
  ```
  等价于
  ```java
    @Builder
    public class UserExample {
        private Integer id;
        private String name;
        private String address;
    }
  ```
+ ### @NotNull
  表示不能为null，但可以为empty,没有Size的约束
+ ### @NotBlank
  只用于String,不能为null,且trim()之后size>0
+ ### @NotEmpty
  不能为null，且Size>0

  ----  










