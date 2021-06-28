package chapter08_container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/28 10:31
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> collstr = new ArrayList<String>();
        collstr.add("张三");
        collstr.add("李四");
        collstr.add("王五");
        collstr.add("赵六");
        System.out.println(collstr);
        Object[] arrayo = collstr.toArray();

        Collection<String> coll = new ArrayList<String>();
        coll.add("赵刚");
        coll.add("莉莉");
        coll.addAll(collstr);
        System.out.println(coll);
        System.out.println("coll.contains(\"赵刚\") = " + coll.contains("赵刚"));
        System.out.println("coll.contains(collstr) = " + coll.containsAll(collstr));
        System.out.println(coll);

        Iterator it = coll.iterator();
        System.out.println("[");
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println("]");
        coll.removeAll(collstr);
        System.out.println(coll);

    }
}
