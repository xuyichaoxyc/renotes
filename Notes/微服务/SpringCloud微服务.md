SOA——Service-Oriented Architecture，面向服务的架构

单体应用——》SOA架构

**单体应用：**

![image-20210608095028825](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/image-20210608095028825-1623117032884.png)

**参考SOA架构，将各个模块分为独立的服务模块，并使用了数据库的读写分离：**

![image-20210608095130648](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/image-20210608095130648-1623117092540.png)

**企业服务总线（ESB）：**

![image-20210608095205171](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/image-20210608095205171-1623117127627.png)

减少各个模块的耦合。各个模块将服务发布到ESB中，他们与ESB之间使用SOAP协议进行通信

**引入Nginx，负载均衡：**

![image-20210608095417996](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/image-20210608095417996-1623117260014.png)



**架构要求：**

​	环境：大数据、高并发

​	要求：高性能、独立性、容易扩展、便于管理、状态监控与警报

![image-20210608095730117](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/image-20210608095730117-1623117452827.png)





![img](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/728434-20190702163039471-1131916473-1623118489559.png)



![img](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/728434-20190702163245727-2107614238-1623118576720.png)

![img](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/728434-20190702163312110-1659269841-1623118590860.png)

![img](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/101606_hKip_2885163-1623118662676.png)





配置文件的读取顺序：

properties先加载，yml后加载，所以当同时配置2个不同端口号的时候，能执行的是yml配置的端口号

+ 项目根目录的config目录
+ 项目根目录
+ 项目classpath 下的config目录
+ 项目classpath目录

![image-20210608101955049](SpringCloud%E5%BE%AE%E6%9C%8D%E5%8A%A1.assets/image-20210608101955049-1623118797099.png)