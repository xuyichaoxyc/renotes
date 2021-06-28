### 1. 创建线程的三种方式

+ 继承 Thread 类
+ 实现 Runnable 接口
+ 实现 Callable 接口



### 2. 线程的等待与通知

#### 2.1 wait() 方法

+ 功能：当一个线程调用一个共享变量的 wait() 方法时，该调用线程会被阻塞挂起

+ 返回情况：

  + 其他线程调用了该**共享对象**的 **notify 、notifyAll** 方法
  + 其他线程调用了该**线程**的 **interrupt** 方法，该线程 抛出 InterruptedException 异常返回

+ 异常：

  + 调用 wait() 方法时，未事先获取该对象的监视器锁，抛出 IllegalMonitorStateException 异常

+ 虚假唤醒：一个线程从挂起状态变为就绪状态（可运行状态，被唤醒），未经历 notify、notifyAll、被中断，等待超时

  + 通过 在循环中调用 wait() 方法进行防范

+ 当线程调用共享对象的 wait() 方法时，当前线程只会释放当前共享对象的锁，当前线程持有的其他共享对象的监视器锁并不会被释放。

#### 2.2 wait(long timeout)

  timeout 超时参数，若没有在指定时间内被其他线程调用该共享变量的 notify 或 notifyAll 方法，那么该函数还是会因为超时而返回。

  wait 和 wait(0) 效果等同，wait 也是通过调用 wait(0) 

  timeout < 0：抛出 IllegalArgumentException 异常

#### 2.3 wait(long timeout, int nanous )

  在其内部调用的还是 wait(long timeout) 方法

#### 2.4 notify()

一个线程调用共享对象的 notify() 方法后，会唤醒一个在该共享变量上调用 wait 系列方法后被挂起的线程

随机

等调用 notify() 方法的线程释放资源后，共同竞争

#### 2.5 notifyAll()

全部唤醒

共同竞争