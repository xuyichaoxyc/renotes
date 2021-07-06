package chapter08_container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 17:01
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("语文");
        list.add("数学");
        list.add("生物");
        list.add("物理");

        System.out.println("第一次选课单中的科目：");
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String s = iter.next();
            System.out.println(s + "\t");
            if ("数学".equals(s)) {
                iter.remove();
            }
        }
        System.out.println();
        System.out.println("第二次选课单中的科目：");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s + "\t");
            if ("语文".equals(s) || "物理".equals(s)) {
                it.remove();
            }
        }
        System.out.println();
        System.out.println("最后还没有选择的科目：");
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String s = iter.next();
            System.out.println(s + "\t");
        }
    }
}
