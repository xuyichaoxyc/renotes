package chapter04_reflection;

import java.lang.reflect.Field;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 14:43
 */
public class FieldTest {
    public static void main(String[] args) throws IllegalAccessException {
        House house = new House("George", 160, 300, "Beijing", "Happy House");
        Class c = house.getClass();
        // 取出所有成员变量
        Field[] fields = c.getDeclaredFields();
        System.out.println("共有成员变量：" + fields.length);
        System.out.println("============================");
        for(Field f : fields){
            // 设置此变量的可访问性为 true
            f.setAccessible(true);
            // 取得该变量类型
            Class t = f.getType();
            if(t == String.class){
                System.out.println(f.getName() + " : " + f.get(house));
            }
            if(t == int.class){
                System.out.println(f.getName() + " : " + f.getInt(house));
            }
        }

        // 为变量设置新值
        System.out.println("\n 为变量设置新值：");
        System.out.println("=================");
        for(Field field : fields){
            field.setAccessible(true);
            // 取得该变量名称
            String n = field.getName();
            switch (n){
                case "owner":
                    field.set(house, "Geroge Li");
                    break;
                case "space":
                    field.set(house, field.getInt(house) * 2);
                    break;
                case "price":
                    field.set(house, field.getInt(house) * 2);
                    break;
                case "address":
                    field.set(house, "BeiJing China");
                    break;
                case "name":
                    field.set(house, "Brilliant house");
                    break;
            }
        }
        for(Field field : fields){
            System.out.println(field.getName() + " : " + field.get(house));
        }

    }
}
