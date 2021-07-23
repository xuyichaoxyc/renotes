package com.xyc.learn.test.base.exceptionandassertandlogtest.throwtest;

/**
 * @ClassName ThrowTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/21 14:31
 * @Version 1.0
 **/
public class ThrowTest {
    public static void main(String[] args) {
        int resultNormal = RandomGenerator.randInt(2, 5);
        System.out.println("正常输出随机生成结果：" + resultNormal);

        int resultException = RandomGenerator.randInt(5, 2);
        System.out.println("发生异常" + resultException);
    }
}
