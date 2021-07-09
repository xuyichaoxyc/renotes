import java.lang.reflect.Field;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 10:23
 */
public class AnimalInfoUtil {
    public static void getInfo(Class<?> clazz){

        StringBuilder strAnimalName = new StringBuilder( "动物种类：");
        StringBuilder strAnimalColor = new StringBuilder( "动物颜色：");
        StringBuilder strAnimalProvider = new StringBuilder( "主人信息：");

        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            if(field.isAnnotationPresent(AnimalName.class)){
                AnimalName animalAnimal = (AnimalName)field.getAnnotation(AnimalName.class);
                strAnimalName.append(animalAnimal.value());
                System.out.println(strAnimalName);
            } else if(field.isAnnotationPresent(AnimalColor.class)){
                AnimalColor animalColor = (AnimalColor)field.getAnnotation(AnimalColor.class);
                strAnimalColor.append(animalColor.animalColor().toString());
                System.out.println(strAnimalColor);
            } else if(field.isAnnotationPresent(AnimalMaster.class)){
                AnimalMaster animalMaster = (AnimalMaster)field.getAnnotation(AnimalMaster.class);
                strAnimalProvider.append("[编号：" + animalMaster.id() + ",主人名字：" + animalMaster.name() + ",地址：" + animalMaster.address() + "]");
                System.out.println(strAnimalProvider);
            }

        }

    }
}
