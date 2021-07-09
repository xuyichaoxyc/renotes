package com.xyc.springboot.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 10:22
 */
@Component
@Aspect
public class TestAspect {
//    // 所有 set 开头的方法
//    @Pointcut("execution(* set*(..))")
//    public void pointcutSet() {
//
//    }
//
//    @AfterReturning("pointcutSet()")
//    public void after() throws Throwable {
//        System.out.println("set方法开始之前......");
//        System.out.println("set方法开始之后");
//    }
}
