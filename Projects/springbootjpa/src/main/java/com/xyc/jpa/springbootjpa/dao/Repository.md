Repository 是 Spring Data 的核心概念，抽象了对数据库和 NoSQL 的操作，提供了如下接口:
+ CrudRepository：提供了基本的增删改查，批量操作接口
+ PagingAndSortingRepository：集成 CrudRepository，提供了附加的分页查询功能
+ JpaRepository：专门用于 JPA，提供了更多丰富的数据库访问接口，比如根据 Example 来查询，类似 BeetlSQL 的根据模板来查询

