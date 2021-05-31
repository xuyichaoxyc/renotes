# HTTP相关问题记录  （待整理）  

## Cach、If-Modified-Since、Last-Modified(Request Headers)

**304状态码**

例如：请求一个域名地址，请求方式为GET，无参数请求

服务器返回304状态码，返回HTML页面信息（返回浏览器能够解析的整个网页的HTML）

> 304状态码或许不应该认为是一种错误，而是对客户端有缓存情况下服务端的一种响应。
>
> 表示为Not Modified状态，直接使用缓存信息  

在请求头中：  

```json
Request Headers:
	{
        If-Modified-Since: Thu,20,May 2021 ....//是否改变，本地记录的上一次改变的时间
    }f
Response Headers:
	{
        Last-Modified: Thu, 20 May 2021 ....//服务器告诉客户端最新一次修改的时间
    }
```

​		客户端在请求一个文件的时候，发现自己缓存的文件有 Last Modified ，那么在请求中会包含 If Modified Since ，这个时间就是缓存文件的 Last Modified 。因此，如果请求中包含 If Modified Since，就说明已经有缓存在客户端。服务端只要判断这个时间和当前请求的文件的修改时间就可以确定是返回 304 还是 200 。
对于静态文件，例如：CSS、图片，服务器会自动完成 Last Modified 和 If Modified Since 的比较，完成缓存或者更新。***但是对于动态页面，就是动态产生的页面，往往没有包含 Last Modified 信息，这样浏览器、网关等都不会做缓存，也就是在每次请求的时候都完成一个 200 的请求。***

​		因此，对于动态页面做缓存加速，首先要在 Response 的 HTTP Header 中增加 Last Modified 定义，其次根据 Request 中的 If Modified Since 和被请求内容的更新时间来返回 200 或者 304 。虽然在返回 304 的时候已经做了一次数据库查询，但是可以避免接下来更多的数据库查询，并且没有返回页面内容而只是一个 HTTP Header，从而大大的降低带宽的消耗，对于用户的感觉也是提高。  



> 服务器每次要进行一次条件判断来进行信息获取，但网络具有不可避免地延迟性，所以还是会有所等待

​		客户端发起条件请求，也需要等待服务器响应304或者200，这个过程也是一种浪费，最理想的情况是，在第一次请求的时候，服务器在Response Headers里**设置Cache-Control或Expires**头信息，可以指定该资源缓存可用时常，这样可以跳过条件请求直接获取本地缓存。

```json
Cache:
	{
    	Cache-Control:max-age=1 //设置缓存可用时常
	}
```





**Cache-Control字段在请求中使用Cache-Control 时，它可选的值有**  


![image-20210527153743194](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210527153743194.png)



**在响应中使用Cache-Control 时，它可选的值有：**  

![image-20210527153920179](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210527153920179.png)



## etag	响应头

​		单纯的以修改时间来判断还是有缺陷，比如文件的最后修改时间变了，但内容没变。***此时没必要进行重新请求***，此时要使用**etag**标签来处理。

​		哈希码是根据打包的js文件以及其他静态资源的文件的内容进行的哈希计算，如果里面的内容不变，那么哈希码不变。以此值可以作为**etag**的值传给客户端，在下一次请求的时候在Request Headers的**if-match**字段中携带。

## Remote Address请求头  

​		表示发出请求的远程主机的IP地址，`Remote Address`代表客户端的IP，但它的值不是由客户端提供的，***而是服务端根据客户端的IP指定的***.

当不使用代理时：web的服务器（nginx、apache）会把`Remote Address`设成客户端机器的IP。

使用代理时：浏览器先访问代理，再由代理转发到这个网站，web服务器就会把`Remote Address`设为代理机器的IP。

`Remote Address`一般用来进行三次握手连接，**无法伪造**，如果伪造，则三次握手会失败。  



## CDN（网站加速）加速缓存  

​		CDN的全称Content Delivery Network，即内容分发网络。其基本思路是尽可能避开互联网上有可能影响数据传输速度和稳定性的瓶颈和环节，使内容传输的更快，更稳定。通过在网络各处放置节点服务器所构成的在现有的互联网基础之上的一层智能虚拟网络，CDN系统能够实时地根据网络流量和各节点的连接，负债情况以及到用户的距离和响应时间等综合信息将用户的请求重新导向离用户最近的服务节点上。其目的是使用户可就近取得所需内容，解决Internet网络拥挤的状况，提高用户访问网站的响应速度。  

![image-20210527173146588](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210527173146588.png)

1. 用户在浏览器中输入目标域名
2. 浏览器向本地域名解析系统（Local DNS）发出解析请求
3. 经过 DNS 递归查询，请求被转移至 Tencent DNS（**GSLB**，Global Server Load Balance，全局负载均衡）系统，此时还没有产生 Cache 层
4. GSLB 返回最佳 CDN 接入节点的 IP，同时 Local DNS 缓存此接入节点（在此过程中，会根据客户端的 IP 地址，地理位置，入网类型电信还是网通，返回最佳接入节点）
5. 用户对此 CDN 接入节点发起请求，CDN 网络经过内部路由，并转发请求至源服务器
6. 源服务器返回响应的数据，CDN 节点将数据返回至 CDN 接入节点
7. CDN 接入节点将数据返回给用户，同时缓存数据

​    CDN 节点缓存了数据，任何用户再次请求这一份数据时，CDN 缓存会直接返回，并不需要再由源服务器进行处理，这大大的加快了数据往返的速度，对于静态资源的加速尤为显著。即便请求动态资源，比如动态页面，其中也是有许多的静态资源是不会经常改变的，只要控制好缓存机制，也会有明显的加速效果。