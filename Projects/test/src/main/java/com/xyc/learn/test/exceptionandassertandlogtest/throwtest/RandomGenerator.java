package com.xyc.learn.test.exceptionandassertandlogtest.throwtest;

import java.util.Random;

/**
 * @ClassName RandomGenerator
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/21 14:28
 * @Version 1.0
 **/
public class RandomGenerator {
    private static Random generator = new Random();

    public static int randInt(int low, int high) {
        if (low > high) {
            throw new IllegalArgumentException(
                    String.format("low should be <= high but low is %d and high is %d", low, high)
            );
        }

        return low + (int) (generator.nextDouble() * (high - low + 1));
    }
}
