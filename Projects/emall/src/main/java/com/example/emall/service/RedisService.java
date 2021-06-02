package com.example.emall.service;

/**
 * @author ：xuyichao
 * @description：
 *  定义一些常用Redis操作
 *  对象和数组都以 json 形式存储
 * @date ：2021/6/1 14:06
 */
public interface RedisService {
    // 存储数据
    void set(String key, String value);

    // 获取数据
    String get(String key);

    // 设置超期时间
    boolean expire(String key, long expire);

    // 删除数据
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
