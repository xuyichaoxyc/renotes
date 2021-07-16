package com.xyc.learn.test.collectiontest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);

        for (int i = 0; i < 10; i++) {
            if (map.containsKey(i)) {
                System.out.println("map : key-" + i + " value-" + map.get(i));
            } else {
                System.out.println("the key-" + i + " is not present.");
            }
        }
    }
}
