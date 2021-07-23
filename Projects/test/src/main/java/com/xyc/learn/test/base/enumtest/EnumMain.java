package com.xyc.learn.test.base.enumtest;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println(FirstEnum.FIRST.name());
        System.out.println(FirstEnum.FIRST.getPrivateValue());
        System.out.println(FirstEnum.forValue("diyi"));
        System.out.println(FirstEnum.FIRST);
    }
}
