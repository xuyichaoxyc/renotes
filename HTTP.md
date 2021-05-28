[TOC]

# HTTP

## HTTP报文

### 请求报文

![img](https://raw.githubusercontent.com/xuyichaoxyc/imgSave/master/img/20210528113433.jpeg)

+ 请求头
  + 请求方法
  + URI
  + 协议版本
+ 请求首部字段（可选，键值对组成）
  + Host
  + Connection
  + Content-Type
  + .......
+ 空行
+ 请求体（内容实体）

### 响应报文

![img](https://raw.githubusercontent.com/xuyichaoxyc/imgSave/master/img/20210528113404.jpeg)

+ 状态行
  + 协议版本
  + 响应状态码
  + 状态码的文本描述（原因短语）
+ 响应首部字段（可选，键值对组成）
  + Date
  + Content-Length
  + Content-Type
+ 空行
+ 响应体（内容实体）

## HTTP协议的无状态性

HTTP 是一种无状态协议，对于发送过的请求或响应都不做持久化处理

协议本身并不保留之前一切的请求或响应报文的信息

HTTP/1.1 无状态协议，引入 Cookie 再用HTTP协议通信，就可以管理状态了。

## HTTP方法

![image-20210528144754562](https://raw.githubusercontent.com/xuyichaoxyc/imgSave/master/img/20210528144800.png)

## 持久连接

![image-20210528145035012](https://raw.githubusercontent.com/xuyichaoxyc/imgSave/master/img/20210528145038.png)

HTTP 协议的初始版本中，每进行一次HTTP通信就要断开一次TCP连接

![image-20210528145235007](https://raw.githubusercontent.com/xuyichaoxyc/imgSave/master/img/20210528145237.png)

HTTP/1.1 和一部分的 HTTP/1.0 持久连接（HTTP Persistent Connections，也称为 HTTP keep-alive 或 HTTP connection reuse）

持久连接的特点：只要任意一端没有明确提出断开连接，则保持TCP连接状态

![image-20210528145823526](https://raw.githubusercontent.com/xuyichaoxyc/imgSave/master/img/20210528145825.png)

持久连接旨在建立1次TCP连接后进行多次请求和响应交互

减少了TCP连接的重复建立和断开造成的额外开销

**HTTP/1.1中所有连接默认都是持久连接**

