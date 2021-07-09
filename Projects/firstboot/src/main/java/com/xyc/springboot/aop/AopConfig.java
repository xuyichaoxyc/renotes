package com.xyc.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 10:07
 */
@Configuration
@Aspect
public class AopConfig {
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args: " + Arrays.asList(args));

            // 调用原有方法
            Object o = pjp.proceed();
            System.out.println(pjp.toString());
            System.out.println("return: " + o);

            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
