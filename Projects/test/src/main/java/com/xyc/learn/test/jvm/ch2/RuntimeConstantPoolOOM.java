package com.xyc.learn.test.jvm.ch2;

import java.util.HashSet;
import java.util.Set;

/**
 * 设置永久代大小
 * 采用 jdk1.6
 * VM Args: -XX:PermSize=6M -XX: MaxPermSize=6M
 *
 * JDK8: -XX: MaxMeta-spaceSize=6M，不会OOM
 * JDK7 开始，字符串常量池移至 Java 堆中
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用 Set 保持着常量池引用，避免 Full GC 回收常量池行为
        Set<String> set = new HashSet<String>();

        // 在 short 范围内足以让 6 MB的 PermSize 产生 OOM 了。
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
